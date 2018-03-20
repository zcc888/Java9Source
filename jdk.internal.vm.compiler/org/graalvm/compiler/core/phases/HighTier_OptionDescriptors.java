// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: HighTier.java
package org.graalvm.compiler.core.phases;

import java.util.*;
import org.graalvm.compiler.options.*;

public class HighTier_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("Inline")) {
            return OptionDescriptor.create("Inline", Boolean.class, "Enable inlining", HighTier.Options.class, "Inline", HighTier.Options.Inline);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("Inline", Boolean.class, "Enable inlining", HighTier.Options.class, "Inline", HighTier.Options.Inline)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
