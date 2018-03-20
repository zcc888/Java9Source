// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: Fingerprint.java
package org.graalvm.compiler.debug;

import java.util.*;
import org.graalvm.compiler.options.*;

public class Fingerprint_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "FingerprintErrorEventTailLength": return OptionDescriptor.create("FingerprintErrorEventTailLength", Integer.class, "Limit number of events shown in fingerprinting error message.", Fingerprint.Options.class, "FingerprintErrorEventTailLength", Fingerprint.Options.FingerprintErrorEventTailLength);
            case "FingerprintingBreakpointEvent": return OptionDescriptor.create("FingerprintingBreakpointEvent", Integer.class, "Fingerprinting event at which to execute breakpointable code.", Fingerprint.Options.class, "FingerprintingBreakpointEvent", Fingerprint.Options.FingerprintingBreakpointEvent);
            case "UseFingerprinting": return OptionDescriptor.create("UseFingerprinting", Boolean.class, "Enables execution fingerprinting.", Fingerprint.Options.class, "UseFingerprinting", Fingerprint.Options.UseFingerprinting);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("FingerprintErrorEventTailLength", Integer.class, "Limit number of events shown in fingerprinting error message.", Fingerprint.Options.class, "FingerprintErrorEventTailLength", Fingerprint.Options.FingerprintErrorEventTailLength),
            OptionDescriptor.create("FingerprintingBreakpointEvent", Integer.class, "Fingerprinting event at which to execute breakpointable code.", Fingerprint.Options.class, "FingerprintingBreakpointEvent", Fingerprint.Options.FingerprintingBreakpointEvent),
            OptionDescriptor.create("UseFingerprinting", Boolean.class, "Enables execution fingerprinting.", Fingerprint.Options.class, "UseFingerprinting", Fingerprint.Options.UseFingerprinting)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
