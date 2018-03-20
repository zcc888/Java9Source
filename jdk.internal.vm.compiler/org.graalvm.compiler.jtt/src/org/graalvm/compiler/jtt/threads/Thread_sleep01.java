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
package org.graalvm.compiler.jtt.threads;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public final class Thread_sleep01 extends JTTTest {

    public static boolean test(int i) throws InterruptedException {
        final long before = System.currentTimeMillis();
        Thread.sleep(i);
        return System.currentTimeMillis() - before >= i;
    }

    @Test(timeout = 20000)
    public void run0() throws Throwable {
        runTest("test", 10);
    }

    @Test(timeout = 20000)
    public void run1() throws Throwable {
        runTest("test", 20);
    }

    @Test(timeout = 20000)
    public void run2() throws Throwable {
        runTest("test", 100);
    }

}
