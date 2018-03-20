/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot;

import org.graalvm.compiler.code.CompilationResult;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.GraalDebugConfig;

import jdk.vm.ci.code.CompiledCode;
import jdk.vm.ci.code.InstalledCode;
import jdk.vm.ci.hotspot.HotSpotCodeCacheProvider;
import jdk.vm.ci.hotspot.HotSpotVMEventListener;

public class HotSpotGraalVMEventListener implements HotSpotVMEventListener {

    private final HotSpotGraalRuntime runtime;

    HotSpotGraalVMEventListener(HotSpotGraalRuntime runtime) {
        this.runtime = runtime;
    }

    @Override
    public void notifyShutdown() {
        runtime.shutdown();
    }

    @Override
    public void notifyInstall(HotSpotCodeCacheProvider codeCache, InstalledCode installedCode, CompiledCode compiledCode) {
        if (Debug.isDumpEnabled(Debug.BASIC_LOG_LEVEL)) {
            CompilationResult compResult = Debug.contextLookup(CompilationResult.class);
            assert compResult != null : "can't dump installed code properly without CompilationResult";
            Debug.dump(Debug.BASIC_LOG_LEVEL, installedCode, "After code installation");
        }
        if (Debug.isLogEnabled()) {
            Debug.log("%s", codeCache.disassemble(installedCode));
        }
    }

    @Override
    public void notifyBootstrapFinished() {
        runtime.notifyBootstrapFinished();
        if (GraalDebugConfig.Options.ClearMetricsAfterBootstrap.getValue()) {
            runtime.clearMeters();
        }
    }
}
