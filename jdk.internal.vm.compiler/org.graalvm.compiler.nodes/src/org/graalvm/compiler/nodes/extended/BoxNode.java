/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes.extended;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_100;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_50;

import java.util.Collections;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.core.common.type.TypeReference;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.java.MonitorIdNode;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.nodes.spi.VirtualizableAllocation;
import org.graalvm.compiler.nodes.spi.VirtualizerTool;
import org.graalvm.compiler.nodes.type.StampTool;
import org.graalvm.compiler.nodes.virtual.VirtualBoxingNode;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ResolvedJavaType;

/**
 * This node represents the boxing of a primitive value. This corresponds to a call to the valueOf
 * methods in Integer, Long, etc.
 */
@NodeInfo(cycles = CYCLES_100, size = SIZE_50)
public class BoxNode extends FixedWithNextNode implements VirtualizableAllocation, Lowerable, Canonicalizable.Unary<ValueNode> {

    public static final NodeClass<BoxNode> TYPE = NodeClass.create(BoxNode.class);
    @Input private ValueNode value;
    protected final JavaKind boxingKind;

    public BoxNode(ValueNode value, ResolvedJavaType resultType, JavaKind boxingKind) {
        this(TYPE, value, resultType, boxingKind);
    }

    public BoxNode(NodeClass<? extends BoxNode> c, ValueNode value, ResolvedJavaType resultType, JavaKind boxingKind) {
        super(c, StampFactory.objectNonNull(TypeReference.createExactTrusted(resultType)));
        this.value = value;
        this.boxingKind = boxingKind;
    }

    public JavaKind getBoxingKind() {
        return boxingKind;
    }

    @Override
    public ValueNode getValue() {
        return value;
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forValue) {
        if (tool.allUsagesAvailable() && hasNoUsages()) {
            return null;
        }
        return this;
    }

    protected VirtualBoxingNode createVirtualBoxingNode() {
        return new VirtualBoxingNode(StampTool.typeOrNull(stamp()), boxingKind);
    }

    @Override
    public void virtualize(VirtualizerTool tool) {
        ValueNode alias = tool.getAlias(getValue());

        VirtualBoxingNode newVirtual = createVirtualBoxingNode();
        assert newVirtual.getFields().length == 1;

        tool.createVirtualObject(newVirtual, new ValueNode[]{alias}, Collections.<MonitorIdNode> emptyList(), false);
        tool.replaceWithVirtual(newVirtual);
    }
}
