/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_5;

import java.util.EnumMap;

import org.graalvm.compiler.core.common.calc.FloatConvert;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable.FloatConvertOp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.lir.gen.ArithmeticLIRGeneratorTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.ArithmeticLIRLowerable;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.ConstantReflectionProvider;

/**
 * A {@code FloatConvert} converts between integers and floating point numbers according to Java
 * semantics.
 */
@NodeInfo(cycles = CYCLES_5)
public final class FloatConvertNode extends UnaryArithmeticNode<FloatConvertOp> implements ConvertNode, Lowerable, ArithmeticLIRLowerable {
    public static final NodeClass<FloatConvertNode> TYPE = NodeClass.create(FloatConvertNode.class);

    protected final FloatConvert op;

    private static final EnumMap<FloatConvert, SerializableUnaryFunction<FloatConvertOp>> getOps;
    static {
        getOps = new EnumMap<>(FloatConvert.class);
        for (FloatConvert op : FloatConvert.values()) {
            getOps.put(op, table -> table.getFloatConvert(op));
        }
    }

    public FloatConvertNode(FloatConvert op, ValueNode input) {
        super(TYPE, getOps.get(op), input);
        this.op = op;
    }

    public static ValueNode create(FloatConvert op, ValueNode input) {
        ValueNode synonym = findSynonym(input, ArithmeticOpTable.forStamp(input.stamp()).getFloatConvert(op));
        if (synonym != null) {
            return synonym;
        }
        return new FloatConvertNode(op, input);
    }

    public FloatConvert getFloatConvert() {
        return op;
    }

    @Override
    public Constant convert(Constant c, ConstantReflectionProvider constantReflection) {
        return getArithmeticOp().foldConstant(c);
    }

    @Override
    public Constant reverse(Constant c, ConstantReflectionProvider constantReflection) {
        FloatConvertOp reverse = ArithmeticOpTable.forStamp(stamp()).getFloatConvert(op.reverse());
        return reverse.foldConstant(c);
    }

    @Override
    public boolean isLossless() {
        switch (getFloatConvert()) {
            case F2D:
            case I2D:
                return true;
            default:
                return false;
        }
    }

    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forValue) {
        ValueNode ret = super.canonical(tool, forValue);
        if (ret != this) {
            return ret;
        }

        if (forValue instanceof FloatConvertNode) {
            FloatConvertNode other = (FloatConvertNode) forValue;
            if (other.isLossless() && other.op == this.op.reverse()) {
                return other.getValue();
            }
        }
        return this;
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    @Override
    public void generate(NodeLIRBuilderTool nodeValueMap, ArithmeticLIRGeneratorTool gen) {
        nodeValueMap.setResult(this, gen.emitFloatConvert(getFloatConvert(), nodeValueMap.operand(getValue())));
    }
}
