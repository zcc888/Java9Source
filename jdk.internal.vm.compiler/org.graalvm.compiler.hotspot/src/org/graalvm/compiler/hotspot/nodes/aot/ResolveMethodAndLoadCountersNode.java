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

import jdk.vm.ci.meta.ResolvedJavaMethod;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_3;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_20;

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.hotspot.nodes.type.MethodCountersPointerStamp;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.calc.FloatingNode;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;

@NodeInfo(cycles = CYCLES_3, size = SIZE_20)
public class ResolveMethodAndLoadCountersNode extends FloatingNode implements Lowerable {
    public static final NodeClass<ResolveMethodAndLoadCountersNode> TYPE = NodeClass.create(ResolveMethodAndLoadCountersNode.class);

    ResolvedJavaMethod method;
    @Input ValueNode hub;

    public ResolveMethodAndLoadCountersNode(ResolvedJavaMethod method, ValueNode hub) {
        super(TYPE, MethodCountersPointerStamp.methodCountersNonNull());
        this.method = method;
        this.hub = hub;
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    public ResolvedJavaMethod getMethod() {
        return method;
    }

    public ValueNode getHub() {
        return hub;
    }
}
