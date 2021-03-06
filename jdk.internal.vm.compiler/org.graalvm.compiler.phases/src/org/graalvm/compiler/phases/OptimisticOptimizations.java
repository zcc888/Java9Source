/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.phases;

import java.util.EnumSet;
import java.util.Set;

import org.graalvm.compiler.core.common.GraalOptions;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.DebugCounter;

import jdk.vm.ci.meta.DeoptimizationReason;
import jdk.vm.ci.meta.ProfilingInfo;

public final class OptimisticOptimizations {

    public static final OptimisticOptimizations ALL = new OptimisticOptimizations(EnumSet.allOf(Optimization.class));
    public static final OptimisticOptimizations NONE = new OptimisticOptimizations(EnumSet.noneOf(Optimization.class));
    private static final DebugCounter disabledOptimisticOptsCounter = Debug.counter("DisabledOptimisticOpts");

    public enum Optimization {
        RemoveNeverExecutedCode,
        UseTypeCheckedInlining,
        UseTypeCheckHints,
        UseExceptionProbabilityForOperations,
        UseExceptionProbability,
        UseLoopLimitChecks
    }

    private final Set<Optimization> enabledOpts;

    public OptimisticOptimizations(ProfilingInfo info) {
        this.enabledOpts = EnumSet.noneOf(Optimization.class);

        enabledOpts.add(Optimization.UseExceptionProbabilityForOperations);
        addOptimization(info, DeoptimizationReason.UnreachedCode, Optimization.RemoveNeverExecutedCode);
        addOptimization(info, DeoptimizationReason.TypeCheckedInliningViolated, Optimization.UseTypeCheckedInlining);
        addOptimization(info, DeoptimizationReason.OptimizedTypeCheckViolated, Optimization.UseTypeCheckHints);
        addOptimization(info, DeoptimizationReason.NotCompiledExceptionHandler, Optimization.UseExceptionProbability);
        addOptimization(info, DeoptimizationReason.LoopLimitCheck, Optimization.UseLoopLimitChecks);
    }

    private void addOptimization(ProfilingInfo info, DeoptimizationReason deoptReason, Optimization optimization) {
        if (checkDeoptimizations(info, deoptReason)) {
            enabledOpts.add(optimization);
        } else {
            disabledOptimisticOptsCounter.increment();
        }
    }

    public OptimisticOptimizations remove(Optimization... optimizations) {
        Set<Optimization> newOptimizations = EnumSet.copyOf(enabledOpts);
        for (Optimization o : optimizations) {
            newOptimizations.remove(o);
        }
        return new OptimisticOptimizations(newOptimizations);
    }

    public OptimisticOptimizations add(Optimization... optimizations) {
        Set<Optimization> newOptimizations = EnumSet.copyOf(enabledOpts);
        for (Optimization o : optimizations) {
            newOptimizations.add(o);
        }
        return new OptimisticOptimizations(newOptimizations);
    }

    private OptimisticOptimizations(Set<Optimization> enabledOpts) {
        this.enabledOpts = enabledOpts;
    }

    public boolean removeNeverExecutedCode() {
        return GraalOptions.RemoveNeverExecutedCode.getValue() && enabledOpts.contains(Optimization.RemoveNeverExecutedCode);
    }

    public boolean useTypeCheckHints() {
        return GraalOptions.UseTypeCheckHints.getValue() && enabledOpts.contains(Optimization.UseTypeCheckHints);
    }

    public boolean inlineMonomorphicCalls() {
        return GraalOptions.InlineMonomorphicCalls.getValue() && enabledOpts.contains(Optimization.UseTypeCheckedInlining);
    }

    public boolean inlinePolymorphicCalls() {
        return GraalOptions.InlinePolymorphicCalls.getValue() && enabledOpts.contains(Optimization.UseTypeCheckedInlining);
    }

    public boolean inlineMegamorphicCalls() {
        return GraalOptions.InlineMegamorphicCalls.getValue() && enabledOpts.contains(Optimization.UseTypeCheckedInlining);
    }

    public boolean devirtualizeInvokes() {
        return GraalOptions.OptDevirtualizeInvokesOptimistically.getValue() && enabledOpts.contains(Optimization.UseTypeCheckedInlining);
    }

    public boolean useExceptionProbability() {
        return GraalOptions.UseExceptionProbability.getValue() && enabledOpts.contains(Optimization.UseExceptionProbability);
    }

    public boolean useExceptionProbabilityForOperations() {
        return GraalOptions.UseExceptionProbabilityForOperations.getValue() && enabledOpts.contains(Optimization.UseExceptionProbabilityForOperations);
    }

    public boolean useLoopLimitChecks() {
        return GraalOptions.UseLoopLimitChecks.getValue() && enabledOpts.contains(Optimization.UseLoopLimitChecks);
    }

    public boolean lessOptimisticThan(OptimisticOptimizations other) {
        for (Optimization opt : Optimization.values()) {
            if (!enabledOpts.contains(opt) && other.enabledOpts.contains(opt)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDeoptimizations(ProfilingInfo profilingInfo, DeoptimizationReason reason) {
        return profilingInfo.getDeoptimizationCount(reason) < GraalOptions.DeoptsToDisableOptimisticOptimization.getValue();
    }

    @Override
    public String toString() {
        return enabledOpts.toString();
    }
}
