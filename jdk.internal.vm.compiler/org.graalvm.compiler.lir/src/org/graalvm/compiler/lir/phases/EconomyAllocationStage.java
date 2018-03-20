/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.lir.alloc.lsra.LinearScanPhase;
import org.graalvm.compiler.lir.dfa.LocationMarkerPhase;
import org.graalvm.compiler.lir.phases.AllocationPhase.AllocationContext;
import org.graalvm.compiler.lir.stackslotalloc.SimpleStackSlotAllocator;

public class EconomyAllocationStage extends LIRPhaseSuite<AllocationContext> {
    public EconomyAllocationStage() {
        appendPhase(new LinearScanPhase());

        // build frame map
        appendPhase(new SimpleStackSlotAllocator());

        // currently we mark locations only if we do register allocation
        appendPhase(new LocationMarkerPhase());
    }
}
