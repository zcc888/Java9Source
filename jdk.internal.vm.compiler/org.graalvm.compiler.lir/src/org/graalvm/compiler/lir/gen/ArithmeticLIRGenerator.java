/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.lir.gen;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.lir.Variable;

import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.PlatformKind;
import jdk.vm.ci.meta.Value;

/**
 * This class traverses the HIR instructions and generates LIR instructions from them.
 */
public abstract class ArithmeticLIRGenerator implements ArithmeticLIRGeneratorTool {

    LIRGenerator lirGen;

    public LIRGenerator getLIRGen() {
        return lirGen;
    }

    // automatic derived reference handling

    protected abstract boolean isNumericInteger(PlatformKind kind);

    protected abstract Variable emitAdd(LIRKind resultKind, Value a, Value b, boolean setFlags);

    @Override
    public final Variable emitAdd(Value aVal, Value bVal, boolean setFlags) {
        LIRKind resultKind;
        Value a = aVal;
        Value b = bVal;

        if (isNumericInteger(a.getPlatformKind())) {
            LIRKind aKind = a.getValueKind(LIRKind.class);
            LIRKind bKind = b.getValueKind(LIRKind.class);
            assert a.getPlatformKind() == b.getPlatformKind();

            if (aKind.isUnknownReference()) {
                resultKind = aKind;
            } else if (bKind.isUnknownReference()) {
                resultKind = bKind;
            } else if (aKind.isValue() && bKind.isValue()) {
                resultKind = aKind;
            } else if (aKind.isValue()) {
                if (bKind.isDerivedReference()) {
                    resultKind = bKind;
                } else {
                    AllocatableValue allocatable = getLIRGen().asAllocatable(b);
                    resultKind = bKind.makeDerivedReference(allocatable);
                    b = allocatable;
                }
            } else if (bKind.isValue()) {
                if (aKind.isDerivedReference()) {
                    resultKind = aKind;
                } else {
                    AllocatableValue allocatable = getLIRGen().asAllocatable(a);
                    resultKind = aKind.makeDerivedReference(allocatable);
                    a = allocatable;
                }
            } else {
                resultKind = aKind.makeUnknownReference();
            }
        } else {
            resultKind = LIRKind.combine(a, b);
        }

        return emitAdd(resultKind, a, b, setFlags);
    }

    protected abstract Variable emitSub(LIRKind resultKind, Value a, Value b, boolean setFlags);

    @Override
    public final Variable emitSub(Value aVal, Value bVal, boolean setFlags) {
        LIRKind resultKind;
        Value a = aVal;
        Value b = bVal;

        if (isNumericInteger(a.getPlatformKind())) {
            LIRKind aKind = a.getValueKind(LIRKind.class);
            LIRKind bKind = b.getValueKind(LIRKind.class);
            assert a.getPlatformKind() == b.getPlatformKind();

            if (aKind.isUnknownReference()) {
                resultKind = aKind;
            } else if (bKind.isUnknownReference()) {
                resultKind = bKind;
            }

            if (aKind.isValue() && bKind.isValue()) {
                resultKind = aKind;
            } else if (bKind.isValue()) {
                if (aKind.isDerivedReference()) {
                    resultKind = aKind;
                } else {
                    AllocatableValue allocatable = getLIRGen().asAllocatable(a);
                    resultKind = aKind.makeDerivedReference(allocatable);
                    a = allocatable;
                }
            } else if (aKind.isDerivedReference() && bKind.isDerivedReference() && aKind.getDerivedReferenceBase().equals(bKind.getDerivedReferenceBase())) {
                resultKind = LIRKind.value(a.getPlatformKind());
            } else {
                resultKind = aKind.makeUnknownReference();
            }
        } else {
            resultKind = LIRKind.combine(a, b);
        }

        return emitSub(resultKind, a, b, setFlags);
    }
}
