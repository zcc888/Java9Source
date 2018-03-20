/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
import static org.graalvm.compiler.debug.DelegatingDebugConfig.Feature.INTERCEPT;

import java.lang.reflect.Method;

import jdk.vm.ci.meta.MetaAccessProvider;
import jdk.vm.ci.meta.ResolvedJavaMethod;

import org.junit.Assume;
import org.junit.Test;

import org.graalvm.compiler.api.test.Graal;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.DebugConfigScope;
import org.graalvm.compiler.debug.DelegatingDebugConfig;
import org.graalvm.compiler.java.GraphBuilderPhase;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration.Plugins;
import org.graalvm.compiler.phases.OptimisticOptimizations;
import org.graalvm.compiler.phases.PhaseSuite;
import org.graalvm.compiler.phases.VerifyPhase;
import org.graalvm.compiler.phases.tiers.HighTierContext;
import org.graalvm.compiler.phases.util.Providers;
import org.graalvm.compiler.runtime.RuntimeProvider;
import org.graalvm.compiler.test.GraalTest;

/**
 * Test that interfaces are correctly initialized by a static field resolution during eager graph
 * building.
 */
public class StaticInterfaceFieldTest extends GraalTest {

    private interface I {
        Object CONST = new Object() {
        };

    }

    private static final class C implements I {
        @SuppressWarnings({"static-method", "unused"})
        public Object test() {
            return CONST;
        }
    }

    @Test
    public void test() {
        eagerlyParseMethod(C.class, "test");

    }

    @SuppressWarnings("try")
    private void eagerlyParseMethod(Class<C> clazz, String methodName) {
        RuntimeProvider rt = Graal.getRequiredCapability(RuntimeProvider.class);
        Providers providers = rt.getHostBackend().getProviders();
        MetaAccessProvider metaAccess = providers.getMetaAccess();

        PhaseSuite<HighTierContext> graphBuilderSuite = new PhaseSuite<>();
        Plugins plugins = new Plugins(new InvocationPlugins());
        GraphBuilderConfiguration config = GraphBuilderConfiguration.getDefault(plugins).withEagerResolving(true);
        graphBuilderSuite.appendPhase(new GraphBuilderPhase(config));
        HighTierContext context = new HighTierContext(providers, graphBuilderSuite, OptimisticOptimizations.NONE);

        Assume.assumeTrue(VerifyPhase.class.desiredAssertionStatus());

        final Method m = getMethod(clazz, methodName);
        ResolvedJavaMethod method = metaAccess.lookupJavaMethod(m);
        StructuredGraph graph = new StructuredGraph(method, AllowAssumptions.NO, INVALID_COMPILATION_ID);
        try (DebugConfigScope s = Debug.setConfig(new DelegatingDebugConfig().disable(INTERCEPT)); Debug.Scope ds = Debug.scope("GraphBuilding", graph, method)) {
            graphBuilderSuite.apply(graph, context);
        } catch (Throwable e) {
            throw Debug.handle(e);
        }
    }
}
