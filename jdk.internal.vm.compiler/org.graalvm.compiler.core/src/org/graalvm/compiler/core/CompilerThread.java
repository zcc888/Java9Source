/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.CompilerThreadFactory.DebugConfigAccess;
import org.graalvm.compiler.debug.DebugConfig;
import org.graalvm.compiler.debug.DebugDumpHandler;
import org.graalvm.compiler.debug.GraalDebugConfig;

/**
 * A compiler thread is a daemon thread that runs at {@link Thread#MAX_PRIORITY} and executes in the
 * context of a thread-local {@linkplain GraalDebugConfig debug configuration}.
 */
public class CompilerThread extends Thread {

    private final DebugConfigAccess debugConfigAccess;

    public CompilerThread(Runnable r, String namePrefix, DebugConfigAccess debugConfigAccess) {
        super(r);
        this.setName(namePrefix + "-" + this.getId());
        this.setPriority(Thread.MAX_PRIORITY);
        this.setDaemon(true);
        this.debugConfigAccess = debugConfigAccess;
    }

    @Override
    public void run() {
        DebugConfig debugConfig = debugConfigAccess.getDebugConfig();
        setContextClassLoader(getClass().getClassLoader());
        try {
            super.run();
        } finally {
            if (debugConfig != null) {
                for (DebugDumpHandler dumpHandler : debugConfig.dumpHandlers()) {
                    try {
                        dumpHandler.close();
                    } catch (Throwable t) {
                    }
                }
            }
        }
    }
}
