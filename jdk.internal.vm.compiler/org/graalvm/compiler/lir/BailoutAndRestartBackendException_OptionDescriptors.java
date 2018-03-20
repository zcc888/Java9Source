// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: BailoutAndRestartBackendException.java
package org.graalvm.compiler.lir;

import java.util.*;
import org.graalvm.compiler.options.*;

public class BailoutAndRestartBackendException_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("LIRUnlockBackendRestart")) {
            return OptionDescriptor.create("LIRUnlockBackendRestart", Boolean.class, "Unlock backend restart feature.", BailoutAndRestartBackendException.Options.class, "LIRUnlockBackendRestart", BailoutAndRestartBackendException.Options.LIRUnlockBackendRestart);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("LIRUnlockBackendRestart", Boolean.class, "Unlock backend restart feature.", BailoutAndRestartBackendException.Options.class, "LIRUnlockBackendRestart", BailoutAndRestartBackendException.Options.LIRUnlockBackendRestart)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
