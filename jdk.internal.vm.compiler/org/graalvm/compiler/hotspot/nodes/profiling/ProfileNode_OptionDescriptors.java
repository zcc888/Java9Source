// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: ProfileNode.java
package org.graalvm.compiler.hotspot.nodes.profiling;

import java.util.*;
import org.graalvm.compiler.options.*;

public class ProfileNode_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("ProbabilisticProfiling")) {
            return OptionDescriptor.create("ProbabilisticProfiling", Boolean.class, "Control probabilistic profiling on AMD64", ProfileNode.Options.class, "ProbabilisticProfiling", ProfileNode.Options.ProbabilisticProfiling);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("ProbabilisticProfiling", Boolean.class, "Control probabilistic profiling on AMD64", ProfileNode.Options.class, "ProbabilisticProfiling", ProfileNode.Options.ProbabilisticProfiling)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
