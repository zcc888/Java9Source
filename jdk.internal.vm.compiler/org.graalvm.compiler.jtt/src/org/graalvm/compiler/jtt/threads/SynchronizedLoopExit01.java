/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Inspired by {@code com.sun.media.sound.DirectAudioDevice$DirectDL.drain()}.
 *
 * Two loop exits hold a monitor while merging.
 *
 */
public final class SynchronizedLoopExit01 extends JTTTest {

    protected Object object = new Object();
    protected volatile boolean drained = false;
    protected volatile boolean someBoolean = true;

    public boolean test() {
        boolean b = true;
        while (!drained) {
            synchronized (object) {
                boolean c = b = someBoolean;
                if (c || drained) {
                    break;
                }
            }
        }
        return b;
    }

    @Test(timeout = 20000)
    public void run0() throws Throwable {
        runTest("test");
    }

}
