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
package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_bastore extends JTTTest {

    static boolean[] array = {false, false, false, false};

    public static boolean test(int arg, boolean val) {
        array[arg] = val;
        return array[arg];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, true);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, false);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2, true);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3, false);
    }

}
