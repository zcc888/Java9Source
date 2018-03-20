// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: BenchmarkCounters.java
package org.graalvm.compiler.hotspot.debug;

import java.util.*;
import org.graalvm.compiler.options.*;

public class BenchmarkCounters_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "BenchmarkCountersDumpDynamic": return OptionDescriptor.create("BenchmarkCountersDumpDynamic", Boolean.class, "Dump dynamic counters", BenchmarkCounters.Options.class, "BenchmarkCountersDumpDynamic", BenchmarkCounters.Options.BenchmarkCountersDumpDynamic);
            case "BenchmarkCountersDumpStatic": return OptionDescriptor.create("BenchmarkCountersDumpStatic", Boolean.class, "Dump static counters", BenchmarkCounters.Options.class, "BenchmarkCountersDumpStatic", BenchmarkCounters.Options.BenchmarkCountersDumpStatic);
            case "BenchmarkCountersFile": return OptionDescriptor.create("BenchmarkCountersFile", String.class, "Benchmark counters log file (default is stdout)", BenchmarkCounters.Options.class, "BenchmarkCountersFile", BenchmarkCounters.Options.BenchmarkCountersFile);
            case "BenchmarkDynamicCounters": return OptionDescriptor.create("BenchmarkDynamicCounters", String.class, "Turn on the benchmark counters, and listen for specific patterns on System.out/System.err:%nFormat: (err|out),start pattern,end pattern (~ matches multiple digits)%nExamples:%n  dacapo = 'err, starting =====, PASSED in'%n  specjvm2008 = 'out,Iteration ~ (~s) begins:,Iteration ~ (~s) ends:'", BenchmarkCounters.Options.class, "BenchmarkDynamicCounters", BenchmarkCounters.Options.BenchmarkDynamicCounters);
            case "DynamicCountersHumanReadable": return OptionDescriptor.create("DynamicCountersHumanReadable", Boolean.class, "Print in human readable format", BenchmarkCounters.Options.class, "DynamicCountersHumanReadable", BenchmarkCounters.Options.DynamicCountersHumanReadable);
            case "DynamicCountersPrintGroupSeparator": return OptionDescriptor.create("DynamicCountersPrintGroupSeparator", Boolean.class, "Use grouping separators for number printing", BenchmarkCounters.Options.class, "DynamicCountersPrintGroupSeparator", BenchmarkCounters.Options.DynamicCountersPrintGroupSeparator);
            case "GenericDynamicCounters": return OptionDescriptor.create("GenericDynamicCounters", Boolean.class, "Turn on the benchmark counters, and displays the results on VM shutdown", BenchmarkCounters.Options.class, "GenericDynamicCounters", BenchmarkCounters.Options.GenericDynamicCounters);
            case "TimedDynamicCounters": return OptionDescriptor.create("TimedDynamicCounters", Integer.class, "Turn on the benchmark counters, and displays the results every n milliseconds", BenchmarkCounters.Options.class, "TimedDynamicCounters", BenchmarkCounters.Options.TimedDynamicCounters);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("BenchmarkCountersDumpDynamic", Boolean.class, "Dump dynamic counters", BenchmarkCounters.Options.class, "BenchmarkCountersDumpDynamic", BenchmarkCounters.Options.BenchmarkCountersDumpDynamic),
            OptionDescriptor.create("BenchmarkCountersDumpStatic", Boolean.class, "Dump static counters", BenchmarkCounters.Options.class, "BenchmarkCountersDumpStatic", BenchmarkCounters.Options.BenchmarkCountersDumpStatic),
            OptionDescriptor.create("BenchmarkCountersFile", String.class, "Benchmark counters log file (default is stdout)", BenchmarkCounters.Options.class, "BenchmarkCountersFile", BenchmarkCounters.Options.BenchmarkCountersFile),
            OptionDescriptor.create("BenchmarkDynamicCounters", String.class, "Turn on the benchmark counters, and listen for specific patterns on System.out/System.err:%nFormat: (err|out),start pattern,end pattern (~ matches multiple digits)%nExamples:%n  dacapo = 'err, starting =====, PASSED in'%n  specjvm2008 = 'out,Iteration ~ (~s) begins:,Iteration ~ (~s) ends:'", BenchmarkCounters.Options.class, "BenchmarkDynamicCounters", BenchmarkCounters.Options.BenchmarkDynamicCounters),
            OptionDescriptor.create("DynamicCountersHumanReadable", Boolean.class, "Print in human readable format", BenchmarkCounters.Options.class, "DynamicCountersHumanReadable", BenchmarkCounters.Options.DynamicCountersHumanReadable),
            OptionDescriptor.create("DynamicCountersPrintGroupSeparator", Boolean.class, "Use grouping separators for number printing", BenchmarkCounters.Options.class, "DynamicCountersPrintGroupSeparator", BenchmarkCounters.Options.DynamicCountersPrintGroupSeparator),
            OptionDescriptor.create("GenericDynamicCounters", Boolean.class, "Turn on the benchmark counters, and displays the results on VM shutdown", BenchmarkCounters.Options.class, "GenericDynamicCounters", BenchmarkCounters.Options.GenericDynamicCounters),
            OptionDescriptor.create("TimedDynamicCounters", Integer.class, "Turn on the benchmark counters, and displays the results every n milliseconds", BenchmarkCounters.Options.class, "TimedDynamicCounters", BenchmarkCounters.Options.TimedDynamicCounters)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
