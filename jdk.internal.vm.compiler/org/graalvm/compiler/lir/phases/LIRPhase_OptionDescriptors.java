// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: LIRPhase.java
package org.graalvm.compiler.lir.phases;

import java.util.*;
import org.graalvm.compiler.options.*;

public class LIRPhase_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("LIROptimization")) {
            return OptionDescriptor.create("LIROptimization", Boolean.class, "Enable LIR level optimiztations.", LIRPhase.Options.class, "LIROptimization", LIRPhase.Options.LIROptimization);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("LIROptimization", Boolean.class, "Enable LIR level optimiztations.", LIRPhase.Options.class, "LIROptimization", LIRPhase.Options.LIROptimization)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
