// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: JavaConstantFieldProvider.java
package org.graalvm.compiler.core.common.spi;

import java.util.*;
import org.graalvm.compiler.options.*;

public class JavaConstantFieldProvider_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("TrustFinalDefaultFields")) {
            return OptionDescriptor.create("TrustFinalDefaultFields", Boolean.class, "Determines whether to treat final fields with default values as constant.", JavaConstantFieldProvider.Options.class, "TrustFinalDefaultFields", JavaConstantFieldProvider.Options.TrustFinalDefaultFields);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("TrustFinalDefaultFields", Boolean.class, "Determines whether to treat final fields with default values as constant.", JavaConstantFieldProvider.Options.class, "TrustFinalDefaultFields", JavaConstantFieldProvider.Options.TrustFinalDefaultFields)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
