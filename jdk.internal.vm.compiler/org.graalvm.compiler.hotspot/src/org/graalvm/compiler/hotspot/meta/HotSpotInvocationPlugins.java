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
package org.graalvm.compiler.hotspot.meta;

import java.lang.reflect.Type;

import org.graalvm.compiler.core.common.GraalOptions;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.iterators.NodeIterable;
import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.hotspot.phases.AheadOfTimeVerificationPhase;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.FrameState;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.type.StampTool;
import org.graalvm.compiler.replacements.nodes.MacroNode;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ResolvedJavaType;

/**
 * Extension of {@link InvocationPlugins} that disables plugins based on runtime configuration.
 */
final class HotSpotInvocationPlugins extends InvocationPlugins {
    final GraalHotSpotVMConfig config;

    HotSpotInvocationPlugins(GraalHotSpotVMConfig config) {
        this.config = config;
    }

    @Override
    public void register(InvocationPlugin plugin, Type declaringClass, String name, Type... argumentTypes) {
        if (!config.usePopCountInstruction) {
            if (name.equals("bitCount")) {
                assert declaringClass.equals(Integer.class) || declaringClass.equals(Long.class);
                return;
            }
        }
        super.register(plugin, declaringClass, name, argumentTypes);
    }

    @Override
    public void checkNewNodes(GraphBuilderContext b, InvocationPlugin plugin, NodeIterable<Node> newNodes) {
        for (Node node : newNodes) {
            if (node instanceof MacroNode) {
                // MacroNode based plugins can only be used for inlining since they
                // require a valid bci should they need to replace themselves with
                // an InvokeNode during lowering.
                assert plugin.inlineOnly() : String.format("plugin that creates a %s (%s) must return true for inlineOnly(): %s", MacroNode.class.getSimpleName(), node, plugin);
            }
        }
        if (GraalOptions.ImmutableCode.getValue()) {
            for (Node node : newNodes) {
                if (node.hasUsages() && node instanceof ConstantNode) {
                    ConstantNode c = (ConstantNode) node;
                    if (c.getStackKind() == JavaKind.Object && AheadOfTimeVerificationPhase.isIllegalObjectConstant(c)) {
                        if (isClass(c)) {
                            // This will be handled later by LoadJavaMirrorWithKlassPhase
                        } else {
                            // Tolerate uses in unused FrameStates
                            if (node.usages().filter((n) -> !(n instanceof FrameState) || n.hasUsages()).isNotEmpty()) {
                                throw new AssertionError("illegal constant node in AOT: " + node);
                            }
                        }
                    }
                }
            }
        }
        super.checkNewNodes(b, plugin, newNodes);
    }

    private static boolean isClass(ConstantNode node) {
        ResolvedJavaType type = StampTool.typeOrNull(node);
        return type != null && "Ljava/lang/Class;".equals(type.getName());
    }
}
