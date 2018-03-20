// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: ConstantLoadOptimization.java
package org.graalvm.compiler.lir.constopt;

import java.util.*;
import org.graalvm.compiler.options.*;

public class ConstantLoadOptimization_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("LIROptConstantLoadOptimization")) {
            return OptionDescriptor.create("LIROptConstantLoadOptimization", Boolean.class, "Enable constant load optimization.", ConstantLoadOptimization.Options.class, "LIROptConstantLoadOptimization", ConstantLoadOptimization.Options.LIROptConstantLoadOptimization);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("LIROptConstantLoadOptimization", Boolean.class, "Enable constant load optimization.", ConstantLoadOptimization.Options.class, "LIROptConstantLoadOptimization", ConstantLoadOptimization.Options.LIROptConstantLoadOptimization)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
