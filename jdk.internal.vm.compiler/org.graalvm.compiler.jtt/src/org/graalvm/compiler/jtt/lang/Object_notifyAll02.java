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
package org.graalvm.compiler.jtt.lang;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public final class Object_notifyAll02 extends JTTTest {

    static final Object object = new Object();

    public static boolean test() {
        synchronized (object) {
            object.notifyAll();
        }
        return true;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
