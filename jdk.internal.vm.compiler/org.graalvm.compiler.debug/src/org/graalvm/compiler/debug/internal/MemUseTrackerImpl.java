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

import static org.graalvm.compiler.debug.DebugCloseable.VOID_CLOSEABLE;

import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.DebugCloseable;
import org.graalvm.compiler.debug.DebugMemUseTracker;
import org.graalvm.compiler.debug.Management;
import org.graalvm.compiler.debug.internal.method.MethodMetricsImpl;

public class MemUseTrackerImpl extends AccumulatedDebugValue implements DebugMemUseTracker {
    private final boolean intercepting;

    public static long getCurrentThreadAllocatedBytes() {
        return Management.getCurrentThreadAllocatedBytes();
    }

    /**
     * Records the most recent active tracker.
     */
    private static final ThreadLocal<CloseableCounterImpl> currentTracker = new ThreadLocal<>();

    public MemUseTrackerImpl(String name, boolean conditional, boolean intercepting) {
        super(name, conditional, new DebugValue(name + "_Flat", conditional) {

            @Override
            public String toString(long value) {
                return valueToString(value);
            }

            @Override
            public String rawUnit() {
                return "B";
            }

            @Override
            public String toRawString(long value) {
                return Long.toString(value);
            }
        });
        this.intercepting = intercepting;
    }

    @Override
    public DebugCloseable start() {
        if (!isConditional() || Debug.isMemUseTrackingEnabled()) {
            CloseableCounterImpl result = intercepting ? new MemUseInterceptingCloseableCounterImpl(this) : new MemUseCloseableCounterImpl(this);
            currentTracker.set(result);
            return result;
        } else {
            return VOID_CLOSEABLE;
        }
    }

    public static String valueToString(long value) {
        return String.format("%d bytes", value);
    }

    @Override
    public String toString(long value) {
        return valueToString(value);
    }

    private static final class MemUseCloseableCounterImpl extends CloseableCounterImpl implements DebugCloseable {

        private MemUseCloseableCounterImpl(AccumulatedDebugValue counter) {
            super(currentTracker.get(), counter);
        }

        @Override
        long getCounterValue() {
            return getCurrentThreadAllocatedBytes();
        }

        @Override
        public void close() {
            super.close();
            currentTracker.set(parent);
        }
    }

    private static final class MemUseInterceptingCloseableCounterImpl extends CloseableCounterImpl implements DebugCloseable {

        private MemUseInterceptingCloseableCounterImpl(AccumulatedDebugValue counter) {
            super(currentTracker.get(), counter);
        }

        @Override
        long getCounterValue() {
            return getCurrentThreadAllocatedBytes();
        }

        @Override
        public void close() {
            super.close();
            currentTracker.set(parent);
        }

        @Override
        protected void interceptDifferenceAccm(long difference) {
            if (Debug.isMethodMeterEnabled()) {
                MethodMetricsImpl.addToCurrentScopeMethodMetrics(counter.getName(), difference);
            }
        }

        @Override
        protected void interceptDifferenceFlat(long difference) {
            if (Debug.isMethodMeterEnabled()) {
                MethodMetricsImpl.addToCurrentScopeMethodMetrics(counter.flat.getName(), difference);
            }
        }
    }

    @Override
    public String rawUnit() {
        return "B";
    }

    @Override
    public String toRawString(long value) {
        return Long.toString(value);
    }
}
