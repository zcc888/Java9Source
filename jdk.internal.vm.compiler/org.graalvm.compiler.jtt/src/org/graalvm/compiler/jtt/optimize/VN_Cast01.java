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
package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 * Tests constant folding of integer operations.
 */
public class VN_Cast01 extends JTTTest {

    private static class TestClass {
        int field = 9;
    }

    static final Object object = new TestClass();

    public static int test(int arg) {
        if (arg == 0) {
            return test1();
        }
        if (arg == 1) {
            return test2();
        }
        if (arg == 2) {
            return test3();
        }
        return 0;
    }

    private static int test1() {
        Object o = object;
        TestClass a = (TestClass) o;
        TestClass b = (TestClass) o;
        return a.field + b.field;
    }

    private static int test2() {
        Object obj = new TestClass();
        TestClass a = (TestClass) obj;
        TestClass b = (TestClass) obj;
        return a.field + b.field;
    }

    @SuppressWarnings("all")
    private static int test3() {
        Object o = null;
        TestClass a = (TestClass) o;
        TestClass b = (TestClass) o;
        return a.field + b.field;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2);
    }

}
