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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.DebugCloseable;
import org.graalvm.compiler.debug.DebugConfig;
import org.graalvm.compiler.debug.DebugCounter;
import org.graalvm.compiler.debug.DebugDumpHandler;
import org.graalvm.compiler.debug.DebugMemUseTracker;
import org.graalvm.compiler.debug.DebugMethodMetrics;
import org.graalvm.compiler.debug.DebugTimer;
import org.graalvm.compiler.debug.DebugValueFactory;
import org.graalvm.compiler.debug.DebugVerifyHandler;
import org.graalvm.compiler.debug.GraalDebugConfig;
import org.graalvm.compiler.debug.internal.method.MethodMetricsImpl;
import org.graalvm.compiler.debug.internal.method.MethodMetricsPrinter;
import org.graalvm.compiler.options.OptionValue;
import org.graalvm.compiler.options.OptionValue.OverrideScope;
import org.graalvm.compiler.phases.Phase;

import jdk.vm.ci.meta.ResolvedJavaMethod;

// intercepting metrics
public class MethodMetricsTestInterception02 extends MethodMetricsTest {

    @Override
    protected Phase additionalPhase() {
        return new MethodMetricPhases.ScopeTestPhase();
    }

    private DebugValueFactory factory;

    public void setFactory() {
        /*
         * setting a custom debug value factory creating a constant timer for checking scope
         * creation and inlining scopes with metric intercepting works
         */
        factory = Debug.getDebugValueFactory();
        Debug.setDebugValueFactory(new DebugValueFactory() {
            @Override
            public DebugTimer createTimer(String name, boolean conditional) {
                // can still use together with real timer
                // TimerImpl realTimer = new TimerImpl(name, conditional, true);
                return new DebugTimer() {
                    int runs = 0;

                    // private DebugCloseable t;

                    @Override
                    public DebugCloseable start() {
                        // t = realTimer.start();
                        return new DebugCloseable() {
                            @Override
                            public void close() {
                                // t.close();
                                runs++;
                                MethodMetricsImpl.addToCurrentScopeMethodMetrics(name, 1);
                            }
                        };
                    }

                    @Override
                    public void setConditional(boolean flag) {

                    }

                    @Override
                    public boolean isConditional() {
                        return false;
                    }

                    @Override
                    public TimeUnit getTimeUnit() {
                        return TimeUnit.MILLISECONDS;
                    }

                    @Override
                    public long getCurrentValue() {
                        return runs;
                    }
                };
            }

            @Override
            public DebugCounter createCounter(String name, boolean conditional) {
                return factory.createCounter(name, conditional);
            }

            @Override
            public DebugMethodMetrics createMethodMetrics(ResolvedJavaMethod method) {
                return factory.createMethodMetrics(method);
            }

            @Override
            public DebugMemUseTracker createMemUseTracker(String name, boolean conditional) {
                return factory.createMemUseTracker(name, conditional);
            }
        });
    }

    @Override
    protected OverrideScope getOScope() {
        Map<OptionValue<?>, Object> mapping = new HashMap<>();
        mapping.put(MethodMetricsPrinter.Options.MethodMeterPrintAscii, true);
        return OptionValue.override(mapping);
    }

    @Test
    @Override
    public void test() throws Throwable {
        setFactory();
        super.test();
    }

    @Override
    public void afterTest() {
        super.afterTest();
        Debug.setDebugValueFactory(factory);
    }

    @Override
    DebugConfig getConfig() {
        List<DebugDumpHandler> dumpHandlers = new ArrayList<>();
        List<DebugVerifyHandler> verifyHandlers = new ArrayList<>();
        GraalDebugConfig debugConfig = new GraalDebugConfig(
                        GraalDebugConfig.Options.Log.getValue(),
                        ""/* unscoped meter */,
                        GraalDebugConfig.Options.TrackMemUse.getValue(),
                        ""/* unscoped time */,
                        GraalDebugConfig.Options.Dump.getValue(),
                        GraalDebugConfig.Options.Verify.getValue(),
                        null /* no method filter */,
                        "" /* unscoped method metering */,
                        System.out, dumpHandlers, verifyHandlers);
        return debugConfig;
    }

    @Override
    @SuppressWarnings("try")
    void assertValues() throws Throwable {
        assertValues("GlobalTimer4_WithoutInlineEnhancement", new long[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50});
    }

}
