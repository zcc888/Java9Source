// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: LSStackSlotAllocator.java
package org.graalvm.compiler.lir.stackslotalloc;

import java.util.*;
import org.graalvm.compiler.options.*;

public class LSStackSlotAllocator_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("LIROptLSStackSlotAllocator")) {
            return OptionDescriptor.create("LIROptLSStackSlotAllocator", Boolean.class, "Use linear scan stack slot allocation.", LSStackSlotAllocator.Options.class, "LIROptLSStackSlotAllocator", LSStackSlotAllocator.Options.LIROptLSStackSlotAllocator);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("LIROptLSStackSlotAllocator", Boolean.class, "Use linear scan stack slot allocation.", LSStackSlotAllocator.Options.class, "LIROptLSStackSlotAllocator", LSStackSlotAllocator.Options.LIROptLSStackSlotAllocator)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
