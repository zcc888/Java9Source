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
package org.graalvm.compiler.replacements.test;

import static org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration.BytecodeExceptionMode.CheckAll;

import org.junit.Assert;
import org.junit.Test;

import org.graalvm.compiler.core.common.CompilationIdentifier;
import org.graalvm.compiler.core.phases.HighTier;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.extended.BytecodeExceptionNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.InlineInvokePlugin.InlineInfo;
import org.graalvm.compiler.options.OptionValue;
import org.graalvm.compiler.options.OptionValue.OverrideScope;
import org.graalvm.compiler.phases.tiers.Suites;

import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Tests compilation of a hot exception handler.
 */
public class CompiledNullPointerExceptionTest extends GraalCompilerTest {

    @Override
    @SuppressWarnings("try")
    protected Suites createSuites() {
        try (OverrideScope scope = OptionValue.override(HighTier.Options.Inline, false)) {
            return super.createSuites();
        }
    }

    @Override
    protected InlineInfo bytecodeParserShouldInlineInvoke(GraphBuilderContext b, ResolvedJavaMethod method, ValueNode[] args) {
        return InlineInfo.DO_NOT_INLINE_NO_EXCEPTION;
    }

    @Override
    protected GraphBuilderConfiguration editGraphBuilderConfiguration(GraphBuilderConfiguration conf) {
        return super.editGraphBuilderConfiguration(conf).withBytecodeExceptionMode(CheckAll);
    }

    @Override
    protected StructuredGraph parseEager(ResolvedJavaMethod m, AllowAssumptions allowAssumptions, CompilationIdentifier compilationId) {
        StructuredGraph graph = super.parseEager(m, allowAssumptions, compilationId);
        int handlers = graph.getNodes().filter(BytecodeExceptionNode.class).count();
        Assert.assertEquals(1, handlers);
        return graph;
    }

    private class TestClass {

        @Override
        public String toString() {
            return "TestClass";
        }
    }

    @Test
    public void test() {
        test("testSnippet", (TestClass) null, "object2");
        test("testSnippet", new TestClass(), "object2");
    }

    public static String testSnippet(TestClass o, Object o2) {
        try {
            return o.toString();
        } catch (NullPointerException e) {
            return String.valueOf(o2);
        }
    }
}
