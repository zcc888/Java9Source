/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.type.IntegerStamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

import jdk.vm.ci.code.CodeUtil;

@NodeInfo(shortName = "|/|")
public class UnsignedDivNode extends IntegerDivRemNode implements LIRLowerable {

    public static final NodeClass<UnsignedDivNode> TYPE = NodeClass.create(UnsignedDivNode.class);

    public UnsignedDivNode(ValueNode x, ValueNode y) {
        this(TYPE, x, y);
    }

    protected UnsignedDivNode(NodeClass<? extends UnsignedDivNode> c, ValueNode x, ValueNode y) {
        super(c, x.stamp().unrestricted(), Op.DIV, Type.UNSIGNED, x, y);
    }

    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forX, ValueNode forY) {
        int bits = ((IntegerStamp) stamp()).getBits();
        if (forX.isConstant() && forY.isConstant()) {
            long yConst = CodeUtil.zeroExtend(forY.asJavaConstant().asLong(), bits);
            if (yConst == 0) {
                return this; // this will trap, cannot canonicalize
            }
            return ConstantNode.forIntegerStamp(stamp(), Long.divideUnsigned(CodeUtil.zeroExtend(forX.asJavaConstant().asLong(), bits), yConst));
        } else if (forY.isConstant()) {
            long c = CodeUtil.zeroExtend(forY.asJavaConstant().asLong(), bits);
            if (c == 1) {
                return forX;
            }
            if (CodeUtil.isPowerOf2(c)) {
                return new UnsignedRightShiftNode(forX, ConstantNode.forInt(CodeUtil.log2(c)));
            }
        }
        return this;
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        gen.setResult(this, gen.getLIRGeneratorTool().getArithmetic().emitUDiv(gen.operand(getX()), gen.operand(getY()), gen.state(this)));
    }

    @NodeIntrinsic
    public static native int unsignedDivide(int a, int b);

    @NodeIntrinsic
    public static native long unsignedDivide(long a, long b);
}
