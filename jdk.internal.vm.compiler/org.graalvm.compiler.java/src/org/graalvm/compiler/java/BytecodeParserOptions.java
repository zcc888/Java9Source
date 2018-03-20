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
package org.graalvm.compiler.java;

import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.OptionValue;
import org.graalvm.compiler.options.StableOptionValue;

/**
 * Options related to {@link BytecodeParser}.
 *
 * Note: This must be a top level class to work around for
 * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=477597">Eclipse bug 477597</a>.
 */
public class BytecodeParserOptions {
    // @formatter:off
    @Option(help = "The trace level for the bytecode parser used when building a graph from bytecode", type = OptionType.Debug)
    public static final OptionValue<Integer> TraceBytecodeParserLevel = new OptionValue<>(0);

    @Option(help = "Inlines trivial methods during bytecode parsing.", type = OptionType.Expert)
    public static final StableOptionValue<Boolean> InlineDuringParsing = new StableOptionValue<>(true);

    @Option(help = "Inlines intrinsic methods during bytecode parsing.", type = OptionType.Expert)
    public static final StableOptionValue<Boolean> InlineIntrinsicsDuringParsing = new StableOptionValue<>(true);

    @Option(help = "Traces inlining performed during bytecode parsing.", type = OptionType.Debug)
    public static final StableOptionValue<Boolean> TraceInlineDuringParsing = new StableOptionValue<>(false);

    @Option(help = "Traces use of plugins during bytecode parsing.", type = OptionType.Debug)
    public static final StableOptionValue<Boolean> TraceParserPlugins = new StableOptionValue<>(false);

    @Option(help = "Maximum depth when inlining during bytecode parsing.", type = OptionType.Debug)
    public static final StableOptionValue<Integer> InlineDuringParsingMaxDepth = new StableOptionValue<>(10);

    @Option(help = "Dump graphs after non-trivial changes during bytecode parsing.", type = OptionType.Debug)
    public static final StableOptionValue<Boolean> DumpDuringGraphBuilding = new StableOptionValue<>(false);

    @Option(help = "When creating info points hide the methods of the substitutions.", type = OptionType.Debug)
    public static final OptionValue<Boolean> HideSubstitutionStates = new OptionValue<>(false);

    @Option(help = "Use intrinsics guarded by a virtual dispatch test at indirect call sites.", type = OptionType.Debug)
    public static final OptionValue<Boolean> UseGuardedIntrinsics = new OptionValue<>(true);
    // @formatter:on
}
