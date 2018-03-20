/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.test;

import static org.graalvm.compiler.core.common.CompilationIdentifier.INVALID_COMPILATION_ID;

import org.junit.Test;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.replacements.test.MethodSubstitutionTest;

/**
 * Tests HotSpot specific substitutions for {@link Node}.
 */
public class HotSpotNodeSubstitutionsTest extends MethodSubstitutionTest {

    @Test
    public void test() {
        StructuredGraph graph = new StructuredGraph(AllowAssumptions.YES, INVALID_COMPILATION_ID);
        test("getNodeClass", ConstantNode.forInt(42, graph));
    }

    public static NodeClass<?> getNodeClass(Node n) {
        return n.getNodeClass();
    }
}
