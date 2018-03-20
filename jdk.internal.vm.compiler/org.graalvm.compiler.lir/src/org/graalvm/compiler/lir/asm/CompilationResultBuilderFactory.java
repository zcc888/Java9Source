/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.lir.asm;

import org.graalvm.compiler.asm.Assembler;
import org.graalvm.compiler.code.CompilationResult;
import org.graalvm.compiler.core.common.spi.ForeignCallsProvider;
import org.graalvm.compiler.lir.framemap.FrameMap;

import jdk.vm.ci.code.CodeCacheProvider;

/**
 * Factory class for creating {@link CompilationResultBuilder}s.
 */
public interface CompilationResultBuilderFactory {

    /**
     * Creates a new {@link CompilationResultBuilder}.
     */
    CompilationResultBuilder createBuilder(CodeCacheProvider codeCache, ForeignCallsProvider foreignCalls, FrameMap frameMap, Assembler asm, DataBuilder dataBuilder, FrameContext frameContext,
                    CompilationResult compilationResult);

    /**
     * The default factory creates a standard {@link CompilationResultBuilder}.
     */
    CompilationResultBuilderFactory Default = new CompilationResultBuilderFactory() {

        @Override
        public CompilationResultBuilder createBuilder(CodeCacheProvider codeCache, ForeignCallsProvider foreignCalls, FrameMap frameMap, Assembler asm, DataBuilder dataBuilder,
                        FrameContext frameContext, CompilationResult compilationResult) {
            return new CompilationResultBuilder(codeCache, foreignCalls, frameMap, asm, dataBuilder, frameContext, compilationResult);
        }
    };
}
