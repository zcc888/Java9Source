/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes;

import static org.graalvm.compiler.nodeinfo.InputType.Condition;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.graph.IterableNodeType;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;

@NodeInfo(cycles = CYCLES_0, size = SIZE_0)
public final class ShortCircuitOrNode extends LogicNode implements IterableNodeType, Canonicalizable.Binary<LogicNode> {

    public static final NodeClass<ShortCircuitOrNode> TYPE = NodeClass.create(ShortCircuitOrNode.class);
    @Input(Condition) LogicNode x;
    @Input(Condition) LogicNode y;
    protected boolean xNegated;
    protected boolean yNegated;
    protected double shortCircuitProbability;

    public ShortCircuitOrNode(LogicNode x, boolean xNegated, LogicNode y, boolean yNegated, double shortCircuitProbability) {
        super(TYPE);
        this.x = x;
        this.xNegated = xNegated;
        this.y = y;
        this.yNegated = yNegated;
        this.shortCircuitProbability = shortCircuitProbability;
    }

    @Override
    public LogicNode getX() {
        return x;
    }

    @Override
    public LogicNode getY() {
        return y;
    }

    public boolean isXNegated() {
        return xNegated;
    }

    public boolean isYNegated() {
        return yNegated;
    }

    /**
     * Gets the probability that the {@link #getY() y} part of this binary node is <b>not</b>
     * evaluated. This is the probability that this operator will short-circuit its execution.
     */
    public double getShortCircuitProbability() {
        return shortCircuitProbability;
    }

    protected ShortCircuitOrNode canonicalizeNegation(LogicNode forX, LogicNode forY) {
        LogicNode xCond = forX;
        boolean xNeg = xNegated;
        while (xCond instanceof LogicNegationNode) {
            xCond = ((LogicNegationNode) xCond).getValue();
            xNeg = !xNeg;
        }

        LogicNode yCond = forY;
        boolean yNeg = yNegated;
        while (yCond instanceof LogicNegationNode) {
            yCond = ((LogicNegationNode) yCond).getValue();
            yNeg = !yNeg;
        }

        if (xCond != forX || yCond != forY) {
            return new ShortCircuitOrNode(xCond, xNeg, yCond, yNeg, shortCircuitProbability);
        } else {
            return this;
        }
    }

    @Override
    public LogicNode canonical(CanonicalizerTool tool, LogicNode forX, LogicNode forY) {
        ShortCircuitOrNode ret = canonicalizeNegation(forX, forY);
        if (ret != this) {
            return ret;
        }

        if (forX == forY) {
            // @formatter:off
            //  a ||  a = a
            //  a || !a = true
            // !a ||  a = true
            // !a || !a = !a
            // @formatter:on
            if (isXNegated()) {
                if (isYNegated()) {
                    // !a || !a = !a
                    return LogicNegationNode.create(forX);
                } else {
                    // !a || a = true
                    return LogicConstantNode.tautology();
                }
            } else {
                if (isYNegated()) {
                    // a || !a = true
                    return LogicConstantNode.tautology();
                } else {
                    // a || a = a
                    return forX;
                }
            }
        }
        if (forX instanceof LogicConstantNode) {
            if (((LogicConstantNode) forX).getValue() ^ isXNegated()) {
                return LogicConstantNode.tautology();
            } else {
                if (isYNegated()) {
                    return new LogicNegationNode(forY);
                } else {
                    return forY;
                }
            }
        }
        if (forY instanceof LogicConstantNode) {
            if (((LogicConstantNode) forY).getValue() ^ isYNegated()) {
                return LogicConstantNode.tautology();
            } else {
                if (isXNegated()) {
                    return new LogicNegationNode(forX);
                } else {
                    return forX;
                }
            }
        }
        return this;
    }
}
