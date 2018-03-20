/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.jtt;

import static java.lang.reflect.Modifier.isStatic;

import java.util.Collections;
import java.util.Set;

import jdk.vm.ci.code.InstalledCode;
import jdk.vm.ci.meta.DeoptimizationReason;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaType;
import jdk.vm.ci.meta.ResolvedJavaMethod;

import org.junit.Assert;

import org.graalvm.compiler.core.common.CompilationIdentifier;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.ParameterNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;

/**
 * Base class for the JTT tests.
 * <p>
 * These tests are executed twice: once with arguments passed to the execution and once with the
 * arguments bound to the test's parameters during compilation. The latter is a good test of
 * canonicalization.
 */
public class JTTTest extends GraalCompilerTest {

    public static final class DummyTestClass {
    }

    protected static final Set<DeoptimizationReason> EMPTY = Collections.<DeoptimizationReason> emptySet();
    /**
     * The arguments which, if non-null, will replace the Locals in the test method's graph.
     */
    Object[] argsToBind;

    public JTTTest() {
        Assert.assertNotNull(getCodeCache());
    }

    @Override
    protected StructuredGraph parseEager(ResolvedJavaMethod m, AllowAssumptions allowAssumptions, CompilationIdentifier compilationId) {
        StructuredGraph graph = super.parseEager(m, allowAssumptions, compilationId);
        if (argsToBind != null) {
            Object receiver = isStatic(m.getModifiers()) ? null : this;
            Object[] args = argsWithReceiver(receiver, argsToBind);
            JavaType[] parameterTypes = m.toParameterTypes();
            assert parameterTypes.length == args.length;
            for (ParameterNode param : graph.getNodes(ParameterNode.TYPE)) {
                JavaConstant c = getSnippetReflection().forBoxed(parameterTypes[param.index()].getJavaKind(), args[param.index()]);
                ConstantNode replacement = ConstantNode.forConstant(c, getMetaAccess(), graph);
                param.replaceAtUsages(replacement);
            }
        }
        return graph;
    }

    @Override
    protected InstalledCode getCode(ResolvedJavaMethod method, StructuredGraph graph) {
        return super.getCode(method, graph, argsToBind != null);
    }

    Double delta;

    @Override
    protected void assertDeepEquals(Object expected, Object actual) {
        if (delta != null) {
            Assert.assertEquals(((Number) expected).doubleValue(), ((Number) actual).doubleValue(), delta);
        } else {
            super.assertDeepEquals(expected, actual);
        }
    }

    @SuppressWarnings("hiding")
    protected void runTestWithDelta(double delta, String name, Object... args) {
        this.delta = Double.valueOf(delta);
        runTest(name, args);
    }

    protected void runTest(String name, Object... args) {
        runTest(EMPTY, name, args);
    }

    protected void runTest(Set<DeoptimizationReason> shouldNotDeopt, String name, Object... args) {
        runTest(shouldNotDeopt, true, false, name, args);
    }

    protected void runTest(Set<DeoptimizationReason> shouldNotDeopt, boolean bind, boolean noProfile, String name, Object... args) {
        ResolvedJavaMethod method = getResolvedJavaMethod(name);
        Object receiver = method.isStatic() ? null : this;

        Result expect = executeExpected(method, receiver, args);

        if (noProfile) {
            method.reprofile();
        }

        testAgainstExpected(method, expect, shouldNotDeopt, receiver, args);
        if (args.length > 0 && bind) {
            if (noProfile) {
                method.reprofile();
            }

            this.argsToBind = args;
            testAgainstExpected(method, expect, shouldNotDeopt, receiver, args);
            this.argsToBind = null;
        }
    }
}
