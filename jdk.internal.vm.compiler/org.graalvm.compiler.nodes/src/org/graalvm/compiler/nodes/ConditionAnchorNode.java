/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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
import static org.graalvm.compiler.nodeinfo.InputType.Guard;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodeinfo.Verbosity;
import org.graalvm.compiler.nodes.extended.GuardingNode;
import org.graalvm.compiler.nodes.extended.ValueAnchorNode;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;

@NodeInfo(nameTemplate = "ConditionAnchor(!={p#negated})", allowedUsageTypes = Guard, cycles = CYCLES_0, size = SIZE_0)
public final class ConditionAnchorNode extends FixedWithNextNode implements Canonicalizable.Unary<Node>, Lowerable, GuardingNode {

    public static final NodeClass<ConditionAnchorNode> TYPE = NodeClass.create(ConditionAnchorNode.class);
    @Input(Condition) LogicNode condition;
    protected boolean negated;

    public ConditionAnchorNode(LogicNode condition) {
        this(condition, false);
    }

    public ConditionAnchorNode(LogicNode condition, boolean negated) {
        super(TYPE, StampFactory.forVoid());
        this.negated = negated;
        this.condition = condition;
    }

    public LogicNode condition() {
        return condition;
    }

    public boolean isNegated() {
        return negated;
    }

    @Override
    public String toString(Verbosity verbosity) {
        if (verbosity == Verbosity.Name && negated) {
            return "!" + super.toString(verbosity);
        } else {
            return super.toString(verbosity);
        }
    }

    @Override
    public Node canonical(CanonicalizerTool tool, Node forValue) {
        if (forValue instanceof LogicNegationNode) {
            LogicNegationNode negation = (LogicNegationNode) forValue;
            return new ConditionAnchorNode(negation.getValue(), !negated);
        }
        if (forValue instanceof LogicConstantNode) {
            LogicConstantNode c = (LogicConstantNode) forValue;
            if (c.getValue() != negated) {
                return null;
            } else {
                return new ValueAnchorNode(null);
            }
        }
        if (tool.allUsagesAvailable() && this.hasNoUsages()) {
            return null;
        }
        return this;
    }

    @Override
    public void lower(LoweringTool tool) {
        if (graph().getGuardsStage() == StructuredGraph.GuardsStage.FIXED_DEOPTS) {
            ValueAnchorNode newAnchor = graph().add(new ValueAnchorNode(null));
            graph().replaceFixedWithFixed(this, newAnchor);
        }
    }

    @Override
    public Node getValue() {
        return condition;
    }
}
