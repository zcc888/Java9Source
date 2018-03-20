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

import static org.graalvm.compiler.lir.alloc.trace.TraceUtil.isTrivialTrace;

import java.util.List;

import org.graalvm.compiler.core.common.alloc.BiDirectionalTraceBuilder;
import org.graalvm.compiler.core.common.alloc.SingleBlockTraceBuilder;
import org.graalvm.compiler.core.common.alloc.Trace;
import org.graalvm.compiler.core.common.alloc.TraceBuilderResult;
import org.graalvm.compiler.core.common.alloc.TraceBuilderResult.TrivialTracePredicate;
import org.graalvm.compiler.core.common.alloc.TraceStatisticsPrinter;
import org.graalvm.compiler.core.common.alloc.UniDirectionalTraceBuilder;
import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.lir.LIR;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.phases.AllocationPhase;
import org.graalvm.compiler.options.EnumOptionValue;
import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.OptionValue;

import jdk.vm.ci.code.TargetDescription;

public class TraceBuilderPhase extends AllocationPhase {

    public enum TraceBuilder {
        UniDirectional,
        BiDirectional,
        SingleBlock
    }

    public static class Options {
        // @formatter:off
        @Option(help = "Trace building algorithm.", type = OptionType.Debug)
        public static final EnumOptionValue<TraceBuilder> TraceBuilding = new EnumOptionValue<>(TraceBuilder.UniDirectional);
        @Option(help = "Schedule trivial traces as early as possible.", type = OptionType.Debug)
        public static final OptionValue<Boolean> TraceRAScheduleTrivialTracesEarly = new OptionValue<>(true);
        // @formatter:on
    }

    private static final int TRACE_LOG_LEVEL = 1;
    public static final int TRACE_DUMP_LEVEL = 3;

    @Override
    protected void run(TargetDescription target, LIRGenerationResult lirGenRes, AllocationContext context) {
        AbstractBlockBase<?>[] linearScanOrder = lirGenRes.getLIR().linearScanOrder();
        AbstractBlockBase<?> startBlock = linearScanOrder[0];
        LIR lir = lirGenRes.getLIR();
        assert startBlock.equals(lir.getControlFlowGraph().getStartBlock());

        final TraceBuilderResult traceBuilderResult = getTraceBuilderResult(lir, startBlock, linearScanOrder);

        if (Debug.isLogEnabled(TRACE_LOG_LEVEL)) {
            List<Trace> traces = traceBuilderResult.getTraces();
            for (int i = 0; i < traces.size(); i++) {
                Trace trace = traces.get(i);
                Debug.log(TRACE_LOG_LEVEL, "Trace %5d: %s%s", i, trace, isTrivialTrace(lirGenRes.getLIR(), trace) ? " (trivial)" : "");
            }
        }
        TraceStatisticsPrinter.printTraceStatistics(traceBuilderResult, lirGenRes.getCompilationUnitName());
        Debug.dump(TRACE_DUMP_LEVEL, traceBuilderResult, "After TraceBuilding");
        context.contextAdd(traceBuilderResult);
    }

    private static TraceBuilderResult getTraceBuilderResult(LIR lir, AbstractBlockBase<?> startBlock, AbstractBlockBase<?>[] linearScanOrder) {
        TraceBuilderResult.TrivialTracePredicate pred = getTrivialTracePredicate(lir);

        TraceBuilder selectedTraceBuilder = Options.TraceBuilding.getValue();
        Debug.log(TRACE_LOG_LEVEL, "Building Traces using %s", selectedTraceBuilder);
        switch (Options.TraceBuilding.getValue()) {
            case SingleBlock:
                return SingleBlockTraceBuilder.computeTraces(startBlock, linearScanOrder, pred);
            case BiDirectional:
                return BiDirectionalTraceBuilder.computeTraces(startBlock, linearScanOrder, pred);
            case UniDirectional:
                return UniDirectionalTraceBuilder.computeTraces(startBlock, linearScanOrder, pred);
        }
        throw GraalError.shouldNotReachHere("Unknown trace building algorithm: " + Options.TraceBuilding.getValue());
    }

    public static TraceBuilderResult.TrivialTracePredicate getTrivialTracePredicate(LIR lir) {
        if (!Options.TraceRAScheduleTrivialTracesEarly.getValue()) {
            return null;
        }
        return new TrivialTracePredicate() {
            @Override
            public boolean isTrivialTrace(Trace trace) {
                return TraceUtil.isTrivialTrace(lir, trace);
            }
        };
    }
}
