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

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FrameState;
import org.graalvm.compiler.nodes.StateSplit;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.Virtualizable;
import org.graalvm.compiler.nodes.spi.VirtualizerTool;
import org.graalvm.compiler.nodes.virtual.VirtualInstanceNode;
import org.graalvm.compiler.nodes.virtual.VirtualObjectNode;

import jdk.vm.ci.meta.ResolvedJavaField;

/**
 * The {@code StoreFieldNode} represents a write to a static or instance field.
 */
@NodeInfo(nameTemplate = "StoreField#{p#field/s}")
public final class StoreFieldNode extends AccessFieldNode implements StateSplit, Virtualizable {
    public static final NodeClass<StoreFieldNode> TYPE = NodeClass.create(StoreFieldNode.class);

    @Input ValueNode value;
    @OptionalInput(InputType.State) FrameState stateAfter;

    @Override
    public FrameState stateAfter() {
        return stateAfter;
    }

    @Override
    public void setStateAfter(FrameState x) {
        assert x == null || x.isAlive() : "frame state must be in a graph";
        updateUsages(stateAfter, x);
        stateAfter = x;
    }

    @Override
    public boolean hasSideEffect() {
        return true;
    }

    public ValueNode value() {
        return value;
    }

    public StoreFieldNode(ValueNode object, ResolvedJavaField field, ValueNode value) {
        super(TYPE, StampFactory.forVoid(), object, field);
        this.value = value;
    }

    public StoreFieldNode(ValueNode object, ResolvedJavaField field, ValueNode value, FrameState stateAfter) {
        super(TYPE, StampFactory.forVoid(), object, field);
        this.value = value;
        this.stateAfter = stateAfter;
    }

    @Override
    public void virtualize(VirtualizerTool tool) {
        ValueNode alias = tool.getAlias(object());
        if (alias instanceof VirtualObjectNode) {
            VirtualInstanceNode virtual = (VirtualInstanceNode) alias;
            int fieldIndex = virtual.fieldIndex(field());
            if (fieldIndex != -1) {
                tool.setVirtualEntry(virtual, fieldIndex, value(), false);
                tool.delete();
            }
        }
    }

    public FrameState getState() {
        return stateAfter;
    }
}
