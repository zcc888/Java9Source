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

package org.graalvm.compiler.core.amd64;

import static org.graalvm.compiler.lir.LIRValueUtil.asConstant;
import static org.graalvm.compiler.lir.LIRValueUtil.isConstantValue;
import static org.graalvm.compiler.lir.LIRValueUtil.isStackSlotValue;
import static jdk.vm.ci.code.ValueUtil.isRegister;

import org.graalvm.compiler.asm.NumUtil;
import org.graalvm.compiler.core.common.type.DataPointerConstant;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.lir.amd64.AMD64AddressValue;
import org.graalvm.compiler.lir.amd64.AMD64LIRInstruction;
import org.graalvm.compiler.lir.amd64.AMD64Move.AMD64StackMove;
import org.graalvm.compiler.lir.amd64.AMD64Move.LeaDataOp;
import org.graalvm.compiler.lir.amd64.AMD64Move.LeaOp;
import org.graalvm.compiler.lir.amd64.AMD64Move.MoveFromConstOp;
import org.graalvm.compiler.lir.amd64.AMD64Move.MoveFromRegOp;
import org.graalvm.compiler.lir.amd64.AMD64Move.MoveToRegOp;

import jdk.vm.ci.amd64.AMD64Kind;
import jdk.vm.ci.code.Register;
import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.Value;

public abstract class AMD64MoveFactory extends AMD64MoveFactoryBase {

    public AMD64MoveFactory(BackupSlotProvider backupSlotProvider) {
        super(backupSlotProvider);
    }

    @Override
    public boolean canInlineConstant(JavaConstant c) {
        switch (c.getJavaKind()) {
            case Long:
                return NumUtil.isInt(c.asLong());
            case Object:
                return c.isNull();
            default:
                return true;
        }
    }

    @Override
    public AMD64LIRInstruction createMove(AllocatableValue dst, Value src) {
        if (src instanceof AMD64AddressValue) {
            return new LeaOp(dst, (AMD64AddressValue) src);
        } else if (isConstantValue(src)) {
            return createLoad(dst, asConstant(src));
        } else if (isRegister(src) || isStackSlotValue(dst)) {
            return new MoveFromRegOp((AMD64Kind) dst.getPlatformKind(), dst, (AllocatableValue) src);
        } else {
            return new MoveToRegOp((AMD64Kind) dst.getPlatformKind(), dst, (AllocatableValue) src);
        }
    }

    @Override
    public AMD64LIRInstruction createStackMove(AllocatableValue result, AllocatableValue input, Register scratchRegister, AllocatableValue backupSlot) {
        return new AMD64StackMove(result, input, scratchRegister, backupSlot);
    }

    @Override
    public AMD64LIRInstruction createLoad(AllocatableValue dst, Constant src) {
        if (src instanceof JavaConstant) {
            return new MoveFromConstOp(dst, (JavaConstant) src);
        } else if (src instanceof DataPointerConstant) {
            return new LeaDataOp(dst, (DataPointerConstant) src);
        } else {
            throw GraalError.shouldNotReachHere(String.format("unsupported constant: %s", src));
        }
    }
}
