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
package org.graalvm.compiler.nodes.calc;

import org.graalvm.compiler.core.common.type.AbstractPointerStamp;
import org.graalvm.compiler.core.common.type.ObjectStamp;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeCycles;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.LogicConstantNode;
import org.graalvm.compiler.nodes.LogicNode;
import org.graalvm.compiler.nodes.PiNode;
import org.graalvm.compiler.nodes.UnaryOpLogicNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import org.graalvm.compiler.nodes.spi.PiPushable;
import org.graalvm.compiler.nodes.spi.Virtualizable;
import org.graalvm.compiler.nodes.spi.VirtualizerTool;
import org.graalvm.compiler.nodes.type.StampTool;

import jdk.vm.ci.meta.TriState;

/**
 * An IsNullNode will be true if the supplied value is null, and false if it is non-null.
 */
@NodeInfo(cycles = NodeCycles.CYCLES_2)
public final class IsNullNode extends UnaryOpLogicNode implements LIRLowerable, Virtualizable, PiPushable {

    public static final NodeClass<IsNullNode> TYPE = NodeClass.create(IsNullNode.class);

    public IsNullNode(ValueNode object) {
        super(TYPE, object);
        assert object != null;
    }

    public static LogicNode create(ValueNode forValue) {
        LogicNode result = tryCanonicalize(forValue);
        return result == null ? new IsNullNode(forValue) : result;
    }

    public static LogicNode tryCanonicalize(ValueNode forValue) {
        if (StampTool.isPointerAlwaysNull(forValue)) {
            return LogicConstantNode.tautology();
        } else if (StampTool.isPointerNonNull(forValue)) {
            return LogicConstantNode.contradiction();
        }
        return null;
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        // Nothing to do.
    }

    @Override
    public boolean verify() {
        assertTrue(getValue() != null, "is null input must not be null");
        assertTrue(getValue().stamp() instanceof AbstractPointerStamp, "input must be a pointer not %s", getValue().stamp());
        return super.verify();
    }

    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forValue) {
        LogicNode result = tryCanonicalize(forValue);
        return result == null ? this : result;
    }

    @Override
    public void virtualize(VirtualizerTool tool) {
        ValueNode alias = tool.getAlias(getValue());
        TriState fold = tryFold(alias.stamp());
        if (fold != TriState.UNKNOWN) {
            tool.replaceWithValue(LogicConstantNode.forBoolean(fold.isTrue(), graph()));
        }
    }

    @Override
    public boolean push(PiNode parent) {
        if (parent.stamp() instanceof ObjectStamp && parent.object().stamp() instanceof ObjectStamp) {
            ObjectStamp piStamp = (ObjectStamp) parent.stamp();
            ObjectStamp piValueStamp = (ObjectStamp) parent.object().stamp();
            if (piStamp.nonNull() == piValueStamp.nonNull() && piStamp.alwaysNull() == piValueStamp.alwaysNull()) {
                replaceFirstInput(parent, parent.object());
                return true;
            }
        }
        return false;
    }

    @NodeIntrinsic
    public static native IsNullNode isNull(Object object);

    @Override
    public Stamp getSucceedingStampForValue(boolean negated) {
        return negated ? getValue().stamp().join(StampFactory.objectNonNull()) : StampFactory.alwaysNull();
    }

    @Override
    public TriState tryFold(Stamp valueStamp) {
        if (valueStamp instanceof ObjectStamp) {
            ObjectStamp objectStamp = (ObjectStamp) valueStamp;
            if (objectStamp.alwaysNull()) {
                return TriState.TRUE;
            } else if (objectStamp.nonNull()) {
                return TriState.FALSE;
            }
        }
        return TriState.UNKNOWN;
    }
}
