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

import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.REG;
import static jdk.vm.ci.code.ValueUtil.asRegister;
import static jdk.vm.ci.code.ValueUtil.isLegal;

import java.util.EnumSet;

import org.graalvm.compiler.asm.sparc.SPARCAddress;
import org.graalvm.compiler.asm.sparc.SPARCAssembler;
import org.graalvm.compiler.lir.CompositeValue;
import org.graalvm.compiler.lir.InstructionValueConsumer;
import org.graalvm.compiler.lir.InstructionValueProcedure;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.LIRInstruction.OperandFlag;
import org.graalvm.compiler.lir.LIRInstruction.OperandMode;

import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.Value;
import jdk.vm.ci.meta.ValueKind;

public final class SPARCImmediateAddressValue extends SPARCAddressValue {

    @Component({REG}) protected AllocatableValue base;
    protected final int displacement;

    private static final EnumSet<OperandFlag> flags = EnumSet.of(OperandFlag.REG);

    public SPARCImmediateAddressValue(ValueKind<?> kind, AllocatableValue base, int displacement) {
        super(kind);
        assert SPARCAssembler.isSimm13(displacement);
        this.base = base;
        this.displacement = displacement;
    }

    @Override
    public CompositeValue forEachComponent(LIRInstruction inst, OperandMode mode, InstructionValueProcedure proc) {
        AllocatableValue newBase = (AllocatableValue) proc.doValue(inst, base, mode, flags);
        if (!base.identityEquals(newBase)) {
            return new SPARCImmediateAddressValue(getValueKind(), newBase, displacement);
        }
        return this;
    }

    @Override
    protected void visitEachComponent(LIRInstruction inst, OperandMode mode, InstructionValueConsumer proc) {
        proc.visitValue(inst, base, mode, flags);
    }

    @Override
    public SPARCAddress toAddress() {
        return new SPARCAddress(asRegister(base), displacement);
    }

    @Override
    public boolean isValidImplicitNullCheckFor(Value value, int implicitNullCheckLimit) {
        return value.equals(base) && displacement >= 0 && displacement < implicitNullCheckLimit;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        String sep = "";
        if (isLegal(base)) {
            s.append(base);
            sep = " + ";
        }
        if (displacement < 0) {
            s.append(" - ").append(-displacement);
        } else if (displacement > 0) {
            s.append(sep).append(displacement);
        }
        s.append("]");
        return s.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SPARCImmediateAddressValue) {
            SPARCImmediateAddressValue addr = (SPARCImmediateAddressValue) obj;
            return getValueKind().equals(addr.getValueKind()) && displacement == addr.displacement && base.equals(addr.base);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return base.hashCode() ^ (displacement << 4) ^ getValueKind().hashCode();
    }
}
