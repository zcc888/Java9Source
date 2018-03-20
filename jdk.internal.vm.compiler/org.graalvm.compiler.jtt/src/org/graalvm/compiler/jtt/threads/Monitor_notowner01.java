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

public class Monitor_notowner01 extends JTTTest {

    static Object monitor = new Object();
    static Object finished = new Object();

    public static boolean test() throws InterruptedException {
        final BadRunnable badRunnable = new BadRunnable();
        synchronized (monitor) {
            new Thread(badRunnable).start();
            synchronized (finished) {
                finished.wait(1000);
            }
        }
        return badRunnable.caught;
    }

    static class BadRunnable implements Runnable {

        protected boolean caught = false;

        @Override
        public void run() {
            try {
                // we don't own this!
                monitor.wait();
            } catch (InterruptedException ex) {

            } catch (IllegalMonitorStateException ex) {
                caught = true;
                synchronized (finished) {
                    finished.notifyAll();
                }
            }
        }
    }

    @Test(timeout = 20000)
    public void run0() throws Throwable {
        runTest("test");
    }

}
