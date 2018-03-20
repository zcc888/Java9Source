/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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

import java.util.EnumSet;

import jdk.vm.ci.meta.DeoptimizationReason;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class ConditionalElimination02 extends JTTTest {

    private static Object o = null;

    private static class A {

        A(int y) {
            this.y = y;
        }

        int y;
    }

    public int test(A a, boolean isNull, boolean isVeryNull) {
        if (o == null) {
            if (!isNull) {
                if (o == null) {
                    return a.y;
                }
            }
            if (!isVeryNull) {
                if (o == null) {
                    return a.y;
                }
            }
        }
        return -1;
    }

    @Test
    public void run0() throws Throwable {
        runTest(EnumSet.of(DeoptimizationReason.NullCheckException), "test", new A(5), false, false);
    }

    @Test
    public void run1() throws Throwable {
        runTest(EnumSet.of(DeoptimizationReason.NullCheckException), "test", new Object[]{null, true, true});
    }

}
