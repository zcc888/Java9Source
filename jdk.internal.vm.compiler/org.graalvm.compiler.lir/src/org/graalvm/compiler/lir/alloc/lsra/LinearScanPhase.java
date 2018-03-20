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

import org.graalvm.compiler.core.common.alloc.RegisterAllocationConfig;
import org.graalvm.compiler.lir.alloc.lsra.ssa.SSALinearScan;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.gen.LIRGeneratorTool.MoveFactory;
import org.graalvm.compiler.lir.phases.AllocationPhase;

import jdk.vm.ci.code.TargetDescription;

public final class LinearScanPhase extends AllocationPhase {

    private boolean neverSpillConstants;

    public void setNeverSpillConstants(boolean neverSpillConstants) {
        this.neverSpillConstants = neverSpillConstants;
    }

    @Override
    protected void run(TargetDescription target, LIRGenerationResult lirGenRes, AllocationContext context) {
        MoveFactory spillMoveFactory = context.spillMoveFactory;
        RegisterAllocationConfig registerAllocationConfig = context.registerAllocationConfig;
        final LinearScan allocator = new SSALinearScan(target, lirGenRes, spillMoveFactory, registerAllocationConfig, lirGenRes.getLIR().linearScanOrder(), neverSpillConstants);
        allocator.allocate(target, lirGenRes, spillMoveFactory, registerAllocationConfig);
    }
}
