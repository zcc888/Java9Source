/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes.debug;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_30;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_50;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FixedNode;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;

/**
 * A node for platform dependent verification of the Java heap. Intended to be used for debugging
 * heap corruption issues.
 */
@NodeInfo(cycles = CYCLES_30, size = SIZE_50)
public final class VerifyHeapNode extends FixedWithNextNode implements Lowerable {

    public static final NodeClass<VerifyHeapNode> TYPE = NodeClass.create(VerifyHeapNode.class);

    public VerifyHeapNode() {
        super(TYPE, StampFactory.forVoid());
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    public static void addBefore(FixedNode position) {
        StructuredGraph graph = position.graph();
        graph.addBeforeFixed(position, graph.add(new VerifyHeapNode()));
    }

    public static void addAfter(FixedWithNextNode position) {
        StructuredGraph graph = position.graph();
        graph.addAfterFixed(position, graph.add(new VerifyHeapNode()));
    }

}
