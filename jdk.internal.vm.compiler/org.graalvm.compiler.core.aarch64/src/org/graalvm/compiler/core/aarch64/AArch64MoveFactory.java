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

package org.graalvm.compiler.core.aarch64;

import static org.graalvm.compiler.lir.LIRValueUtil.asConstant;
import static org.graalvm.compiler.lir.LIRValueUtil.isConstantValue;
import static org.graalvm.compiler.lir.LIRValueUtil.isStackSlotValue;

import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.core.common.type.DataPointerConstant;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.aarch64.AArch64AddressValue;
import org.graalvm.compiler.lir.aarch64.AArch64Move;
import org.graalvm.compiler.lir.aarch64.AArch64Move.LoadAddressOp;
import org.graalvm.compiler.lir.gen.LIRGeneratorTool.MoveFactory;

import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.Value;

public class AArch64MoveFactory implements MoveFactory {

    @Override
    public LIRInstruction createMove(AllocatableValue dst, Value src) {
        boolean srcIsSlot = isStackSlotValue(src);
        boolean dstIsSlot = isStackSlotValue(dst);
        if (isConstantValue(src)) {
            return createLoad(dst, asConstant(src));
        } else if (src instanceof AArch64AddressValue) {
            return new LoadAddressOp(dst, (AArch64AddressValue) src);
        } else {
            assert src instanceof AllocatableValue;
            if (srcIsSlot && dstIsSlot) {
                throw GraalError.shouldNotReachHere(src.getClass() + " " + dst.getClass());
            } else {
                return new AArch64Move.Move(dst, (AllocatableValue) src);
            }
        }
    }

    @Override
    public LIRInstruction createStackMove(AllocatableValue result, AllocatableValue input) {
        return new AArch64Move.Move(result, input);
    }

    @Override
    public LIRInstruction createLoad(AllocatableValue dst, Constant src) {
        if (src instanceof JavaConstant) {
            JavaConstant javaConstant = (JavaConstant) src;
            if (canInlineConstant(javaConstant)) {
                return new AArch64Move.LoadInlineConstant(javaConstant, dst);
            } else {
                // return new AArch64Move.LoadConstantFromTable(javaConstant,
                // constantTableBaseProvider.getConstantTableBase(), dst);
                return new AArch64Move.LoadInlineConstant(javaConstant, dst);
            }
        } else if (src instanceof DataPointerConstant) {
            return new AArch64Move.LoadDataOp(dst, (DataPointerConstant) src);
        } else {
            // throw GraalError.shouldNotReachHere(src.getClass().toString());
            throw GraalError.unimplemented();
        }
    }

    @Override
    public boolean canInlineConstant(JavaConstant c) {
        switch (c.getJavaKind()) {
            case Boolean:
            case Byte:
            case Char:
            case Short:
            case Int:
                return AArch64MacroAssembler.isMovableImmediate(c.asInt());
            case Long:
                return AArch64MacroAssembler.isMovableImmediate(c.asLong());
            case Object:
                return c.isNull();
            default:
                return false;
        }
    }

    @Override
    public boolean allowConstantToStackMove(Constant value) {
        return false;
    }

}
