/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

import static jdk.vm.ci.sparc.SPARC.g1;
import static jdk.vm.ci.sparc.SPARC.g3;
import static jdk.vm.ci.sparc.SPARC.g4;
import static jdk.vm.ci.sparc.SPARC.g5;
import static jdk.vm.ci.sparc.SPARC.o0;
import static jdk.vm.ci.sparc.SPARC.o1;
import static jdk.vm.ci.sparc.SPARC.o2;
import static jdk.vm.ci.sparc.SPARC.o3;
import static jdk.vm.ci.sparc.SPARC.o4;

import org.graalvm.compiler.hotspot.HotSpotForeignCallLinkage;
import org.graalvm.compiler.hotspot.meta.HotSpotProviders;
import org.graalvm.compiler.hotspot.stubs.UncommonTrapStub;

import jdk.vm.ci.code.RegisterArray;
import jdk.vm.ci.code.RegisterConfig;
import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.hotspot.sparc.SPARCHotSpotRegisterConfig;

final class SPARCUncommonTrapStub extends UncommonTrapStub {

    private RegisterConfig registerConfig;

    SPARCUncommonTrapStub(HotSpotProviders providers, TargetDescription target, HotSpotForeignCallLinkage linkage) {
        super(providers, target, linkage);
        // This is basically the maximum we can spare. All other G and O register are used.
        RegisterArray allocatable = new RegisterArray(g1, g3, g4, g5, o0, o1, o2, o3, o4);
        registerConfig = new SPARCHotSpotRegisterConfig(target, allocatable);
    }

    @Override
    public RegisterConfig getRegisterConfig() {
        return registerConfig;
    }

}
