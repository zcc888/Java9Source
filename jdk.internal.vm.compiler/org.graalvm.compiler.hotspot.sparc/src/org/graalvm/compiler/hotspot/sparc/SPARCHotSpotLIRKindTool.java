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
package org.graalvm.compiler.hotspot.sparc;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.core.sparc.SPARCLIRKindTool;
import org.graalvm.compiler.hotspot.nodes.type.HotSpotLIRKindTool;

import jdk.vm.ci.sparc.SPARCKind;

public class SPARCHotSpotLIRKindTool extends SPARCLIRKindTool implements HotSpotLIRKindTool {

    @Override
    public LIRKind getNarrowOopKind() {
        return LIRKind.reference(SPARCKind.WORD);
    }

    @Override
    public LIRKind getNarrowPointerKind() {
        return LIRKind.value(SPARCKind.WORD);
    }
}
