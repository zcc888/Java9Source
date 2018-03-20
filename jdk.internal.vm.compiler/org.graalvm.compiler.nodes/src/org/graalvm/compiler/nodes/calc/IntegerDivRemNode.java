/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_40;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_2;

import org.graalvm.compiler.core.common.type.IntegerStamp;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;

@NodeInfo(cycles = CYCLES_40, size = SIZE_2)
public abstract class IntegerDivRemNode extends FixedBinaryNode implements Lowerable {

    public static final NodeClass<IntegerDivRemNode> TYPE = NodeClass.create(IntegerDivRemNode.class);

    public enum Op {
        DIV,
        REM
    }

    public enum Type {
        SIGNED,
        UNSIGNED
    }

    private final Op op;
    private final Type type;

    protected IntegerDivRemNode(NodeClass<? extends IntegerDivRemNode> c, Stamp stamp, Op op, Type type, ValueNode x, ValueNode y) {
        super(c, stamp, x, y);
        this.op = op;
        this.type = type;
    }

    public final Op getOp() {
        return op;
    }

    public final Type getType() {
        return type;
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    @Override
    public boolean canDeoptimize() {
        return !(getY().stamp() instanceof IntegerStamp) || ((IntegerStamp) getY().stamp()).contains(0);
    }
}
