// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: LinearScan.java
package org.graalvm.compiler.lir.alloc.lsra;

import java.util.*;
import org.graalvm.compiler.options.*;

public class LinearScan_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("LIROptLSRAOptimizeSpillPosition")) {
            return OptionDescriptor.create("LIROptLSRAOptimizeSpillPosition", Boolean.class, "Enable spill position optimization", LinearScan.Options.class, "LIROptLSRAOptimizeSpillPosition", LinearScan.Options.LIROptLSRAOptimizeSpillPosition);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("LIROptLSRAOptimizeSpillPosition", Boolean.class, "Enable spill position optimization", LinearScan.Options.class, "LIROptLSRAOptimizeSpillPosition", LinearScan.Options.LIROptLSRAOptimizeSpillPosition)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
