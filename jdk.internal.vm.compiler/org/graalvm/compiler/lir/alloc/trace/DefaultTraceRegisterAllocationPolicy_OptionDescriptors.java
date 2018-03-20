// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: DefaultTraceRegisterAllocationPolicy.java
package org.graalvm.compiler.lir.alloc.trace;

import java.util.*;
import org.graalvm.compiler.options.*;

public class DefaultTraceRegisterAllocationPolicy_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "TraceRAPolicy": return OptionDescriptor.create("TraceRAPolicy", org.graalvm.compiler.lir.alloc.trace.DefaultTraceRegisterAllocationPolicy.TraceRAPolicies.class, "TraceRA allocation policy to use.", DefaultTraceRegisterAllocationPolicy.Options.class, "TraceRAPolicy", DefaultTraceRegisterAllocationPolicy.Options.TraceRAPolicy);
            case "TraceRAbottomUpRatio": return OptionDescriptor.create("TraceRAbottomUpRatio", Double.class, "Use LSRA / BottomUp ratio", DefaultTraceRegisterAllocationPolicy.Options.class, "TraceRAbottomUpRatio", DefaultTraceRegisterAllocationPolicy.Options.TraceRAbottomUpRatio);
            case "TraceRAtrivialBlockAllocator": return OptionDescriptor.create("TraceRAtrivialBlockAllocator", Boolean.class, "Use special allocator for trivial blocks.", DefaultTraceRegisterAllocationPolicy.Options.class, "TraceRAtrivialBlockAllocator", DefaultTraceRegisterAllocationPolicy.Options.TraceRAtrivialBlockAllocator);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("TraceRAPolicy", org.graalvm.compiler.lir.alloc.trace.DefaultTraceRegisterAllocationPolicy.TraceRAPolicies.class, "TraceRA allocation policy to use.", DefaultTraceRegisterAllocationPolicy.Options.class, "TraceRAPolicy", DefaultTraceRegisterAllocationPolicy.Options.TraceRAPolicy),
            OptionDescriptor.create("TraceRAbottomUpRatio", Double.class, "Use LSRA / BottomUp ratio", DefaultTraceRegisterAllocationPolicy.Options.class, "TraceRAbottomUpRatio", DefaultTraceRegisterAllocationPolicy.Options.TraceRAbottomUpRatio),
            OptionDescriptor.create("TraceRAtrivialBlockAllocator", Boolean.class, "Use special allocator for trivial blocks.", DefaultTraceRegisterAllocationPolicy.Options.class, "TraceRAtrivialBlockAllocator", DefaultTraceRegisterAllocationPolicy.Options.TraceRAtrivialBlockAllocator)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
