/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.hotspot.HotSpotBackend.FETCH_UNROLL_INFO;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_UNKNOWN;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_UNKNOWN;

import org.graalvm.compiler.core.common.LocationIdentity;
import org.graalvm.compiler.core.common.spi.ForeignCallsProvider;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.hotspot.HotSpotLIRGenerator;
import org.graalvm.compiler.lir.StandardOp.SaveRegistersOp;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.memory.MemoryCheckpoint;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import org.graalvm.compiler.word.Word;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.Value;

/**
 * A call to the runtime code {@code Deoptimization::fetch_unroll_info}.
 */
@NodeInfo(allowedUsageTypes = {InputType.Memory}, cycles = CYCLES_UNKNOWN, size = SIZE_UNKNOWN)
public final class DeoptimizationFetchUnrollInfoCallNode extends FixedWithNextNode implements LIRLowerable, MemoryCheckpoint.Single {

    public static final NodeClass<DeoptimizationFetchUnrollInfoCallNode> TYPE = NodeClass.create(DeoptimizationFetchUnrollInfoCallNode.class);
    @Input SaveAllRegistersNode registerSaver;
    @Input ValueNode mode;
    protected final ForeignCallsProvider foreignCalls;

    public DeoptimizationFetchUnrollInfoCallNode(@InjectedNodeParameter ForeignCallsProvider foreignCalls, ValueNode registerSaver, ValueNode mode) {
        super(TYPE, StampFactory.forKind(JavaKind.fromJavaClass(FETCH_UNROLL_INFO.getResultType())));
        this.registerSaver = (SaveAllRegistersNode) registerSaver;
        this.mode = mode;
        this.foreignCalls = foreignCalls;
    }

    @Override
    public LocationIdentity getLocationIdentity() {
        return LocationIdentity.any();
    }

    public SaveRegistersOp getSaveRegistersOp() {
        return registerSaver.getSaveRegistersOp();
    }

    /**
     * Returns the node representing the exec_mode/unpack_kind used during this fetch_unroll_info
     * call.
     */
    public ValueNode getMode() {
        return mode;
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        Value result = ((HotSpotLIRGenerator) gen.getLIRGeneratorTool()).emitDeoptimizationFetchUnrollInfoCall(gen.operand(getMode()), getSaveRegistersOp());
        gen.setResult(this, result);
    }

    @NodeIntrinsic
    public static native Word fetchUnrollInfo(long registerSaver, int mode);
}
