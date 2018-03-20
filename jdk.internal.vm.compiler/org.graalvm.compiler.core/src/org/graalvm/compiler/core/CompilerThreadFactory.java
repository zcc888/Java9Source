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
package org.graalvm.compiler.core;

import java.util.concurrent.ThreadFactory;

import org.graalvm.compiler.debug.DebugConfig;

/**
 * Facility for creating {@linkplain CompilerThread compiler threads}.
 */
public class CompilerThreadFactory implements ThreadFactory {

    /**
     * Capability to get a thread-local debug configuration for the current thread.
     */
    public interface DebugConfigAccess {
        /**
         * Get a thread-local debug configuration for the current thread. This will be null if
         * debugging is disabled.
         */
        DebugConfig getDebugConfig();
    }

    protected final String threadNamePrefix;
    protected final DebugConfigAccess debugConfigAccess;

    public CompilerThreadFactory(String threadNamePrefix, DebugConfigAccess debugConfigAccess) {
        this.threadNamePrefix = threadNamePrefix;
        this.debugConfigAccess = debugConfigAccess;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new CompilerThread(r, threadNamePrefix, debugConfigAccess);
    }
}
