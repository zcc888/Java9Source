/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.core.test;

import org.junit.Test;

import org.graalvm.compiler.common.RetryableBailoutException;
import org.graalvm.compiler.core.common.util.CompilationAlarm;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.options.OptionValue;
import org.graalvm.compiler.options.OptionValue.OverrideScope;
import org.graalvm.compiler.phases.Phase;

public class CooperativePhaseTest extends GraalCompilerTest {

    public static void snippet() {
        // dummy snippet
    }

    private static class CooperativePhase extends Phase {

        @Override
        protected void run(StructuredGraph graph) {
            while (true) {
                sleep(200);
                if (CompilationAlarm.hasExpired()) {
                    return;
                }
            }
        }

    }

    private static class UnCooperativePhase extends Phase {

        @Override
        protected void run(StructuredGraph graph) {
            while (true) {
                sleep(200);
                if (CompilationAlarm.hasExpired()) {
                    throw new RetryableBailoutException("Expiring...");
                }
            }
        }

    }

    private static class ParlyCooperativePhase extends Phase {

        @Override
        protected void run(StructuredGraph graph) {
            for (int i = 0; i < 10; i++) {
                sleep(200);
                if (CompilationAlarm.hasExpired()) {
                    throw new RuntimeException("Phase must not exit in the timeout path");
                }
            }
        }
    }

    private static class CooperativePhaseWithoutAlarm extends Phase {

        @Override
        protected void run(StructuredGraph graph) {
            if (CompilationAlarm.hasExpired()) {
                throw new RuntimeException("Phase must not exit in the timeout path");
            }
        }
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            GraalError.shouldNotReachHere(e.getCause());
        }
    }

    @Test(timeout = 60_000)
    @SuppressWarnings("try")
    public void test01() {
        StructuredGraph g = parseEager("snippet", AllowAssumptions.NO);
        try (OverrideScope o = OptionValue.override(CompilationAlarm.Options.CompilationExpirationPeriod, 1/* sec */);
                        CompilationAlarm c1 = CompilationAlarm.trackCompilationPeriod()) {
            new CooperativePhase().apply(g);
        }
    }

    @Test(expected = RetryableBailoutException.class, timeout = 60_000)
    @SuppressWarnings("try")
    public void test02() {
        StructuredGraph g = parseEager("snippet", AllowAssumptions.NO);
        try (OverrideScope o = OptionValue.override(CompilationAlarm.Options.CompilationExpirationPeriod, 1/* sec */);
                        CompilationAlarm c1 = CompilationAlarm.trackCompilationPeriod()) {
            new UnCooperativePhase().apply(g);
        }
    }

    @Test(timeout = 60_000)
    @SuppressWarnings("try")
    public void test03() {
        StructuredGraph g = parseEager("snippet", AllowAssumptions.NO);
        // 0 disables alarm utility
        try (OverrideScope o = OptionValue.override(CompilationAlarm.Options.CompilationExpirationPeriod, 0);
                        CompilationAlarm c1 = CompilationAlarm.trackCompilationPeriod()) {
            new ParlyCooperativePhase().apply(g);
        }
    }

    @Test(timeout = 60_000)
    @SuppressWarnings("try")
    public void test04() {
        StructuredGraph g = parseEager("snippet", AllowAssumptions.NO);
        new CooperativePhaseWithoutAlarm().apply(g);
    }
}
