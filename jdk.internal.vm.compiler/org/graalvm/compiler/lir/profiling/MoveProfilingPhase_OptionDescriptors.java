// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: MoveProfilingPhase.java
package org.graalvm.compiler.lir.profiling;

import java.util.*;
import org.graalvm.compiler.options.*;

public class MoveProfilingPhase_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("LIRDynMoveProfilMethod")) {
            return OptionDescriptor.create("LIRDynMoveProfilMethod", Boolean.class, "Enable dynamic move profiling per method.", MoveProfilingPhase.Options.class, "LIRDynMoveProfilMethod", MoveProfilingPhase.Options.LIRDynMoveProfilMethod);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("LIRDynMoveProfilMethod", Boolean.class, "Enable dynamic move profiling per method.", MoveProfilingPhase.Options.class, "LIRDynMoveProfilMethod", MoveProfilingPhase.Options.LIRDynMoveProfilMethod)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
