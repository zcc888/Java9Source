// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: InliningPhase.java
package org.graalvm.compiler.phases.common.inlining;

import java.util.*;
import org.graalvm.compiler.options.*;

public class InliningPhase_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "AlwaysInlineIntrinsics": return OptionDescriptor.create("AlwaysInlineIntrinsics", Boolean.class, "Unconditionally inline intrinsics", InliningPhase.Options.class, "AlwaysInlineIntrinsics", InliningPhase.Options.AlwaysInlineIntrinsics);
            case "MethodInlineBailoutLimit": return OptionDescriptor.create("MethodInlineBailoutLimit", Integer.class, "Per-compilation method inlining exploration limit before giving up (use 0 to disable)", InliningPhase.Options.class, "MethodInlineBailoutLimit", InliningPhase.Options.MethodInlineBailoutLimit);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("AlwaysInlineIntrinsics", Boolean.class, "Unconditionally inline intrinsics", InliningPhase.Options.class, "AlwaysInlineIntrinsics", InliningPhase.Options.AlwaysInlineIntrinsics),
            OptionDescriptor.create("MethodInlineBailoutLimit", Integer.class, "Per-compilation method inlining exploration limit before giving up (use 0 to disable)", InliningPhase.Options.class, "MethodInlineBailoutLimit", InliningPhase.Options.MethodInlineBailoutLimit)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
