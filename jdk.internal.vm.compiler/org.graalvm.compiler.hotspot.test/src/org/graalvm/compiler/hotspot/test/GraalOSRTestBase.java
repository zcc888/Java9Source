/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import org.junit.Assert;

import org.graalvm.compiler.bytecode.Bytecode;
import org.graalvm.compiler.bytecode.BytecodeStream;
import org.graalvm.compiler.bytecode.ResolvedJavaMethodBytecode;
import org.graalvm.compiler.core.target.Backend;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.hotspot.CompilationTask;
import org.graalvm.compiler.hotspot.HotSpotGraalCompiler;
import org.graalvm.compiler.java.BciBlockMapping;
import org.graalvm.compiler.java.BciBlockMapping.BciBlock;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;

import jdk.vm.ci.code.Architecture;
import jdk.vm.ci.hotspot.HotSpotCompilationRequest;
import jdk.vm.ci.hotspot.HotSpotCompilationRequestResult;
import jdk.vm.ci.hotspot.HotSpotJVMCIRuntime;
import jdk.vm.ci.hotspot.HotSpotJVMCIRuntimeProvider;
import jdk.vm.ci.hotspot.HotSpotResolvedJavaMethod;
import jdk.vm.ci.meta.ResolvedJavaMethod;

public abstract class GraalOSRTestBase extends GraalCompilerTest {

    protected void testOSR(String methodName) {
        ResolvedJavaMethod method = getResolvedJavaMethod(methodName);
        testOSR(method);
    }

    protected void testOSR(ResolvedJavaMethod method) {
        // invalidate any existing compiled code
        method.reprofile();
        compileOSR(method);
        Result result = executeExpected(method, null);
        checkResult(result);
    }

    private static void compile(ResolvedJavaMethod method, int bci) {
        HotSpotJVMCIRuntimeProvider runtime = HotSpotJVMCIRuntime.runtime();
        long jvmciEnv = 0L;
        HotSpotCompilationRequest request = new HotSpotCompilationRequest((HotSpotResolvedJavaMethod) method, bci, jvmciEnv);
        HotSpotGraalCompiler compiler = (HotSpotGraalCompiler) runtime.getCompiler();
        CompilationTask task = new CompilationTask(runtime, compiler, request, true, true);
        HotSpotCompilationRequestResult result = task.runCompilation();
        if (result.getFailure() != null) {
            throw new GraalError(result.getFailureMessage());
        }
    }

    /**
     * Returns the target BCI of the first bytecode backedge. This is where HotSpot triggers
     * on-stack-replacement in case the backedge counter overflows.
     */
    private static int getBackedgeBCI(ResolvedJavaMethod method) {
        Bytecode code = new ResolvedJavaMethodBytecode(method);
        BytecodeStream stream = new BytecodeStream(code.getCode());
        BciBlockMapping bciBlockMapping = BciBlockMapping.create(stream, code);
        assert bciBlockMapping.getLoopCount() == 1 : "Expected exactly one loop " + method;

        for (BciBlock block : bciBlockMapping.getBlocks()) {
            int bci = block.startBci;
            for (BciBlock succ : block.getSuccessors()) {
                int succBci = succ.startBci;
                if (succBci < bci) {
                    // back edge
                    return succBci;
                }
            }
        }
        return -1;
    }

    private static void checkResult(Result result) {
        Assert.assertNull("Unexpected exception", result.exception);
        Assert.assertNotNull(result.returnValue);
        Assert.assertTrue(result.returnValue instanceof ReturnValue);
        Assert.assertEquals(ReturnValue.SUCCESS, result.returnValue);
    }

    private void compileOSR(ResolvedJavaMethod method) {
        int bci = getBackedgeBCI(method);
        assert bci != -1;
        // ensure eager resolving
        parseEager(method, AllowAssumptions.YES);
        compile(method, bci);
    }

    protected enum ReturnValue {
        SUCCESS,
        FAILURE
    }

    public GraalOSRTestBase() {
        super();
    }

    public GraalOSRTestBase(Class<? extends Architecture> arch) {
        super(arch);
    }

    public GraalOSRTestBase(Backend backend) {
        super(backend);
    }

}
