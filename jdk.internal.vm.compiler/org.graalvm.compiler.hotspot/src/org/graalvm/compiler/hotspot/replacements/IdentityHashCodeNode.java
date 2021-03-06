/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.replacements;

import static org.graalvm.compiler.core.common.GraalOptions.ImmutableCode;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.core.common.LocationIdentity;
import org.graalvm.compiler.core.common.type.AbstractObjectStamp;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.memory.MemoryCheckpoint;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;

import jdk.vm.ci.hotspot.HotSpotObjectConstant;
import jdk.vm.ci.meta.JavaConstant;

@NodeInfo(cycles = CYCLES_0, size = SIZE_0)
public class IdentityHashCodeNode extends FixedWithNextNode implements Canonicalizable, Lowerable, MemoryCheckpoint.Single {

    public static final NodeClass<IdentityHashCodeNode> TYPE = NodeClass.create(IdentityHashCodeNode.class);

    @Input ValueNode object;

    public IdentityHashCodeNode(ValueNode object) {
        super(TYPE, StampFactory.forInteger(32));
        this.object = object;

    }

    @Override
    public LocationIdentity getLocationIdentity() {
        return HotSpotReplacementsUtil.MARK_WORD_LOCATION;
    }

    @Override
    public Node canonical(CanonicalizerTool tool) {
        if (object.isConstant()) {
            assert object.stamp() instanceof AbstractObjectStamp;
            JavaConstant c = (JavaConstant) object.asConstant();
            if (ImmutableCode.getValue()) {
                return this;
            }
            JavaConstant identityHashCode = null;
            if (c.isNull()) {
                identityHashCode = JavaConstant.forInt(0);
            } else {
                identityHashCode = JavaConstant.forInt(((HotSpotObjectConstant) c).getIdentityHashCode());
            }

            return new ConstantNode(identityHashCode, StampFactory.forConstant(identityHashCode));
        }
        return this;
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    @NodeIntrinsic
    public static native int identityHashCode(Object object);

}
