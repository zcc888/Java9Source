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

import static org.graalvm.compiler.core.common.GraalOptions.EscapeAnalyzeOnly;

import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.ScheduleResult;
import org.graalvm.compiler.nodes.cfg.ControlFlowGraph;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;

public class EarlyReadEliminationPhase extends EffectsPhase<PhaseContext> {

    public EarlyReadEliminationPhase(CanonicalizerPhase canonicalizer) {
        super(1, canonicalizer, true);
    }

    @Override
    protected void run(StructuredGraph graph, PhaseContext context) {
        if (VirtualUtil.matches(graph, EscapeAnalyzeOnly.getValue())) {
            runAnalysis(graph, context);
        }
    }

    @Override
    protected Closure<?> createEffectsClosure(PhaseContext context, ScheduleResult schedule, ControlFlowGraph cfg) {
        assert schedule == null;
        return new ReadEliminationClosure(cfg);
    }
}
