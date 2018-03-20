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

@NodeInfo(shortName = "%")
public class SignedRemNode extends IntegerDivRemNode implements LIRLowerable {

    public static final NodeClass<SignedRemNode> TYPE = NodeClass.create(SignedRemNode.class);

    public SignedRemNode(ValueNode x, ValueNode y) {
        this(TYPE, x, y);
    }

    protected SignedRemNode(NodeClass<? extends SignedRemNode> c, ValueNode x, ValueNode y) {
        super(c, IntegerStamp.OPS.getRem().foldStamp(x.stamp(), y.stamp()), Op.REM, Type.SIGNED, x, y);
    }

    @Override
    public boolean inferStamp() {
        return updateStamp(IntegerStamp.OPS.getRem().foldStamp(getX().stamp(), getY().stamp()));
    }

    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forX, ValueNode forY) {
        if (forX.isConstant() && forY.isConstant()) {
            @SuppressWarnings("hiding")
            long y = forY.asJavaConstant().asLong();
            if (y == 0) {
                return this; // this will trap, can not canonicalize
            }
            return ConstantNode.forIntegerStamp(stamp(), forX.asJavaConstant().asLong() % y);
        } else if (forY.isConstant()) {
            long c = forY.asJavaConstant().asLong();
            if (c == 1 || c == -1) {
                return ConstantNode.forIntegerStamp(stamp(), 0);
            } else if (c > 0 && CodeUtil.isPowerOf2(c) && forX.stamp() instanceof IntegerStamp && ((IntegerStamp) forX.stamp()).isPositive()) {
                return new AndNode(forX, ConstantNode.forIntegerStamp(stamp(), c - 1));
            }
        }
        return this;
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        gen.setResult(this, gen.getLIRGeneratorTool().getArithmetic().emitRem(gen.operand(getX()), gen.operand(getY()), gen.state(this)));
    }
}
