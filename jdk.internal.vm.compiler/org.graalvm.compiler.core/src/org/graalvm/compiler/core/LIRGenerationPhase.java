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
package org.graalvm.compiler.core;

import java.util.List;

import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.core.common.cfg.BlockMap;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.DebugCounter;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.gen.LIRGeneratorTool;
import org.graalvm.compiler.lir.phases.LIRPhase;
import org.graalvm.compiler.lir.ssa.SSAUtil;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.ScheduleResult;
import org.graalvm.compiler.nodes.cfg.Block;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

import jdk.vm.ci.code.TargetDescription;

public class LIRGenerationPhase extends LIRPhase<LIRGenerationPhase.LIRGenerationContext> {

    public static final class LIRGenerationContext {
        private final NodeLIRBuilderTool nodeLirBuilder;
        private final LIRGeneratorTool lirGen;
        private final StructuredGraph graph;
        private final ScheduleResult schedule;

        public LIRGenerationContext(LIRGeneratorTool lirGen, NodeLIRBuilderTool nodeLirBuilder, StructuredGraph graph, ScheduleResult schedule) {
            this.nodeLirBuilder = nodeLirBuilder;
            this.lirGen = lirGen;
            this.graph = graph;
            this.schedule = schedule;
        }
    }

    private static final DebugCounter instructionCounter = Debug.counter("GeneratedLIRInstructions");

    @Override
    protected final void run(TargetDescription target, LIRGenerationResult lirGenRes, LIRGenerationPhase.LIRGenerationContext context) {
        NodeLIRBuilderTool nodeLirBuilder = context.nodeLirBuilder;
        StructuredGraph graph = context.graph;
        ScheduleResult schedule = context.schedule;
        for (AbstractBlockBase<?> b : lirGenRes.getLIR().getControlFlowGraph().getBlocks()) {
            emitBlock(nodeLirBuilder, lirGenRes, (Block) b, graph, schedule.getBlockToNodesMap());
        }
        context.lirGen.beforeRegisterAllocation();
        assert SSAUtil.verifySSAForm(lirGenRes.getLIR());
    }

    private static void emitBlock(NodeLIRBuilderTool nodeLirGen, LIRGenerationResult lirGenRes, Block b, StructuredGraph graph, BlockMap<List<Node>> blockMap) {
        assert !isProcessed(lirGenRes, b) : "Block already processed " + b;
        assert verifyPredecessors(lirGenRes, b);
        nodeLirGen.doBlock(b, graph, blockMap);
        if (instructionCounter.isEnabled()) {
            instructionCounter.add(lirGenRes.getLIR().getLIRforBlock(b).size());
        }
    }

    private static boolean verifyPredecessors(LIRGenerationResult lirGenRes, Block block) {
        for (Block pred : block.getPredecessors()) {
            if (!block.isLoopHeader() || !pred.isLoopEnd()) {
                assert isProcessed(lirGenRes, pred) : "Predecessor not yet processed " + pred;
            }
        }
        return true;
    }

    private static boolean isProcessed(LIRGenerationResult lirGenRes, Block b) {
        return lirGenRes.getLIR().getLIRforBlock(b) != null;
    }

}
