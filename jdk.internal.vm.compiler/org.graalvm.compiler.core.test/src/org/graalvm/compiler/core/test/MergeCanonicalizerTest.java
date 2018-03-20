/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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

import org.junit.Test;

import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.nodes.ReturnNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;

public class MergeCanonicalizerTest extends GraalCompilerTest {

    public static int staticField;

    private int field;

    @Test
    public void testSplitReturn() {
        test("testSplitReturnSnippet", 2);
        testReturnCount("testSplitReturnSnippet", 2);
    }

    public int testSplitReturnSnippet(int b) {
        int v;
        if (b < 0) {
            staticField = 1;
            v = 10;
        } else {
            staticField = 2;
            v = 20;
        }
        int i = field;
        i = field + i;
        return v;
    }

    private void testReturnCount(String snippet, int returnCount) {
        StructuredGraph graph = parseEager(snippet, AllowAssumptions.YES);
        new CanonicalizerPhase().apply(graph, new PhaseContext(getProviders()));
        new CanonicalizerPhase().apply(graph, new PhaseContext(getProviders()));
        Debug.dump(Debug.BASIC_LOG_LEVEL, graph, "Graph");
        assertDeepEquals(returnCount, graph.getNodes(ReturnNode.TYPE).count());
    }
}
