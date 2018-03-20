/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class ABCE_02 extends JTTTest {

    public static int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static int test(int arg) {
        int r = 0;
        for (int i = 0; i < arg; i++) {
            r += array[i];
        }
        return r;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 10);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 20);
    }

}
