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

import org.graalvm.compiler.debug.internal.DebugScope;

/**
 * A utility for scoping a change to the current debug {@linkplain DebugScope#setConfig(DebugConfig)
 * configuration}. For example:
 *
 * <pre>
 *     DebugConfig config = ...;
 *     try (DebugConfigScope s = new DebugConfigScope(config)) {
 *         // ...
 *     }
 * </pre>
 */
public class DebugConfigScope implements AutoCloseable {

    private final DebugConfig current;

    /**
     * Sets the current debug {@linkplain DebugScope#setConfig(DebugConfig) configuration} to a
     * given value and creates an object that when {@linkplain #close() closed} resets the
     * configuration to the {@linkplain DebugScope#getConfig() current} configuration.
     */
    public DebugConfigScope(DebugConfig config) {
        this.current = DebugScope.getConfig();
        DebugScope.getInstance().setConfig(config);
    }

    @Override
    public void close() {
        DebugScope.getInstance().setConfig(current);
    }
}
