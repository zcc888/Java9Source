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
package org.graalvm.compiler.loop;

import static org.graalvm.compiler.loop.MathUtil.add;
import static org.graalvm.compiler.loop.MathUtil.mul;
import static org.graalvm.compiler.loop.MathUtil.sub;

import org.graalvm.compiler.core.common.type.IntegerStamp;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.ValuePhiNode;
import org.graalvm.compiler.nodes.calc.AddNode;
import org.graalvm.compiler.nodes.calc.BinaryArithmeticNode;
import org.graalvm.compiler.nodes.calc.IntegerConvertNode;
import org.graalvm.compiler.nodes.calc.NegateNode;
import org.graalvm.compiler.nodes.calc.SubNode;

public class BasicInductionVariable extends InductionVariable {

    private final ValuePhiNode phi;
    private final ValueNode init;
    private final ValueNode rawStride;
    private final BinaryArithmeticNode<?> op;

    public BasicInductionVariable(LoopEx loop, ValuePhiNode phi, ValueNode init, ValueNode rawStride, BinaryArithmeticNode<?> op) {
        super(loop);
        this.phi = phi;
        this.init = init;
        this.rawStride = rawStride;
        this.op = op;
    }

    @Override
    public StructuredGraph graph() {
        return phi.graph();
    }

    public BinaryArithmeticNode<?> getOp() {
        return op;
    }

    @Override
    public Direction direction() {
        Stamp stamp = rawStride.stamp();
        if (stamp instanceof IntegerStamp) {
            IntegerStamp integerStamp = (IntegerStamp) stamp;
            Direction dir = null;
            if (integerStamp.isStrictlyPositive()) {
                dir = Direction.Up;
            } else if (integerStamp.isStrictlyNegative()) {
                dir = Direction.Down;
            }
            if (dir != null) {
                if (op instanceof AddNode) {
                    return dir;
                } else {
                    assert op instanceof SubNode;
                    return dir.opposite();
                }
            }
        }
        return null;
    }

    @Override
    public ValuePhiNode valueNode() {
        return phi;
    }

    @Override
    public ValueNode initNode() {
        return init;
    }

    @Override
    public ValueNode strideNode() {
        if (op instanceof AddNode) {
            return rawStride;
        }
        if (op instanceof SubNode) {
            return graph().unique(new NegateNode(rawStride));
        }
        throw GraalError.shouldNotReachHere();
    }

    @Override
    public boolean isConstantInit() {
        return init.isConstant();
    }

    @Override
    public boolean isConstantStride() {
        return rawStride.isConstant();
    }

    @Override
    public long constantInit() {
        return init.asJavaConstant().asLong();
    }

    @Override
    public long constantStride() {
        if (op instanceof AddNode) {
            return rawStride.asJavaConstant().asLong();
        }
        if (op instanceof SubNode) {
            return -rawStride.asJavaConstant().asLong();
        }
        throw GraalError.shouldNotReachHere();
    }

    @Override
    public ValueNode extremumNode(boolean assumePositiveTripCount, Stamp stamp) {
        Stamp fromStamp = phi.stamp();
        StructuredGraph graph = graph();
        ValueNode stride = strideNode();
        ValueNode initNode = this.initNode();
        if (!fromStamp.isCompatible(stamp)) {
            stride = IntegerConvertNode.convert(stride, stamp, graph());
            initNode = IntegerConvertNode.convert(initNode, stamp, graph());
        }
        ValueNode maxTripCount = loop.counted().maxTripCountNode(assumePositiveTripCount);
        if (!maxTripCount.stamp().isCompatible(stamp)) {
            maxTripCount = IntegerConvertNode.convert(maxTripCount, stamp, graph());
        }
        return add(graph, mul(graph, stride, sub(graph, maxTripCount, ConstantNode.forIntegerStamp(stamp, 1, graph))), initNode);
    }

    @Override
    public ValueNode exitValueNode() {
        Stamp stamp = phi.stamp();
        ValueNode maxTripCount = loop.counted().maxTripCountNode(false);
        if (!maxTripCount.stamp().isCompatible(stamp)) {
            maxTripCount = IntegerConvertNode.convert(maxTripCount, stamp, graph());
        }
        return add(graph(), mul(graph(), strideNode(), maxTripCount), initNode());
    }

    @Override
    public boolean isConstantExtremum() {
        return isConstantInit() && isConstantStride() && loop.counted().isConstantMaxTripCount();
    }

    @Override
    public long constantExtremum() {
        return constantStride() * (loop.counted().constantMaxTripCount() - 1) + constantInit();
    }

    @Override
    public void deleteUnusedNodes() {
    }

    @Override
    public String toString() {
        return String.format("BasicInductionVariable %s %s %s %s", initNode(), phi, op.getNodeClass().shortName(), strideNode());
    }
}
