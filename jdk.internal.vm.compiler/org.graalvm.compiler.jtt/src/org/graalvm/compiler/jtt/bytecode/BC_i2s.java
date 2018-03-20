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
public class BC_i2s extends JTTTest {

    public static short test(int a) {
        return (short) a;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -1);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 34);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 65535);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 32768);
    }

    public static int testInt(int a) {
        return (short) a;
    }

    @Test
    public void runI0() throws Throwable {
        runTest("testInt", -1);
    }

    @Test
    public void runI1() throws Throwable {
        runTest("testInt", 34);
    }

    @Test
    public void runI2() throws Throwable {
        runTest("testInt", 65535);
    }

    @Test
    public void runI3() throws Throwable {
        runTest("testInt", 32768);
    }

    public static long testLong(int a) {
        return (short) a;
    }

    @Test
    public void runL0() throws Throwable {
        runTest("testLong", -1);
    }

    @Test
    public void runL1() throws Throwable {
        runTest("testLong", 34);
    }

    @Test
    public void runL2() throws Throwable {
        runTest("testLong", 65535);
    }

    @Test
    public void runL3() throws Throwable {
        runTest("testLong", 32768);
    }
}
