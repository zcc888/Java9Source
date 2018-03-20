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
package org.graalvm.compiler.replacements.aarch64;

import org.graalvm.compiler.bytecode.BytecodeProvider;
import org.graalvm.compiler.core.common.spi.ForeignCallsProvider;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration.Plugins;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins.Registration;
import org.graalvm.compiler.replacements.nodes.BitScanForwardNode;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ResolvedJavaMethod;

public class AArch64GraphBuilderPlugins {

    public static void register(Plugins plugins, ForeignCallsProvider foreignCalls, BytecodeProvider bytecodeProvider) {
        InvocationPlugins invocationPlugins = plugins.getInvocationPlugins();
        invocationPlugins.defer(new Runnable() {
            @Override
            public void run() {
                registerIntegerLongPlugins(invocationPlugins, AArch64IntegerSubstitutions.class, JavaKind.Int, bytecodeProvider);
                registerIntegerLongPlugins(invocationPlugins, AArch64LongSubstitutions.class, JavaKind.Long, bytecodeProvider);
                registerMathPlugins(invocationPlugins, foreignCalls);
            }
        });
    }

    private static void registerIntegerLongPlugins(InvocationPlugins plugins, Class<?> substituteDeclaringClass, JavaKind kind, BytecodeProvider bytecodeProvider) {
        Class<?> declaringClass = kind.toBoxedJavaClass();
        Class<?> type = kind.toJavaClass();
        Registration r = new Registration(plugins, declaringClass, bytecodeProvider);
        r.register1("numberOfLeadingZeros", type, new InvocationPlugin() {
            @Override
            public boolean apply(GraphBuilderContext b, ResolvedJavaMethod targetMethod, Receiver receiver, ValueNode value) {
                ValueNode folded = AArch64CountLeadingZerosNode.tryFold(value);
                if (folded != null) {
                    b.addPush(JavaKind.Int, folded);
                } else {
                    b.addPush(JavaKind.Int, new AArch64CountLeadingZerosNode(value));
                }
                return true;
            }
        });
        r.register1("numberOfTrailingZeros", type, new InvocationPlugin() {
            @Override
            public boolean apply(GraphBuilderContext b, ResolvedJavaMethod targetMethod, Receiver receiver, ValueNode value) {
                ValueNode folded = BitScanForwardNode.tryFold(value);
                if (folded != null) {
                    b.addPush(JavaKind.Int, folded);
                } else {
                    b.addPush(JavaKind.Int, new BitScanForwardNode(value));
                }
                return true;
            }
        });
        r.registerMethodSubstitution(substituteDeclaringClass, "bitCount", type);
    }

    @SuppressWarnings("unused")
    private static void registerMathPlugins(InvocationPlugins plugins, ForeignCallsProvider foreignCalls) {
        // Registration r = new Registration(plugins, Math.class);
        // r.register1("sin", Double.TYPE, new ForeignCallPlugin(foreignCalls, ARITHMETIC_SIN));
        // r.register1("cos", Double.TYPE, new ForeignCallPlugin(foreignCalls, ARITHMETIC_COS));
        // r.register1("tan", Double.TYPE, new ForeignCallPlugin(foreignCalls, ARITHMETIC_TAN));
        // r.register1("exp", Double.TYPE, new ForeignCallPlugin(foreignCalls, ARITHMETIC_EXP));
        // r.register1("log", Double.TYPE, new ForeignCallPlugin(foreignCalls, ARITHMETIC_LOG));
        // r.register1("log10", Double.TYPE, new ForeignCallPlugin(foreignCalls, ARITHMETIC_LOG10));
        // r.register2("pow", Double.TYPE, Double.TYPE, new ForeignCallPlugin(foreignCalls,
        // ARITHMETIC_POW));
    }
}
