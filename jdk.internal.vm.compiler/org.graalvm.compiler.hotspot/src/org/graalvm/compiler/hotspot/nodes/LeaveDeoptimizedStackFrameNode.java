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

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_3;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_2;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.hotspot.HotSpotLIRGenerator;
import org.graalvm.compiler.hotspot.stubs.DeoptimizationStub;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import org.graalvm.compiler.word.Word;

import jdk.vm.ci.meta.Value;

/**
 * Emits code to leave (pop) the current low-level stack frame which is being deoptimized. This node
 * is only used in {@link DeoptimizationStub}.
 */
@NodeInfo(cycles = CYCLES_3, size = SIZE_2)
public final class LeaveDeoptimizedStackFrameNode extends FixedWithNextNode implements LIRLowerable {

    public static final NodeClass<LeaveDeoptimizedStackFrameNode> TYPE = NodeClass.create(LeaveDeoptimizedStackFrameNode.class);
    @Input ValueNode frameSize;
    @Input ValueNode initialInfo;

    public LeaveDeoptimizedStackFrameNode(ValueNode frameSize, ValueNode initialInfo) {
        super(TYPE, StampFactory.forVoid());
        this.frameSize = frameSize;
        this.initialInfo = initialInfo;
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        Value frameSizeValue = gen.operand(frameSize);
        Value initialInfoValue = gen.operand(initialInfo);
        ((HotSpotLIRGenerator) gen.getLIRGeneratorTool()).emitLeaveDeoptimizedStackFrame(frameSizeValue, initialInfoValue);
    }

    @NodeIntrinsic
    public static native void leaveDeoptimizedStackFrame(int frameSize, Word initialInfo);
}
