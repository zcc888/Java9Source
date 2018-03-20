// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: PartialEscapePhase.java
package org.graalvm.compiler.virtual.phases.ea;

import java.util.*;
import org.graalvm.compiler.options.*;

public class PartialEscapePhase_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("OptEarlyReadElimination")) {
            return OptionDescriptor.create("OptEarlyReadElimination", Boolean.class, "", PartialEscapePhase.Options.class, "OptEarlyReadElimination", PartialEscapePhase.Options.OptEarlyReadElimination);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("OptEarlyReadElimination", Boolean.class, "", PartialEscapePhase.Options.class, "OptEarlyReadElimination", PartialEscapePhase.Options.OptEarlyReadElimination)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
