// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: LIRGenerator.java
package org.graalvm.compiler.lir.gen;

import java.util.*;
import org.graalvm.compiler.options.*;

public class LIRGenerator_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "PrintIRWithLIR": return OptionDescriptor.create("PrintIRWithLIR", Boolean.class, "Print HIR along side LIR as the latter is generated", LIRGenerator.Options.class, "PrintIRWithLIR", LIRGenerator.Options.PrintIRWithLIR);
            case "TraceLIRGeneratorLevel": return OptionDescriptor.create("TraceLIRGeneratorLevel", Integer.class, "The trace level for the LIR generator", LIRGenerator.Options.class, "TraceLIRGeneratorLevel", LIRGenerator.Options.TraceLIRGeneratorLevel);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("PrintIRWithLIR", Boolean.class, "Print HIR along side LIR as the latter is generated", LIRGenerator.Options.class, "PrintIRWithLIR", LIRGenerator.Options.PrintIRWithLIR),
            OptionDescriptor.create("TraceLIRGeneratorLevel", Integer.class, "The trace level for the LIR generator", LIRGenerator.Options.class, "TraceLIRGeneratorLevel", LIRGenerator.Options.TraceLIRGeneratorLevel)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
