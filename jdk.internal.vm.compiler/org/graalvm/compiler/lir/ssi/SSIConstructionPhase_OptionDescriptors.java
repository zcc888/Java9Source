// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: SSIConstructionPhase.java
package org.graalvm.compiler.lir.ssi;

import java.util.*;
import org.graalvm.compiler.options.*;

public class SSIConstructionPhase_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("TraceRAFastSSIBuilder")) {
            return OptionDescriptor.create("TraceRAFastSSIBuilder", Boolean.class, "Use fast SSI builder.", SSIConstructionPhase.Options.class, "TraceRAFastSSIBuilder", SSIConstructionPhase.Options.TraceRAFastSSIBuilder);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("TraceRAFastSSIBuilder", Boolean.class, "Use fast SSI builder.", SSIConstructionPhase.Options.class, "TraceRAFastSSIBuilder", SSIConstructionPhase.Options.TraceRAFastSSIBuilder)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
