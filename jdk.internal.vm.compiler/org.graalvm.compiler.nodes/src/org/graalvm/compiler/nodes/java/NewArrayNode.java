/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes.java;

import java.util.Collections;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.core.common.type.TypeReference;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.FrameState;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.VirtualizableAllocation;
import org.graalvm.compiler.nodes.spi.VirtualizerTool;
import org.graalvm.compiler.nodes.virtual.VirtualArrayNode;
import org.graalvm.compiler.nodes.virtual.VirtualObjectNode;

import jdk.vm.ci.meta.ResolvedJavaType;

/**
 * The {@code NewArrayNode} is used for all array allocations where the element type is know at
 * compile time.
 */
// JaCoCo Exclude
@NodeInfo
public class NewArrayNode extends AbstractNewArrayNode implements VirtualizableAllocation {

    public static final NodeClass<NewArrayNode> TYPE = NodeClass.create(NewArrayNode.class);
    private final ResolvedJavaType elementType;

    public NewArrayNode(ResolvedJavaType elementType, ValueNode length, boolean fillContents) {
        this(elementType, length, fillContents, null);
    }

    public NewArrayNode(ResolvedJavaType elementType, ValueNode length, boolean fillContents, FrameState stateBefore) {
        this(TYPE, elementType, length, fillContents, stateBefore);
    }

    protected NewArrayNode(NodeClass<? extends NewArrayNode> c, ResolvedJavaType elementType, ValueNode length, boolean fillContents, FrameState stateBefore) {
        super(c, StampFactory.objectNonNull(TypeReference.createExactTrusted(elementType.getArrayClass())), length, fillContents, stateBefore);
        this.elementType = elementType;
    }

    @NodeIntrinsic
    private static native Object newArray(@ConstantNodeParameter Class<?> elementType, int length, @ConstantNodeParameter boolean fillContents);

    public static Object newUninitializedArray(Class<?> elementType, int length) {
        return newArray(elementType, length, false);
    }

    /**
     * Gets the element type of the array.
     *
     * @return the element type of the array
     */
    public ResolvedJavaType elementType() {
        return elementType;
    }

    @Override
    public void virtualize(VirtualizerTool tool) {
        ValueNode lengthAlias = tool.getAlias(length());
        if (lengthAlias.asConstant() != null) {
            int constantLength = lengthAlias.asJavaConstant().asInt();
            if (constantLength >= 0 && constantLength < tool.getMaximumEntryCount()) {
                ValueNode[] state = new ValueNode[constantLength];
                ConstantNode defaultForKind = constantLength == 0 ? null : defaultElementValue();
                for (int i = 0; i < constantLength; i++) {
                    state[i] = defaultForKind;
                }
                VirtualObjectNode virtualObject = createVirtualArrayNode(constantLength);
                tool.createVirtualObject(virtualObject, state, Collections.<MonitorIdNode> emptyList(), false);
                tool.replaceWithVirtual(virtualObject);
            }
        }
    }

    protected VirtualArrayNode createVirtualArrayNode(int constantLength) {
        return new VirtualArrayNode(elementType(), constantLength);
    }

    /* Factored out in a separate method so that subclasses can override it. */
    protected ConstantNode defaultElementValue() {
        return ConstantNode.defaultForKind(elementType().getJavaKind(), graph());
    }
}
