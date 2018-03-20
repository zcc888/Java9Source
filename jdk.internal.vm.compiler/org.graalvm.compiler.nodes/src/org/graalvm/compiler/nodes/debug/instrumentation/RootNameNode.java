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
package org.graalvm.compiler.nodes.debug.instrumentation;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_IGNORED;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_IGNORED;

import org.graalvm.compiler.core.common.LocationIdentity;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.NamedLocationIdentity;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.debug.StringToBytesNode;
import org.graalvm.compiler.nodes.memory.MemoryCheckpoint;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * The {@code RootNameNode} represents the name of the compilation root.
 */
@NodeInfo(cycles = CYCLES_IGNORED, size = SIZE_IGNORED)
public final class RootNameNode extends FixedWithNextNode implements Lowerable, InstrumentationInliningCallback, MemoryCheckpoint.Single {

    public static final NodeClass<RootNameNode> TYPE = NodeClass.create(RootNameNode.class);

    public RootNameNode(Stamp stamp) {
        super(TYPE, stamp);
    }

    /**
     * resolve this node and replace with a {@link StringToBytesNode} that constructs the root
     * method name in the compiled code. To ensure the correct result, this method should be invoked
     * after inlining.
     */
    private void resolve(StructuredGraph graph) {
        ResolvedJavaMethod method = graph.method();
        String rootName = method == null ? "<unresolved method>" : (method.getDeclaringClass().toJavaName() + "." + method.getName() + method.getSignature().toMethodDescriptor());
        StringToBytesNode stringToByteNode = graph().add(new StringToBytesNode(rootName, stamp()));
        graph().replaceFixedWithFixed(this, stringToByteNode);
    }

    @Override
    public void lower(LoweringTool tool) {
        resolve(graph());
    }

    @Override
    public void preInlineInstrumentation(InstrumentationNode instrumentation) {
        // resolve to the method name of the original graph
        resolve(instrumentation.graph());
    }

    @Override
    public void postInlineInstrumentation(InstrumentationNode instrumentation) {
    }

    @Override
    public LocationIdentity getLocationIdentity() {
        return NamedLocationIdentity.getArrayLocation(JavaKind.Byte);
    }

}
