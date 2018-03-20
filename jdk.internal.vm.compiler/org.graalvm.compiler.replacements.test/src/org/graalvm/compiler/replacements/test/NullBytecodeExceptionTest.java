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

import org.junit.Test;

import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public class NullBytecodeExceptionTest extends BytecodeExceptionTest {

    private static class Exceptions {

        private static Object obj = null;

        public static void throwNull() {
            obj.toString();
        }
    }

    @Override
    protected void registerPlugin(InvocationPlugins plugins) {
        plugins.register(new InvocationPlugin() {
            @Override
            public boolean apply(GraphBuilderContext b, ResolvedJavaMethod targetMethod, Receiver receiver) {
                return throwBytecodeException(b, NullPointerException.class);
            }
        }, Exceptions.class, "throwNull");
    }

    public static void nullSnippet() {
        Exceptions.throwNull();
    }

    @Test
    public void testNullPointerException() {
        test("nullSnippet");
    }
}
