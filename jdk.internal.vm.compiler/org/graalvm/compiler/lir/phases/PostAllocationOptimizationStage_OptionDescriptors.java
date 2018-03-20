// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: PostAllocationOptimizationStage.java
package org.graalvm.compiler.lir.phases;

import java.util.*;
import org.graalvm.compiler.options.*;

public class PostAllocationOptimizationStage_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "LIROptControlFlowOptimizer": return OptionDescriptor.create("LIROptControlFlowOptimizer", Boolean.class, "", PostAllocationOptimizationStage.Options.class, "LIROptControlFlowOptimizer", PostAllocationOptimizationStage.Options.LIROptControlFlowOptimizer);
            case "LIROptEdgeMoveOptimizer": return OptionDescriptor.create("LIROptEdgeMoveOptimizer", Boolean.class, "", PostAllocationOptimizationStage.Options.class, "LIROptEdgeMoveOptimizer", PostAllocationOptimizationStage.Options.LIROptEdgeMoveOptimizer);
            case "LIROptNullCheckOptimizer": return OptionDescriptor.create("LIROptNullCheckOptimizer", Boolean.class, "", PostAllocationOptimizationStage.Options.class, "LIROptNullCheckOptimizer", PostAllocationOptimizationStage.Options.LIROptNullCheckOptimizer);
            case "LIROptRedundantMoveElimination": return OptionDescriptor.create("LIROptRedundantMoveElimination", Boolean.class, "", PostAllocationOptimizationStage.Options.class, "LIROptRedundantMoveElimination", PostAllocationOptimizationStage.Options.LIROptRedundantMoveElimination);
            case "LIRProfileMethods": return OptionDescriptor.create("LIRProfileMethods", Boolean.class, "Enables profiling of methods.", PostAllocationOptimizationStage.Options.class, "LIRProfileMethods", PostAllocationOptimizationStage.Options.LIRProfileMethods);
            case "LIRProfileMoves": return OptionDescriptor.create("LIRProfileMoves", Boolean.class, "Enables profiling of move types on LIR level. Move types are for example stores (register to stack), constant loads (constant to register) or copies (register to register).", PostAllocationOptimizationStage.Options.class, "LIRProfileMoves", PostAllocationOptimizationStage.Options.LIRProfileMoves);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("LIROptControlFlowOptimizer", Boolean.class, "", PostAllocationOptimizationStage.Options.class, "LIROptControlFlowOptimizer", PostAllocationOptimizationStage.Options.LIROptControlFlowOptimizer),
            OptionDescriptor.create("LIROptEdgeMoveOptimizer", Boolean.class, "", PostAllocationOptimizationStage.Options.class, "LIROptEdgeMoveOptimizer", PostAllocationOptimizationStage.Options.LIROptEdgeMoveOptimizer),
            OptionDescriptor.create("LIROptNullCheckOptimizer", Boolean.class, "", PostAllocationOptimizationStage.Options.class, "LIROptNullCheckOptimizer", PostAllocationOptimizationStage.Options.LIROptNullCheckOptimizer),
            OptionDescriptor.create("LIROptRedundantMoveElimination", Boolean.class, "", PostAllocationOptimizationStage.Options.class, "LIROptRedundantMoveElimination", PostAllocationOptimizationStage.Options.LIROptRedundantMoveElimination),
            OptionDescriptor.create("LIRProfileMethods", Boolean.class, "Enables profiling of methods.", PostAllocationOptimizationStage.Options.class, "LIRProfileMethods", PostAllocationOptimizationStage.Options.LIRProfileMethods),
            OptionDescriptor.create("LIRProfileMoves", Boolean.class, "Enables profiling of move types on LIR level. Move types are for example stores (register to stack), constant loads (constant to register) or copies (register to register).", PostAllocationOptimizationStage.Options.class, "LIRProfileMoves", PostAllocationOptimizationStage.Options.LIRProfileMoves)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
