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
package org.graalvm.compiler.lir.alloc.trace;

import static org.graalvm.compiler.lir.LIRValueUtil.asVariable;
import static org.graalvm.compiler.lir.LIRValueUtil.isConstantValue;
import static org.graalvm.compiler.lir.LIRValueUtil.isVariable;
import static org.graalvm.compiler.lir.alloc.trace.TraceUtil.isTrivialTrace;

import java.util.List;

import org.graalvm.compiler.core.common.alloc.Trace;
import org.graalvm.compiler.core.common.alloc.TraceBuilderResult;
import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.lir.LIR;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.LIRInstruction.OperandFlag;
import org.graalvm.compiler.lir.StandardOp.JumpOp;
import org.graalvm.compiler.lir.StandardOp.LabelOp;
import org.graalvm.compiler.lir.ValueProcedure;
import org.graalvm.compiler.lir.Variable;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.ssi.SSIUtil;
import org.graalvm.compiler.lir.util.VariableVirtualStackValueMap;

import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.meta.Value;

/**
 * Allocates a trivial trace i.e. a trace consisting of a single block with no instructions other
 * than the {@link LabelOp} and the {@link JumpOp}.
 */
final class TrivialTraceAllocator extends TraceAllocationPhase<TraceAllocationPhase.TraceAllocationContext> {

    @Override
    protected void run(TargetDescription target, LIRGenerationResult lirGenRes, Trace trace, TraceAllocationContext context) {
        LIR lir = lirGenRes.getLIR();
        TraceBuilderResult resultTraces = context.resultTraces;
        assert isTrivialTrace(lir, trace) : "Not a trivial trace! " + trace;
        AbstractBlockBase<?> block = trace.getBlocks()[0];

        AbstractBlockBase<?> pred = TraceUtil.getBestTraceInterPredecessor(resultTraces, block);

        VariableVirtualStackValueMap<Variable, Value> variableMap = new VariableVirtualStackValueMap<>(lir.numVariables(), 0);
        SSIUtil.forEachValuePair(lir, block, pred, (to, from) -> {
            if (isVariable(to)) {
                variableMap.put(asVariable(to), from);
            }
        });

        ValueProcedure outputConsumer = (value, mode, flags) -> {
            if (isVariable(value)) {
                Value incomingValue = variableMap.get(asVariable(value));
                assert !flags.contains(OperandFlag.COMPOSITE);
                assert !(SSIUtil.incoming(lir, block).isPhiIn() && isConstantValue(incomingValue)) : "Phi variable cannot be constant: " + incomingValue + " -> " + value;
                return incomingValue;
            }
            return value;
        };

        List<LIRInstruction> instructions = lir.getLIRforBlock(block);
        for (LIRInstruction op : instructions) {

            op.forEachOutput(outputConsumer);
            op.forEachTemp(outputConsumer);
            op.forEachAlive(outputConsumer);
            op.forEachInput(outputConsumer);
            op.forEachState(outputConsumer);
        }
    }
}
