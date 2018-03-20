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
package org.graalvm.compiler.hotspot;

import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.OptionValue;

/**
 * Options related to {@link CompileTheWorld}.
 *
 * Note: This must be a top level class to work around for
 * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=477597">Eclipse bug 477597</a>.
 */
public class CompileTheWorldOptions {
    // @formatter:off
    @Option(help = "Class path denoting methods to compile", type = OptionType.Debug)
    public static final OptionValue<String> CompileTheWorldClasspath = new OptionValue<>(CompileTheWorld.SUN_BOOT_CLASS_PATH);
    @Option(help = "Verbose CompileTheWorld operation", type = OptionType.Debug)
    public static final OptionValue<Boolean> CompileTheWorldVerbose = new OptionValue<>(true);
    @Option(help = "The number of CompileTheWorld iterations to perform", type = OptionType.Debug)
    public static final OptionValue<Integer> CompileTheWorldIterations = new OptionValue<>(1);
    @Option(help = "Only compile methods matching this filter", type = OptionType.Debug)
    public static final OptionValue<String> CompileTheWorldMethodFilter = new OptionValue<>(null);
    @Option(help = "Exclude methods matching this filter from compilation", type = OptionType.Debug)
    public static final OptionValue<String> CompileTheWorldExcludeMethodFilter = new OptionValue<>(null);
    @Option(help = "First class to consider when using -XX:+CompileTheWorld", type = OptionType.Debug)
    public static final OptionValue<Integer> CompileTheWorldStartAt = new OptionValue<>(1);
    @Option(help = "Last class to consider when using -XX:+CompileTheWorld", type = OptionType.Debug)
    public static final OptionValue<Integer> CompileTheWorldStopAt = new OptionValue<>(Integer.MAX_VALUE);
    @Option(help = "Option value overrides to use during compile the world. For example, " +
                   "to disable inlining and partial escape analysis specify 'PartialEscapeAnalysis=false Inline=false'. " +
                   "The format for each option is the same as on the command line just without the '-Dgraal.' prefix.", type = OptionType.Debug)
    public static final OptionValue<String> CompileTheWorldConfig = new OptionValue<>(null);

    @Option(help = "Run CTW using as many threads as there are processors on the system", type = OptionType.Debug)
    public static final OptionValue<Boolean> CompileTheWorldMultiThreaded = new OptionValue<>(false);
    @Option(help = "Number of threads to use for multithreaded CTW.  Defaults to Runtime.getRuntime().availableProcessors()", type = OptionType.Debug)
    public static final OptionValue<Integer> CompileTheWorldThreads = new OptionValue<>(0);
    // @formatter:on

    /**
     * Overrides {@link #CompileTheWorldStartAt} and {@link #CompileTheWorldStopAt} from {@code -XX}
     * HotSpot options of the same name if the latter have non-default values.
     */
    public static void overrideWithNativeOptions(GraalHotSpotVMConfig c) {
        if (c.compileTheWorldStartAt != 1) {
            CompileTheWorldStartAt.setValue(c.compileTheWorldStartAt);
        }
        if (c.compileTheWorldStopAt != Integer.MAX_VALUE) {
            CompileTheWorldStopAt.setValue(c.compileTheWorldStopAt);
        }
    }
}
