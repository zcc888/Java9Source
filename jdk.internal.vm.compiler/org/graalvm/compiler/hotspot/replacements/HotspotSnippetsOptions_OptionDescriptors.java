// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: HotspotSnippetsOptions.java
package org.graalvm.compiler.hotspot.replacements;

import java.util.*;
import org.graalvm.compiler.options.*;

public class HotspotSnippetsOptions_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "LoadExceptionObjectInVM": return OptionDescriptor.create("LoadExceptionObjectInVM", Boolean.class, "Use a VM runtime call to load and clear the exception object from the thread at the start of a compiled exception handler.", HotspotSnippetsOptions.class, "LoadExceptionObjectInVM", HotspotSnippetsOptions.LoadExceptionObjectInVM);
            case "ProfileAllocations": return OptionDescriptor.create("ProfileAllocations", Boolean.class, "Enable profiling of allocation sites.", HotspotSnippetsOptions.class, "ProfileAllocations", HotspotSnippetsOptions.ProfileAllocations);
            case "ProfileAllocationsContext": return OptionDescriptor.create("ProfileAllocationsContext", org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.ProfileContext.class, "Control the naming of the counters when using ProfileAllocations.", HotspotSnippetsOptions.class, "ProfileAllocationsContext", HotspotSnippetsOptions.ProfileAllocationsContext);
            case "ProfileMonitors": return OptionDescriptor.create("ProfileMonitors", Boolean.class, "Enable profiling of monitor operations.", HotspotSnippetsOptions.class, "ProfileMonitors", HotspotSnippetsOptions.ProfileMonitors);
            case "TraceMonitorsMethodFilter": return OptionDescriptor.create("TraceMonitorsMethodFilter", String.class, "Trace monitor operations in methods whose fully qualified name contains this substring.", HotspotSnippetsOptions.class, "TraceMonitorsMethodFilter", HotspotSnippetsOptions.TraceMonitorsMethodFilter);
            case "TraceMonitorsTypeFilter": return OptionDescriptor.create("TraceMonitorsTypeFilter", String.class, "Trace monitor operations on objects whose type contains this substring.", HotspotSnippetsOptions.class, "TraceMonitorsTypeFilter", HotspotSnippetsOptions.TraceMonitorsTypeFilter);
            case "TypeCheckMaxHints": return OptionDescriptor.create("TypeCheckMaxHints", Integer.class, "The maximum number of profiled types that will be used when compiling a profiled type check. Note that TypeCheckMinProfileHitProbability also influences whether profiling info is used in compiled type checks.", HotspotSnippetsOptions.class, "TypeCheckMaxHints", HotspotSnippetsOptions.TypeCheckMaxHints);
            case "TypeCheckMinProfileHitProbability": return OptionDescriptor.create("TypeCheckMinProfileHitProbability", Double.class, "If the probability that a type check will hit one the profiled types (up to TypeCheckMaxHints) is below this value, the type check will be compiled without profiling info", HotspotSnippetsOptions.class, "TypeCheckMinProfileHitProbability", HotspotSnippetsOptions.TypeCheckMinProfileHitProbability);
            case "VerifyBalancedMonitors": return OptionDescriptor.create("VerifyBalancedMonitors", Boolean.class, "Emit extra code to dynamically check monitor operations are balanced.", HotspotSnippetsOptions.class, "VerifyBalancedMonitors", HotspotSnippetsOptions.VerifyBalancedMonitors);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("LoadExceptionObjectInVM", Boolean.class, "Use a VM runtime call to load and clear the exception object from the thread at the start of a compiled exception handler.", HotspotSnippetsOptions.class, "LoadExceptionObjectInVM", HotspotSnippetsOptions.LoadExceptionObjectInVM),
            OptionDescriptor.create("ProfileAllocations", Boolean.class, "Enable profiling of allocation sites.", HotspotSnippetsOptions.class, "ProfileAllocations", HotspotSnippetsOptions.ProfileAllocations),
            OptionDescriptor.create("ProfileAllocationsContext", org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.ProfileContext.class, "Control the naming of the counters when using ProfileAllocations.", HotspotSnippetsOptions.class, "ProfileAllocationsContext", HotspotSnippetsOptions.ProfileAllocationsContext),
            OptionDescriptor.create("ProfileMonitors", Boolean.class, "Enable profiling of monitor operations.", HotspotSnippetsOptions.class, "ProfileMonitors", HotspotSnippetsOptions.ProfileMonitors),
            OptionDescriptor.create("TraceMonitorsMethodFilter", String.class, "Trace monitor operations in methods whose fully qualified name contains this substring.", HotspotSnippetsOptions.class, "TraceMonitorsMethodFilter", HotspotSnippetsOptions.TraceMonitorsMethodFilter),
            OptionDescriptor.create("TraceMonitorsTypeFilter", String.class, "Trace monitor operations on objects whose type contains this substring.", HotspotSnippetsOptions.class, "TraceMonitorsTypeFilter", HotspotSnippetsOptions.TraceMonitorsTypeFilter),
            OptionDescriptor.create("TypeCheckMaxHints", Integer.class, "The maximum number of profiled types that will be used when compiling a profiled type check. Note that TypeCheckMinProfileHitProbability also influences whether profiling info is used in compiled type checks.", HotspotSnippetsOptions.class, "TypeCheckMaxHints", HotspotSnippetsOptions.TypeCheckMaxHints),
            OptionDescriptor.create("TypeCheckMinProfileHitProbability", Double.class, "If the probability that a type check will hit one the profiled types (up to TypeCheckMaxHints) is below this value, the type check will be compiled without profiling info", HotspotSnippetsOptions.class, "TypeCheckMinProfileHitProbability", HotspotSnippetsOptions.TypeCheckMinProfileHitProbability),
            OptionDescriptor.create("VerifyBalancedMonitors", Boolean.class, "Emit extra code to dynamically check monitor operations are balanced.", HotspotSnippetsOptions.class, "VerifyBalancedMonitors", HotspotSnippetsOptions.VerifyBalancedMonitors)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
