// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: CompilationCounters.java
package org.graalvm.compiler.hotspot;

import java.util.*;
import org.graalvm.compiler.options.*;

public class CompilationCounters_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("CompilationCountLimit")) {
            return OptionDescriptor.create("CompilationCountLimit", Integer.class, "The number of compilations allowed for any method before the VM exits (a value of 0 means there is no limit).", CompilationCounters.Options.class, "CompilationCountLimit", CompilationCounters.Options.CompilationCountLimit);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("CompilationCountLimit", Integer.class, "The number of compilations allowed for any method before the VM exits (a value of 0 means there is no limit).", CompilationCounters.Options.class, "CompilationCountLimit", CompilationCounters.Options.CompilationCountLimit)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
