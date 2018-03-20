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
package org.graalvm.compiler.replacements.test;

import org.junit.Test;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.api.replacements.ClassSubstitution;
import org.graalvm.compiler.api.replacements.Fold;
import org.graalvm.compiler.api.replacements.MethodSubstitution;
import org.graalvm.compiler.bytecode.BytecodeProvider;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.ReturnNode;
import org.graalvm.compiler.nodes.StartNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration.Plugins;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins.Registration;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory.InjectionProvider;
import org.graalvm.compiler.replacements.NodeIntrinsificationProvider;

public class FoldTest extends GraalCompilerTest {

    private static class TestMethod {

        public static int test() {
            return 42;
        }
    }

    static class FoldUtils {

        private int number;

        FoldUtils(int number) {
            this.number = number;
        }

        @Fold
        static int multiply(int a, int b) {
            // we want to test whether @Fold works, so prevent automatic constant folding
            return a * GraalDirectives.opaque(b);
        }

        @Fold
        int getNumber() {
            // we want to test whether @Fold works, so prevent automatic constant folding
            return GraalDirectives.opaque(number);
        }
    }

    @ClassSubstitution(TestMethod.class)
    private static class TestMethodSubstitution {

        private static final FoldUtils utils = new FoldUtils(21);

        @MethodSubstitution
        public static int test() {
            return FoldUtils.multiply(utils.getNumber(), 2);
        }
    }

    @Override
    protected GraphBuilderConfiguration editGraphBuilderConfiguration(GraphBuilderConfiguration conf) {
        InvocationPlugins invocationPlugins = conf.getPlugins().getInvocationPlugins();
        BytecodeProvider replacementBytecodeProvider = getReplacements().getReplacementBytecodeProvider();
        Registration r = new Registration(invocationPlugins, TestMethod.class, replacementBytecodeProvider);
        r.registerMethodSubstitution(TestMethodSubstitution.class, "test");
        return super.editGraphBuilderConfiguration(conf);
    }

    public static int callTest() {
        return TestMethod.test();
    }

    @Override
    protected Plugins getDefaultGraphBuilderPlugins() {
        Plugins ret = super.getDefaultGraphBuilderPlugins();
        // manually register generated factories, jvmci service providers don't work from unit tests
        InjectionProvider injection = new NodeIntrinsificationProvider(getMetaAccess(), getSnippetReflection(), getProviders().getForeignCalls(), null);
        new PluginFactory_FoldTest().registerPlugins(ret.getInvocationPlugins(), injection);
        return ret;
    }

    @Override
    protected boolean checkHighTierGraph(StructuredGraph graph) {
        // check that folding happened correctly
        StartNode start = graph.start();
        assert start.next() instanceof ReturnNode : "expected ReturnNode, got " + start.next();

        ReturnNode ret = (ReturnNode) start.next();
        assert ret.result().isConstant() : "expected ConstantNode, got " + ret.result();
        return true;
    }

    @Test
    public void snippetTest() {
        test("callTest");
    }
}
