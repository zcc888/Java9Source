/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.aarch64;

import static jdk.vm.ci.aarch64.AArch64.zr;

import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.aarch64.AArch64LIRInstruction;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.code.Register;

@Opcode("CRUNTIME_CALL_EPILOGUE")
public class AArch64HotSpotCRuntimeCallEpilogueOp extends AArch64LIRInstruction {
    public static final LIRInstructionClass<AArch64HotSpotCRuntimeCallEpilogueOp> TYPE = LIRInstructionClass.create(AArch64HotSpotCRuntimeCallEpilogueOp.class);

    private final int threadLastJavaSpOffset;
    private final int threadLastJavaFpOffset;
    private final Register thread;

    public AArch64HotSpotCRuntimeCallEpilogueOp(int threadLastJavaSpOffset, int threadLastJavaFpOffset, Register thread) {
        super(TYPE);
        this.threadLastJavaSpOffset = threadLastJavaSpOffset;
        this.threadLastJavaFpOffset = threadLastJavaFpOffset;
        this.thread = thread;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AArch64MacroAssembler masm) {
        // Reset last Java frame:
        masm.str(64, zr, masm.makeAddress(thread, threadLastJavaSpOffset, 8));
        masm.str(64, zr, masm.makeAddress(thread, threadLastJavaFpOffset, 8));
    }
}
