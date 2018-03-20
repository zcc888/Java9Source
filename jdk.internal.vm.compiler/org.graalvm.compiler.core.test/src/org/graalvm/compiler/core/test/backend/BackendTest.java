/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.core.test.backend;

import jdk.vm.ci.code.Architecture;

import org.graalvm.compiler.core.GraalCompiler;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.Debug.Scope;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.phases.OptimisticOptimizations;

public abstract class BackendTest extends GraalCompilerTest {

    public BackendTest() {
        super();
    }

    public BackendTest(Class<? extends Architecture> arch) {
        super(arch);
    }

    @SuppressWarnings("try")
    protected LIRGenerationResult getLIRGenerationResult(final StructuredGraph graph) {
        try (Scope s = Debug.scope("FrontEnd")) {
            GraalCompiler.emitFrontEnd(getProviders(), getBackend(), graph, getDefaultGraphBuilderSuite(), OptimisticOptimizations.NONE, graph.getProfilingInfo(), getSuites());
        } catch (Throwable e) {
            throw Debug.handle(e);
        }

        LIRGenerationResult lirGen = GraalCompiler.emitLIR(getBackend(), graph, null, null, getLIRSuites());
        return lirGen;
    }

}
