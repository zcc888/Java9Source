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
package org.graalvm.compiler.lir.alloc.trace.lsra;

import org.graalvm.compiler.core.common.alloc.Trace;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.Indent;
import org.graalvm.compiler.lir.alloc.trace.lsra.TraceLinearScanPhase.TraceLinearScan;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;

import jdk.vm.ci.code.TargetDescription;

final class TraceLinearScanRegisterAllocationPhase extends TraceLinearScanAllocationPhase {

    @Override
    protected void run(TargetDescription target, LIRGenerationResult lirGenRes, Trace trace, TraceLinearScanAllocationContext context) {
        TraceLinearScan allocator = context.allocator;
        allocateRegisters(allocator);
    }

    @SuppressWarnings("try")
    private static void allocateRegisters(TraceLinearScan allocator) {
        try (Indent indent = Debug.logAndIndent("allocate registers")) {
            FixedInterval precoloredIntervals = allocator.createFixedUnhandledList();
            TraceInterval notPrecoloredIntervals = allocator.createUnhandledListByFrom(TraceLinearScanPhase.IS_VARIABLE_INTERVAL);

            // allocate cpu registers
            TraceLinearScanWalker lsw = new TraceLinearScanWalker(allocator, precoloredIntervals, notPrecoloredIntervals);
            lsw.walk();
            lsw.finishAllocation();
        }
    }

}
