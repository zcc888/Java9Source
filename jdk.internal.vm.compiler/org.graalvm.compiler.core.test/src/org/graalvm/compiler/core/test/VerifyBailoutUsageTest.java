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
package org.graalvm.compiler.core.test;

import static org.graalvm.compiler.core.common.CompilationIdentifier.INVALID_COMPILATION_ID;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import org.graalvm.compiler.api.test.Graal;
import org.graalvm.compiler.common.PermanentBailoutException;
import org.graalvm.compiler.common.RetryableBailoutException;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.DebugConfigScope;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.java.GraphBuilderPhase;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration.Plugins;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.phases.OptimisticOptimizations;
import org.graalvm.compiler.phases.Phase;
import org.graalvm.compiler.phases.PhaseSuite;
import org.graalvm.compiler.phases.VerifyPhase.VerificationError;
import org.graalvm.compiler.phases.tiers.HighTierContext;
import org.graalvm.compiler.phases.util.Providers;
import org.graalvm.compiler.phases.verify.VerifyBailoutUsage;
import org.graalvm.compiler.runtime.RuntimeProvider;

import jdk.vm.ci.code.BailoutException;
import jdk.vm.ci.meta.MetaAccessProvider;
import jdk.vm.ci.meta.ResolvedJavaMethod;

public class VerifyBailoutUsageTest {

    private static class InvalidBailoutUsagePhase1 extends Phase {
        @Override
        protected void run(StructuredGraph graph) {
            throw new BailoutException("Bailout in graph %s", graph);
        }
    }

    private static class InvalidBailoutUsagePhase2 extends Phase {
        @Override
        protected void run(StructuredGraph graph) {
            throw new BailoutException(new GraalError("other cause"), "Bailout in graph %s", graph);
        }
    }

    private static class InvalidBailoutUsagePhase3 extends Phase {
        @Override
        protected void run(StructuredGraph graph) {
            throw new BailoutException(true/* permanent */, "Bailout in graph %s", graph);
        }
    }

    private static class ValidPermanentBailoutUsage extends Phase {
        @Override
        protected void run(StructuredGraph graph) {
            throw new PermanentBailoutException("Valid permanent bailout %s", graph);
        }
    }

    private static class ValidRetryableBailoutUsage extends Phase {
        @Override
        protected void run(StructuredGraph graph) {
            throw new RetryableBailoutException("Valid retryable bailout %s", graph);
        }
    }

    @Test(expected = VerificationError.class)
    public void testInvalidBailout01() {
        testBailoutUsage(InvalidBailoutUsagePhase1.class);
    }

    @Test(expected = VerificationError.class)
    public void testInvalidBailout02() {
        testBailoutUsage(InvalidBailoutUsagePhase2.class);
    }

    @Test(expected = VerificationError.class)
    public void testInvalidBailout03() {
        testBailoutUsage(InvalidBailoutUsagePhase3.class);
    }

    @Test
    public void testValidPermanentBailout() {
        testBailoutUsage(ValidPermanentBailoutUsage.class);
    }

    @Test
    public void testValidRetryableBailout() {
        testBailoutUsage(ValidRetryableBailoutUsage.class);
    }

    @SuppressWarnings("try")
    private static void testBailoutUsage(Class<?> c) {
        RuntimeProvider rt = Graal.getRequiredCapability(RuntimeProvider.class);
        Providers providers = rt.getHostBackend().getProviders();
        MetaAccessProvider metaAccess = providers.getMetaAccess();
        PhaseSuite<HighTierContext> graphBuilderSuite = new PhaseSuite<>();
        Plugins plugins = new Plugins(new InvocationPlugins());
        GraphBuilderConfiguration config = GraphBuilderConfiguration.getDefault(plugins).withEagerResolving(true);
        graphBuilderSuite.appendPhase(new GraphBuilderPhase(config));
        HighTierContext context = new HighTierContext(providers, graphBuilderSuite, OptimisticOptimizations.NONE);
        for (Method m : c.getDeclaredMethods()) {
            if (!Modifier.isNative(m.getModifiers()) && !Modifier.isAbstract(m.getModifiers())) {
                ResolvedJavaMethod method = metaAccess.lookupJavaMethod(m);
                StructuredGraph graph = new StructuredGraph(method, AllowAssumptions.NO, INVALID_COMPILATION_ID);
                graphBuilderSuite.apply(graph, context);
                try (DebugConfigScope s = Debug.disableIntercept()) {
                    new VerifyBailoutUsage().apply(graph, context);
                }
            }
        }
    }
}
