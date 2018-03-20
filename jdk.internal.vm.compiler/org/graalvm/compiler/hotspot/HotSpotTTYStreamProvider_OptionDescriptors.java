// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: HotSpotTTYStreamProvider.java
package org.graalvm.compiler.hotspot;

import java.util.*;
import org.graalvm.compiler.options.*;

public class HotSpotTTYStreamProvider_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("LogFile")) {
            return OptionDescriptor.create("LogFile", String.class, "File to which logging is sent.  A %p in the name will be replaced with a string identifying the process, usually the process id and %t will be replaced by System.currentTimeMillis().", HotSpotTTYStreamProvider.Options.class, "LogFile", HotSpotTTYStreamProvider.Options.LogFile);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("LogFile", String.class, "File to which logging is sent.  A %p in the name will be replaced with a string identifying the process, usually the process id and %t will be replaced by System.currentTimeMillis().", HotSpotTTYStreamProvider.Options.class, "LogFile", HotSpotTTYStreamProvider.Options.LogFile)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
