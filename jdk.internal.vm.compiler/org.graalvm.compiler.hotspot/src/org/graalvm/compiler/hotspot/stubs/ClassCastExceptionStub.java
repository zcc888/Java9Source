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
package org.graalvm.compiler.hotspot.stubs;

import org.graalvm.compiler.api.replacements.Snippet;
import org.graalvm.compiler.api.replacements.Snippet.ConstantParameter;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.hotspot.HotSpotForeignCallLinkage;
import org.graalvm.compiler.hotspot.meta.HotSpotProviders;
import org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil;
import org.graalvm.compiler.hotspot.word.KlassPointer;

import jdk.vm.ci.code.Register;

/**
 */
public class ClassCastExceptionStub extends CreateExceptionStub {

    public ClassCastExceptionStub(HotSpotProviders providers, HotSpotForeignCallLinkage linkage) {
        super("createClassCastException", providers, linkage);
    }

    @Override
    protected Object getConstantParameterValue(int index, String name) {
        GraalError.guarantee(index == 2, "unknown parameter %s at index %d", name, index);
        return providers.getRegisters().getThreadRegister();
    }

    @Snippet
    private static Object createClassCastException(Object object, KlassPointer targetKlass, @ConstantParameter Register threadRegister) {
        KlassPointer objKlass = HotSpotReplacementsUtil.loadHub(object);
        return createException(threadRegister, ClassCastException.class, objKlass, targetKlass);
    }
}
