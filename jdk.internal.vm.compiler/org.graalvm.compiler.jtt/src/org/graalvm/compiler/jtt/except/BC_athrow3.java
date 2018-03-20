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

public class BC_athrow3 extends JTTTest {

    static Throwable throwable = new Throwable();

    public static int test(int arg) throws Throwable {
        if (arg == 2) {
            throw2();
        } else if (arg == 3) {
            throw1();
        }
        return arg;
    }

    private static void throw2() throws Throwable {
        throw throwable;
    }

    private static void throw1() throws Throwable {
        throw null;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 2);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 3);
    }

}
