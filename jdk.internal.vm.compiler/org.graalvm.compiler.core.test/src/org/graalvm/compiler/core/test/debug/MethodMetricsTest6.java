/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.core.test.debug;

import org.junit.Test;

import org.graalvm.compiler.debug.DebugConfig;
import org.graalvm.compiler.phases.Phase;

public class MethodMetricsTest6 extends MethodMetricsTest {

    @Override
    protected Phase additionalPhase() {
        return new MethodMetricPhases.CountingBinOpPhase();
    }

    @Override
    DebugConfig getConfig() {
        return overrideGraalDebugConfig(System.out, "MethodMetricsTest$TestApplication.*", "CountingBinOpPhase");
    }

    @Override
    void assertValues() throws Throwable {
        assertValues("BinOps", new long[]{1, 1, 1, 1, 1, 1, 0, 1, 1, 1});
    }

    @Override
    @Test
    public void test() throws Throwable {
        super.test();
    }
}
