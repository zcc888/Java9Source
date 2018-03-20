// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: OptimizingLinearScanWalker.java
package org.graalvm.compiler.lir.alloc.lsra;

import java.util.*;
import org.graalvm.compiler.options.*;

public class OptimizingLinearScanWalker_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "LSRAOptSplitOnly": return OptionDescriptor.create("LSRAOptSplitOnly", Boolean.class, "LSRA optimization: Only split but do not reassign", OptimizingLinearScanWalker.Options.class, "LSRAOptSplitOnly", OptimizingLinearScanWalker.Options.LSRAOptSplitOnly);
            case "LSRAOptimization": return OptionDescriptor.create("LSRAOptimization", Boolean.class, "Enable LSRA optimization", OptimizingLinearScanWalker.Options.class, "LSRAOptimization", OptimizingLinearScanWalker.Options.LSRAOptimization);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("LSRAOptSplitOnly", Boolean.class, "LSRA optimization: Only split but do not reassign", OptimizingLinearScanWalker.Options.class, "LSRAOptSplitOnly", OptimizingLinearScanWalker.Options.LSRAOptSplitOnly),
            OptionDescriptor.create("LSRAOptimization", Boolean.class, "Enable LSRA optimization", OptimizingLinearScanWalker.Options.class, "LSRAOptimization", OptimizingLinearScanWalker.Options.LSRAOptimization)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
