/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_lrem2 extends JTTTest {

    public static long test(long a, long b) {
        return a % b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -9223372036854775808L, -1L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -9223372036854775808L, 1L);
    }

}
