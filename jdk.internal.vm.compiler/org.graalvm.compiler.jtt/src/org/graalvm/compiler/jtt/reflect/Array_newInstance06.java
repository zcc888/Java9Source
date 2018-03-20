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
package org.graalvm.compiler.jtt.reflect;

import java.lang.reflect.Array;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class Array_newInstance06 extends JTTTest {

    public static boolean test(int i) {
        final int[] dims = {i, 3};
        Class<?> javaClass;
        if (i == 2) {
            javaClass = int.class;
        } else if (i == 3) {
            javaClass = Object.class;
        } else {
            javaClass = Array_newInstance06.class;
        }
        return Array.newInstance(javaClass, dims).getClass().getComponentType().getComponentType() == javaClass;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1);
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
