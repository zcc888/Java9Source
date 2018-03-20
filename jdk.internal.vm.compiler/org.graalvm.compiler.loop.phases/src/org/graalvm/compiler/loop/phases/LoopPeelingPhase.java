/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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
import org.graalvm.compiler.loop.LoopEx;
import org.graalvm.compiler.loop.LoopPolicies;
import org.graalvm.compiler.loop.LoopsData;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.phases.tiers.PhaseContext;

public class LoopPeelingPhase extends LoopPhase<LoopPolicies> {

    public LoopPeelingPhase(LoopPolicies policies) {
        super(policies);
    }

    @Override
    @SuppressWarnings("try")
    protected void run(StructuredGraph graph, PhaseContext context) {
        if (graph.hasLoops()) {
            LoopsData data = new LoopsData(graph);
            try (Debug.Scope s = Debug.scope("peeling", data.getCFG())) {
                for (LoopEx loop : data.outerFirst()) {
                    if (getPolicies().shouldPeel(loop, data.getCFG(), context.getMetaAccess())) {
                        Debug.log("Peeling %s", loop);
                        LoopTransformations.peel(loop);
                        Debug.dump(Debug.INFO_LOG_LEVEL, graph, "Peeling %s", loop);
                    }
                }
                data.deleteUnusedNodes();
            } catch (Throwable t) {
                throw Debug.handle(t);
            }
        }
    }

    @Override
    public float codeSizeIncrease() {
        return 5.0f;
    }
}
