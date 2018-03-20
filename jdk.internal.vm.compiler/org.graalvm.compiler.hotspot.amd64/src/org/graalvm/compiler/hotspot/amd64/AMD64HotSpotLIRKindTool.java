/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.amd64.AMD64LIRKindTool;
import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.hotspot.nodes.type.HotSpotLIRKindTool;

import jdk.vm.ci.amd64.AMD64Kind;

public class AMD64HotSpotLIRKindTool extends AMD64LIRKindTool implements HotSpotLIRKindTool {

    @Override
    public LIRKind getNarrowOopKind() {
        return LIRKind.reference(AMD64Kind.DWORD);
    }

    @Override
    public LIRKind getNarrowPointerKind() {
        return LIRKind.value(AMD64Kind.DWORD);
    }
}
