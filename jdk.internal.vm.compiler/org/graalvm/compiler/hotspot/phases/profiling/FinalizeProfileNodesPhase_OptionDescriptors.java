// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: FinalizeProfileNodesPhase.java
package org.graalvm.compiler.hotspot.phases.profiling;

import java.util.*;
import org.graalvm.compiler.options.*;

public class FinalizeProfileNodesPhase_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "ProfileSimpleMethods": return OptionDescriptor.create("ProfileSimpleMethods", Boolean.class, "Profile simple methods", FinalizeProfileNodesPhase.Options.class, "ProfileSimpleMethods", FinalizeProfileNodesPhase.Options.ProfileSimpleMethods);
            case "SimpleMethodCalls": return OptionDescriptor.create("SimpleMethodCalls", Integer.class, "Maximum number of calls in a simple method", FinalizeProfileNodesPhase.Options.class, "SimpleMethodCalls", FinalizeProfileNodesPhase.Options.SimpleMethodCalls);
            case "SimpleMethodGraphSize": return OptionDescriptor.create("SimpleMethodGraphSize", Integer.class, "Maximum number of nodes in a graph for a simple method", FinalizeProfileNodesPhase.Options.class, "SimpleMethodGraphSize", FinalizeProfileNodesPhase.Options.SimpleMethodGraphSize);
            case "SimpleMethodIndirectCalls": return OptionDescriptor.create("SimpleMethodIndirectCalls", Integer.class, "Maximum number of indirect calls in a simple moethod", FinalizeProfileNodesPhase.Options.class, "SimpleMethodIndirectCalls", FinalizeProfileNodesPhase.Options.SimpleMethodIndirectCalls);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("ProfileSimpleMethods", Boolean.class, "Profile simple methods", FinalizeProfileNodesPhase.Options.class, "ProfileSimpleMethods", FinalizeProfileNodesPhase.Options.ProfileSimpleMethods),
            OptionDescriptor.create("SimpleMethodCalls", Integer.class, "Maximum number of calls in a simple method", FinalizeProfileNodesPhase.Options.class, "SimpleMethodCalls", FinalizeProfileNodesPhase.Options.SimpleMethodCalls),
            OptionDescriptor.create("SimpleMethodGraphSize", Integer.class, "Maximum number of nodes in a graph for a simple method", FinalizeProfileNodesPhase.Options.class, "SimpleMethodGraphSize", FinalizeProfileNodesPhase.Options.SimpleMethodGraphSize),
            OptionDescriptor.create("SimpleMethodIndirectCalls", Integer.class, "Maximum number of indirect calls in a simple moethod", FinalizeProfileNodesPhase.Options.class, "SimpleMethodIndirectCalls", FinalizeProfileNodesPhase.Options.SimpleMethodIndirectCalls)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
