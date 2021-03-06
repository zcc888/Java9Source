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
import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.Add;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable.BinaryCommutative;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.lir.gen.ArithmeticLIRGeneratorTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.Value;

@NodeInfo(shortName = "+")
public class AddNode extends BinaryArithmeticNode<Add> implements NarrowableArithmeticNode, BinaryCommutative<ValueNode> {

    public static final NodeClass<AddNode> TYPE = NodeClass.create(AddNode.class);

    public AddNode(ValueNode x, ValueNode y) {
        this(TYPE, x, y);
    }

    protected AddNode(NodeClass<? extends AddNode> c, ValueNode x, ValueNode y) {
        super(c, ArithmeticOpTable::getAdd, x, y);
    }

    public static ValueNode create(ValueNode x, ValueNode y) {
        BinaryOp<Add> op = ArithmeticOpTable.forStamp(x.stamp()).getAdd();
        Stamp stamp = op.foldStamp(x.stamp(), y.stamp());
        ConstantNode tryConstantFold = tryConstantFold(op, x, y, stamp);
        if (tryConstantFold != null) {
            return tryConstantFold;
        } else {
            return new AddNode(x, y).maybeCommuteInputs();
        }
    }

    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forX, ValueNode forY) {
        ValueNode ret = super.canonical(tool, forX, forY);
        if (ret != this) {
            return ret;
        }

        if (forX.isConstant() && !forY.isConstant()) {
            // we try to swap and canonicalize
            ValueNode improvement = canonical(tool, forY, forX);
            if (improvement != this) {
                return improvement;
            }
            // if this fails we only swap
            return new AddNode(forY, forX);
        }
        BinaryOp<Add> op = getOp(forX, forY);
        boolean associative = op.isAssociative();
        if (associative) {
            if (forX instanceof SubNode) {
                SubNode sub = (SubNode) forX;
                if (sub.getY() == forY) {
                    // (a - b) + b
                    return sub.getX();
                }
            }
            if (forY instanceof SubNode) {
                SubNode sub = (SubNode) forY;
                if (sub.getY() == forX) {
                    // b + (a - b)
                    return sub.getX();
                }
            }
        }
        if (forY.isConstant()) {
            Constant c = forY.asConstant();
            if (op.isNeutral(c)) {
                return forX;
            }
            if (associative) {
                // canonicalize expressions like "(a + 1) + 2"
                BinaryNode reassociated = reassociate(this, ValueNode.isConstantPredicate(), forX, forY);
                if (reassociated != this) {
                    return reassociated;
                }
            }
        }
        if (forX instanceof NegateNode) {
            return BinaryArithmeticNode.sub(forY, ((NegateNode) forX).getValue());
        } else if (forY instanceof NegateNode) {
            return BinaryArithmeticNode.sub(forX, ((NegateNode) forY).getValue());
        }
        return this;
    }

    @Override
    public void generate(NodeLIRBuilderTool nodeValueMap, ArithmeticLIRGeneratorTool gen) {
        Value op1 = nodeValueMap.operand(getX());
        assert op1 != null : getX() + ", this=" + this;
        Value op2 = nodeValueMap.operand(getY());
        if (shouldSwapInputs(nodeValueMap)) {
            Value tmp = op1;
            op1 = op2;
            op2 = tmp;
        }
        nodeValueMap.setResult(this, gen.emitAdd(op1, op2, false));
    }
}
