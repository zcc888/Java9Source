/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.nodes;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_10;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_6;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.hotspot.HotSpotLIRGenerator;
import org.graalvm.compiler.lir.StandardOp.SaveRegistersOp;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

/**
 * Emits code to leave (pop) the current low-level stack frame. This operation also removes the
 * return address if its location is on the stack.
 */
@NodeInfo(cycles = CYCLES_10, size = SIZE_6)
public final class LeaveCurrentStackFrameNode extends FixedWithNextNode implements LIRLowerable {

    public static final NodeClass<LeaveCurrentStackFrameNode> TYPE = NodeClass.create(LeaveCurrentStackFrameNode.class);
    @Input SaveAllRegistersNode registerSaver;

    public LeaveCurrentStackFrameNode(ValueNode registerSaver) {
        super(TYPE, StampFactory.forVoid());
        this.registerSaver = (SaveAllRegistersNode) registerSaver;
    }

    private SaveRegistersOp getSaveRegistersOp() {
        return registerSaver.getSaveRegistersOp();
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        ((HotSpotLIRGenerator) gen.getLIRGeneratorTool()).emitLeaveCurrentStackFrame(getSaveRegistersOp());
    }

    @NodeIntrinsic
    public static native void leaveCurrentStackFrame(long registerSaver);
}
