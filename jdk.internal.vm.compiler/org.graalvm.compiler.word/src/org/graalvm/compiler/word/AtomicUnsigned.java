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

/**
 * A {@link Unsigned} value that may be updated atomically. See the
 * {@link java.util.concurrent.atomic} package specification for description of the properties of
 * atomic variables.
 */
public class AtomicUnsigned extends AtomicWord<Unsigned> {

    /**
     * Atomically adds the given value to the current value.
     *
     * @param delta the value to add
     * @return the previous value
     */
    public final Unsigned getAndAdd(Unsigned delta) {
        return Word.unsigned(value.getAndAdd(delta.rawValue()));
    }

    /**
     * Atomically adds the given value to the current value.
     *
     * @param delta the value to add
     * @return the updated value
     */
    public final Unsigned addAndGet(Unsigned delta) {
        return Word.unsigned(value.addAndGet(delta.rawValue()));
    }

    /**
     * Atomically subtracts the given value from the current value.
     *
     * @param delta the value to add
     * @return the previous value
     */
    public final Unsigned getAndSubtract(Unsigned delta) {
        return Word.unsigned(value.getAndAdd(-delta.rawValue()));
    }

    /**
     * Atomically subtracts the given value from the current value.
     *
     * @param delta the value to add
     * @return the updated value
     */
    public final Unsigned subtractAndGet(Unsigned delta) {
        return Word.unsigned(value.addAndGet(-delta.rawValue()));
    }
}
