/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.debug.internal;

import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.DebugCounter;
import org.graalvm.compiler.debug.internal.method.MethodMetricsImpl;

public abstract class CounterImpl extends DebugValue implements DebugCounter {

    public CounterImpl(String name, boolean conditional) {
        super(name, conditional);
        if (isEnabled()) {
            // Allows for zero counters to be shown
            getCurrentValue();
        }
    }

    @Override
    public void increment() {
        add(1);
    }

    @Override
    public String rawUnit() {
        return "";
    }

    @Override
    public String toRawString(long value) {
        return Long.toString(value);
    }

    @Override
    public String toString(long value) {
        return Long.toString(value);
    }

    private static final class InterceptingCounterImpl extends CounterImpl {

        private InterceptingCounterImpl(String name, boolean conditional) {
            super(name, conditional);
        }

        @Override
        public void add(long value) {
            if (isEnabled()) {
                if (Debug.isMethodMeterEnabled()) {
                    MethodMetricsImpl.addToCurrentScopeMethodMetrics(getName(), value);
                }
                super.addToCurrentValue(value);
            }
        }
    }

    private static final class PlainCounterImpl extends CounterImpl {

        private PlainCounterImpl(String name, boolean conditional) {
            super(name, conditional);
        }

        @Override
        public void add(long value) {
            if (isEnabled()) {
                super.addToCurrentValue(value);
            }
        }
    }

    public static DebugCounter create(String name, boolean conditional, boolean intercepting) {
        if (intercepting) {
            return new InterceptingCounterImpl(name, conditional);
        }
        return new PlainCounterImpl(name, conditional);
    }
}
