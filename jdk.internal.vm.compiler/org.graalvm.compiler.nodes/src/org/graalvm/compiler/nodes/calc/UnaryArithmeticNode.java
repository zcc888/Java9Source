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

import java.io.Serializable;
import java.util.function.Function;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable.UnaryOp;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ArithmeticOperation;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.ArithmeticLIRLowerable;

@NodeInfo
public abstract class UnaryArithmeticNode<OP> extends UnaryNode implements ArithmeticOperation, ArithmeticLIRLowerable {

    @SuppressWarnings("rawtypes") public static final NodeClass<UnaryArithmeticNode> TYPE = NodeClass.create(UnaryArithmeticNode.class);

    protected interface SerializableUnaryFunction<T> extends Function<ArithmeticOpTable, UnaryOp<T>>, Serializable {
    }

    protected final SerializableUnaryFunction<OP> getOp;

    protected UnaryArithmeticNode(NodeClass<? extends UnaryArithmeticNode<OP>> c, SerializableUnaryFunction<OP> getOp, ValueNode value) {
        super(c, getOp.apply(ArithmeticOpTable.forStamp(value.stamp())).foldStamp(value.stamp()), value);
        this.getOp = getOp;
    }

    protected final UnaryOp<OP> getOp(ValueNode forValue) {
        return getOp.apply(ArithmeticOpTable.forStamp(forValue.stamp()));
    }

    @Override
    public final UnaryOp<OP> getArithmeticOp() {
        return getOp(getValue());
    }

    @Override
    public Stamp foldStamp(Stamp newStamp) {
        assert newStamp.isCompatible(getValue().stamp());
        return getOp(getValue()).foldStamp(newStamp);
    }

    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forValue) {
        ValueNode synonym = findSynonym(forValue, getOp(forValue));
        if (synonym != null) {
            return synonym;
        }
        return this;
    }

    protected static <OP> ValueNode findSynonym(ValueNode forValue, UnaryOp<OP> op) {
        if (forValue.isConstant()) {
            return ConstantNode.forPrimitive(op.foldStamp(forValue.stamp()), op.foldConstant(forValue.asConstant()));
        }
        return null;
    }
}
