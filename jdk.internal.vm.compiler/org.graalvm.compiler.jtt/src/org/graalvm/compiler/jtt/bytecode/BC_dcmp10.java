/*
 * Copyright (c) 2008, 2012, Oracle and/or its affiliates. All rights reserved.
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
public class BC_dcmp10 extends JTTTest {

    public static boolean test(int x) {
        double a = 0;
        double b = 0;
        switch (x) {
            case 0:
                a = Double.POSITIVE_INFINITY;
                b = 1;
                break;
            case 1:
                a = 1;
                b = Double.POSITIVE_INFINITY;
                break;
            case 2:
                a = Double.NEGATIVE_INFINITY;
                b = 1;
                break;
            case 3:
                a = 1;
                b = Double.NEGATIVE_INFINITY;
                break;
            case 4:
                a = Double.NEGATIVE_INFINITY;
                b = Double.NEGATIVE_INFINITY;
                break;
            case 5:
                a = Double.NEGATIVE_INFINITY;
                b = Double.POSITIVE_INFINITY;
                break;
            case 6:
                a = Double.NaN;
                b = Double.POSITIVE_INFINITY;
                break;
            case 7:
                a = 1;
                b = Double.NaN;
                break;
            case 8:
                a = 1;
                b = -0.0d / 0.0d;
                break;
        }
        return a <= b;
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

    @Test
    public void run5() throws Throwable {
        runTest("test", 5);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", 6);
    }

    @Test
    public void run7() throws Throwable {
        runTest("test", 7);
    }

    @Test
    public void run8() throws Throwable {
        runTest("test", 8);
    }

}
