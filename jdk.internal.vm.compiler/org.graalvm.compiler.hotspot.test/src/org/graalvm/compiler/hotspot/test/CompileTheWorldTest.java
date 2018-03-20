/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.test;

import static org.graalvm.compiler.core.GraalCompilerOptions.ExitVMOnException;

import org.junit.Test;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.hotspot.CompileTheWorld;
import org.graalvm.compiler.hotspot.CompileTheWorld.Config;
import org.graalvm.compiler.hotspot.HotSpotGraalCompiler;

import jdk.vm.ci.hotspot.HotSpotJVMCIRuntime;
import jdk.vm.ci.hotspot.HotSpotJVMCIRuntimeProvider;

/**
 * Tests {@link CompileTheWorld} functionality.
 */
public class CompileTheWorldTest extends GraalCompilerTest {

    @Test
    public void testJDK() throws Throwable {
        boolean originalSetting = ExitVMOnException.getValue();
        // Compile a couple classes in rt.jar
        HotSpotJVMCIRuntimeProvider runtime = HotSpotJVMCIRuntime.runtime();
        System.setProperty(CompileTheWorld.LIMITMODS_PROPERTY_NAME, "java.base");
        new CompileTheWorld(runtime, (HotSpotGraalCompiler) runtime.getCompiler(), CompileTheWorld.SUN_BOOT_CLASS_PATH, new Config("Inline=false"), 1, 5, null, null, true).compile();
        assert ExitVMOnException.getValue() == originalSetting;
    }
}
