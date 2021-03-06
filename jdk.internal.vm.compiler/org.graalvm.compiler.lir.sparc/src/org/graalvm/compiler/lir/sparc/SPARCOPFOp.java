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
package org.graalvm.compiler.lir.sparc;

import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.REG;
import static jdk.vm.ci.code.ValueUtil.asRegister;

import org.graalvm.compiler.asm.sparc.SPARCAssembler;
import org.graalvm.compiler.asm.sparc.SPARCAssembler.Opfs;
import org.graalvm.compiler.asm.sparc.SPARCMacroAssembler;
import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.lir.LIRFrameState;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.meta.Value;
import jdk.vm.ci.sparc.SPARC;
import jdk.vm.ci.sparc.SPARCKind;

public final class SPARCOPFOp extends SPARCLIRInstruction implements SPARCTailDelayedLIRInstruction {
    public static final LIRInstructionClass<SPARCOPFOp> TYPE = LIRInstructionClass.create(SPARCOPFOp.class);
    public static final SizeEstimate SIZE = SizeEstimate.create(1);

    @Opcode protected final Opfs opf;
    @Use({REG}) protected Value rs1;
    @Use({REG}) protected Value rs2;
    @Def({REG}) protected Value rd;
    @State protected LIRFrameState state;

    public SPARCOPFOp(Opfs opf, Value rs2, Value rd) {
        this(opf, SPARC.g0.asValue(LIRKind.value(SPARCKind.SINGLE)), rs2, rd);
    }

    public SPARCOPFOp(Opfs opf, Value rs1, Value rs2, Value rd) {
        this(opf, rs1, rs2, rd, null);
    }

    public SPARCOPFOp(Opfs opf, Value rs1, Value rs2, Value rd, LIRFrameState state) {
        super(TYPE, SIZE);
        this.opf = opf;
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.rd = rd;
        this.state = state;
    }

    @Override
    protected void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm) {
        getDelayedControlTransfer().emitControlTransfer(crb, masm);
        if (state != null) {
            crb.recordImplicitException(masm.position(), state);
        }
        SPARCAssembler.OpfOp.emit(masm, opf, asRegister(rs1), asRegister(rs2), asRegister(rd));
    }
}
