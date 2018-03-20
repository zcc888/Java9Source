/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.sparc;

import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.ILLEGAL;
import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.REG;
import static jdk.vm.ci.code.ValueUtil.asRegister;

import org.graalvm.compiler.asm.sparc.SPARCMacroAssembler;
import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;
import org.graalvm.compiler.lir.sparc.SPARCControlFlow.ReturnOp;

import jdk.vm.ci.meta.Value;

/**
 * Returns from a function.
 */
@Opcode("RETURN")
final class SPARCHotSpotReturnOp extends SPARCHotSpotEpilogueOp {
    public static final LIRInstructionClass<SPARCHotSpotReturnOp> TYPE = LIRInstructionClass.create(SPARCHotSpotReturnOp.class);
    public static final SizeEstimate SIZE = SizeEstimate.create(2);

    @Use({REG, ILLEGAL}) protected Value value;
    @Use({REG}) protected Value safepointPollAddress;
    private final boolean isStub;
    private final GraalHotSpotVMConfig config;

    SPARCHotSpotReturnOp(Value value, boolean isStub, GraalHotSpotVMConfig config, Value safepointPoll) {
        super(TYPE, SIZE);
        this.value = value;
        this.isStub = isStub;
        this.config = config;
        this.safepointPollAddress = safepointPoll;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm) {
        if (!isStub) {
            // Every non-stub compile method must have a poll before the return.
            SPARCHotSpotSafepointOp.emitCode(crb, masm, config, true, null, asRegister(safepointPollAddress));
        }
        ReturnOp.emitCodeHelper(crb, masm);
    }
}
