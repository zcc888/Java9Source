/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.loop.phases;

import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.DebugCounter;
import org.graalvm.compiler.loop.LoopEx;
import org.graalvm.compiler.loop.LoopPolicies;
import org.graalvm.compiler.loop.LoopsData;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;

public class LoopFullUnrollPhase extends LoopPhase<LoopPolicies> {

    private static final DebugCounter FULLY_UNROLLED_LOOPS = Debug.counter("FullUnrolls");
    private final CanonicalizerPhase canonicalizer;

    public LoopFullUnrollPhase(CanonicalizerPhase canonicalizer, LoopPolicies policies) {
        super(policies);
        this.canonicalizer = canonicalizer;
    }

    @Override
    protected void run(StructuredGraph graph, PhaseContext context) {
        if (graph.hasLoops()) {
            boolean peeled;
            do {
                peeled = false;
                final LoopsData dataCounted = new LoopsData(graph);
                dataCounted.detectedCountedLoops();
                for (LoopEx loop : dataCounted.countedLoops()) {
                    if (getPolicies().shouldFullUnroll(loop)) {
                        Debug.log("FullUnroll %s", loop);
                        LoopTransformations.fullUnroll(loop, context, canonicalizer);
                        FULLY_UNROLLED_LOOPS.increment();
                        Debug.dump(Debug.INFO_LOG_LEVEL, graph, "FullUnroll %s", loop);
                        peeled = true;
                        break;
                    }
                }
                dataCounted.deleteUnusedNodes();
            } while (peeled);
        }
    }

    @Override
    public boolean checkContract() {
        return false;
    }
}
