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
package org.graalvm.compiler.hotspot.amd64;

import static jdk.vm.ci.amd64.AMD64.r10;
import static jdk.vm.ci.amd64.AMD64.r11;
import static jdk.vm.ci.amd64.AMD64.r13;
import static jdk.vm.ci.amd64.AMD64.r14;
import static jdk.vm.ci.amd64.AMD64.r8;
import static jdk.vm.ci.amd64.AMD64.r9;
import static jdk.vm.ci.amd64.AMD64.rbx;
import static jdk.vm.ci.amd64.AMD64.rcx;
import static jdk.vm.ci.amd64.AMD64.rdi;
import static jdk.vm.ci.amd64.AMD64.rdx;
import static jdk.vm.ci.amd64.AMD64.rsi;

import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.hotspot.HotSpotForeignCallLinkage;
import org.graalvm.compiler.hotspot.meta.HotSpotProviders;
import org.graalvm.compiler.hotspot.stubs.UncommonTrapStub;

import jdk.vm.ci.code.RegisterArray;
import jdk.vm.ci.code.RegisterConfig;
import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.hotspot.amd64.AMD64HotSpotRegisterConfig;

final class AMD64UncommonTrapStub extends UncommonTrapStub {

    private RegisterConfig registerConfig;

    AMD64UncommonTrapStub(HotSpotProviders providers, TargetDescription target, GraalHotSpotVMConfig config, HotSpotForeignCallLinkage linkage) {
        super(providers, target, linkage);
        RegisterArray allocatable = new RegisterArray(rbx, rcx, rdx, rsi, rdi, r8, r9, r10, r11, r13, r14);
        registerConfig = new AMD64HotSpotRegisterConfig(target, allocatable, config.windowsOs);
    }

    @Override
    public RegisterConfig getRegisterConfig() {
        return registerConfig;
    }
}
