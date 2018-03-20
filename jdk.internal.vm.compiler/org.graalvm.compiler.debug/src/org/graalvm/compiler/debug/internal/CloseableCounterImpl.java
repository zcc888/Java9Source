/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.debug.DebugCloseable;

/**
 * A helper class for DebugValues that can nest and need to split out accumulated and flat values
 * for some kind of counter-like measurement.
 */
abstract class CloseableCounterImpl implements DebugCloseable {

    protected final CloseableCounterImpl parent;
    protected final AccumulatedDebugValue counter;
    protected final long start;
    protected long nestedAmountToSubtract;

    CloseableCounterImpl(CloseableCounterImpl parent, AccumulatedDebugValue counter) {
        this.parent = parent;
        this.start = getCounterValue();
        this.counter = counter;
    }

    /**
     * A hook for subclasses. Lets them perform custom operations with the value since the last
     * invocation of {@link CloseableCounterImpl#close()} of this accumulated
     * {@link CloseableCounterImpl#counter}.
     *
     * @param difference since the last invocation of this counter flat
     */
    protected void interceptDifferenceAccm(long difference) {
        // hook for subclasses
    }

    /**
     * A hook for subclasses. Lets them perform custom operations with the value since the last
     * invocation of {@link CloseableCounterImpl#close()} of this flat
     * {@link CloseableCounterImpl#counter}.
     *
     * @param difference since the last invocation of this counter flat
     */
    protected void interceptDifferenceFlat(long difference) {
        // hook for subclasses
    }

    @Override
    public void close() {
        long end = getCounterValue();
        long difference = end - start;
        if (parent != null) {
            if (!counter.getName().equals(parent.counter.getName())) {
                parent.nestedAmountToSubtract += difference;
                // Look for our counter in an outer scope and fix up
                // the adjustment to the flat count
                CloseableCounterImpl ancestor = parent.parent;
                while (ancestor != null) {
                    if (ancestor.counter.getName().equals(counter.getName())) {
                        ancestor.nestedAmountToSubtract -= difference;
                        break;
                    }
                    ancestor = ancestor.parent;
                }
            }
        }
        long flatAmount = difference - nestedAmountToSubtract;
        counter.addToCurrentValue(difference);
        counter.flat.addToCurrentValue(flatAmount);
        interceptDifferenceAccm(difference);
        interceptDifferenceFlat(flatAmount);
    }

    abstract long getCounterValue();
}
