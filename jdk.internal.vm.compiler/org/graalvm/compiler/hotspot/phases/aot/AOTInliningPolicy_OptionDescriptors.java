// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: AOTInliningPolicy.java
package org.graalvm.compiler.hotspot.phases.aot;

import java.util.*;
import org.graalvm.compiler.options.*;

public class AOTInliningPolicy_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "AOTInliningDepthToSizeRate": return OptionDescriptor.create("AOTInliningDepthToSizeRate", Double.class, "", AOTInliningPolicy.Options.class, "AOTInliningDepthToSizeRate", AOTInliningPolicy.Options.AOTInliningDepthToSizeRate);
            case "AOTInliningSizeMaximum": return OptionDescriptor.create("AOTInliningSizeMaximum", Integer.class, "", AOTInliningPolicy.Options.class, "AOTInliningSizeMaximum", AOTInliningPolicy.Options.AOTInliningSizeMaximum);
            case "AOTInliningSizeMinimum": return OptionDescriptor.create("AOTInliningSizeMinimum", Integer.class, "", AOTInliningPolicy.Options.class, "AOTInliningSizeMinimum", AOTInliningPolicy.Options.AOTInliningSizeMinimum);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("AOTInliningDepthToSizeRate", Double.class, "", AOTInliningPolicy.Options.class, "AOTInliningDepthToSizeRate", AOTInliningPolicy.Options.AOTInliningDepthToSizeRate),
            OptionDescriptor.create("AOTInliningSizeMaximum", Integer.class, "", AOTInliningPolicy.Options.class, "AOTInliningSizeMaximum", AOTInliningPolicy.Options.AOTInliningSizeMaximum),
            OptionDescriptor.create("AOTInliningSizeMinimum", Integer.class, "", AOTInliningPolicy.Options.class, "AOTInliningSizeMinimum", AOTInliningPolicy.Options.AOTInliningSizeMinimum)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
