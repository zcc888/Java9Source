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

import java.util.concurrent.TimeUnit;

/**
 * A timer for some activity of interest. A timer should be deployed using the try-with-resources
 * pattern:
 *
 * <pre>
 * try (TimerCloseable a = timer.start()) {
 *     // the code to time
 * }
 * </pre>
 */
public interface DebugTimer {

    /**
     * Starts this timer if timing is {@linkplain Debug#isTimeEnabled() enabled} or this is an
     * {@linkplain #isConditional() unconditional} timer.
     *
     * @return an object that must be closed once the activity has completed to add the elapsed time
     *         since this call to the total for this timer
     */
    DebugCloseable start();

    /**
     * Sets a flag determining if this timer is only enabled if timing is
     * {@link Debug#isTimeEnabled() enabled}.
     */
    void setConditional(boolean flag);

    /**
     * Determines if this timer is only enabled if timing is {@link Debug#isTimeEnabled() enabled}.
     */
    boolean isConditional();

    /**
     * Gets the current value of this timer.
     */
    long getCurrentValue();

    /**
     * Gets the time unit of this timer.
     */
    TimeUnit getTimeUnit();

    /**
     * Gets the timer recording the amount time spent within a timed scope minus the time spent in
     * any nested timed scopes.
     *
     * @return null if this timer does not support flat timing
     */
    default DebugTimer getFlat() {
        return null;
    }
}
