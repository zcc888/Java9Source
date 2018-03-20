/*
 * Copyright (c) 2016, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.lir.ssi;

import java.util.BitSet;

import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.lir.alloc.lsra.LinearScanLifetimeAnalysisPhase;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.phases.AllocationPhase;
import org.graalvm.compiler.lir.ssa.SSAUtil;
import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.StableOptionValue;

import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.common.JVMCIError;

/**
 * Constructs {@linkplain SSIUtil SSI LIR} using a liveness analysis.
 *
 * Implementation derived from {@link LinearScanLifetimeAnalysisPhase}.
 *
 * @see SSIUtil
 */
public final class SSIConstructionPhase extends AllocationPhase {

    static class Options {

        //@formatter:off
        @Option(help = "Use fast SSI builder.", type = OptionType.Debug)
        public static final StableOptionValue<Boolean> TraceRAFastSSIBuilder = new StableOptionValue<>(true);
        //@formatter:on
    }

    @Override
    protected void run(TargetDescription target, LIRGenerationResult lirGenRes, AllocationContext context) {
        assert SSAUtil.verifySSAForm(lirGenRes.getLIR());
        if (Options.TraceRAFastSSIBuilder.getValue()) {
            FastSSIBuilder fastSSIBuilder = new FastSSIBuilder(lirGenRes.getLIR());
            fastSSIBuilder.build();
            fastSSIBuilder.finish();
        } else {
            SSIBuilder ssiBuilder = new SSIBuilder(lirGenRes.getLIR());
            ssiBuilder.build();
            ssiBuilder.finish();
        }
    }

    static void check(AbstractBlockBase<?>[] blocks, SSIBuilderBase liveSets1, SSIBuilderBase liveSets2) {
        for (AbstractBlockBase<?> block : blocks) {
            check(block, liveSets1.getLiveIn(block), liveSets2.getLiveIn(block));
            check(block, liveSets1.getLiveOut(block), liveSets2.getLiveOut(block));
        }
    }

    private static void check(AbstractBlockBase<?> block, BitSet liveIn1, BitSet liveIn2) {
        if (!liveIn1.equals(liveIn2)) {
            throw JVMCIError.shouldNotReachHere(String.format("%s LiveSet differ: %s vs %s", block, liveIn1, liveIn2));
        }
    }
}
