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
 *
 * This test sleeps the joining thread, which should enure that the joinee is
 * terminated by the time the join occurs.
 */
package org.graalvm.compiler.jtt.threads;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class Thread_join03 extends JTTTest {

    private static class TestClass implements Runnable {
        @Override
        public void run() {
            cont = false;
        }
    }

    static volatile boolean cont;

    public static boolean test() throws InterruptedException {
        cont = true;
        final Thread thread = new Thread(new TestClass());
        thread.start();
        Thread.sleep(200);
        thread.join();
        return cont;
    }

    @Test(timeout = 20000)
    public void run0() throws Throwable {
        runTest("test");
    }

}
