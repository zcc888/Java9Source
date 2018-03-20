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

import java.util.List;

import org.junit.Assert;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeMap;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.ScheduleResult;
import org.graalvm.compiler.nodes.cfg.Block;
import org.graalvm.compiler.phases.schedule.SchedulePhase;

public class GraphScheduleTest extends GraalCompilerTest {

    protected void assertOrderedAfterSchedule(StructuredGraph graph, Node a, Node b) {
        SchedulePhase ibp = new SchedulePhase(SchedulePhase.SchedulingStrategy.LATEST);
        ibp.apply(graph);
        assertOrderedAfterSchedule(graph.getLastSchedule(), a, b);
    }

    protected void assertOrderedAfterSchedule(ScheduleResult ibp, Node a, Node b) {
        NodeMap<Block> nodeToBlock = ibp.getCFG().getNodeToBlock();
        Block bBlock = nodeToBlock.get(b);
        Block aBlock = nodeToBlock.get(a);

        if (bBlock == aBlock) {
            List<Node> instructions = ibp.nodesFor(bBlock);
            Assert.assertTrue(instructions.indexOf(b) > instructions.indexOf(a));
        } else {
            Block block = bBlock;
            while (block != null) {
                if (block == aBlock) {
                    return;
                }
                block = block.getDominator();
            }
            Assert.fail("block of A doesn't dominate the block of B");
        }
    }
}
