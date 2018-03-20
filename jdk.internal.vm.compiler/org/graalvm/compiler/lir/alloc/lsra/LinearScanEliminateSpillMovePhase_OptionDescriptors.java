// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: LinearScanEliminateSpillMovePhase.java
package org.graalvm.compiler.lir.alloc.lsra;

import java.util.*;
import org.graalvm.compiler.options.*;

public class LinearScanEliminateSpillMovePhase_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("LIROptLSRAEliminateSpillMoves")) {
            return OptionDescriptor.create("LIROptLSRAEliminateSpillMoves", Boolean.class, "Enable spill move elimination.", LinearScanEliminateSpillMovePhase.Options.class, "LIROptLSRAEliminateSpillMoves", LinearScanEliminateSpillMovePhase.Options.LIROptLSRAEliminateSpillMoves);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("LIROptLSRAEliminateSpillMoves", Boolean.class, "Enable spill move elimination.", LinearScanEliminateSpillMovePhase.Options.class, "LIROptLSRAEliminateSpillMoves", LinearScanEliminateSpillMovePhase.Options.LIROptLSRAEliminateSpillMoves)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
