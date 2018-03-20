/*
 * Copyright (c) 2016, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.microbenchmarks.lir;

import java.util.HashMap;

import org.openjdk.jmh.annotations.Benchmark;

import org.graalvm.compiler.core.common.GraalOptions;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.phases.LIRSuites;
import org.graalvm.compiler.microbenchmarks.graal.GraalBenchmark;
import org.graalvm.compiler.microbenchmarks.graal.util.MethodSpec;
import org.graalvm.compiler.options.OptionValue;
import org.graalvm.compiler.options.OptionValue.OverrideScope;

public class RegisterAllocationTimeBenchmark extends GraalBenchmark {

    // Checkstyle: stop method name check
    public static class LSRA_Allocation extends GraalCompilerState.AllocationStage {
        @SuppressWarnings("try")
        @Override
        protected LIRSuites createLIRSuites() {
            try (OverrideScope os = OptionValue.override(GraalOptions.TraceRA, false)) {
                return super.createLIRSuites();
            }
        }
    }

    @MethodSpec(declaringClass = String.class, name = "equals")
    public static class LSRA_StringEquals extends LSRA_Allocation {
    }

    @MethodSpec(declaringClass = HashMap.class, name = "computeIfAbsent")
    public static class LSRA_HashMapComputeIfAbsent extends LSRA_Allocation {
    }

    @Benchmark
    public LIRGenerationResult lsra_STRING_equals(LSRA_StringEquals s) {
        return s.compile();
    }

    @Benchmark
    public LIRGenerationResult lsra_HASHMAP_computeIfAbsent(LSRA_HashMapComputeIfAbsent s) {
        return s.compile();
    }

    public static class TraceRA_Allocation extends GraalCompilerState.AllocationStage {
        @SuppressWarnings("try")
        @Override
        protected LIRSuites createLIRSuites() {
            try (OverrideScope os = OptionValue.override(GraalOptions.TraceRA, true)) {
                return super.createLIRSuites();
            }
        }
    }

    @MethodSpec(declaringClass = String.class, name = "equals")
    public static class TraceRA_StringEquals extends TraceRA_Allocation {
    }

    @MethodSpec(declaringClass = HashMap.class, name = "computeIfAbsent")
    public static class TraceRA_HashMapComputeIfAbsent extends TraceRA_Allocation {
    }

    @Benchmark
    public LIRGenerationResult tracera_STRING_equals(TraceRA_StringEquals s) {
        return s.compile();
    }

    @Benchmark
    public LIRGenerationResult tracera_HASHMAP_computeIfAbsent(TraceRA_HashMapComputeIfAbsent s) {
        return s.compile();
    }
    // Checkstyle: resume method name check
}
