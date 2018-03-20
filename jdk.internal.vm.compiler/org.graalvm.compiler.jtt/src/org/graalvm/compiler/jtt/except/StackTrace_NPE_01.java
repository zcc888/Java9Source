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
package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class StackTrace_NPE_01 extends JTTTest {

    @SuppressWarnings("all")
    public static int test(int a) {
        try {
            if (a >= 0) {
                final Object o = null;
                return o.hashCode();
            }
        } catch (NullPointerException npe) {
            for (StackTraceElement e : npe.getStackTrace()) {
                if (e.getClassName().equals(StackTrace_NPE_01.class.getName()) && e.getMethodName().equals("test")) {
                    return a;
                }
            }
        }
        return -1;
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
        runTest("test", -2);
    }

}
