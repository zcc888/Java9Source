/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.lir.alloc.trace;

import java.util.ArrayList;

import org.graalvm.compiler.core.common.alloc.RegisterAllocationConfig;
import org.graalvm.compiler.core.common.alloc.Trace;
import org.graalvm.compiler.core.common.alloc.TraceBuilderResult;
import org.graalvm.compiler.lir.LIR;
import org.graalvm.compiler.lir.alloc.trace.TraceAllocationPhase.TraceAllocationContext;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.gen.LIRGeneratorTool.MoveFactory;

import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.common.JVMCIError;
import jdk.vm.ci.meta.AllocatableValue;

/**
 * Manages the selection of allocation strategies.
 */
public final class TraceRegisterAllocationPolicy {

    protected abstract class AllocationStrategy {
        TraceAllocationPhase<TraceAllocationContext> allocator;

        public final TraceAllocationPhase<TraceAllocationContext> getAllocator() {
            if (allocator == null) {
                allocator = initAllocator(target, lirGenRes, spillMoveFactory, registerAllocationConfig, cachedStackSlots, resultTraces, neverSpillConstants, strategies);
            }
            return allocator;
        }

        protected final LIR getLIR() {
            return lirGenRes.getLIR();
        }

        protected final LIRGenerationResult getLIRGenerationResult() {
            return lirGenRes;
        }

        protected final TraceBuilderResult getTraceBuilderResult() {
            return resultTraces;
        }

        /**
         * Returns {@code true} if the allocation strategy should be used for {@code trace}.
         */
        public abstract boolean shouldApplyTo(Trace trace);

        @SuppressWarnings("hiding")
        protected abstract TraceAllocationPhase<TraceAllocationContext> initAllocator(TargetDescription target, LIRGenerationResult lirGenRes, MoveFactory spillMoveFactory,
                        RegisterAllocationConfig registerAllocationConfig, AllocatableValue[] cachedStackSlots, TraceBuilderResult resultTraces, boolean neverSpillConstant,
                        ArrayList<AllocationStrategy> strategies);
    }

    private final TargetDescription target;
    private final LIRGenerationResult lirGenRes;
    private final MoveFactory spillMoveFactory;
    private final RegisterAllocationConfig registerAllocationConfig;
    private final AllocatableValue[] cachedStackSlots;
    private final TraceBuilderResult resultTraces;
    private final boolean neverSpillConstants;

    private final ArrayList<AllocationStrategy> strategies;

    public TraceRegisterAllocationPolicy(TargetDescription target, LIRGenerationResult lirGenRes, MoveFactory spillMoveFactory, RegisterAllocationConfig registerAllocationConfig,
                    AllocatableValue[] cachedStackSlots, TraceBuilderResult resultTraces, boolean neverSpillConstant) {
        this.target = target;
        this.lirGenRes = lirGenRes;
        this.spillMoveFactory = spillMoveFactory;
        this.registerAllocationConfig = registerAllocationConfig;
        this.cachedStackSlots = cachedStackSlots;
        this.resultTraces = resultTraces;
        this.neverSpillConstants = neverSpillConstant;

        this.strategies = new ArrayList<>(3);
    }

    public void appendStrategy(AllocationStrategy strategy) {
        strategies.add(strategy);
    }

    public TraceAllocationPhase<TraceAllocationContext> selectStrategy(Trace trace) {
        for (AllocationStrategy strategy : strategies) {
            if (strategy.shouldApplyTo(trace)) {
                return strategy.getAllocator();
            }
        }
        throw JVMCIError.shouldNotReachHere("No Allocation Strategy found!");
    }

}
