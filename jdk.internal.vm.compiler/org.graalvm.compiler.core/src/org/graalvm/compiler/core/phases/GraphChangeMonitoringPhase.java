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
package org.graalvm.compiler.core.phases;

import java.util.Set;
import java.util.stream.Collectors;

import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.Debug.Scope;
import org.graalvm.compiler.graph.Graph.NodeEvent;
import org.graalvm.compiler.graph.Graph.NodeEventScope;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.nodes.LogicConstantNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.phases.BasePhase;
import org.graalvm.compiler.phases.PhaseSuite;
import org.graalvm.compiler.phases.common.util.HashSetNodeEventListener;
import org.graalvm.compiler.phases.tiers.PhaseContext;

/**
 * A utility phase for detecting when a phase would change the graph and reporting extra information
 * about the effects. The phase is first run on a copy of the graph and if a change in that graph is
 * detected then it's rerun on the original graph inside a new debug scope under
 * GraphChangeMonitoringPhase. The message argument can be used to distinguish between the same
 * phase run at different points.
 *
 * @param <C>
 */
public class GraphChangeMonitoringPhase<C extends PhaseContext> extends PhaseSuite<C> {

    private final String message;

    public GraphChangeMonitoringPhase(String message, BasePhase<C> phase) {
        super();
        this.message = message;
        appendPhase(phase);
    }

    public GraphChangeMonitoringPhase(String message) {
        super();
        this.message = message;
    }

    @Override
    @SuppressWarnings("try")
    protected void run(StructuredGraph graph, C context) {
        /*
         * Phase may add nodes but not end up using them so ignore additions. Nodes going dead and
         * having their inputs change are the main interesting differences.
         */
        HashSetNodeEventListener listener = new HashSetNodeEventListener().exclude(NodeEvent.NODE_ADDED);
        StructuredGraph graphCopy = (StructuredGraph) graph.copy();
        try (NodeEventScope s = graphCopy.trackNodeEvents(listener)) {
            try (Scope s2 = Debug.sandbox("WithoutMonitoring", null)) {
                super.run(graphCopy, context);
            } catch (Throwable t) {
                Debug.handle(t);
            }
        }
        /*
         * Ignore LogicConstantNode since those are sometimes created and deleted as part of running
         * a phase.
         */
        if (listener.getNodes().stream().filter(e -> !(e instanceof LogicConstantNode)).findFirst().isPresent()) {
            /* rerun it on the real graph in a new Debug scope so Dump and Log can find it. */
            listener = new HashSetNodeEventListener();
            try (NodeEventScope s = graph.trackNodeEvents(listener)) {
                try (Scope s2 = Debug.scope("WithGraphChangeMonitoring")) {
                    if (Debug.isDumpEnabled(Debug.BASIC_LOG_LEVEL)) {
                        Debug.dump(Debug.BASIC_LOG_LEVEL, graph, "*** Before phase %s", getName());
                    }
                    super.run(graph, context);
                    Set<Node> collect = listener.getNodes().stream().filter(e -> !e.isAlive()).filter(e -> !(e instanceof LogicConstantNode)).collect(Collectors.toSet());
                    if (Debug.isDumpEnabled(Debug.BASIC_LOG_LEVEL)) {
                        Debug.dump(Debug.BASIC_LOG_LEVEL, graph, "*** After phase %s %s", getName(), collect);
                    }
                    Debug.log("*** %s %s %s\n", message, graph, collect);
                }
            }
        } else {
            // Go ahead and run it normally even though it should have no effect
            super.run(graph, context);
        }
    }
}
