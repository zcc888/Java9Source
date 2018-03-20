// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: TraceLinearScanPhase.java
package org.graalvm.compiler.lir.alloc.trace.lsra;

import java.util.*;
import org.graalvm.compiler.options.*;

public class TraceLinearScanPhase_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("LIROptTraceRAEliminateSpillMoves")) {
            return OptionDescriptor.create("LIROptTraceRAEliminateSpillMoves", Boolean.class, "Enable spill position optimization", TraceLinearScanPhase.Options.class, "LIROptTraceRAEliminateSpillMoves", TraceLinearScanPhase.Options.LIROptTraceRAEliminateSpillMoves);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("LIROptTraceRAEliminateSpillMoves", Boolean.class, "Enable spill position optimization", TraceLinearScanPhase.Options.class, "LIROptTraceRAEliminateSpillMoves", TraceLinearScanPhase.Options.LIROptTraceRAEliminateSpillMoves)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
