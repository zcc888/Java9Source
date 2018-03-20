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
package org.graalvm.compiler.hotspot.nodes.aot;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_3;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_20;

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.hotspot.meta.HotSpotConstantLoadAction;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.calc.FloatingNode;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;

@NodeInfo(cycles = CYCLES_3, size = SIZE_20)
public class ResolveConstantNode extends FloatingNode implements Lowerable {
    public static final NodeClass<ResolveConstantNode> TYPE = NodeClass.create(ResolveConstantNode.class);

    @Input ValueNode value;
    protected HotSpotConstantLoadAction action;

    public ResolveConstantNode(ValueNode value, HotSpotConstantLoadAction action) {
        super(TYPE, value.stamp());
        this.value = value;
        this.action = action;
    }

    public ResolveConstantNode(ValueNode value) {
        super(TYPE, value.stamp());
        this.value = value;
        this.action = HotSpotConstantLoadAction.RESOLVE;
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    public ValueNode value() {
        return value;
    }

    public HotSpotConstantLoadAction action() {
        return action;
    }
}
