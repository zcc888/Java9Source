/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.core;

import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.OptionValue;

/**
 * Options related to {@link GraalCompiler}.
 */
public class GraalCompilerOptions {

    // @formatter:off
    @Option(help = "Repeatedly run the LIR code generation pass to improve statistical profiling results.", type = OptionType.Debug)
    public static final OptionValue<Integer> EmitLIRRepeatCount = new OptionValue<>(0);
    @Option(help = "", type = OptionType.Debug)
    public static final OptionValue<String> PrintFilter = new OptionValue<>(null);
    @Option(help = "", type = OptionType.Debug)
    public static final OptionValue<Boolean> PrintCompilation = new OptionValue<>(false);
    @Option(help = "", type = OptionType.Debug)
    public static final OptionValue<Boolean> PrintAfterCompilation = new OptionValue<>(false);
    @Option(help = "", type = OptionType.Debug)
    public static final OptionValue<Boolean> PrintBailout = new OptionValue<>(false);
    @Option(help = "", type = OptionType.Debug)
    public static final OptionValue<Boolean> ExitVMOnBailout = new OptionValue<>(false);
    @Option(help = "", type = OptionType.Debug)
    public static final OptionValue<Boolean> ExitVMOnException = new OptionValue<>(false);
    @Option(help = "", type = OptionType.Debug)
    public static final OptionValue<Boolean> PrintStackTraceOnException = new OptionValue<>(false);
    // @formatter:on

}
