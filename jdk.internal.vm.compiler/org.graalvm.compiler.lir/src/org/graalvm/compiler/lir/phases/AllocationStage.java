/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.lir.phases;

import static org.graalvm.compiler.core.common.GraalOptions.TraceRA;

import org.graalvm.compiler.core.common.GraalOptions;
import org.graalvm.compiler.lir.alloc.AllocationStageVerifier;
import org.graalvm.compiler.lir.alloc.lsra.LinearScanPhase;
import org.graalvm.compiler.lir.alloc.trace.TraceBuilderPhase;
import org.graalvm.compiler.lir.alloc.trace.TraceRegisterAllocationPhase;
import org.graalvm.compiler.lir.dfa.LocationMarkerPhase;
import org.graalvm.compiler.lir.dfa.MarkBasePointersPhase;
import org.graalvm.compiler.lir.phases.AllocationPhase.AllocationContext;
import org.graalvm.compiler.lir.ssi.SSIConstructionPhase;
import org.graalvm.compiler.lir.stackslotalloc.LSStackSlotAllocator;
import org.graalvm.compiler.lir.stackslotalloc.SimpleStackSlotAllocator;

public class AllocationStage extends LIRPhaseSuite<AllocationContext> {

    public AllocationStage() {
        appendPhase(new MarkBasePointersPhase());
        if (TraceRA.getValue()) {
            appendPhase(new TraceBuilderPhase());
            appendPhase(new SSIConstructionPhase());
            appendPhase(new TraceRegisterAllocationPhase());
        } else {
            appendPhase(new LinearScanPhase());
        }

        // build frame map
        if (LSStackSlotAllocator.Options.LIROptLSStackSlotAllocator.getValue()) {
            appendPhase(new LSStackSlotAllocator());
        } else {
            appendPhase(new SimpleStackSlotAllocator());
        }
        // currently we mark locations only if we do register allocation
        appendPhase(new LocationMarkerPhase());

        if (GraalOptions.DetailedAsserts.getValue()) {
            appendPhase(new AllocationStageVerifier());
        }
    }
}
