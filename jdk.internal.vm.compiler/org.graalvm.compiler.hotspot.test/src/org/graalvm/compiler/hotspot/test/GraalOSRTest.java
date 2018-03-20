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
package org.graalvm.compiler.hotspot.test;

import org.junit.Test;

import org.graalvm.compiler.api.directives.GraalDirectives;

/**
 * Test on-stack-replacement with Graal. The test manually triggers a Graal OSR-compilation which is
 * later invoked when hitting the backedge counter overflow.
 */
public class GraalOSRTest extends GraalOSRTestBase {

    @Test
    public void testOSR() {
        testOSR("test");
    }

    static int limit = 10000;

    public static ReturnValue test() {
        for (int i = 0; i < limit * limit; i++) {
            GraalDirectives.blackhole(i);
            if (GraalDirectives.inCompiledCode()) {
                return ReturnValue.SUCCESS;
            }
        }
        return ReturnValue.FAILURE;
    }

}
