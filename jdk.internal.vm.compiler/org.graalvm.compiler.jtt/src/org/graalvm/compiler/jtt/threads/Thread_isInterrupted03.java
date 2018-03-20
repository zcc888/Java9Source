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
package org.graalvm.compiler.jtt.threads;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */

// Interrupted while sleeping, throws an interrupted exception
public class Thread_isInterrupted03 extends JTTTest {

    public static boolean test() throws InterruptedException {
        final Thread1 thread = new Thread1();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        Thread.sleep(1000);
        // Did thread get interrupted?
        final boolean result = thread.getInterrupted();
        // This stops the thread even if the interrupt didn't!
        thread.setInterrupted(true);
        return result;
    }

    private static class Thread1 extends java.lang.Thread {

        private boolean interrupted = false;

        @Override
        public void run() {
            while (!interrupted) {
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
        }

        public void setInterrupted(boolean val) {
            interrupted = val;
        }

        public boolean getInterrupted() {
            return interrupted;
        }
    }

    @Test(timeout = 20000)
    public void run0() throws Throwable {
        runTest("test");
    }

}
