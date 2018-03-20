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

package org.graalvm.compiler.lir.aarch64;

import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.COMPOSITE;

import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

public final class AArch64PrefetchOp extends AArch64LIRInstruction {
    public static final LIRInstructionClass<AArch64PrefetchOp> TYPE = LIRInstructionClass.create(AArch64PrefetchOp.class);

    @SuppressWarnings("unused") private final int instr;  // AllocatePrefetchInstr
    @Alive({COMPOSITE}) protected AArch64AddressValue address;

    public AArch64PrefetchOp(AArch64AddressValue address, int instr) {
        super(TYPE);
        this.address = address;
        this.instr = instr;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AArch64MacroAssembler masm) {
        // TODO implement prefetch
        masm.nop();
    }
}
