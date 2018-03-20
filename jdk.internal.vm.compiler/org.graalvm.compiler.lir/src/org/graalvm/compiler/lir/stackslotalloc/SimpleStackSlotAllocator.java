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
package org.graalvm.compiler.lir.stackslotalloc;

import static org.graalvm.compiler.lir.LIRValueUtil.asVirtualStackSlot;
import static org.graalvm.compiler.lir.LIRValueUtil.isVirtualStackSlot;
import static org.graalvm.compiler.lir.stackslotalloc.StackSlotAllocatorUtil.allocatedFramesize;
import static org.graalvm.compiler.lir.stackslotalloc.StackSlotAllocatorUtil.allocatedSlots;
import static org.graalvm.compiler.lir.stackslotalloc.StackSlotAllocatorUtil.virtualFramesize;

import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.Debug.Scope;
import org.graalvm.compiler.debug.Indent;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.ValueProcedure;
import org.graalvm.compiler.lir.VirtualStackSlot;
import org.graalvm.compiler.lir.framemap.FrameMapBuilderTool;
import org.graalvm.compiler.lir.framemap.SimpleVirtualStackSlot;
import org.graalvm.compiler.lir.framemap.VirtualStackSlotRange;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.phases.AllocationPhase;

import jdk.vm.ci.code.StackSlot;
import jdk.vm.ci.code.TargetDescription;

public class SimpleStackSlotAllocator extends AllocationPhase {

    @Override
    protected void run(TargetDescription target, LIRGenerationResult lirGenRes, AllocationContext context) {
        allocateStackSlots((FrameMapBuilderTool) lirGenRes.getFrameMapBuilder(), lirGenRes);
        lirGenRes.buildFrameMap();
    }

    public void allocateStackSlots(FrameMapBuilderTool builder, LIRGenerationResult res) {
        StackSlot[] mapping = new StackSlot[builder.getNumberOfStackSlots()];
        long currentFrameSize = allocatedFramesize.isEnabled() ? builder.getFrameMap().currentFrameSize() : 0;
        for (VirtualStackSlot virtualSlot : builder.getStackSlots()) {
            final StackSlot slot;
            if (virtualSlot instanceof SimpleVirtualStackSlot) {
                slot = mapSimpleVirtualStackSlot(builder, (SimpleVirtualStackSlot) virtualSlot);
                virtualFramesize.add(builder.getFrameMap().spillSlotSize(virtualSlot.getValueKind()));
            } else if (virtualSlot instanceof VirtualStackSlotRange) {
                VirtualStackSlotRange slotRange = (VirtualStackSlotRange) virtualSlot;
                slot = mapVirtualStackSlotRange(builder, slotRange);
                virtualFramesize.add(builder.getFrameMap().spillSlotRangeSize(slotRange.getSlots()));
            } else {
                throw GraalError.shouldNotReachHere("Unknown VirtualStackSlot: " + virtualSlot);
            }
            allocatedSlots.increment();
            mapping[virtualSlot.getId()] = slot;
        }
        updateLIR(res, mapping);
        if (allocatedFramesize.isEnabled()) {
            allocatedFramesize.add(builder.getFrameMap().currentFrameSize() - currentFrameSize);
        }
    }

    @SuppressWarnings("try")
    protected void updateLIR(LIRGenerationResult res, StackSlot[] mapping) {
        try (Scope scope = Debug.scope("StackSlotMappingLIR")) {
            ValueProcedure updateProc = (value, mode, flags) -> {
                if (isVirtualStackSlot(value)) {
                    StackSlot stackSlot = mapping[asVirtualStackSlot(value).getId()];
                    Debug.log("map %s -> %s", value, stackSlot);
                    return stackSlot;
                }
                return value;
            };
            for (AbstractBlockBase<?> block : res.getLIR().getControlFlowGraph().getBlocks()) {
                try (Indent indent0 = Debug.logAndIndent("block: %s", block)) {
                    for (LIRInstruction inst : res.getLIR().getLIRforBlock(block)) {
                        try (Indent indent1 = Debug.logAndIndent("Inst: %d: %s", inst.id(), inst)) {
                            inst.forEachAlive(updateProc);
                            inst.forEachInput(updateProc);
                            inst.forEachOutput(updateProc);
                            inst.forEachTemp(updateProc);
                            inst.forEachState(updateProc);
                        }
                    }
                }
            }
        }
    }

    protected StackSlot mapSimpleVirtualStackSlot(FrameMapBuilderTool builder, SimpleVirtualStackSlot virtualStackSlot) {
        return builder.getFrameMap().allocateSpillSlot(virtualStackSlot.getValueKind());
    }

    protected StackSlot mapVirtualStackSlotRange(FrameMapBuilderTool builder, VirtualStackSlotRange virtualStackSlot) {
        return builder.getFrameMap().allocateStackSlots(virtualStackSlot.getSlots(), virtualStackSlot.getObjects());
    }
}
