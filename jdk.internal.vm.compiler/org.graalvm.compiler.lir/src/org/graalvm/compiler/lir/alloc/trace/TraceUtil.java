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

import java.util.List;

import org.graalvm.compiler.core.common.alloc.Trace;
import org.graalvm.compiler.core.common.alloc.TraceBuilderResult;
import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.lir.LIR;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.StandardOp.JumpOp;
import org.graalvm.compiler.lir.StandardOp.LabelOp;

import jdk.vm.ci.meta.Value;

public class TraceUtil {

    public static AbstractBlockBase<?> getBestTraceInterPredecessor(TraceBuilderResult traceResult, AbstractBlockBase<?> block) {
        AbstractBlockBase<?> bestPred = null;
        int bestTraceId = traceResult.getTraceForBlock(block).getId();
        for (AbstractBlockBase<?> pred : block.getPredecessors()) {
            int predTraceId = traceResult.getTraceForBlock(pred).getId();
            if (predTraceId < bestTraceId) {
                bestPred = pred;
                bestTraceId = predTraceId;
            }
        }
        return bestPred;
    }

    public static boolean isShadowedRegisterValue(Value value) {
        assert value != null;
        return value instanceof ShadowedRegisterValue;
    }

    public static ShadowedRegisterValue asShadowedRegisterValue(Value value) {
        assert isShadowedRegisterValue(value);
        return (ShadowedRegisterValue) value;
    }

    public static boolean isTrivialTrace(LIR lir, Trace trace) {
        if (trace.size() != 1) {
            return false;
        }
        List<LIRInstruction> instructions = lir.getLIRforBlock(trace.getBlocks()[0]);
        if (instructions.size() != 2) {
            return false;
        }
        assert instructions.get(0) instanceof LabelOp : "First instruction not a LabelOp: " + instructions.get(0);
        if (((LabelOp) instructions.get(0)).isPhiIn()) {
            /*
             * Merge blocks are in general not trivial block because variables defined by a PHI
             * always need a location. If the outgoing value of the predecessor is a constant we
             * need to find an appropriate location (register or stack).
             *
             * Note that this case should not happen in practice since the trace containing the
             * merge block should also contain one of the predecessors. For non-standard trace
             * builders (e.g. the single block trace builder) this is not the true, though.
             */
            return false;
        }
        /*
         * Now we need to check if the BlockEndOp has no special operand requirements (i.e.
         * stack-slot, register). For now we just check for JumpOp because we know that it doesn't.
         */
        return instructions.get(1) instanceof JumpOp;
    }
}
