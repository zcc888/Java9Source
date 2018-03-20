// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: PEGraphDecoder.java
package org.graalvm.compiler.replacements;

import java.util.*;
import org.graalvm.compiler.options.*;

public class PEGraphDecoder_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "FailedLoopExplosionIsFatal": return OptionDescriptor.create("FailedLoopExplosionIsFatal", Boolean.class, "Do not bail out but throw an exception on failed loop explosion.", PEGraphDecoder.Options.class, "FailedLoopExplosionIsFatal", PEGraphDecoder.Options.FailedLoopExplosionIsFatal);
            case "InliningDepthError": return OptionDescriptor.create("InliningDepthError", Integer.class, "Maximum inlining depth during partial evaluation before reporting an infinite recursion", PEGraphDecoder.Options.class, "InliningDepthError", PEGraphDecoder.Options.InliningDepthError);
            case "MaximumLoopExplosionCount": return OptionDescriptor.create("MaximumLoopExplosionCount", Integer.class, "Max number of loop explosions per method.", PEGraphDecoder.Options.class, "MaximumLoopExplosionCount", PEGraphDecoder.Options.MaximumLoopExplosionCount);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("FailedLoopExplosionIsFatal", Boolean.class, "Do not bail out but throw an exception on failed loop explosion.", PEGraphDecoder.Options.class, "FailedLoopExplosionIsFatal", PEGraphDecoder.Options.FailedLoopExplosionIsFatal),
            OptionDescriptor.create("InliningDepthError", Integer.class, "Maximum inlining depth during partial evaluation before reporting an infinite recursion", PEGraphDecoder.Options.class, "InliningDepthError", PEGraphDecoder.Options.InliningDepthError),
            OptionDescriptor.create("MaximumLoopExplosionCount", Integer.class, "Max number of loop explosions per method.", PEGraphDecoder.Options.class, "MaximumLoopExplosionCount", PEGraphDecoder.Options.MaximumLoopExplosionCount)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
