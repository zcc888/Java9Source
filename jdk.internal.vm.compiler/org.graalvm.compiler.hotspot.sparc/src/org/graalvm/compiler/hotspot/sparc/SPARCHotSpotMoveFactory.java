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
package org.graalvm.compiler.hotspot.sparc;

import static jdk.vm.ci.hotspot.HotSpotCompressedNullConstant.COMPRESSED_NULL;
import static jdk.vm.ci.meta.JavaConstant.INT_0;
import static jdk.vm.ci.meta.JavaConstant.LONG_0;

import org.graalvm.compiler.core.sparc.SPARCLIRGenerator.ConstantTableBaseProvider;
import org.graalvm.compiler.core.sparc.SPARCMoveFactory;
import org.graalvm.compiler.lir.LIRInstruction;

import jdk.vm.ci.hotspot.HotSpotCompressedNullConstant;
import jdk.vm.ci.hotspot.HotSpotConstant;
import jdk.vm.ci.hotspot.HotSpotObjectConstant;
import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.JavaConstant;

public class SPARCHotSpotMoveFactory extends SPARCMoveFactory {

    public SPARCHotSpotMoveFactory(ConstantTableBaseProvider constantTableBaseProvider) {
        super(constantTableBaseProvider);
    }

    @Override
    public boolean canInlineConstant(JavaConstant c) {
        if (HotSpotCompressedNullConstant.COMPRESSED_NULL.equals(c)) {
            return true;
        } else if (c instanceof HotSpotObjectConstant) {
            return false;
        } else {
            return super.canInlineConstant(c);
        }
    }

    @Override
    public LIRInstruction createLoad(AllocatableValue dst, Constant src) {
        Constant usedSource;
        if (COMPRESSED_NULL.equals(src)) {
            usedSource = INT_0;
        } else if (src instanceof HotSpotObjectConstant && ((HotSpotObjectConstant) src).isNull()) {
            usedSource = LONG_0;
        } else {
            usedSource = src;
        }
        if (usedSource instanceof HotSpotConstant) {
            HotSpotConstant constant = (HotSpotConstant) usedSource;
            if (constant.isCompressed()) {
                return new SPARCHotSpotMove.LoadHotSpotObjectConstantInline(constant, dst);
            } else {
                return new SPARCHotSpotMove.LoadHotSpotObjectConstantFromTable(constant, dst, constantTableBaseProvider.getConstantTableBase());
            }
        } else {
            return super.createLoad(dst, usedSource);
        }
    }
}
