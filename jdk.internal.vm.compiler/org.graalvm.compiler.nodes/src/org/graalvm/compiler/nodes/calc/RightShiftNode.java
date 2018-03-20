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

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable.ShiftOp.Shr;
import org.graalvm.compiler.core.common.type.IntegerStamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.lir.gen.ArithmeticLIRGeneratorTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

import jdk.vm.ci.code.CodeUtil;

@NodeInfo(shortName = ">>")
public final class RightShiftNode extends ShiftNode<Shr> {

    public static final NodeClass<RightShiftNode> TYPE = NodeClass.create(RightShiftNode.class);

    public RightShiftNode(ValueNode x, ValueNode y) {
        super(TYPE, ArithmeticOpTable::getShr, x, y);
    }

    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forX, ValueNode forY) {
        ValueNode ret = super.canonical(tool, forX, forY);
        if (ret != this) {
            return ret;
        }

        if (forX.stamp() instanceof IntegerStamp && ((IntegerStamp) forX.stamp()).isPositive()) {
            return new UnsignedRightShiftNode(forX, forY);
        }

        if (forY.isConstant()) {
            int amount = forY.asJavaConstant().asInt();
            int originalAmout = amount;
            int mask = getShiftAmountMask();
            amount &= mask;
            if (amount == 0) {
                return forX;
            }
            if (forX instanceof ShiftNode) {
                ShiftNode<?> other = (ShiftNode<?>) forX;
                if (other.getY().isConstant()) {
                    int otherAmount = other.getY().asJavaConstant().asInt() & mask;
                    if (other instanceof RightShiftNode) {
                        int total = amount + otherAmount;
                        if (total != (total & mask)) {
                            assert other.getX().stamp() instanceof IntegerStamp;
                            IntegerStamp istamp = (IntegerStamp) other.getX().stamp();

                            if (istamp.isPositive()) {
                                return ConstantNode.forIntegerKind(getStackKind(), 0);
                            }
                            if (istamp.isStrictlyNegative()) {
                                return ConstantNode.forIntegerKind(getStackKind(), -1L);
                            }

                            /*
                             * if we cannot replace both shifts with a constant, replace them by a
                             * full shift for this kind
                             */
                            assert total >= mask;
                            return new RightShiftNode(other.getX(), ConstantNode.forInt(mask));
                        }
                        return new RightShiftNode(other.getX(), ConstantNode.forInt(total));
                    }
                }
            }
            if (originalAmout != amount) {
                return new RightShiftNode(forX, ConstantNode.forInt(amount));
            }
        }
        return this;
    }

    @Override
    public void generate(NodeLIRBuilderTool nodeValueMap, ArithmeticLIRGeneratorTool gen) {
        nodeValueMap.setResult(this, gen.emitShr(nodeValueMap.operand(getX()), nodeValueMap.operand(getY())));
    }

    @Override
    public boolean isNarrowable(int resultBits) {
        if (super.isNarrowable(resultBits)) {
            /*
             * For signed right shifts, the narrow can be done before the shift if the cut off bits
             * are all equal to the sign bit of the input. That's equivalent to the condition that
             * the input is in the signed range of the narrow type.
             */
            IntegerStamp inputStamp = (IntegerStamp) getX().stamp();
            return CodeUtil.minValue(resultBits) <= inputStamp.lowerBound() && inputStamp.upperBound() <= CodeUtil.maxValue(resultBits);
        } else {
            return false;
        }
    }
}
