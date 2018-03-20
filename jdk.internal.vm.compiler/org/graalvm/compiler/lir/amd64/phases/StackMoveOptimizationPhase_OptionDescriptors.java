// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: StackMoveOptimizationPhase.java
package org.graalvm.compiler.lir.amd64.phases;

import java.util.*;
import org.graalvm.compiler.options.*;

public class StackMoveOptimizationPhase_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("LIROptStackMoveOptimizer")) {
            return OptionDescriptor.create("LIROptStackMoveOptimizer", Boolean.class, "", StackMoveOptimizationPhase.Options.class, "LIROptStackMoveOptimizer", StackMoveOptimizationPhase.Options.LIROptStackMoveOptimizer);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("LIROptStackMoveOptimizer", Boolean.class, "", StackMoveOptimizationPhase.Options.class, "LIROptStackMoveOptimizer", StackMoveOptimizationPhase.Options.LIROptStackMoveOptimizer)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
