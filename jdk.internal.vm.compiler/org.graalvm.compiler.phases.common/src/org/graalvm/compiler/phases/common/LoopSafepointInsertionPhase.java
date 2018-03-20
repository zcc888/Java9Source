/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.phases.common;

import static org.graalvm.compiler.core.common.GraalOptions.GenLoopSafepoints;

import org.graalvm.compiler.nodes.LoopEndNode;
import org.graalvm.compiler.nodes.SafepointNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.phases.Phase;

/**
 * Adds safepoints to loops.
 */
public class LoopSafepointInsertionPhase extends Phase {

    @Override
    public boolean checkContract() {
        // the size / cost after is highly dynamic and dependent on the graph, thus we do not verify
        // costs for this phase
        return false;
    }

    @Override
    protected void run(StructuredGraph graph) {
        if (GenLoopSafepoints.getValue()) {
            for (LoopEndNode loopEndNode : graph.getNodes(LoopEndNode.TYPE)) {
                if (loopEndNode.canSafepoint()) {
                    SafepointNode safepointNode = graph.add(new SafepointNode());
                    graph.addBeforeFixed(loopEndNode, safepointNode);
                }
            }
        }
    }
}
