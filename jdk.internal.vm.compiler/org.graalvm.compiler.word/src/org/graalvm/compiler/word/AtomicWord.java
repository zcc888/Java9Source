/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.word;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * A {@link WordBase word} value that may be updated atomically. See the
 * {@link java.util.concurrent.atomic} package specification for description of the properties of
 * atomic variables.
 *
 * Similar to {@link AtomicReference}, but for {@link WordBase word} types. A dedicated
 * implementation is necessary because Object and word types cannot be mixed.
 */
public class AtomicWord<T extends WordBase> {

    /**
     * For simplicity, we convert the word value to a long and delegate to existing atomic
     * operations.
     */
    protected final AtomicLong value;

    /**
     * Creates a new AtomicLong with initial value {@link Word#zero}.
     */
    public AtomicWord() {
        value = new AtomicLong();
    }

    /**
     * Gets the current value.
     *
     * @return the current value
     */
    @SuppressWarnings("unchecked")
    public final T get() {
        return (T) Word.unsigned(value.get());
    }

    /**
     * Sets to the given value.
     *
     * @param newValue the new value
     */
    public final void set(T newValue) {
        value.set(newValue.rawValue());
    }

    /**
     * Atomically sets to the given value and returns the old value.
     *
     * @param newValue the new value
     * @return the previous value
     */
    @SuppressWarnings("unchecked")
    public final T getAndSet(T newValue) {
        return (T) Word.unsigned(value.getAndSet(newValue.rawValue()));
    }

    /**
     * Atomically sets the value to the given updated value if the current value {@code ==} the
     * expected value.
     *
     * @param expect the expected value
     * @param update the new value
     * @return {@code true} if successful. False return indicates that the actual value was not
     *         equal to the expected value.
     */
    public final boolean compareAndSet(T expect, T update) {
        return value.compareAndSet(expect.rawValue(), update.rawValue());
    }
}
