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
package org.graalvm.compiler.debug;

/**
 * A counter for some value of interest.
 */
public interface DebugCounter {

    /**
     * Adds 1 to this counter if counting is {@link Debug#isCountEnabled() enabled} or this is an
     * {@linkplain #isConditional() unconditional} counter.
     */
    void increment();

    /**
     * Adds {@code value} to this counter if counting is {@link Debug#isCountEnabled() enabled} or
     * this is an {@linkplain #isConditional() unconditional} counter.
     */
    void add(long value);

    /**
     * Sets a flag determining if this counter is only enabled if counting is
     * {@link Debug#isCountEnabled() enabled}.
     */
    void setConditional(boolean flag);

    /**
     * Determines if this counter is only enabled if counting is {@link Debug#isCountEnabled()
     * enabled}.
     */
    boolean isConditional();

    /**
     * Gets the current value of this counter.
     */
    long getCurrentValue();

    /**
     * Determines if this counter is enabled (either conditionally or unconditionally).
     */
    default boolean isEnabled() {
        return !isConditional() || Debug.isCountEnabled();
    }
}
