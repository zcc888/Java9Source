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
package org.graalvm.compiler.lir.alloc.lsra;

import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.Indent;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.phases.AllocationPhase;

import jdk.vm.ci.code.TargetDescription;

public final class LinearScanRegisterAllocationPhase extends AllocationPhase {

    private final LinearScan allocator;

    LinearScanRegisterAllocationPhase(LinearScan allocator) {
        this.allocator = allocator;
    }

    @Override
    protected void run(TargetDescription target, LIRGenerationResult lirGenRes, AllocationContext context) {
        allocator.printIntervals("Before register allocation");
        allocateRegisters();
        allocator.printIntervals("After register allocation");
    }

    @SuppressWarnings("try")
    void allocateRegisters() {
        try (Indent indent = Debug.logAndIndent("allocate registers")) {
            Interval precoloredIntervals;
            Interval notPrecoloredIntervals;

            Interval.Pair result = allocator.createUnhandledLists(LinearScan.IS_PRECOLORED_INTERVAL, LinearScan.IS_VARIABLE_INTERVAL);
            precoloredIntervals = result.first;
            notPrecoloredIntervals = result.second;

            // allocate cpu registers
            LinearScanWalker lsw;
            if (OptimizingLinearScanWalker.Options.LSRAOptimization.getValue()) {
                lsw = new OptimizingLinearScanWalker(allocator, precoloredIntervals, notPrecoloredIntervals);
            } else {
                lsw = new LinearScanWalker(allocator, precoloredIntervals, notPrecoloredIntervals);
            }
            lsw.walk();
            lsw.finishAllocation();
        }
    }

}
