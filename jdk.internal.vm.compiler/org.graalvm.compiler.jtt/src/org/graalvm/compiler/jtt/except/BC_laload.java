/*
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
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
/*
 */
package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class BC_laload extends JTTTest {

    static long[] arr = {0L, -1L, 4L, 1000000000000L};

    public static long test(int arg) {
        final long[] array = arg == -2 ? null : arr;
        return array[arg];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -2);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 4);
    }

}
