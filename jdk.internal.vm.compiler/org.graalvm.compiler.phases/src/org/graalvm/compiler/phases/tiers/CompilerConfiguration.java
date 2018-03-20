/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.phases.tiers;

import org.graalvm.compiler.lir.phases.AllocationPhase.AllocationContext;
import org.graalvm.compiler.lir.phases.LIRPhaseSuite;
import org.graalvm.compiler.lir.phases.PostAllocationOptimizationPhase.PostAllocationOptimizationContext;
import org.graalvm.compiler.lir.phases.PreAllocationOptimizationPhase.PreAllocationOptimizationContext;
import org.graalvm.compiler.phases.PhaseSuite;

public interface CompilerConfiguration {

    PhaseSuite<HighTierContext> createHighTier();

    PhaseSuite<MidTierContext> createMidTier();

    PhaseSuite<LowTierContext> createLowTier();

    LIRPhaseSuite<PreAllocationOptimizationContext> createPreAllocationOptimizationStage();

    LIRPhaseSuite<AllocationContext> createAllocationStage();

    LIRPhaseSuite<PostAllocationOptimizationContext> createPostAllocationOptimizationStage();
}
