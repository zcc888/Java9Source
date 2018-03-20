// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: TraceRegisterAllocationPhase.java
package org.graalvm.compiler.lir.alloc.trace;

import java.util.*;
import org.graalvm.compiler.options.*;

public class TraceRegisterAllocationPhase_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "TraceRACacheStackSlots": return OptionDescriptor.create("TraceRACacheStackSlots", Boolean.class, "Cache stack slots globally (i.e. a variable always gets the same slot in every trace).", TraceRegisterAllocationPhase.Options.class, "TraceRACacheStackSlots", TraceRegisterAllocationPhase.Options.TraceRACacheStackSlots);
            case "TraceRAreuseStackSlotsForMoveResolutionCycleBreaking": return OptionDescriptor.create("TraceRAreuseStackSlotsForMoveResolutionCycleBreaking", Boolean.class, "Reuse spill slots for global move resolution cycle breaking.", TraceRegisterAllocationPhase.Options.class, "TraceRAreuseStackSlotsForMoveResolutionCycleBreaking", TraceRegisterAllocationPhase.Options.TraceRAreuseStackSlotsForMoveResolutionCycleBreaking);
            case "TraceRAshareSpillInformation": return OptionDescriptor.create("TraceRAshareSpillInformation", Boolean.class, "Share information about spilled values to other traces.", TraceRegisterAllocationPhase.Options.class, "TraceRAshareSpillInformation", TraceRegisterAllocationPhase.Options.TraceRAshareSpillInformation);
            case "TraceRAuseInterTraceHints": return OptionDescriptor.create("TraceRAuseInterTraceHints", Boolean.class, "Use inter-trace register hints.", TraceRegisterAllocationPhase.Options.class, "TraceRAuseInterTraceHints", TraceRegisterAllocationPhase.Options.TraceRAuseInterTraceHints);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("TraceRACacheStackSlots", Boolean.class, "Cache stack slots globally (i.e. a variable always gets the same slot in every trace).", TraceRegisterAllocationPhase.Options.class, "TraceRACacheStackSlots", TraceRegisterAllocationPhase.Options.TraceRACacheStackSlots),
            OptionDescriptor.create("TraceRAreuseStackSlotsForMoveResolutionCycleBreaking", Boolean.class, "Reuse spill slots for global move resolution cycle breaking.", TraceRegisterAllocationPhase.Options.class, "TraceRAreuseStackSlotsForMoveResolutionCycleBreaking", TraceRegisterAllocationPhase.Options.TraceRAreuseStackSlotsForMoveResolutionCycleBreaking),
            OptionDescriptor.create("TraceRAshareSpillInformation", Boolean.class, "Share information about spilled values to other traces.", TraceRegisterAllocationPhase.Options.class, "TraceRAshareSpillInformation", TraceRegisterAllocationPhase.Options.TraceRAshareSpillInformation),
            OptionDescriptor.create("TraceRAuseInterTraceHints", Boolean.class, "Use inter-trace register hints.", TraceRegisterAllocationPhase.Options.class, "TraceRAuseInterTraceHints", TraceRegisterAllocationPhase.Options.TraceRAuseInterTraceHints)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
