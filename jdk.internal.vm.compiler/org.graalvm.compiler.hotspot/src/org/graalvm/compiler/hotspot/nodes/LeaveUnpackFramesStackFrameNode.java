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
import org.graalvm.compiler.hotspot.HotSpotBackend;
import org.graalvm.compiler.hotspot.HotSpotLIRGenerator;
import org.graalvm.compiler.lir.StandardOp.SaveRegistersOp;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

/**
 * Emits code to leave a low-level stack frame specifically to call out to the C++ method
 * {@link HotSpotBackend#UNPACK_FRAMES Deoptimization::unpack_frames}.
 */
@NodeInfo(cycles = CYCLES_10, size = SIZE_6)
public final class LeaveUnpackFramesStackFrameNode extends FixedWithNextNode implements LIRLowerable {

    public static final NodeClass<LeaveUnpackFramesStackFrameNode> TYPE = NodeClass.create(LeaveUnpackFramesStackFrameNode.class);
    @Input SaveAllRegistersNode registerSaver;

    public LeaveUnpackFramesStackFrameNode(ValueNode registerSaver) {
        super(TYPE, StampFactory.forVoid());
        this.registerSaver = (SaveAllRegistersNode) registerSaver;
    }

    private SaveRegistersOp getSaveRegistersOp() {
        return registerSaver.getSaveRegistersOp();
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        ((HotSpotLIRGenerator) gen.getLIRGeneratorTool()).emitLeaveUnpackFramesStackFrame(getSaveRegistersOp());
    }

    @NodeIntrinsic
    public static native void leaveUnpackFramesStackFrame(long registerSaver);
}
