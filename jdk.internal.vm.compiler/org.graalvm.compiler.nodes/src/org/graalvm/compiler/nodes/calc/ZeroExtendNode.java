/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_1;

import org.graalvm.compiler.core.common.calc.Condition;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable.IntegerConvertOp;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable.IntegerConvertOp.Narrow;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable.IntegerConvertOp.ZeroExtend;
import org.graalvm.compiler.core.common.type.IntegerStamp;
import org.graalvm.compiler.core.common.type.PrimitiveStamp;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.lir.gen.ArithmeticLIRGeneratorTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

import jdk.vm.ci.code.CodeUtil;

/**
 * The {@code ZeroExtendNode} converts an integer to a wider integer using zero extension.
 */
@NodeInfo(cycles = CYCLES_1)
public final class ZeroExtendNode extends IntegerConvertNode<ZeroExtend, Narrow> {

    public static final NodeClass<ZeroExtendNode> TYPE = NodeClass.create(ZeroExtendNode.class);

    public ZeroExtendNode(ValueNode input, int resultBits) {
        this(input, PrimitiveStamp.getBits(input.stamp()), resultBits);
        assert 0 < PrimitiveStamp.getBits(input.stamp()) && PrimitiveStamp.getBits(input.stamp()) <= resultBits;
    }

    public ZeroExtendNode(ValueNode input, int inputBits, int resultBits) {
        super(TYPE, ArithmeticOpTable::getZeroExtend, ArithmeticOpTable::getNarrow, inputBits, resultBits, input);
    }

    public static ValueNode create(ValueNode input, int resultBits) {
        return create(input, PrimitiveStamp.getBits(input.stamp()), resultBits);
    }

    public static ValueNode create(ValueNode input, int inputBits, int resultBits) {
        IntegerConvertOp<ZeroExtend> signExtend = ArithmeticOpTable.forStamp(input.stamp()).getZeroExtend();
        ValueNode synonym = findSynonym(signExtend, input, inputBits, resultBits, signExtend.foldStamp(inputBits, resultBits, input.stamp()));
        if (synonym != null) {
            return synonym;
        } else {
            return new ZeroExtendNode(input, inputBits, resultBits);
        }
    }

    @Override
    public boolean isLossless() {
        return true;
    }

    @Override
    public boolean preservesOrder(Condition cond) {
        switch (cond) {
            case GE:
            case GT:
            case LE:
            case LT:
                return false;
            default:
                return true;
        }
    }

    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forValue) {
        ValueNode ret = super.canonical(tool, forValue);
        if (ret != this) {
            return ret;
        }

        if (forValue instanceof ZeroExtendNode) {
            // xxxx -(zero-extend)-> 0000 xxxx -(zero-extend)-> 00000000 0000xxxx
            // ==> xxxx -(zero-extend)-> 00000000 0000xxxx
            ZeroExtendNode other = (ZeroExtendNode) forValue;
            return new ZeroExtendNode(other.getValue(), other.getInputBits(), getResultBits());
        }
        if (forValue instanceof NarrowNode) {
            NarrowNode narrow = (NarrowNode) forValue;
            Stamp inputStamp = narrow.getValue().stamp();
            if (inputStamp instanceof IntegerStamp && inputStamp.isCompatible(stamp())) {
                IntegerStamp istamp = (IntegerStamp) inputStamp;
                long mask = CodeUtil.mask(PrimitiveStamp.getBits(narrow.stamp()));
                if (((istamp.upMask() | istamp.downMask()) & ~mask) == 0) {
                    // The original value is in the range of the masked zero extended result so
                    // simply return the original input.
                    return narrow.getValue();
                }
            }
        }

        return this;
    }

    @Override
    public void generate(NodeLIRBuilderTool nodeValueMap, ArithmeticLIRGeneratorTool gen) {
        nodeValueMap.setResult(this, gen.emitZeroExtend(nodeValueMap.operand(getValue()), getInputBits(), getResultBits()));
    }
}
