// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: HotSpotProfilingPlugin.java
package org.graalvm.compiler.hotspot.meta;

import java.util.*;
import org.graalvm.compiler.options.*;

public class HotSpotProfilingPlugin_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "ProfileBackedges": return OptionDescriptor.create("ProfileBackedges", Boolean.class, "Emit profiling of backedges", HotSpotProfilingPlugin.Options.class, "ProfileBackedges", HotSpotProfilingPlugin.Options.ProfileBackedges);
            case "ProfileInvokes": return OptionDescriptor.create("ProfileInvokes", Boolean.class, "Emit profiling of invokes", HotSpotProfilingPlugin.Options.class, "ProfileInvokes", HotSpotProfilingPlugin.Options.ProfileInvokes);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("ProfileBackedges", Boolean.class, "Emit profiling of backedges", HotSpotProfilingPlugin.Options.class, "ProfileBackedges", HotSpotProfilingPlugin.Options.ProfileBackedges),
            OptionDescriptor.create("ProfileInvokes", Boolean.class, "Emit profiling of invokes", HotSpotProfilingPlugin.Options.class, "ProfileInvokes", HotSpotProfilingPlugin.Options.ProfileInvokes)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
