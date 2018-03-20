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

package jdk.tools.jaotc;

import jdk.tools.jaotc.binformat.Relocation.RelocType;

/**
 * Describes a call site relocation. Contains a name of the callee and a relocation type, describing
 * which relocation to use at the call site.
 */
abstract class CallSiteRelocationInfo {

    public final String targetSymbol;
    public final RelocType type;

    public CallSiteRelocationInfo(String targetSymbol, RelocType type) {
        this.targetSymbol = targetSymbol;
        this.type = type;
    }

}
