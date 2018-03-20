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
package org.graalvm.compiler.jtt.threads;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */

// Interrupted during wait, with interrupter joining
public class Thread_isInterrupted05 extends JTTTest {

    public static boolean test() throws InterruptedException {
        final WaitInterruptee waitInterruptee = new WaitInterruptee();
        waitInterruptee.start();
        waitInterruptee.interrupt();
        waitInterruptee.join();

        if (waitInterruptee.throwable != null) {
            throw new RuntimeException(waitInterruptee.throwable);
        }
        return true;
    }

    static class WaitInterruptee extends Thread {

        Throwable throwable;

        WaitInterruptee() {
            super("WaitInterruptee");
        }

        @Override
        public void run() {
            try {
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                    }
                }
            } catch (Throwable t) {
                throwable = t;
            }
        }
    }

    @Test(timeout = 20000)
    public void run0() throws Throwable {
        runTest("test");
    }

}
