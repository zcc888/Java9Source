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
package org.graalvm.compiler.microbenchmarks.graal;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

@Warmup(iterations = 1)
@Measurement(iterations = 1)
@Fork(1)
/**
 * This dummy class is used to verify that the JMH microbenchmarking environment is set up properly.
 */
public class TestJMH {

    @Benchmark
    public void testJMH() {
        // This method was intentionally left blank.
    }

}
