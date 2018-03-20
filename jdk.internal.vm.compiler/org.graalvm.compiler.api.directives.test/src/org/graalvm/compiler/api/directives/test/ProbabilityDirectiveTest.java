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
package org.graalvm.compiler.api.directives.test;

import org.junit.Assert;
import org.junit.Test;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.graph.iterators.NodeIterable;
import org.graalvm.compiler.nodes.AbstractBeginNode;
import org.graalvm.compiler.nodes.IfNode;
import org.graalvm.compiler.nodes.StructuredGraph;

public class ProbabilityDirectiveTest extends GraalCompilerTest {

    public static int branchProbabilitySnippet(int arg) {
        if (GraalDirectives.injectBranchProbability(0.125, arg > 0)) {
            GraalDirectives.controlFlowAnchor(); // prevent removal of the if
            return 1;
        } else {
            GraalDirectives.controlFlowAnchor(); // prevent removal of the if
            return 2;
        }
    }

    @Test
    public void testBranchProbability() {
        test("branchProbabilitySnippet", 5);
    }

    @Override
    protected boolean checkLowTierGraph(StructuredGraph graph) {
        NodeIterable<IfNode> ifNodes = graph.getNodes(IfNode.TYPE);
        Assert.assertEquals("IfNode count", 1, ifNodes.count());

        IfNode ifNode = ifNodes.first();
        AbstractBeginNode trueSuccessor = ifNode.trueSuccessor();
        Assert.assertEquals("branch probability of " + ifNode, 0.125, ifNode.probability(trueSuccessor), 0);

        return true;
    }
}
