// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: CompilerConfigurationFactory.java
package org.graalvm.compiler.hotspot;

import java.util.*;
import org.graalvm.compiler.options.*;

public class CompilerConfigurationFactory_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("CompilerConfiguration")) {
            return OptionDescriptor.create("CompilerConfiguration", String.class, "Names the Graal compiler configuration to use. If ommitted, the compiler configuration with the highest auto-selection priority is used. To see the set of available configurations, supply the value 'help' to this option.", CompilerConfigurationFactory.Options.class, "CompilerConfiguration", CompilerConfigurationFactory.Options.CompilerConfiguration);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("CompilerConfiguration", String.class, "Names the Graal compiler configuration to use. If ommitted, the compiler configuration with the highest auto-selection priority is used. To see the set of available configurations, supply the value 'help' to this option.", CompilerConfigurationFactory.Options.class, "CompilerConfiguration", CompilerConfigurationFactory.Options.CompilerConfiguration)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
