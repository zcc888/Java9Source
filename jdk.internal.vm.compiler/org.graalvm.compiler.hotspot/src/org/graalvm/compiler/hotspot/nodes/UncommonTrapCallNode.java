/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.nodes;

import static org.graalvm.compiler.hotspot.HotSpotBackend.UNCOMMON_TRAP;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_UNKNOWN;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_UNKNOWN;

import org.graalvm.compiler.core.common.LocationIdentity;
import org.graalvm.compiler.core.common.spi.ForeignCallsProvider;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.hotspot.HotSpotLIRGenerator;
import org.graalvm.compiler.lir.StandardOp.SaveRegistersOp;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.memory.MemoryCheckpoint;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import org.graalvm.compiler.word.Word;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.Value;

/**
 * A call to the runtime code implementing the uncommon trap logic.
 */
@NodeInfo(allowedUsageTypes = {InputType.Memory}, cycles = CYCLES_UNKNOWN, size = SIZE_UNKNOWN)
public final class UncommonTrapCallNode extends FixedWithNextNode implements LIRLowerable, MemoryCheckpoint.Single {

    public static final NodeClass<UncommonTrapCallNode> TYPE = NodeClass.create(UncommonTrapCallNode.class);
    @Input ValueNode trapRequest;
    @Input ValueNode mode;
    @Input SaveAllRegistersNode registerSaver;
    protected final ForeignCallsProvider foreignCalls;

    public UncommonTrapCallNode(@InjectedNodeParameter ForeignCallsProvider foreignCalls, ValueNode registerSaver, ValueNode trapRequest, ValueNode mode) {
        super(TYPE, StampFactory.forKind(JavaKind.fromJavaClass(UNCOMMON_TRAP.getResultType())));
        this.trapRequest = trapRequest;
        this.mode = mode;
        this.registerSaver = (SaveAllRegistersNode) registerSaver;
        this.foreignCalls = foreignCalls;
    }

    @Override
    public LocationIdentity getLocationIdentity() {
        return LocationIdentity.any();
    }

    public SaveRegistersOp getSaveRegistersOp() {
        return registerSaver.getSaveRegistersOp();
    }

    /**
     * Returns the node representing the exec_mode/unpack_kind used during this fetch_unroll_info
     * call.
     */
    public ValueNode getMode() {
        return mode;
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        Value trapRequestValue = gen.operand(trapRequest);
        Value modeValue = gen.operand(getMode());
        Value result = ((HotSpotLIRGenerator) gen.getLIRGeneratorTool()).emitUncommonTrapCall(trapRequestValue, modeValue, getSaveRegistersOp());
        gen.setResult(this, result);
    }

    @NodeIntrinsic
    public static native Word uncommonTrap(long registerSaver, int trapRequest, int mode);
}
