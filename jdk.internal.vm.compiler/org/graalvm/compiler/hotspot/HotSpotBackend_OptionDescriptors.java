// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: HotSpotBackend.java
package org.graalvm.compiler.hotspot;

import java.util.*;
import org.graalvm.compiler.options.*;

public class HotSpotBackend_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "ASMInstructionProfiling": return OptionDescriptor.create("ASMInstructionProfiling", String.class, "Enables instruction profiling on assembler level. Valid values are a comma separated list of supported instructions. Compare with subclasses of Assembler.InstructionCounter.", HotSpotBackend.Options.class, "ASMInstructionProfiling", HotSpotBackend.Options.ASMInstructionProfiling);
            case "GraalArithmeticStubs": return OptionDescriptor.create("GraalArithmeticStubs", Boolean.class, "Use Graal arithmetic stubs instead of HotSpot stubs where possible", HotSpotBackend.Options.class, "GraalArithmeticStubs", HotSpotBackend.Options.GraalArithmeticStubs);
            case "PreferGraalStubs": return OptionDescriptor.create("PreferGraalStubs", Boolean.class, "Use Graal stubs instead of HotSpot stubs where possible", HotSpotBackend.Options.class, "PreferGraalStubs", HotSpotBackend.Options.PreferGraalStubs);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("ASMInstructionProfiling", String.class, "Enables instruction profiling on assembler level. Valid values are a comma separated list of supported instructions. Compare with subclasses of Assembler.InstructionCounter.", HotSpotBackend.Options.class, "ASMInstructionProfiling", HotSpotBackend.Options.ASMInstructionProfiling),
            OptionDescriptor.create("GraalArithmeticStubs", Boolean.class, "Use Graal arithmetic stubs instead of HotSpot stubs where possible", HotSpotBackend.Options.class, "GraalArithmeticStubs", HotSpotBackend.Options.GraalArithmeticStubs),
            OptionDescriptor.create("PreferGraalStubs", Boolean.class, "Use Graal stubs instead of HotSpot stubs where possible", HotSpotBackend.Options.class, "PreferGraalStubs", HotSpotBackend.Options.PreferGraalStubs)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
