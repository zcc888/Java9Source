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

public class Throw_Synchronized03 extends JTTTest {

    public static synchronized boolean test(int i) throws Exception {
        if (i == 0) {
            return true;
        }
        return test2(i);
    }

    @SuppressWarnings("unused")
    public static synchronized boolean test2(int i) throws Exception {
        throw new Exception();
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

}
