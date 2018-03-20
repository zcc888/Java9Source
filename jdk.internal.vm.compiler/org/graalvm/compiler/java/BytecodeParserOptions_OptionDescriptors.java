// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: BytecodeParserOptions.java
package org.graalvm.compiler.java;

import java.util.*;
import org.graalvm.compiler.options.*;

public class BytecodeParserOptions_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "DumpDuringGraphBuilding": return OptionDescriptor.create("DumpDuringGraphBuilding", Boolean.class, "Dump graphs after non-trivial changes during bytecode parsing.", BytecodeParserOptions.class, "DumpDuringGraphBuilding", BytecodeParserOptions.DumpDuringGraphBuilding);
            case "HideSubstitutionStates": return OptionDescriptor.create("HideSubstitutionStates", Boolean.class, "When creating info points hide the methods of the substitutions.", BytecodeParserOptions.class, "HideSubstitutionStates", BytecodeParserOptions.HideSubstitutionStates);
            case "InlineDuringParsing": return OptionDescriptor.create("InlineDuringParsing", Boolean.class, "Inlines trivial methods during bytecode parsing.", BytecodeParserOptions.class, "InlineDuringParsing", BytecodeParserOptions.InlineDuringParsing);
            case "InlineDuringParsingMaxDepth": return OptionDescriptor.create("InlineDuringParsingMaxDepth", Integer.class, "Maximum depth when inlining during bytecode parsing.", BytecodeParserOptions.class, "InlineDuringParsingMaxDepth", BytecodeParserOptions.InlineDuringParsingMaxDepth);
            case "InlineIntrinsicsDuringParsing": return OptionDescriptor.create("InlineIntrinsicsDuringParsing", Boolean.class, "Inlines intrinsic methods during bytecode parsing.", BytecodeParserOptions.class, "InlineIntrinsicsDuringParsing", BytecodeParserOptions.InlineIntrinsicsDuringParsing);
            case "TraceBytecodeParserLevel": return OptionDescriptor.create("TraceBytecodeParserLevel", Integer.class, "The trace level for the bytecode parser used when building a graph from bytecode", BytecodeParserOptions.class, "TraceBytecodeParserLevel", BytecodeParserOptions.TraceBytecodeParserLevel);
            case "TraceInlineDuringParsing": return OptionDescriptor.create("TraceInlineDuringParsing", Boolean.class, "Traces inlining performed during bytecode parsing.", BytecodeParserOptions.class, "TraceInlineDuringParsing", BytecodeParserOptions.TraceInlineDuringParsing);
            case "TraceParserPlugins": return OptionDescriptor.create("TraceParserPlugins", Boolean.class, "Traces use of plugins during bytecode parsing.", BytecodeParserOptions.class, "TraceParserPlugins", BytecodeParserOptions.TraceParserPlugins);
            case "UseGuardedIntrinsics": return OptionDescriptor.create("UseGuardedIntrinsics", Boolean.class, "Use intrinsics guarded by a virtual dispatch test at indirect call sites.", BytecodeParserOptions.class, "UseGuardedIntrinsics", BytecodeParserOptions.UseGuardedIntrinsics);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("DumpDuringGraphBuilding", Boolean.class, "Dump graphs after non-trivial changes during bytecode parsing.", BytecodeParserOptions.class, "DumpDuringGraphBuilding", BytecodeParserOptions.DumpDuringGraphBuilding),
            OptionDescriptor.create("HideSubstitutionStates", Boolean.class, "When creating info points hide the methods of the substitutions.", BytecodeParserOptions.class, "HideSubstitutionStates", BytecodeParserOptions.HideSubstitutionStates),
            OptionDescriptor.create("InlineDuringParsing", Boolean.class, "Inlines trivial methods during bytecode parsing.", BytecodeParserOptions.class, "InlineDuringParsing", BytecodeParserOptions.InlineDuringParsing),
            OptionDescriptor.create("InlineDuringParsingMaxDepth", Integer.class, "Maximum depth when inlining during bytecode parsing.", BytecodeParserOptions.class, "InlineDuringParsingMaxDepth", BytecodeParserOptions.InlineDuringParsingMaxDepth),
            OptionDescriptor.create("InlineIntrinsicsDuringParsing", Boolean.class, "Inlines intrinsic methods during bytecode parsing.", BytecodeParserOptions.class, "InlineIntrinsicsDuringParsing", BytecodeParserOptions.InlineIntrinsicsDuringParsing),
            OptionDescriptor.create("TraceBytecodeParserLevel", Integer.class, "The trace level for the bytecode parser used when building a graph from bytecode", BytecodeParserOptions.class, "TraceBytecodeParserLevel", BytecodeParserOptions.TraceBytecodeParserLevel),
            OptionDescriptor.create("TraceInlineDuringParsing", Boolean.class, "Traces inlining performed during bytecode parsing.", BytecodeParserOptions.class, "TraceInlineDuringParsing", BytecodeParserOptions.TraceInlineDuringParsing),
            OptionDescriptor.create("TraceParserPlugins", Boolean.class, "Traces use of plugins during bytecode parsing.", BytecodeParserOptions.class, "TraceParserPlugins", BytecodeParserOptions.TraceParserPlugins),
            OptionDescriptor.create("UseGuardedIntrinsics", Boolean.class, "Use intrinsics guarded by a virtual dispatch test at indirect call sites.", BytecodeParserOptions.class, "UseGuardedIntrinsics", BytecodeParserOptions.UseGuardedIntrinsics)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
