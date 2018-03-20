// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: CompilationAlarm.java
package org.graalvm.compiler.core.common.util;

import java.util.*;
import org.graalvm.compiler.options.*;

public class CompilationAlarm_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("CompilationExpirationPeriod")) {
            return OptionDescriptor.create("CompilationExpirationPeriod", Integer.class, "Time limit in seconds before a compilation expires (0 to disable the limit).", CompilationAlarm.Options.class, "CompilationExpirationPeriod", CompilationAlarm.Options.CompilationExpirationPeriod);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("CompilationExpirationPeriod", Integer.class, "Time limit in seconds before a compilation expires (0 to disable the limit).", CompilationAlarm.Options.class, "CompilationExpirationPeriod", CompilationAlarm.Options.CompilationExpirationPeriod)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
