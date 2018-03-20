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
 * This test sleeps the thread that is joined to, which should ensure that the joining thread
 * actually does wait for completeion.
 */
package org.graalvm.compiler.jtt.threads;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class Thread_join02 extends JTTTest {

    private static class TestClass implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
            }
            cont = false;
        }
    }

    static volatile boolean cont;

    public static boolean test() throws InterruptedException {
        cont = true;
        final Thread thread = new Thread(new TestClass());
        thread.start();
        thread.join();
        return cont;
    }

    @Test(timeout = 20000)
    public void run0() throws Throwable {
        runTest("test");
    }

}
