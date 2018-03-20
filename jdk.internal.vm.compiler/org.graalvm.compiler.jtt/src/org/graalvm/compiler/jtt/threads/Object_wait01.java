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

public class Object_wait01 extends JTTTest {

    private static class TestClass implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (i++ < 1000000 && !done) {
                synchronized (object) {
                    count++;
                    object.notifyAll();
                }
            }
        }
    }

    static volatile int count = 0;
    static volatile boolean done;
    static final Object object = new Object();

    public static boolean test(int i) throws InterruptedException {
        count = 0;
        done = false;
        new Thread(new TestClass()).start();
        synchronized (object) {
            while (count < i) {
                object.wait();
            }
            done = true;
            return count >= i;
        }
    }

    @Test(timeout = 20000)
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test(timeout = 20000)
    public void run1() throws Throwable {
        runTest("test", 1);
    }

    @Test(timeout = 20000)
    public void run2() throws Throwable {
        runTest("test", 3);
    }

    @Test(timeout = 20000)
    public void run3() throws Throwable {
        runTest("test", 15);
    }

}
