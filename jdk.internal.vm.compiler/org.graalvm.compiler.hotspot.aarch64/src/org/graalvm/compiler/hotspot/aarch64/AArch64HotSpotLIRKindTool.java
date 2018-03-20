/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.aarch64.AArch64LIRKindTool;
import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.hotspot.nodes.type.HotSpotLIRKindTool;

import jdk.vm.ci.aarch64.AArch64Kind;

public class AArch64HotSpotLIRKindTool extends AArch64LIRKindTool implements HotSpotLIRKindTool {

    @Override
    public LIRKind getNarrowOopKind() {
        return LIRKind.reference(AArch64Kind.DWORD);
    }

    @Override
    public LIRKind getNarrowPointerKind() {
        return LIRKind.value(AArch64Kind.DWORD);
    }
}
