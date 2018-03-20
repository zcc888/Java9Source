// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: BootstrapWatchDog.java
package org.graalvm.compiler.hotspot;

import java.util.*;
import org.graalvm.compiler.options.*;

public class BootstrapWatchDog_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "BootstrapTimeout": return OptionDescriptor.create("BootstrapTimeout", Double.class, "Maximum time in minutes to spend bootstrapping (0 to disable this limit).", BootstrapWatchDog.Options.class, "BootstrapTimeout", BootstrapWatchDog.Options.BootstrapTimeout);
            case "BootstrapWatchDogCriticalRateRatio": return OptionDescriptor.create("BootstrapWatchDogCriticalRateRatio", Double.class, "Ratio of the maximum compilation rate below which the bootstrap compilation rate must not fall (0 or less disables monitoring).", BootstrapWatchDog.Options.class, "BootstrapWatchDogCriticalRateRatio", BootstrapWatchDog.Options.BootstrapWatchDogCriticalRateRatio);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("BootstrapTimeout", Double.class, "Maximum time in minutes to spend bootstrapping (0 to disable this limit).", BootstrapWatchDog.Options.class, "BootstrapTimeout", BootstrapWatchDog.Options.BootstrapTimeout),
            OptionDescriptor.create("BootstrapWatchDogCriticalRateRatio", Double.class, "Ratio of the maximum compilation rate below which the bootstrap compilation rate must not fall (0 or less disables monitoring).", BootstrapWatchDog.Options.class, "BootstrapWatchDogCriticalRateRatio", BootstrapWatchDog.Options.BootstrapWatchDogCriticalRateRatio)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
