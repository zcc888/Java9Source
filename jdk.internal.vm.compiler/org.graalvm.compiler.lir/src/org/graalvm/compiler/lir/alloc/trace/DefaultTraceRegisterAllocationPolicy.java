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
import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.lir.alloc.trace.TraceAllocationPhase.TraceAllocationContext;
import org.graalvm.compiler.lir.alloc.trace.TraceRegisterAllocationPolicy.AllocationStrategy;
import org.graalvm.compiler.lir.alloc.trace.bu.BottomUpAllocator;
import org.graalvm.compiler.lir.alloc.trace.lsra.TraceLinearScanPhase;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.gen.LIRGeneratorTool.MoveFactory;
import org.graalvm.compiler.options.EnumOptionValue;
import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.StableOptionValue;

import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.common.JVMCIError;
import jdk.vm.ci.meta.AllocatableValue;

/**
 * Manages the selection of allocation strategies.
 */
public final class DefaultTraceRegisterAllocationPolicy {

    public enum TraceRAPolicies {
        Default,
        LinearScanOnly,
        BottomUpOnly
    }

    public static class Options {
        // @formatter:off
        @Option(help = "Use special allocator for trivial blocks.", type = OptionType.Debug)
        public static final StableOptionValue<Boolean> TraceRAtrivialBlockAllocator = new StableOptionValue<>(true);
        @Option(help = "Use LSRA / BottomUp ratio", type = OptionType.Debug)
        public static final StableOptionValue<Double> TraceRAbottomUpRatio = new StableOptionValue<>(0.0);
        @Option(help = "TraceRA allocation policy to use.", type = OptionType.Debug)
        public static final EnumOptionValue<TraceRAPolicies> TraceRAPolicy = new EnumOptionValue<>(TraceRAPolicies.Default);
        // @formatter:on
    }

    public static final class TrivialTraceStrategy extends AllocationStrategy {

        public TrivialTraceStrategy(TraceRegisterAllocationPolicy plan) {
            plan.super();
        }

        @Override
        public boolean shouldApplyTo(Trace trace) {
            return TraceUtil.isTrivialTrace(getLIR(), trace);
        }

        @Override
        protected TraceAllocationPhase<TraceAllocationContext> initAllocator(TargetDescription target, LIRGenerationResult lirGenRes, MoveFactory spillMoveFactory,
                        RegisterAllocationConfig registerAllocationConfig, AllocatableValue[] cachedStackSlots, TraceBuilderResult resultTraces, boolean neverSpillConstant,
                        ArrayList<AllocationStrategy> strategies) {
            return new TrivialTraceAllocator();
        }
    }

    public static class BottomUpStrategy extends AllocationStrategy {

        public BottomUpStrategy(TraceRegisterAllocationPolicy plan) {
            // explicitly specify the enclosing instance for the superclass constructor call
            plan.super();
        }

        @Override
        public boolean shouldApplyTo(Trace trace) {
            return !containsExceptionEdge(trace);
        }

        private static boolean containsExceptionEdge(Trace trace) {
            for (AbstractBlockBase<?> block : trace.getBlocks()) {
                // check if one of the successors is an exception handler
                for (AbstractBlockBase<?> succ : block.getSuccessors()) {
                    if (succ.isExceptionEntry()) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        protected TraceAllocationPhase<TraceAllocationContext> initAllocator(TargetDescription target, LIRGenerationResult lirGenRes, MoveFactory spillMoveFactory,
                        RegisterAllocationConfig registerAllocationConfig, AllocatableValue[] cachedStackSlots, TraceBuilderResult resultTraces, boolean neverSpillConstant,
                        ArrayList<AllocationStrategy> strategies) {
            return new BottomUpAllocator(target, lirGenRes, spillMoveFactory, registerAllocationConfig, cachedStackSlots, resultTraces, neverSpillConstant);
        }
    }

    public static final class TraceLinearScanStrategy extends AllocationStrategy {

        public TraceLinearScanStrategy(TraceRegisterAllocationPolicy plan) {
            // explicitly specify the enclosing instance for the superclass constructor call
            plan.super();
        }

        @Override
        public boolean shouldApplyTo(Trace trace) {
            return true;
        }

        @Override
        protected TraceAllocationPhase<TraceAllocationContext> initAllocator(TargetDescription target, LIRGenerationResult lirGenRes, MoveFactory spillMoveFactory,
                        RegisterAllocationConfig registerAllocationConfig, AllocatableValue[] cachedStackSlots, TraceBuilderResult resultTraces, boolean neverSpillConstant,
                        ArrayList<AllocationStrategy> strategies) {
            return new TraceLinearScanPhase(target, lirGenRes, spillMoveFactory, registerAllocationConfig, resultTraces, neverSpillConstant, cachedStackSlots);
        }
    }

    public static TraceRegisterAllocationPolicy allocationPolicy(TargetDescription target, LIRGenerationResult lirGenRes, MoveFactory spillMoveFactory,
                    RegisterAllocationConfig registerAllocationConfig, AllocatableValue[] cachedStackSlots, TraceBuilderResult resultTraces, boolean neverSpillConstant) {
        TraceRegisterAllocationPolicy plan = new TraceRegisterAllocationPolicy(target, lirGenRes, spillMoveFactory, registerAllocationConfig, cachedStackSlots, resultTraces, neverSpillConstant);
        if (Options.TraceRAtrivialBlockAllocator.getValue()) {
            plan.appendStrategy(new TrivialTraceStrategy(plan));
        }
        switch (Options.TraceRAPolicy.getValue()) {
            case Default:
            case LinearScanOnly:
                plan.appendStrategy(new TraceLinearScanStrategy(plan));
                break;
            case BottomUpOnly:
                plan.appendStrategy(new BottomUpStrategy(plan));
                // Fallback
                plan.appendStrategy(new TraceLinearScanStrategy(plan));
                break;
            default:
                throw JVMCIError.shouldNotReachHere();
        }
        return plan;
    }
}
