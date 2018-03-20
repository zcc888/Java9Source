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
package org.graalvm.compiler.loop.phases;

import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.Debug.Scope;
import org.graalvm.compiler.loop.LoopEx;
import org.graalvm.compiler.loop.LoopsData;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.phases.Phase;

public class ReassociateInvariantPhase extends Phase {

    @SuppressWarnings("try")
    @Override
    protected void run(StructuredGraph graph) {
        if (graph.hasLoops()) {
            final LoopsData dataReassociate = new LoopsData(graph);
            try (Scope s = Debug.scope("ReassociateInvariants")) {
                for (LoopEx loop : dataReassociate.loops()) {
                    loop.reassociateInvariants();
                }
            } catch (Throwable e) {
                throw Debug.handle(e);
            }
            dataReassociate.deleteUnusedNodes();
        }
    }
}
