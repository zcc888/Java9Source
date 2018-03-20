// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: DeadCodeEliminationPhase.java
package org.graalvm.compiler.phases.common;

import java.util.*;
import org.graalvm.compiler.options.*;

public class DeadCodeEliminationPhase_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("ReduceDCE")) {
            return OptionDescriptor.create("ReduceDCE", Boolean.class, "Disable optional dead code eliminations", DeadCodeEliminationPhase.Options.class, "ReduceDCE", DeadCodeEliminationPhase.Options.ReduceDCE);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("ReduceDCE", Boolean.class, "Disable optional dead code eliminations", DeadCodeEliminationPhase.Options.class, "ReduceDCE", DeadCodeEliminationPhase.Options.ReduceDCE)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
