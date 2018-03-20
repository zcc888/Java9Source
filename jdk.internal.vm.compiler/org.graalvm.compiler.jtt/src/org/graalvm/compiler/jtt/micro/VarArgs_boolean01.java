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
package org.graalvm.compiler.jtt.micro;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class VarArgs_boolean01 extends JTTTest {

    public static boolean test(int arg) {
        if (arg == 4) {
            return get(0);
        }
        return get(arg, true, false, true);
    }

    private static boolean get(int index, boolean... args) {
        return args[index];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 4);
    }

}
