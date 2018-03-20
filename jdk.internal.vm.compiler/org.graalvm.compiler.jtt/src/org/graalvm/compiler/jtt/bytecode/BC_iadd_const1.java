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
package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_iadd_const1 extends JTTTest {

    public static int test(byte a, byte b, boolean neg) {
        byte x = GraalDirectives.opaque(a);
        if (!neg) {
            return x + b;
        }
        return x - b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", (byte) 42, (byte) 1, false);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", (byte) 42, (byte) -1, false);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", (byte) 42, (byte) 1, true);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", (byte) 42, (byte) -1, true);
    }
}
