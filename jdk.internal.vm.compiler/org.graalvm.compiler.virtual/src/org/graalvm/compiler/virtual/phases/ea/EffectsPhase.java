/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.virtual.phases.ea;

import static org.graalvm.compiler.debug.Debug.isEnabled;
import static org.graalvm.compiler.phases.common.DeadCodeEliminationPhase.Optionality.Required;

import java.util.Set;

import org.graalvm.compiler.core.common.util.CompilationAlarm;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.Debug.Scope;
import org.graalvm.compiler.graph.Graph.NodeEventScope;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.spi.Simplifiable;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.ScheduleResult;
import org.graalvm.compiler.nodes.cfg.ControlFlowGraph;
import org.graalvm.compiler.phases.BasePhase;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.common.DeadCodeEliminationPhase;
import org.graalvm.compiler.phases.common.util.HashSetNodeEventListener;
import org.graalvm.compiler.phases.graph.ReentrantBlockIterator;
import org.graalvm.compiler.phases.schedule.SchedulePhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;

public abstract class EffectsPhase<PhaseContextT extends PhaseContext> extends BasePhase<PhaseContextT> {

    public abstract static class Closure<T> extends ReentrantBlockIterator.BlockIteratorClosure<T> {

        public abstract boolean hasChanged();

        public abstract void applyEffects();
    }

    private final int maxIterations;
    protected final CanonicalizerPhase canonicalizer;
    private final boolean unscheduled;

    protected EffectsPhase(int maxIterations, CanonicalizerPhase canonicalizer) {
        this(maxIterations, canonicalizer, false);
    }

    protected EffectsPhase(int maxIterations, CanonicalizerPhase canonicalizer, boolean unscheduled) {
        this.maxIterations = maxIterations;
        this.canonicalizer = canonicalizer;
        this.unscheduled = unscheduled;
    }

    @Override
    protected void run(StructuredGraph graph, PhaseContextT context) {
        runAnalysis(graph, context);
    }

    @SuppressWarnings("try")
    public boolean runAnalysis(final StructuredGraph graph, final PhaseContextT context) {
        boolean changed = false;
        boolean stop = false;
        for (int iteration = 0; !stop && iteration < maxIterations && !CompilationAlarm.hasExpired(); iteration++) {
            try (Scope s = Debug.scope(isEnabled() ? "iteration " + iteration : null)) {
                ScheduleResult schedule;
                ControlFlowGraph cfg;
                if (unscheduled) {
                    schedule = null;
                    cfg = ControlFlowGraph.compute(graph, true, true, false, false);
                } else {
                    new SchedulePhase(SchedulePhase.SchedulingStrategy.EARLIEST).apply(graph, false);
                    schedule = graph.getLastSchedule();
                    cfg = schedule.getCFG();
                }
                try (Scope scheduleScope = Debug.scope("EffectsPhaseWithSchedule", schedule)) {
                    Closure<?> closure = createEffectsClosure(context, schedule, cfg);
                    ReentrantBlockIterator.apply(closure, cfg.getStartBlock());

                    if (closure.hasChanged()) {
                        changed = true;
                    } else {
                        stop = true;
                    }

                    // apply the effects collected during this iteration
                    HashSetNodeEventListener listener = new HashSetNodeEventListener();
                    try (NodeEventScope nes = graph.trackNodeEvents(listener)) {
                        closure.applyEffects();
                    }

                    if (Debug.isDumpEnabled(Debug.INFO_LOG_LEVEL)) {
                        Debug.dump(Debug.INFO_LOG_LEVEL, graph, "%s iteration", getName());
                    }

                    new DeadCodeEliminationPhase(Required).apply(graph);

                    Set<Node> changedNodes = listener.getNodes();
                    for (Node node : graph.getNodes()) {
                        if (node instanceof Simplifiable) {
                            changedNodes.add(node);
                        }
                    }
                    postIteration(graph, context, changedNodes);
                } catch (Throwable t) {
                    throw Debug.handle(t);
                }
            }
        }
        return changed;
    }

    protected void postIteration(final StructuredGraph graph, final PhaseContextT context, Set<Node> changedNodes) {
        if (canonicalizer != null) {
            canonicalizer.applyIncremental(graph, context, changedNodes);
        }
    }

    protected abstract Closure<?> createEffectsClosure(PhaseContextT context, ScheduleResult schedule, ControlFlowGraph cfg);
}
