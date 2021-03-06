/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.graalvm.compiler.nodes.memory;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_2;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_1;
import static org.graalvm.compiler.nodes.NamedLocationIdentity.ARRAY_LENGTH_LOCATION;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.core.common.LocationIdentity;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.debug.DebugCloseable;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.CanonicalizableLocation;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.FixedNode;
import org.graalvm.compiler.nodes.FrameState;
import org.graalvm.compiler.nodes.PiNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.extended.GuardingNode;
import org.graalvm.compiler.nodes.extended.ValueAnchorNode;
import org.graalvm.compiler.nodes.memory.address.AddressNode;
import org.graalvm.compiler.nodes.memory.address.OffsetAddressNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import org.graalvm.compiler.nodes.spi.Virtualizable;
import org.graalvm.compiler.nodes.spi.VirtualizerTool;
import org.graalvm.compiler.nodes.util.GraphUtil;

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.MetaAccessProvider;

/**
 * Reads an {@linkplain FixedAccessNode accessed} value.
 */
@NodeInfo(nameTemplate = "Read#{p#location/s}", cycles = CYCLES_2, size = SIZE_1)
public class ReadNode extends FloatableAccessNode implements LIRLowerable, Canonicalizable, Virtualizable, GuardingNode {

    public static final NodeClass<ReadNode> TYPE = NodeClass.create(ReadNode.class);

    public ReadNode(AddressNode address, LocationIdentity location, Stamp stamp, BarrierType barrierType) {
        super(TYPE, address, location, stamp, null, barrierType);
    }

    public ReadNode(AddressNode address, LocationIdentity location, Stamp stamp, GuardingNode guard, BarrierType barrierType) {
        super(TYPE, address, location, stamp, guard, barrierType);
    }

    public ReadNode(AddressNode address, LocationIdentity location, Stamp stamp, GuardingNode guard, BarrierType barrierType, boolean nullCheck, FrameState stateBefore) {
        this(TYPE, address, location, stamp, guard, barrierType, nullCheck, stateBefore);
    }

    protected ReadNode(NodeClass<? extends ReadNode> c, AddressNode address, LocationIdentity location, Stamp stamp, GuardingNode guard, BarrierType barrierType, boolean nullCheck,
                    FrameState stateBefore) {
        super(c, address, location, stamp, guard, barrierType, nullCheck, stateBefore);
    }

    public ReadNode(AddressNode address, LocationIdentity location, ValueNode guard, BarrierType barrierType) {
        /*
         * Used by node intrinsics. Really, you can trust me on that! Since the initial value for
         * location is a parameter, i.e., a ParameterNode, the constructor cannot use the declared
         * type LocationNode.
         */
        super(TYPE, address, location, StampFactory.forNodeIntrinsic(), (GuardingNode) guard, barrierType);
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        LIRKind readKind = gen.getLIRGeneratorTool().getLIRKind(stamp());
        gen.setResult(this, gen.getLIRGeneratorTool().getArithmetic().emitLoad(readKind, gen.operand(address), gen.state(this)));
    }

    @Override
    public Node canonical(CanonicalizerTool tool) {
        if (tool.allUsagesAvailable() && hasNoUsages()) {
            if (getGuard() != null && !(getGuard() instanceof FixedNode)) {
                // The guard is necessary even if the read goes away.
                return new ValueAnchorNode((ValueNode) getGuard());
            } else {
                // Read without usages or guard can be safely removed.
                return null;
            }
        }
        if (getAddress() instanceof OffsetAddressNode) {
            OffsetAddressNode objAddress = (OffsetAddressNode) getAddress();
            if (objAddress.getBase() instanceof PiNode && ((PiNode) objAddress.getBase()).getGuard() == getGuard()) {
                OffsetAddressNode newAddress = new OffsetAddressNode(((PiNode) objAddress.getBase()).getOriginalNode(), objAddress.getOffset());
                return new ReadNode(newAddress, getLocationIdentity(), stamp(), getGuard(), getBarrierType(), getNullCheck(), stateBefore());
            }
        }
        if (!getNullCheck()) {
            return canonicalizeRead(this, getAddress(), getLocationIdentity(), tool);
        } else {
            // if this read is a null check, then replacing it with the value is incorrect for
            // guard-type usages
            return this;
        }
    }

    @SuppressWarnings("try")
    @Override
    public FloatingAccessNode asFloatingNode(MemoryNode lastLocationAccess) {
        try (DebugCloseable position = withNodeSourcePosition()) {
            return graph().unique(new FloatingReadNode(getAddress(), getLocationIdentity(), lastLocationAccess, stamp(), getGuard(), getBarrierType()));
        }
    }

    @Override
    public boolean isAllowedUsageType(InputType type) {
        return (getNullCheck() && type == InputType.Guard) ? true : super.isAllowedUsageType(type);
    }

    public static ValueNode canonicalizeRead(ValueNode read, AddressNode address, LocationIdentity locationIdentity, CanonicalizerTool tool) {
        MetaAccessProvider metaAccess = tool.getMetaAccess();
        if (tool.canonicalizeReads() && address instanceof OffsetAddressNode) {
            OffsetAddressNode objAddress = (OffsetAddressNode) address;
            ValueNode object = objAddress.getBase();
            if (metaAccess != null && object.isConstant() && !object.isNullConstant() && objAddress.getOffset().isConstant()) {
                long displacement = objAddress.getOffset().asJavaConstant().asLong();
                int stableDimension = ((ConstantNode) object).getStableDimension();
                if (locationIdentity.isImmutable() || stableDimension > 0) {
                    Constant constant = read.stamp().readConstant(tool.getConstantReflection().getMemoryAccessProvider(), object.asConstant(), displacement);
                    boolean isDefaultStable = locationIdentity.isImmutable() || ((ConstantNode) object).isDefaultStable();
                    if (constant != null && (isDefaultStable || !constant.isDefaultForKind())) {
                        return ConstantNode.forConstant(read.stamp(), constant, Math.max(stableDimension - 1, 0), isDefaultStable, metaAccess);
                    }
                }
            }
            if (locationIdentity.equals(ARRAY_LENGTH_LOCATION)) {
                ValueNode length = GraphUtil.arrayLength(object);
                if (length != null) {
                    // TODO Does this need a PiCastNode to the positive range?
                    return length;
                }
            }
            if (locationIdentity instanceof CanonicalizableLocation) {
                CanonicalizableLocation canonicalize = (CanonicalizableLocation) locationIdentity;
                ValueNode result = canonicalize.canonicalizeRead(read, address, object, tool);
                assert result != null && result.stamp().isCompatible(read.stamp());
                return result;
            }

        }
        return read;
    }

    @Override
    public void virtualize(VirtualizerTool tool) {
        throw GraalError.shouldNotReachHere("unexpected ReadNode before PEA");
    }

    @Override
    public boolean canNullCheck() {
        return true;
    }
}
