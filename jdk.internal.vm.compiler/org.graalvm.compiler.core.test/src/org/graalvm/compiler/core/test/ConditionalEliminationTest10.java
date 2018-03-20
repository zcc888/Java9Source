/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.core.test;

import org.junit.Assert;
import org.junit.Test;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.nodes.GuardNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.common.DominatorConditionalEliminationPhase;
import org.graalvm.compiler.phases.common.LoweringPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;

/**
 * This test checks the combined action of
 * {@link org.graalvm.compiler.phases.common.DominatorConditionalEliminationPhase} and
 * {@link org.graalvm.compiler.phases.common.LoweringPhase}. The lowering phase needs to introduce
 * the null checks at the correct places for the dominator conditional elimination phase to pick
 * them up.
 */
public class ConditionalEliminationTest10 extends ConditionalEliminationTestBase {

    private static class TestClass {
        int x;
    }

    @SuppressWarnings("all")
    public static int testSnippet(int a, TestClass t) {
        int result = 0;
        if (a == 0) {
            GraalDirectives.controlFlowAnchor();
            result = t.x;
        }
        GraalDirectives.controlFlowAnchor();
        return result + t.x;
    }

    @Test
    public void test1() {
        StructuredGraph graph = parseEager("testSnippet", AllowAssumptions.YES);
        PhaseContext context = new PhaseContext(getProviders());
        new LoweringPhase(new CanonicalizerPhase(), LoweringTool.StandardLoweringStage.HIGH_TIER).apply(graph, context);
        Assert.assertEquals(2, graph.getNodes().filter(GuardNode.class).count());
        new DominatorConditionalEliminationPhase(true).apply(graph, context);
        Assert.assertEquals(1, graph.getNodes().filter(GuardNode.class).count());
    }
}
