/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.core.common.GraalOptions.EscapeAnalysisIterations;
import static org.graalvm.compiler.core.common.GraalOptions.EscapeAnalyzeOnly;

import java.util.Set;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.ScheduleResult;
import org.graalvm.compiler.nodes.cfg.ControlFlowGraph;
import org.graalvm.compiler.nodes.virtual.VirtualObjectNode;
import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.OptionValue;
import org.graalvm.compiler.phases.BasePhase;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;

public class PartialEscapePhase extends EffectsPhase<PhaseContext> {

    static class Options {
        //@formatter:off
        @Option(help = "", type = OptionType.Debug)
        public static final OptionValue<Boolean> OptEarlyReadElimination = new OptionValue<>(true);
        //@formatter:on
    }

    private final boolean readElimination;
    private final BasePhase<PhaseContext> cleanupPhase;

    public PartialEscapePhase(boolean iterative, CanonicalizerPhase canonicalizer) {
        this(iterative, Options.OptEarlyReadElimination.getValue(), canonicalizer, null);
    }

    public PartialEscapePhase(boolean iterative, CanonicalizerPhase canonicalizer, BasePhase<PhaseContext> cleanupPhase) {
        this(iterative, Options.OptEarlyReadElimination.getValue(), canonicalizer, cleanupPhase);
    }

    public PartialEscapePhase(boolean iterative, boolean readElimination, CanonicalizerPhase canonicalizer, BasePhase<PhaseContext> cleanupPhase) {
        super(iterative ? EscapeAnalysisIterations.getValue() : 1, canonicalizer);
        this.readElimination = readElimination;
        this.cleanupPhase = cleanupPhase;
    }

    @Override
    protected void postIteration(StructuredGraph graph, PhaseContext context, Set<Node> changedNodes) {
        super.postIteration(graph, context, changedNodes);
        if (cleanupPhase != null) {
            cleanupPhase.apply(graph, context);
        }
    }

    @Override
    protected void run(StructuredGraph graph, PhaseContext context) {
        if (VirtualUtil.matches(graph, EscapeAnalyzeOnly.getValue())) {
            if (readElimination || graph.hasVirtualizableAllocation()) {
                runAnalysis(graph, context);
            }
        }
    }

    @Override
    protected Closure<?> createEffectsClosure(PhaseContext context, ScheduleResult schedule, ControlFlowGraph cfg) {
        for (VirtualObjectNode virtual : cfg.graph.getNodes(VirtualObjectNode.TYPE)) {
            virtual.resetObjectId();
        }
        assert schedule != null;
        if (readElimination) {
            return new PEReadEliminationClosure(schedule, context.getMetaAccess(), context.getConstantReflection(), context.getConstantFieldProvider(), context.getLowerer());
        } else {
            return new PartialEscapeClosure.Final(schedule, context.getMetaAccess(), context.getConstantReflection(), context.getConstantFieldProvider(), context.getLowerer());
        }
    }

    @Override
    public boolean checkContract() {
        return false;
    }

}
