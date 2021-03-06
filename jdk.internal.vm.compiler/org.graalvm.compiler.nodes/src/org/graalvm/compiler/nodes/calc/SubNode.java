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
import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.Sub;
import org.graalvm.compiler.core.common.type.IntegerStamp;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.lir.gen.ArithmeticLIRGeneratorTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import org.graalvm.compiler.nodes.util.GraphUtil;

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.PrimitiveConstant;

@NodeInfo(shortName = "-")
public class SubNode extends BinaryArithmeticNode<Sub> implements NarrowableArithmeticNode {

    public static final NodeClass<SubNode> TYPE = NodeClass.create(SubNode.class);

    public SubNode(ValueNode x, ValueNode y) {
        this(TYPE, x, y);
    }

    protected SubNode(NodeClass<? extends SubNode> c, ValueNode x, ValueNode y) {
        super(c, ArithmeticOpTable::getSub, x, y);
    }

    public static ValueNode create(ValueNode x, ValueNode y) {
        BinaryOp<Sub> op = ArithmeticOpTable.forStamp(x.stamp()).getSub();
        Stamp stamp = op.foldStamp(x.stamp(), y.stamp());
        ConstantNode tryConstantFold = tryConstantFold(op, x, y, stamp);
        if (tryConstantFold != null) {
            return tryConstantFold;
        } else {
            return new SubNode(x, y);
        }
    }

    @SuppressWarnings("hiding")
    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forX, ValueNode forY) {
        ValueNode ret = super.canonical(tool, forX, forY);
        if (ret != this) {
            return ret;
        }

        BinaryOp<Sub> op = getOp(forX, forY);
        if (GraphUtil.unproxify(forX) == GraphUtil.unproxify(forY)) {
            Constant zero = op.getZero(forX.stamp());
            if (zero != null) {
                return ConstantNode.forPrimitive(stamp(), zero);
            }
        }
        boolean associative = op.isAssociative();
        if (associative) {
            if (forX instanceof AddNode) {
                AddNode x = (AddNode) forX;
                if (x.getY() == forY) {
                    // (a + b) - b
                    return x.getX();
                }
                if (x.getX() == forY) {
                    // (a + b) - a
                    return x.getY();
                }
            } else if (forX instanceof SubNode) {
                SubNode x = (SubNode) forX;
                if (x.getX() == forY) {
                    // (a - b) - a
                    return new NegateNode(x.getY());
                }
            }
            if (forY instanceof AddNode) {
                AddNode y = (AddNode) forY;
                if (y.getX() == forX) {
                    // a - (a + b)
                    return new NegateNode(y.getY());
                }
                if (y.getY() == forX) {
                    // b - (a + b)
                    return new NegateNode(y.getX());
                }
            } else if (forY instanceof SubNode) {
                SubNode y = (SubNode) forY;
                if (y.getX() == forX) {
                    // a - (a - b)
                    return y.getY();
                }
            }
        }
        if (forY.isConstant()) {
            Constant c = forY.asConstant();
            if (op.isNeutral(c)) {
                return forX;
            }
            if (associative) {
                BinaryNode reassociated = reassociate(this, ValueNode.isConstantPredicate(), forX, forY);
                if (reassociated != this) {
                    return reassociated;
                }
            }
            if (c instanceof PrimitiveConstant && ((PrimitiveConstant) c).getJavaKind().isNumericInteger()) {
                long i = ((PrimitiveConstant) c).asLong();
                if (i < 0 || ((IntegerStamp) StampFactory.forKind(forY.getStackKind())).contains(-i)) {
                    // Adding a negative is more friendly to the backend since adds are
                    // commutative, so prefer add when it fits.
                    return BinaryArithmeticNode.add(forX, ConstantNode.forIntegerStamp(stamp(), -i));
                }
            }
        } else if (forX.isConstant()) {
            Constant c = forX.asConstant();
            if (ArithmeticOpTable.forStamp(stamp()).getAdd().isNeutral(c)) {
                /*
                 * Note that for floating point numbers, + and - have different neutral elements. We
                 * have to test for the neutral element of +, because we are doing this
                 * transformation: 0 - x == (-x) + 0 == -x.
                 */
                return new NegateNode(forY);
            }
            if (associative) {
                return reassociate(this, ValueNode.isConstantPredicate(), forX, forY);
            }
        }
        if (forY instanceof NegateNode) {
            return BinaryArithmeticNode.add(forX, ((NegateNode) forY).getValue());
        }
        return this;
    }

    @Override
    public void generate(NodeLIRBuilderTool nodeValueMap, ArithmeticLIRGeneratorTool gen) {
        nodeValueMap.setResult(this, gen.emitSub(nodeValueMap.operand(getX()), nodeValueMap.operand(getY()), false));
    }
}
