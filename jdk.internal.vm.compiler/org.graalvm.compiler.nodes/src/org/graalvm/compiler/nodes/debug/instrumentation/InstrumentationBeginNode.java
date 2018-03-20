/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes.debug.instrumentation;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_IGNORED;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_IGNORED;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.AbstractStateSplit;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

/**
 * The {@code InstrumentationBeginNode} represents the boundary of the instrumentation. It also
 * maintains the target of the instrumentation.
 */
@NodeInfo(cycles = CYCLES_IGNORED, size = SIZE_IGNORED)
public final class InstrumentationBeginNode extends AbstractStateSplit implements LIRLowerable {

    public static final NodeClass<InstrumentationBeginNode> TYPE = NodeClass.create(InstrumentationBeginNode.class);

    @OptionalInput(value = InputType.Unchecked) protected ValueNode target;
    private final boolean anchored;

    public InstrumentationBeginNode(boolean anchored) {
        super(TYPE, StampFactory.forVoid());
        this.anchored = anchored;
        this.target = null;

    }

    public boolean isAnchored() {
        return anchored;
    }

    public ValueNode getTarget() {
        return target;
    }

    public void setTarget(ValueNode target) {
        updateUsages(this.target, target);
        this.target = target;
    }

    @Override
    public void generate(NodeLIRBuilderTool generator) {
        // do nothing
    }

}
