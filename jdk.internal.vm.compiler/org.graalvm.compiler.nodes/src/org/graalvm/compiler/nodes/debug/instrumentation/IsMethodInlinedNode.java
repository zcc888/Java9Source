/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes.debug.instrumentation;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_IGNORED;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_IGNORED;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;

import jdk.vm.ci.meta.JavaKind;

/**
 * The {@code IsMethodInlinedNode} represents a boolean value indicating whether it is inlined into
 * the current graph. There are two clues for the decision: first, the parsing depth, which is a
 * contextual information during bytecode parsing; second, the original graph upon cloning, which
 * can detect the inlining when comparing to the current graph.
 */
@NodeInfo(cycles = CYCLES_IGNORED, size = SIZE_IGNORED)
public final class IsMethodInlinedNode extends FixedWithNextNode implements Lowerable, InstrumentationInliningCallback {

    public static final NodeClass<IsMethodInlinedNode> TYPE = NodeClass.create(IsMethodInlinedNode.class);

    protected StructuredGraph originalGraph;
    protected int parsingDepth;

    public IsMethodInlinedNode(int depth) {
        super(TYPE, StampFactory.forKind(JavaKind.Boolean));
        this.parsingDepth = depth;
    }

    @Override
    protected void afterClone(Node other) {
        if (other instanceof IsMethodInlinedNode) {
            // keep track of the original graph
            IsMethodInlinedNode that = (IsMethodInlinedNode) other;
            this.originalGraph = that.originalGraph == null ? that.graph() : that.originalGraph;
        }
    }

    private void resolve(StructuredGraph target) {
        // if parsingDepth is greater than 0, then inlined
        // if the original graph is null, which means this node is never cloned, then not inlined
        // if the original graph does not match the current graph, then inlined
        replaceAtUsages(ConstantNode.forBoolean(parsingDepth > 0 || (originalGraph != null && originalGraph != target), graph()));
        graph().removeFixed(this);
    }

    @Override
    public void lower(LoweringTool tool) {
        resolve(graph());
    }

    @Override
    public void preInlineInstrumentation(InstrumentationNode instrumentation) {
        // This node will be further merged back to instrumentation.graph(). We care about if this
        // node originates from instrumentation.graph().
        resolve(instrumentation.graph());
    }

    @Override
    public void postInlineInstrumentation(InstrumentationNode instrumentation) {
    }

}
