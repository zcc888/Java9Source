// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: HotSpotAOTProfilingPlugin.java
package org.graalvm.compiler.hotspot.meta;

import java.util.*;
import org.graalvm.compiler.options.*;

public class HotSpotAOTProfilingPlugin_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "TierABackedgeNotifyFreqLog": return OptionDescriptor.create("TierABackedgeNotifyFreqLog", Integer.class, "Backedge notification frequency", HotSpotAOTProfilingPlugin.Options.class, "TierABackedgeNotifyFreqLog", HotSpotAOTProfilingPlugin.Options.TierABackedgeNotifyFreqLog);
            case "TierABackedgeProfileProbabilityLog": return OptionDescriptor.create("TierABackedgeProfileProbabilityLog", Integer.class, "Backedge profile probability", HotSpotAOTProfilingPlugin.Options.class, "TierABackedgeProfileProbabilityLog", HotSpotAOTProfilingPlugin.Options.TierABackedgeProfileProbabilityLog);
            case "TierAInvokeInlineeNotifyFreqLog": return OptionDescriptor.create("TierAInvokeInlineeNotifyFreqLog", Integer.class, "Inlinee invocation notification frequency (-1 means count, but do not notify)", HotSpotAOTProfilingPlugin.Options.class, "TierAInvokeInlineeNotifyFreqLog", HotSpotAOTProfilingPlugin.Options.TierAInvokeInlineeNotifyFreqLog);
            case "TierAInvokeNotifyFreqLog": return OptionDescriptor.create("TierAInvokeNotifyFreqLog", Integer.class, "Invocation notification frequency", HotSpotAOTProfilingPlugin.Options.class, "TierAInvokeNotifyFreqLog", HotSpotAOTProfilingPlugin.Options.TierAInvokeNotifyFreqLog);
            case "TierAInvokeProfileProbabilityLog": return OptionDescriptor.create("TierAInvokeProfileProbabilityLog", Integer.class, "Invocation profile probability", HotSpotAOTProfilingPlugin.Options.class, "TierAInvokeProfileProbabilityLog", HotSpotAOTProfilingPlugin.Options.TierAInvokeProfileProbabilityLog);
            case "TieredAOT": return OptionDescriptor.create("TieredAOT", Boolean.class, "Do profiling and callbacks to tiered runtime", HotSpotAOTProfilingPlugin.Options.class, "TieredAOT", HotSpotAOTProfilingPlugin.Options.TieredAOT);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("TierABackedgeNotifyFreqLog", Integer.class, "Backedge notification frequency", HotSpotAOTProfilingPlugin.Options.class, "TierABackedgeNotifyFreqLog", HotSpotAOTProfilingPlugin.Options.TierABackedgeNotifyFreqLog),
            OptionDescriptor.create("TierABackedgeProfileProbabilityLog", Integer.class, "Backedge profile probability", HotSpotAOTProfilingPlugin.Options.class, "TierABackedgeProfileProbabilityLog", HotSpotAOTProfilingPlugin.Options.TierABackedgeProfileProbabilityLog),
            OptionDescriptor.create("TierAInvokeInlineeNotifyFreqLog", Integer.class, "Inlinee invocation notification frequency (-1 means count, but do not notify)", HotSpotAOTProfilingPlugin.Options.class, "TierAInvokeInlineeNotifyFreqLog", HotSpotAOTProfilingPlugin.Options.TierAInvokeInlineeNotifyFreqLog),
            OptionDescriptor.create("TierAInvokeNotifyFreqLog", Integer.class, "Invocation notification frequency", HotSpotAOTProfilingPlugin.Options.class, "TierAInvokeNotifyFreqLog", HotSpotAOTProfilingPlugin.Options.TierAInvokeNotifyFreqLog),
            OptionDescriptor.create("TierAInvokeProfileProbabilityLog", Integer.class, "Invocation profile probability", HotSpotAOTProfilingPlugin.Options.class, "TierAInvokeProfileProbabilityLog", HotSpotAOTProfilingPlugin.Options.TierAInvokeProfileProbabilityLog),
            OptionDescriptor.create("TieredAOT", Boolean.class, "Do profiling and callbacks to tiered runtime", HotSpotAOTProfilingPlugin.Options.class, "TieredAOT", HotSpotAOTProfilingPlugin.Options.TieredAOT)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
