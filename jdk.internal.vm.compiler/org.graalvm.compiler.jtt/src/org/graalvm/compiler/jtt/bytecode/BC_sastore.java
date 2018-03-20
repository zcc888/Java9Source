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
public class BC_sastore extends JTTTest {

    static short[] array = {0, 0, 0, 0};

    public static short test(int arg, short val) {
        array[arg] = val;
        return array[arg];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, ((short) 0));
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, ((short) -1));
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2, ((short) 11));
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3, ((short) -14));
    }

}
