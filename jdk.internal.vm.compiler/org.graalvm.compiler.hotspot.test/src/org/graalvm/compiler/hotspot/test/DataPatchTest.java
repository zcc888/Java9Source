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

package org.graalvm.compiler.hotspot.test;

import org.junit.Assume;
import org.junit.Test;

import org.graalvm.compiler.hotspot.CompressEncoding;
import org.graalvm.compiler.hotspot.nodes.CompressionNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.debug.OpaqueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins.Registration;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ResolvedJavaMethod;

public class DataPatchTest extends HotSpotGraalCompilerTest {

    public static double doubleSnippet() {
        return 84.72;
    }

    @Test
    public void doubleTest() {
        test("doubleSnippet");
    }

    public static Object oopSnippet() {
        return "asdf";
    }

    @Test
    public void oopTest() {
        test("oopSnippet");
    }

    private static Object compressUncompress(Object obj) {
        return obj;
    }

    public static Object narrowOopSnippet() {
        return compressUncompress("narrowAsdf");
    }

    @Test
    public void narrowOopTest() {
        Assume.assumeTrue("skipping narrow oop data patch test", runtime().getVMConfig().useCompressedOops);
        test("narrowOopSnippet");
    }

    @Override
    protected GraphBuilderConfiguration editGraphBuilderConfiguration(GraphBuilderConfiguration conf) {
        InvocationPlugins invocationPlugins = conf.getPlugins().getInvocationPlugins();
        Registration r = new Registration(invocationPlugins, DataPatchTest.class);
        r.register1("compressUncompress", Object.class, new InvocationPlugin() {
            @Override
            public boolean apply(GraphBuilderContext b, ResolvedJavaMethod targetMethod, Receiver receiver, ValueNode arg) {
                CompressEncoding encoding = runtime().getVMConfig().getOopEncoding();
                ValueNode compressed = b.add(CompressionNode.compress(arg, encoding));
                ValueNode proxy = b.add(new OpaqueNode(compressed));
                b.addPush(JavaKind.Object, CompressionNode.uncompress(proxy, encoding));
                return true;
            }
        });
        return super.editGraphBuilderConfiguration(conf);
    }
}
