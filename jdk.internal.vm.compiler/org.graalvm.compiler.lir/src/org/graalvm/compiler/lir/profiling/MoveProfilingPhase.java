/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.lir.profiling;

import java.util.ArrayList;
import java.util.List;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.core.common.cfg.BlockMap;
import org.graalvm.compiler.lir.ConstantValue;
import org.graalvm.compiler.lir.LIR;
import org.graalvm.compiler.lir.LIRInsertionBuffer;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.gen.DiagnosticLIRGeneratorTool;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.phases.PostAllocationOptimizationPhase;
import org.graalvm.compiler.lir.profiling.MoveProfiler.MoveStatistics;
import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.OptionValue;

import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.Value;

/**
 * Inserts counters into the {@link LIR} code to the number of move instruction dynamically
 * executed.
 */
public class MoveProfilingPhase extends PostAllocationOptimizationPhase {

    public static class Options {
        // @formatter:off
        @Option(help = "Enable dynamic move profiling per method.", type = OptionType.Debug)
        public static final OptionValue<Boolean> LIRDynMoveProfilMethod = new OptionValue<>(false);
        // @formatter:on
    }

    private static final String MOVE_OPERATIONS = "MoveOperations";

    @Override
    protected void run(TargetDescription target, LIRGenerationResult lirGenRes, PostAllocationOptimizationContext context) {
        new Analyzer(target, lirGenRes, context.diagnosticLirGenTool).run();
    }

    static class Analyzer {
        private final TargetDescription target;
        private final LIRGenerationResult lirGenRes;
        private final DiagnosticLIRGeneratorTool diagnosticLirGenTool;
        private final LIRInsertionBuffer buffer;
        private String cachedGroupName;
        private final List<String> names;
        private final List<String> groups;
        private final List<Value> increments;

        Analyzer(TargetDescription target, LIRGenerationResult lirGenRes, DiagnosticLIRGeneratorTool diagnosticLirGenTool) {
            this.target = target;
            this.lirGenRes = lirGenRes;
            this.diagnosticLirGenTool = diagnosticLirGenTool;
            this.buffer = new LIRInsertionBuffer();
            this.names = new ArrayList<>();
            this.groups = new ArrayList<>();
            this.increments = new ArrayList<>();
        }

        public void run() {
            LIR lir = lirGenRes.getLIR();
            BlockMap<MoveStatistics> collected = MoveProfiler.profile(lir);
            for (AbstractBlockBase<?> block : lir.getControlFlowGraph().getBlocks()) {
                MoveStatistics moveStatistics = collected.get(block);
                if (moveStatistics != null) {
                    names.clear();
                    groups.clear();
                    increments.clear();
                    doBlock(block, moveStatistics);
                }
            }
        }

        public void doBlock(AbstractBlockBase<?> block, MoveStatistics moveStatistics) {
            // counter insertion phase
            for (MoveType type : MoveType.values()) {
                String name = type.toString();
                // current run
                addEntry(name, getGroupName(), moveStatistics.get(type));
            }
            insertBenchmarkCounter(block);
        }

        protected final void addEntry(String name, String groupName, int count) {
            if (count > 0) {
                names.add(name);
                groups.add(groupName);
                increments.add(new ConstantValue(LIRKind.fromJavaKind(target.arch, JavaKind.Int), JavaConstant.forInt(count)));
            }
        }

        protected final void insertBenchmarkCounter(AbstractBlockBase<?> block) {
            int size = names.size();
            if (size > 0) { // Don't pollute LIR when nothing has to be done
                assert size > 0 && size == groups.size() && size == increments.size();
                List<LIRInstruction> instructions = lirGenRes.getLIR().getLIRforBlock(block);
                LIRInstruction inst = diagnosticLirGenTool.createMultiBenchmarkCounter(names.toArray(new String[size]), groups.toArray(new String[size]),
                                increments.toArray(new Value[size]));
                assert inst != null;
                buffer.init(instructions);
                buffer.append(1, inst);
                buffer.finish();
            }
        }

        protected final String getGroupName() {
            if (cachedGroupName == null) {
                cachedGroupName = createGroupName();
            }
            return cachedGroupName;
        }

        protected String createGroupName() {
            if (Options.LIRDynMoveProfilMethod.getValue()) {
                return new StringBuilder('"').append(MOVE_OPERATIONS).append(':').append(lirGenRes.getCompilationUnitName()).append('"').toString();
            }
            return MOVE_OPERATIONS;
        }
    }

}
