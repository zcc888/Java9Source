// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: BasePhase.java
package org.graalvm.compiler.phases;

import java.util.*;
import org.graalvm.compiler.options.*;

public class BasePhase_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("VerifyGraalPhasesSize")) {
            return OptionDescriptor.create("VerifyGraalPhasesSize", Boolean.class, "Verify before - after relation of the relative, computed, code size of a graph", BasePhase.PhaseOptions.class, "VerifyGraalPhasesSize", BasePhase.PhaseOptions.VerifyGraalPhasesSize);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("VerifyGraalPhasesSize", Boolean.class, "Verify before - after relation of the relative, computed, code size of a graph", BasePhase.PhaseOptions.class, "VerifyGraalPhasesSize", BasePhase.PhaseOptions.VerifyGraalPhasesSize)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
