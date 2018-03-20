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

import org.graalvm.compiler.core.common.alloc.RegisterAllocationConfig;
import org.graalvm.compiler.core.common.alloc.TraceBuilderResult;
import org.graalvm.compiler.lir.alloc.trace.TraceAllocationPhase;
import org.graalvm.compiler.lir.alloc.trace.lsra.TraceLinearScanPhase.TraceLinearScan;
import org.graalvm.compiler.lir.gen.LIRGeneratorTool.MoveFactory;

abstract class TraceLinearScanAllocationPhase extends TraceAllocationPhase<TraceLinearScanAllocationPhase.TraceLinearScanAllocationContext> {

    static final class TraceLinearScanAllocationContext extends TraceAllocationPhase.TraceAllocationContext {
        public final TraceLinearScan allocator;

        TraceLinearScanAllocationContext(MoveFactory spillMoveFactory, RegisterAllocationConfig registerAllocationConfig, TraceBuilderResult traceBuilderResult, TraceLinearScan allocator) {
            super(spillMoveFactory, registerAllocationConfig, traceBuilderResult);
            this.allocator = allocator;
        }
    }
}
