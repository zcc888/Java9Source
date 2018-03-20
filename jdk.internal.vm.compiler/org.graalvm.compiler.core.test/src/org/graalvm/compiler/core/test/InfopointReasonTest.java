/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.core.test;

import static org.graalvm.compiler.core.GraalCompiler.compileGraph;
import static org.graalvm.compiler.core.common.GraalOptions.OptAssumptions;
import static org.junit.Assert.assertNotNull;
import jdk.vm.ci.code.site.Call;
import jdk.vm.ci.code.site.Infopoint;
import jdk.vm.ci.code.site.InfopointReason;
import jdk.vm.ci.meta.ResolvedJavaMethod;

import org.junit.Test;

import org.graalvm.compiler.code.CompilationResult;
import org.graalvm.compiler.lir.asm.CompilationResultBuilderFactory;
import org.graalvm.compiler.nodes.FullInfopointNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration;
import org.graalvm.compiler.phases.OptimisticOptimizations;
import org.graalvm.compiler.phases.PhaseSuite;
import org.graalvm.compiler.phases.tiers.HighTierContext;

/**
 * Test that infopoints in {@link CompilationResult}s have correctly assigned reasons.
 */
public class InfopointReasonTest extends GraalCompilerTest {

    public static final String[] STRINGS = new String[]{"world", "everyone", "you"};

    public String testMethod() {
        StringBuilder sb = new StringBuilder("Hello ");
        for (String s : STRINGS) {
            sb.append(s).append(", ");
        }
        sb.replace(sb.length() - 2, sb.length(), "!");
        return sb.toString();
    }

    @Test
    public void callInfopoints() {
        final ResolvedJavaMethod method = getResolvedJavaMethod("testMethod");
        final StructuredGraph graph = parseEager(method, AllowAssumptions.YES);
        final CompilationResult cr = compileGraph(graph, graph.method(), getProviders(), getBackend(), getDefaultGraphBuilderSuite(), OptimisticOptimizations.ALL, graph.getProfilingInfo(),
                        getSuites(), getLIRSuites(), new CompilationResult(), CompilationResultBuilderFactory.Default);
        for (Infopoint sp : cr.getInfopoints()) {
            assertNotNull(sp.reason);
            if (sp instanceof Call) {
                assertDeepEquals(InfopointReason.CALL, sp.reason);
            }
        }
    }

    @Test
    public void lineInfopoints() {
        final ResolvedJavaMethod method = getResolvedJavaMethod("testMethod");
        final StructuredGraph graph = parseDebug(method, AllowAssumptions.from(OptAssumptions.getValue()));
        int graphLineSPs = 0;
        for (FullInfopointNode ipn : graph.getNodes().filter(FullInfopointNode.class)) {
            if (ipn.getReason() == InfopointReason.BYTECODE_POSITION) {
                ++graphLineSPs;
            }
        }
        assertTrue(graphLineSPs > 0);
        PhaseSuite<HighTierContext> graphBuilderSuite = getCustomGraphBuilderSuite(GraphBuilderConfiguration.getDefault(getDefaultGraphBuilderPlugins()).withFullInfopoints(true));
        final CompilationResult cr = compileGraph(graph, graph.method(), getProviders(), getBackend(), graphBuilderSuite, OptimisticOptimizations.ALL, graph.getProfilingInfo(), getSuites(),
                        getLIRSuites(), new CompilationResult(), CompilationResultBuilderFactory.Default);
        int lineSPs = 0;
        for (Infopoint sp : cr.getInfopoints()) {
            assertNotNull(sp.reason);
            if (sp.reason == InfopointReason.BYTECODE_POSITION) {
                ++lineSPs;
            }
        }
        assertTrue(lineSPs > 0);
    }

}
