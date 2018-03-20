// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: CompilationResultBuilder.java
package org.graalvm.compiler.lir.asm;

import java.util.*;
import org.graalvm.compiler.options.*;

public class CompilationResultBuilder_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("PrintLIRWithAssembly")) {
            return OptionDescriptor.create("PrintLIRWithAssembly", Boolean.class, "Include the LIR as comments with the final assembly.", CompilationResultBuilder.class, "PrintLIRWithAssembly", CompilationResultBuilder.PrintLIRWithAssembly);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("PrintLIRWithAssembly", Boolean.class, "Include the LIR as comments with the final assembly.", CompilationResultBuilder.class, "PrintLIRWithAssembly", CompilationResultBuilder.PrintLIRWithAssembly)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
