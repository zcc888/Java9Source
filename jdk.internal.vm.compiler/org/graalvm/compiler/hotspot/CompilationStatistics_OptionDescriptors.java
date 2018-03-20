// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: CompilationStatistics.java
package org.graalvm.compiler.hotspot;

import java.util.*;
import org.graalvm.compiler.options.*;

public class CompilationStatistics_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("UseCompilationStatistics")) {
            return OptionDescriptor.create("UseCompilationStatistics", Boolean.class, "Enables CompilationStatistics.", CompilationStatistics.Options.class, "UseCompilationStatistics", CompilationStatistics.Options.UseCompilationStatistics);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("UseCompilationStatistics", Boolean.class, "Enables CompilationStatistics.", CompilationStatistics.Options.class, "UseCompilationStatistics", CompilationStatistics.Options.UseCompilationStatistics)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
