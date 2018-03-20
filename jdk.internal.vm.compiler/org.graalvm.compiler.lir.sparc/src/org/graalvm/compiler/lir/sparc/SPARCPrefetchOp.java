/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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

package org.graalvm.compiler.lir.sparc;

import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.COMPOSITE;

import org.graalvm.compiler.asm.sparc.SPARCAssembler;
import org.graalvm.compiler.asm.sparc.SPARCMacroAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

public final class SPARCPrefetchOp extends SPARCLIRInstruction {
    public static final LIRInstructionClass<SPARCPrefetchOp> TYPE = LIRInstructionClass.create(SPARCPrefetchOp.class);
    public static final SizeEstimate SIZE = SizeEstimate.create(1);

    private final int instr;  // AllocatePrefetchInstr
    @Alive({COMPOSITE}) protected SPARCAddressValue address;

    public SPARCPrefetchOp(SPARCAddressValue address, int instr) {
        super(TYPE, SIZE);
        this.address = address;
        this.instr = instr;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm) {
        assert instr >= 0 && instr < SPARCAssembler.Fcn.values().length : instr;
        masm.prefetch(address.toAddress(), SPARCAssembler.Fcn.values()[instr]);
    }
}
