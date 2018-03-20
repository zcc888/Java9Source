/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.alloc.RegisterAllocationConfig;
import org.graalvm.compiler.core.common.alloc.Trace;
import org.graalvm.compiler.core.common.alloc.TraceBuilderResult;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.Debug.Scope;
import org.graalvm.compiler.debug.DebugCloseable;
import org.graalvm.compiler.debug.DebugCounter;
import org.graalvm.compiler.debug.DebugMemUseTracker;
import org.graalvm.compiler.debug.DebugTimer;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.gen.LIRGeneratorTool.MoveFactory;
import org.graalvm.compiler.lir.phases.LIRPhase;
import org.graalvm.compiler.lir.phases.LIRPhase.LIRPhaseStatistics;

import jdk.vm.ci.code.TargetDescription;

public abstract class TraceAllocationPhase<C extends TraceAllocationPhase.TraceAllocationContext> {

    public static class TraceAllocationContext {
        public final MoveFactory spillMoveFactory;
        public final RegisterAllocationConfig registerAllocationConfig;
        public final TraceBuilderResult resultTraces;

        public TraceAllocationContext(MoveFactory spillMoveFactory, RegisterAllocationConfig registerAllocationConfig, TraceBuilderResult resultTraces) {
            this.spillMoveFactory = spillMoveFactory;
            this.registerAllocationConfig = registerAllocationConfig;
            this.resultTraces = resultTraces;
        }
    }

    /**
     * Records time spent within {@link #apply}.
     */
    private final DebugTimer timer;

    /**
     * Records memory usage within {@link #apply}.
     */
    private final DebugMemUseTracker memUseTracker;

    /**
     * Records the number of traces allocated with this phase.
     */
    private final DebugCounter allocatedTraces;

    private static final class AllocationStatistics {
        private final DebugCounter allocatedTraces;

        private AllocationStatistics(Class<?> clazz) {
            allocatedTraces = Debug.counter("TraceRA[%s]", clazz);
        }
    }

    private static final ClassValue<AllocationStatistics> counterClassValue = new ClassValue<AllocationStatistics>() {
        @Override
        protected AllocationStatistics computeValue(Class<?> c) {
            return new AllocationStatistics(c);
        }
    };

    public TraceAllocationPhase() {
        LIRPhaseStatistics statistics = LIRPhase.statisticsClassValue.get(getClass());
        timer = statistics.timer;
        memUseTracker = statistics.memUseTracker;
        allocatedTraces = counterClassValue.get(getClass()).allocatedTraces;
    }

    public final CharSequence getName() {
        return LIRPhase.createName(getClass());
    }

    @Override
    public final String toString() {
        return getName().toString();
    }

    public final void apply(TargetDescription target, LIRGenerationResult lirGenRes, Trace trace, C context) {
        apply(target, lirGenRes, trace, context, true);
    }

    @SuppressWarnings("try")
    public final void apply(TargetDescription target, LIRGenerationResult lirGenRes, Trace trace, C context, boolean dumpTrace) {
        try (Scope s = Debug.scope(getName(), this)) {
            try (DebugCloseable a = timer.start(); DebugCloseable c = memUseTracker.start()) {
                if (dumpTrace && Debug.isDumpEnabled(TraceBuilderPhase.TRACE_DUMP_LEVEL + 1)) {
                    Debug.dump(TraceBuilderPhase.TRACE_DUMP_LEVEL + 1, trace, "%s before (Trace%s: %s)", getName(), trace.getId(), trace);
                }
                run(target, lirGenRes, trace, context);
                allocatedTraces.increment();
                if (dumpTrace && Debug.isDumpEnabled(TraceBuilderPhase.TRACE_DUMP_LEVEL)) {
                    Debug.dump(TraceBuilderPhase.TRACE_DUMP_LEVEL, trace, "%s (Trace%s: %s)", getName(), trace.getId(), trace);
                }
            }
        } catch (Throwable e) {
            throw Debug.handle(e);
        }
    }

    protected abstract void run(TargetDescription target, LIRGenerationResult lirGenRes, Trace trace, C context);
}
