/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.debug.GraalDebugConfig.Options.Dump;
import static org.graalvm.compiler.debug.GraalDebugConfig.Options.Log;
import static org.graalvm.compiler.debug.GraalDebugConfig.Options.Count;
import static org.graalvm.compiler.debug.GraalDebugConfig.Options.MethodFilter;
import static org.graalvm.compiler.debug.GraalDebugConfig.Options.Time;
import static org.graalvm.compiler.debug.GraalDebugConfig.Options.TrackMemUse;
import static org.graalvm.compiler.debug.GraalDebugConfig.Options.Verify;
import static org.graalvm.compiler.debug.GraalDebugConfig.Options.MethodMeter;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.graalvm.compiler.serviceprovider.GraalServices;

import jdk.vm.ci.runtime.JVMCI;

public class DebugEnvironment {

    public static GraalDebugConfig initialize(PrintStream log, Object... extraArgs) {
        // Initialize JVMCI before loading class Debug
        JVMCI.initialize();
        if (!Debug.isEnabled()) {
            log.println("WARNING: Scope debugging needs to be enabled with -esa");
            return null;
        }
        List<DebugDumpHandler> dumpHandlers = new ArrayList<>();
        List<DebugVerifyHandler> verifyHandlers = new ArrayList<>();
        GraalDebugConfig debugConfig = new GraalDebugConfig(Log.getValue(), Count.getValue(), TrackMemUse.getValue(), Time.getValue(), Dump.getValue(), Verify.getValue(), MethodFilter.getValue(),
                        MethodMeter.getValue(),
                        log, dumpHandlers, verifyHandlers);

        for (DebugConfigCustomizer customizer : GraalServices.load(DebugConfigCustomizer.class)) {
            customizer.customize(debugConfig, extraArgs);
        }

        Debug.setConfig(debugConfig);
        return debugConfig;
    }
}
