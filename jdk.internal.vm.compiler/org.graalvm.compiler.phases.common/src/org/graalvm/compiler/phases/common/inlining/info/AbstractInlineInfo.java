/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.phases.common.inlining.info;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.internal.method.MethodMetricsInlineeScopeInfo;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.nodes.Invoke;
import org.graalvm.compiler.nodes.ParameterNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.common.inlining.InliningUtil;
import org.graalvm.compiler.phases.common.inlining.info.elem.Inlineable;
import org.graalvm.compiler.phases.common.inlining.info.elem.InlineableGraph;
import org.graalvm.compiler.phases.tiers.HighTierContext;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public abstract class AbstractInlineInfo implements InlineInfo {

    protected final Invoke invoke;

    public AbstractInlineInfo(Invoke invoke) {
        this.invoke = invoke;
    }

    @Override
    public StructuredGraph graph() {
        return invoke.asNode().graph();
    }

    @Override
    public Invoke invoke() {
        return invoke;
    }

    protected static Collection<Node> inline(Invoke invoke, ResolvedJavaMethod concrete, Inlineable inlineable, boolean receiverNullCheck) {
        List<Node> canonicalizeNodes = new ArrayList<>();
        assert inlineable instanceof InlineableGraph;
        StructuredGraph calleeGraph = ((InlineableGraph) inlineable).getGraph();
        Map<Node, Node> duplicateMap = InliningUtil.inline(invoke, calleeGraph, receiverNullCheck, canonicalizeNodes, concrete);
        getInlinedParameterUsages(canonicalizeNodes, calleeGraph, duplicateMap);
        return canonicalizeNodes;
    }

    public static void getInlinedParameterUsages(Collection<Node> parameterUsages, StructuredGraph calleeGraph, Map<Node, Node> duplicateMap) {
        for (ParameterNode parameter : calleeGraph.getNodes(ParameterNode.TYPE)) {
            for (Node usage : parameter.usages()) {
                Node node = duplicateMap.get(usage);
                if (node != null && node.isAlive()) {
                    parameterUsages.add(node);
                }
            }
        }
    }

    @Override
    @SuppressWarnings("try")
    public final void populateInlinableElements(HighTierContext context, StructuredGraph caller, CanonicalizerPhase canonicalizer) {
        for (int i = 0; i < numberOfMethods(); i++) {
            try (Debug.Scope s = Debug.methodMetricsScope("InlineEnhancement", MethodMetricsInlineeScopeInfo.create(), false)) {
                Inlineable elem = Inlineable.getInlineableElement(methodAt(i), invoke, context, canonicalizer);
                setInlinableElement(i, elem);
            }
        }
    }

    @Override
    public final int determineNodeCount() {
        int nodes = 0;
        for (int i = 0; i < numberOfMethods(); i++) {
            Inlineable elem = inlineableElementAt(i);
            if (elem != null) {
                nodes += elem.getNodeCount();
            }
        }
        return nodes;
    }
}
