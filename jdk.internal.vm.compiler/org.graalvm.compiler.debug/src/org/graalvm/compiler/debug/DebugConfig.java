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

import java.io.PrintStream;
import java.util.Collection;

public interface DebugConfig {

    /**
     * Determines the current log level in the {@linkplain Debug#currentScope() current debug scope}
     * .
     */
    int getLogLevel();

    /**
     * Determines the current dump level in the {@linkplain Debug#currentScope() current debug
     * scope}.
     */
    int getDumpLevel();

    /**
     * Determines if logging can be enabled in the current method, regardless of the
     * {@linkplain Debug#currentScope() current debug scope}.
     */
    boolean isLogEnabledForMethod();

    /**
     * Determines if counting is enabled in the {@linkplain Debug#currentScope() current debug
     * scope}.
     *
     * @see Debug#counter(CharSequence)
     */
    boolean isCountEnabled();

    /**
     * Determines if memory use tracking is enabled in the {@linkplain Debug#currentScope() current
     * debug scope}.
     *
     * @see Debug#memUseTracker(CharSequence)
     */
    boolean isMemUseTrackingEnabled();

    /**
     * Determines if dumping can be enabled in the current method, regardless of the
     * {@linkplain Debug#currentScope() current debug scope}.
     */
    boolean isDumpEnabledForMethod();

    /**
     * @see Debug#isVerifyEnabled()
     */
    boolean isVerifyEnabled();

    /**
     * @see Debug#isVerifyEnabledForMethod()
     */
    boolean isVerifyEnabledForMethod();

    /**
     * @see Debug#isMethodMeterEnabled()
     */
    boolean isMethodMeterEnabled();

    /**
     * Adds an object the context used by this configuration to do filtering.
     */
    void addToContext(Object o);

    /**
     * Removes an object the context used by this configuration to do filtering.
     *
     * This should only removes extra context added by {@link #addToContext(Object)}.
     */
    void removeFromContext(Object o);

    /**
     * @see Debug#timer(CharSequence)
     */
    boolean isTimeEnabled();

    /**
     * Handles notification of an exception occurring within a debug scope.
     *
     * @return the exception object that is to be propagated to parent scope. A value of
     *         {@code null} indicates that {@code e} is to be propagated.
     */
    RuntimeException interceptException(Throwable e);

    /**
     * Gets the modifiable collection of dump handlers registered with this configuration.
     */
    Collection<DebugDumpHandler> dumpHandlers();

    PrintStream output();

    /**
     * Gets the modifiable collection of verify handlers registered with this configuration.
     */
    Collection<DebugVerifyHandler> verifyHandlers();

}
