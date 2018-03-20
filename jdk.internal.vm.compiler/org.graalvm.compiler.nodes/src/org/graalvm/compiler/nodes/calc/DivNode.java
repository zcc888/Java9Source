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
import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.Div;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.lir.gen.ArithmeticLIRGeneratorTool;
import org.graalvm.compiler.nodeinfo.NodeCycles;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

import jdk.vm.ci.code.CodeUtil;
import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.PrimitiveConstant;

@NodeInfo(shortName = "/", cycles = NodeCycles.CYCLES_30)
public class DivNode extends BinaryArithmeticNode<Div> {

    public static final NodeClass<DivNode> TYPE = NodeClass.create(DivNode.class);

    public DivNode(ValueNode x, ValueNode y) {
        super(TYPE, ArithmeticOpTable::getDiv, x, y);
    }

    protected DivNode(NodeClass<? extends DivNode> c, ValueNode x, ValueNode y) {
        super(c, ArithmeticOpTable::getDiv, x, y);
    }

    public static ValueNode create(ValueNode x, ValueNode y) {
        BinaryOp<Div> op = ArithmeticOpTable.forStamp(x.stamp()).getDiv();
        Stamp stamp = op.foldStamp(x.stamp(), y.stamp());
        ConstantNode tryConstantFold = tryConstantFold(op, x, y, stamp);
        if (tryConstantFold != null) {
            return tryConstantFold;
        } else {
            return new DivNode(x, y);
        }
    }

    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forX, ValueNode forY) {
        ValueNode ret = super.canonical(tool, forX, forY);
        if (ret != this) {
            return ret;
        }

        if (forY.isConstant()) {
            Constant c = forY.asConstant();
            if (getOp(forX, forY).isNeutral(c)) {
                return forX;
            }
            if (c instanceof PrimitiveConstant && ((PrimitiveConstant) c).getJavaKind().isNumericInteger()) {
                long i = ((PrimitiveConstant) c).asLong();
                boolean signFlip = false;
                if (i < 0) {
                    i = -i;
                    signFlip = true;
                }
                ValueNode divResult = null;
                if (CodeUtil.isPowerOf2(i)) {
                    divResult = new RightShiftNode(forX, ConstantNode.forInt(CodeUtil.log2(i)));
                }
                if (divResult != null) {
                    if (signFlip) {
                        return new NegateNode(divResult);
                    } else {
                        return divResult;
                    }
                }
            }
        }
        return this;
    }

    @Override
    public void generate(NodeLIRBuilderTool nodeValueMap, ArithmeticLIRGeneratorTool gen) {
        nodeValueMap.setResult(this, gen.emitDiv(nodeValueMap.operand(getX()), nodeValueMap.operand(getY()), null));
    }
}
