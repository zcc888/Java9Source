// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: CompileTheWorldOptions.java
package org.graalvm.compiler.hotspot;

import java.util.*;
import org.graalvm.compiler.options.*;

public class CompileTheWorldOptions_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "CompileTheWorldClasspath": return OptionDescriptor.create("CompileTheWorldClasspath", String.class, "Class path denoting methods to compile", CompileTheWorldOptions.class, "CompileTheWorldClasspath", CompileTheWorldOptions.CompileTheWorldClasspath);
            case "CompileTheWorldConfig": return OptionDescriptor.create("CompileTheWorldConfig", String.class, "Option value overrides to use during compile the world. For example, to disable inlining and partial escape analysis specify 'PartialEscapeAnalysis=false Inline=false'. The format for each option is the same as on the command line just without the '-Dgraal.' prefix.", CompileTheWorldOptions.class, "CompileTheWorldConfig", CompileTheWorldOptions.CompileTheWorldConfig);
            case "CompileTheWorldExcludeMethodFilter": return OptionDescriptor.create("CompileTheWorldExcludeMethodFilter", String.class, "Exclude methods matching this filter from compilation", CompileTheWorldOptions.class, "CompileTheWorldExcludeMethodFilter", CompileTheWorldOptions.CompileTheWorldExcludeMethodFilter);
            case "CompileTheWorldIterations": return OptionDescriptor.create("CompileTheWorldIterations", Integer.class, "The number of CompileTheWorld iterations to perform", CompileTheWorldOptions.class, "CompileTheWorldIterations", CompileTheWorldOptions.CompileTheWorldIterations);
            case "CompileTheWorldMethodFilter": return OptionDescriptor.create("CompileTheWorldMethodFilter", String.class, "Only compile methods matching this filter", CompileTheWorldOptions.class, "CompileTheWorldMethodFilter", CompileTheWorldOptions.CompileTheWorldMethodFilter);
            case "CompileTheWorldMultiThreaded": return OptionDescriptor.create("CompileTheWorldMultiThreaded", Boolean.class, "Run CTW using as many threads as there are processors on the system", CompileTheWorldOptions.class, "CompileTheWorldMultiThreaded", CompileTheWorldOptions.CompileTheWorldMultiThreaded);
            case "CompileTheWorldStartAt": return OptionDescriptor.create("CompileTheWorldStartAt", Integer.class, "First class to consider when using -XX:+CompileTheWorld", CompileTheWorldOptions.class, "CompileTheWorldStartAt", CompileTheWorldOptions.CompileTheWorldStartAt);
            case "CompileTheWorldStopAt": return OptionDescriptor.create("CompileTheWorldStopAt", Integer.class, "Last class to consider when using -XX:+CompileTheWorld", CompileTheWorldOptions.class, "CompileTheWorldStopAt", CompileTheWorldOptions.CompileTheWorldStopAt);
            case "CompileTheWorldThreads": return OptionDescriptor.create("CompileTheWorldThreads", Integer.class, "Number of threads to use for multithreaded CTW.  Defaults to Runtime.getRuntime().availableProcessors()", CompileTheWorldOptions.class, "CompileTheWorldThreads", CompileTheWorldOptions.CompileTheWorldThreads);
            case "CompileTheWorldVerbose": return OptionDescriptor.create("CompileTheWorldVerbose", Boolean.class, "Verbose CompileTheWorld operation", CompileTheWorldOptions.class, "CompileTheWorldVerbose", CompileTheWorldOptions.CompileTheWorldVerbose);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("CompileTheWorldClasspath", String.class, "Class path denoting methods to compile", CompileTheWorldOptions.class, "CompileTheWorldClasspath", CompileTheWorldOptions.CompileTheWorldClasspath),
            OptionDescriptor.create("CompileTheWorldConfig", String.class, "Option value overrides to use during compile the world. For example, to disable inlining and partial escape analysis specify 'PartialEscapeAnalysis=false Inline=false'. The format for each option is the same as on the command line just without the '-Dgraal.' prefix.", CompileTheWorldOptions.class, "CompileTheWorldConfig", CompileTheWorldOptions.CompileTheWorldConfig),
            OptionDescriptor.create("CompileTheWorldExcludeMethodFilter", String.class, "Exclude methods matching this filter from compilation", CompileTheWorldOptions.class, "CompileTheWorldExcludeMethodFilter", CompileTheWorldOptions.CompileTheWorldExcludeMethodFilter),
            OptionDescriptor.create("CompileTheWorldIterations", Integer.class, "The number of CompileTheWorld iterations to perform", CompileTheWorldOptions.class, "CompileTheWorldIterations", CompileTheWorldOptions.CompileTheWorldIterations),
            OptionDescriptor.create("CompileTheWorldMethodFilter", String.class, "Only compile methods matching this filter", CompileTheWorldOptions.class, "CompileTheWorldMethodFilter", CompileTheWorldOptions.CompileTheWorldMethodFilter),
            OptionDescriptor.create("CompileTheWorldMultiThreaded", Boolean.class, "Run CTW using as many threads as there are processors on the system", CompileTheWorldOptions.class, "CompileTheWorldMultiThreaded", CompileTheWorldOptions.CompileTheWorldMultiThreaded),
            OptionDescriptor.create("CompileTheWorldStartAt", Integer.class, "First class to consider when using -XX:+CompileTheWorld", CompileTheWorldOptions.class, "CompileTheWorldStartAt", CompileTheWorldOptions.CompileTheWorldStartAt),
            OptionDescriptor.create("CompileTheWorldStopAt", Integer.class, "Last class to consider when using -XX:+CompileTheWorld", CompileTheWorldOptions.class, "CompileTheWorldStopAt", CompileTheWorldOptions.CompileTheWorldStopAt),
            OptionDescriptor.create("CompileTheWorldThreads", Integer.class, "Number of threads to use for multithreaded CTW.  Defaults to Runtime.getRuntime().availableProcessors()", CompileTheWorldOptions.class, "CompileTheWorldThreads", CompileTheWorldOptions.CompileTheWorldThreads),
            OptionDescriptor.create("CompileTheWorldVerbose", Boolean.class, "Verbose CompileTheWorld operation", CompileTheWorldOptions.class, "CompileTheWorldVerbose", CompileTheWorldOptions.CompileTheWorldVerbose)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
