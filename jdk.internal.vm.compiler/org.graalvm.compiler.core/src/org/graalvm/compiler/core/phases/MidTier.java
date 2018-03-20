/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.core.common.GraalOptions.ConditionalElimination;
import static org.graalvm.compiler.core.common.GraalOptions.ImmutableCode;
import static org.graalvm.compiler.core.common.GraalOptions.OptDeoptimizationGrouping;
import static org.graalvm.compiler.core.common.GraalOptions.OptEliminatePartiallyRedundantGuards;
import static org.graalvm.compiler.core.common.GraalOptions.OptFloatingReads;
import static org.graalvm.compiler.core.common.GraalOptions.OptPushThroughPi;
import static org.graalvm.compiler.core.common.GraalOptions.OptReadElimination;
import static org.graalvm.compiler.core.common.GraalOptions.ReassociateInvariants;
import static org.graalvm.compiler.core.common.GraalOptions.UseGraalInstrumentation;
import static org.graalvm.compiler.core.common.GraalOptions.VerifyHeapAtReturn;

import org.graalvm.compiler.loop.phases.LoopSafepointEliminationPhase;
import org.graalvm.compiler.loop.phases.ReassociateInvariantPhase;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.phases.PhaseSuite;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.common.DeoptimizationGroupingPhase;
import org.graalvm.compiler.phases.common.FloatingReadPhase;
import org.graalvm.compiler.phases.common.FrameStateAssignmentPhase;
import org.graalvm.compiler.phases.common.GuardLoweringPhase;
import org.graalvm.compiler.phases.common.IncrementalCanonicalizerPhase;
import org.graalvm.compiler.phases.common.IterativeConditionalEliminationPhase;
import org.graalvm.compiler.phases.common.LockEliminationPhase;
import org.graalvm.compiler.phases.common.LoopSafepointInsertionPhase;
import org.graalvm.compiler.phases.common.LoweringPhase;
import org.graalvm.compiler.phases.common.OptimizeGuardAnchorsPhase;
import org.graalvm.compiler.phases.common.PushThroughPiPhase;
import org.graalvm.compiler.phases.common.RemoveValueProxyPhase;
import org.graalvm.compiler.phases.common.ValueAnchorCleanupPhase;
import org.graalvm.compiler.phases.common.VerifyHeapAtReturnPhase;
import org.graalvm.compiler.phases.common.instrumentation.MidTierReconcileInstrumentationPhase;
import org.graalvm.compiler.phases.tiers.MidTierContext;
import org.graalvm.compiler.virtual.phases.ea.EarlyReadEliminationPhase;

public class MidTier extends PhaseSuite<MidTierContext> {

    public MidTier() {
        CanonicalizerPhase canonicalizer = new CanonicalizerPhase();
        if (ImmutableCode.getValue()) {
            canonicalizer.disableReadCanonicalization();
        }

        if (OptPushThroughPi.getValue()) {
            appendPhase(new PushThroughPiPhase());
        }

        appendPhase(canonicalizer);

        appendPhase(new ValueAnchorCleanupPhase());
        appendPhase(new LockEliminationPhase());

        if (OptReadElimination.getValue()) {
            appendPhase(new EarlyReadEliminationPhase(canonicalizer));
        }

        if (OptFloatingReads.getValue()) {
            appendPhase(new IncrementalCanonicalizerPhase<>(canonicalizer, new FloatingReadPhase()));
        }
        appendPhase(new RemoveValueProxyPhase());

        appendPhase(canonicalizer);

        if (OptEliminatePartiallyRedundantGuards.getValue()) {
            appendPhase(new OptimizeGuardAnchorsPhase());
        }

        if (ConditionalElimination.getValue()) {
            appendPhase(new IterativeConditionalEliminationPhase(canonicalizer, true));
        }

        if (OptEliminatePartiallyRedundantGuards.getValue()) {
            appendPhase(new OptimizeGuardAnchorsPhase());
        }

        appendPhase(canonicalizer);

        appendPhase(new IncrementalCanonicalizerPhase<>(canonicalizer, new LoopSafepointEliminationPhase()));

        appendPhase(new LoopSafepointInsertionPhase());

        appendPhase(new IncrementalCanonicalizerPhase<>(canonicalizer, new GuardLoweringPhase()));

        if (VerifyHeapAtReturn.getValue()) {
            appendPhase(new VerifyHeapAtReturnPhase());
        }

        appendPhase(new LoweringPhase(canonicalizer, LoweringTool.StandardLoweringStage.MID_TIER));
        if (UseGraalInstrumentation.getValue()) {
            appendPhase(new MidTierReconcileInstrumentationPhase());
        }

        appendPhase(new FrameStateAssignmentPhase());

        if (ReassociateInvariants.getValue()) {
            appendPhase(new ReassociateInvariantPhase());
        }

        if (OptDeoptimizationGrouping.getValue()) {
            appendPhase(new DeoptimizationGroupingPhase());
        }

        appendPhase(canonicalizer);
    }
}
