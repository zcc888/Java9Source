// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: CompilationWatchDog.java
package org.graalvm.compiler.hotspot;

import java.util.*;
import org.graalvm.compiler.options.*;

public class CompilationWatchDog_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "CompilationWatchDogStackTraceInterval": return OptionDescriptor.create("CompilationWatchDogStackTraceInterval", Double.class, "Interval in seconds between a watch dog reporting stack traces for long running compilations.", CompilationWatchDog.Options.class, "CompilationWatchDogStackTraceInterval", CompilationWatchDog.Options.CompilationWatchDogStackTraceInterval);
            case "CompilationWatchDogStartDelay": return OptionDescriptor.create("CompilationWatchDogStartDelay", Double.class, "Delay in seconds before watch dog monitoring a compilation (0 disables monitoring).", CompilationWatchDog.Options.class, "CompilationWatchDogStartDelay", CompilationWatchDog.Options.CompilationWatchDogStartDelay);
            case "NonFatalIdenticalCompilationSnapshots": return OptionDescriptor.create("NonFatalIdenticalCompilationSnapshots", Integer.class, "Number of contiguous identical compiler thread stack traces allowed before the VM exits on the basis of a stuck compilation.", CompilationWatchDog.Options.class, "NonFatalIdenticalCompilationSnapshots", CompilationWatchDog.Options.NonFatalIdenticalCompilationSnapshots);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("CompilationWatchDogStackTraceInterval", Double.class, "Interval in seconds between a watch dog reporting stack traces for long running compilations.", CompilationWatchDog.Options.class, "CompilationWatchDogStackTraceInterval", CompilationWatchDog.Options.CompilationWatchDogStackTraceInterval),
            OptionDescriptor.create("CompilationWatchDogStartDelay", Double.class, "Delay in seconds before watch dog monitoring a compilation (0 disables monitoring).", CompilationWatchDog.Options.class, "CompilationWatchDogStartDelay", CompilationWatchDog.Options.CompilationWatchDogStartDelay),
            OptionDescriptor.create("NonFatalIdenticalCompilationSnapshots", Integer.class, "Number of contiguous identical compiler thread stack traces allowed before the VM exits on the basis of a stuck compilation.", CompilationWatchDog.Options.class, "NonFatalIdenticalCompilationSnapshots", CompilationWatchDog.Options.NonFatalIdenticalCompilationSnapshots)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
