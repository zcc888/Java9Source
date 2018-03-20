// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: LowTier.java
package org.graalvm.compiler.core.phases;

import java.util.*;
import org.graalvm.compiler.options.*;

public class LowTier_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("ProfileCompiledMethods")) {
            return OptionDescriptor.create("ProfileCompiledMethods", Boolean.class, "", LowTier.Options.class, "ProfileCompiledMethods", LowTier.Options.ProfileCompiledMethods);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("ProfileCompiledMethods", Boolean.class, "", LowTier.Options.class, "ProfileCompiledMethods", LowTier.Options.ProfileCompiledMethods)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
