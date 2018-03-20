/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.hotspot.stubs.StubUtil.verifyObject;

import org.graalvm.compiler.api.replacements.Snippet;
import org.graalvm.compiler.hotspot.HotSpotForeignCallLinkage;
import org.graalvm.compiler.hotspot.meta.HotSpotHostForeignCallsProvider;
import org.graalvm.compiler.hotspot.meta.HotSpotProviders;

/**
 * Stub called via {@link HotSpotHostForeignCallsProvider#VERIFY_OOP}.
 */
public class VerifyOopStub extends SnippetStub {

    public VerifyOopStub(HotSpotProviders providers, HotSpotForeignCallLinkage linkage) {
        super("verifyOop", providers, linkage);
    }

    @Snippet
    private static Object verifyOop(Object object) {
        return verifyObject(object);
    }
}
