/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.calc.Condition;
import org.graalvm.compiler.core.common.type.FloatStamp;
import org.graalvm.compiler.core.common.type.IntegerStamp;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeCycles;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.LogicConstantNode;
import org.graalvm.compiler.nodes.LogicNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.util.GraphUtil;

import jdk.vm.ci.meta.ConstantReflectionProvider;
import jdk.vm.ci.meta.TriState;

@NodeInfo(shortName = "<", cycles = NodeCycles.CYCLES_3)
public final class FloatLessThanNode extends CompareNode {
    public static final NodeClass<FloatLessThanNode> TYPE = NodeClass.create(FloatLessThanNode.class);

    public FloatLessThanNode(ValueNode x, ValueNode y, boolean unorderedIsTrue) {
        super(TYPE, Condition.LT, unorderedIsTrue, x, y);
        assert x.stamp() instanceof FloatStamp && y.stamp() instanceof FloatStamp;
        assert x.stamp().isCompatible(y.stamp());
    }

    public static LogicNode create(ValueNode x, ValueNode y, boolean unorderedIsTrue, ConstantReflectionProvider constantReflection) {
        LogicNode result = CompareNode.tryConstantFold(Condition.LT, x, y, constantReflection, unorderedIsTrue);
        if (result != null) {
            return result;
        } else {
            return new FloatLessThanNode(x, y, unorderedIsTrue);
        }
    }

    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forX, ValueNode forY) {
        ValueNode result = super.canonical(tool, forX, forY);
        if (result != this) {
            return result;
        }
        if (GraphUtil.unproxify(forX) == GraphUtil.unproxify(forY) && !unorderedIsTrue()) {
            return LogicConstantNode.contradiction();
        }
        return this;
    }

    @Override
    protected CompareNode duplicateModified(ValueNode newX, ValueNode newY) {
        if (newX.stamp() instanceof FloatStamp && newY.stamp() instanceof FloatStamp) {
            return new FloatLessThanNode(newX, newY, unorderedIsTrue);
        } else if (newX.stamp() instanceof IntegerStamp && newY.stamp() instanceof IntegerStamp) {
            return new IntegerLessThanNode(newX, newY);
        }
        throw GraalError.shouldNotReachHere();
    }

    @Override
    public Stamp getSucceedingStampForX(boolean negated) {
        return null;
    }

    @Override
    public Stamp getSucceedingStampForY(boolean negated) {
        return null;
    }

    @Override
    public TriState tryFold(Stamp xStampGeneric, Stamp yStampGeneric) {
        return TriState.UNKNOWN;
    }
}
