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
package org.graalvm.compiler.hotspot;

import java.util.Map;

import org.graalvm.compiler.core.common.CollectionsFactory;
import org.graalvm.compiler.core.common.CompilationIdentifier;
import org.graalvm.compiler.hotspot.stubs.Stub;
import org.graalvm.compiler.lir.LIR;
import org.graalvm.compiler.lir.LIRFrameState;
import org.graalvm.compiler.lir.StandardOp.SaveRegistersOp;
import org.graalvm.compiler.lir.framemap.FrameMapBuilder;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;

import jdk.vm.ci.code.CallingConvention;
import jdk.vm.ci.code.StackSlot;

public class HotSpotLIRGenerationResult extends LIRGenerationResult {

    /**
     * The slot reserved for storing the original return address when a frame is marked for
     * deoptimization. The return address slot in the callee is overwritten with the address of a
     * deoptimization stub.
     */
    private StackSlot deoptimizationRescueSlot;
    protected final Object stub;

    private int maxInterpreterFrameSize;

    /**
     * Map from debug infos that need to be updated with callee save information to the operations
     * that provide the information.
     */
    private Map<LIRFrameState, SaveRegistersOp> calleeSaveInfo = CollectionsFactory.newMap();

    public HotSpotLIRGenerationResult(CompilationIdentifier compilationId, LIR lir, FrameMapBuilder frameMapBuilder, CallingConvention callingConvention, Object stub) {
        super(compilationId, lir, frameMapBuilder, callingConvention);
        this.stub = stub;
    }

    public Map<LIRFrameState, SaveRegistersOp> getCalleeSaveInfo() {
        return calleeSaveInfo;
    }

    public Stub getStub() {
        return (Stub) stub;
    }

    public StackSlot getDeoptimizationRescueSlot() {
        return deoptimizationRescueSlot;
    }

    public final void setDeoptimizationRescueSlot(StackSlot stackSlot) {
        this.deoptimizationRescueSlot = stackSlot;
    }

    public void setMaxInterpreterFrameSize(int maxInterpreterFrameSize) {
        this.maxInterpreterFrameSize = maxInterpreterFrameSize;
    }

    public int getMaxInterpreterFrameSize() {
        return maxInterpreterFrameSize;
    }
}
