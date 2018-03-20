// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: TraceBuilderPhase.java
package org.graalvm.compiler.lir.alloc.trace;

import java.util.*;
import org.graalvm.compiler.options.*;

public class TraceBuilderPhase_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "TraceBuilding": return OptionDescriptor.create("TraceBuilding", org.graalvm.compiler.lir.alloc.trace.TraceBuilderPhase.TraceBuilder.class, "Trace building algorithm.", TraceBuilderPhase.Options.class, "TraceBuilding", TraceBuilderPhase.Options.TraceBuilding);
            case "TraceRAScheduleTrivialTracesEarly": return OptionDescriptor.create("TraceRAScheduleTrivialTracesEarly", Boolean.class, "Schedule trivial traces as early as possible.", TraceBuilderPhase.Options.class, "TraceRAScheduleTrivialTracesEarly", TraceBuilderPhase.Options.TraceRAScheduleTrivialTracesEarly);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("TraceBuilding", org.graalvm.compiler.lir.alloc.trace.TraceBuilderPhase.TraceBuilder.class, "Trace building algorithm.", TraceBuilderPhase.Options.class, "TraceBuilding", TraceBuilderPhase.Options.TraceBuilding),
            OptionDescriptor.create("TraceRAScheduleTrivialTracesEarly", Boolean.class, "Schedule trivial traces as early as possible.", TraceBuilderPhase.Options.class, "TraceRAScheduleTrivialTracesEarly", TraceBuilderPhase.Options.TraceRAScheduleTrivialTracesEarly)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
