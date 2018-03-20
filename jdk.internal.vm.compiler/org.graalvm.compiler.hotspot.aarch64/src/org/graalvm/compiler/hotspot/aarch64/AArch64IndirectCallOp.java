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
package org.graalvm.compiler.hotspot.aarch64;

import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.REG;
import static jdk.vm.ci.aarch64.AArch64.r12;
import static jdk.vm.ci.code.ValueUtil.asRegister;

import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.lir.LIRFrameState;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.aarch64.AArch64Call;
import org.graalvm.compiler.lir.aarch64.AArch64Call.IndirectCallOp;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.code.Register;
import jdk.vm.ci.meta.ResolvedJavaMethod;
import jdk.vm.ci.meta.Value;

/**
 * A register indirect call that complies with the extra conventions for such calls in HotSpot. In
 * particular, the metaspace Method of the callee must be in r12 for the case where a vtable entry's
 * _from_compiled_entry is the address of an C2I adapter. Such adapters expect the target method to
 * be in r12.
 */
@Opcode("CALL_INDIRECT")
final class AArch64IndirectCallOp extends IndirectCallOp {

    public static final LIRInstructionClass<AArch64IndirectCallOp> TYPE = LIRInstructionClass.create(AArch64IndirectCallOp.class);

    /**
     * Vtable stubs expect the metaspace Method in r12.
     */
    public static final Register METHOD = r12;

    @Use({REG}) private Value metaspaceMethod;

    private final GraalHotSpotVMConfig config;

    AArch64IndirectCallOp(ResolvedJavaMethod callTarget, Value result, Value[] parameters, Value[] temps, Value metaspaceMethod, Value targetAddress, LIRFrameState state,
                    GraalHotSpotVMConfig config) {
        super(TYPE, callTarget, result, parameters, temps, targetAddress, state);
        this.metaspaceMethod = metaspaceMethod;
        this.config = config;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AArch64MacroAssembler masm) {
        crb.recordMark(config.MARKID_INLINE_INVOKE);
        Register callReg = asRegister(targetAddress);
        assert !callReg.equals(METHOD);
        AArch64Call.indirectCall(crb, masm, callReg, callTarget, state);
    }

    @Override
    public void verify() {
        super.verify();
        assert asRegister(metaspaceMethod).equals(METHOD);
    }
}
