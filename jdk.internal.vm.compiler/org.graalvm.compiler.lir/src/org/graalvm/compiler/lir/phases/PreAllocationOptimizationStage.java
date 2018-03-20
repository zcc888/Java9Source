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

import org.graalvm.compiler.lir.alloc.SaveCalleeSaveRegisters;
import org.graalvm.compiler.lir.constopt.ConstantLoadOptimization;
import org.graalvm.compiler.lir.phases.PreAllocationOptimizationPhase.PreAllocationOptimizationContext;

public class PreAllocationOptimizationStage extends LIRPhaseSuite<PreAllocationOptimizationContext> {
    public PreAllocationOptimizationStage() {
        if (ConstantLoadOptimization.Options.LIROptConstantLoadOptimization.getValue()) {
            appendPhase(new ConstantLoadOptimization());
            appendPhase(new SaveCalleeSaveRegisters());
        }
    }
}
