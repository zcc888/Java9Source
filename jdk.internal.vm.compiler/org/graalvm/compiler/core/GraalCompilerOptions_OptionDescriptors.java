// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: GraalCompilerOptions.java
package org.graalvm.compiler.core;

import java.util.*;
import org.graalvm.compiler.options.*;

public class GraalCompilerOptions_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "EmitLIRRepeatCount": return OptionDescriptor.create("EmitLIRRepeatCount", Integer.class, "Repeatedly run the LIR code generation pass to improve statistical profiling results.", GraalCompilerOptions.class, "EmitLIRRepeatCount", GraalCompilerOptions.EmitLIRRepeatCount);
            case "ExitVMOnBailout": return OptionDescriptor.create("ExitVMOnBailout", Boolean.class, "", GraalCompilerOptions.class, "ExitVMOnBailout", GraalCompilerOptions.ExitVMOnBailout);
            case "ExitVMOnException": return OptionDescriptor.create("ExitVMOnException", Boolean.class, "", GraalCompilerOptions.class, "ExitVMOnException", GraalCompilerOptions.ExitVMOnException);
            case "PrintAfterCompilation": return OptionDescriptor.create("PrintAfterCompilation", Boolean.class, "", GraalCompilerOptions.class, "PrintAfterCompilation", GraalCompilerOptions.PrintAfterCompilation);
            case "PrintBailout": return OptionDescriptor.create("PrintBailout", Boolean.class, "", GraalCompilerOptions.class, "PrintBailout", GraalCompilerOptions.PrintBailout);
            case "PrintCompilation": return OptionDescriptor.create("PrintCompilation", Boolean.class, "", GraalCompilerOptions.class, "PrintCompilation", GraalCompilerOptions.PrintCompilation);
            case "PrintFilter": return OptionDescriptor.create("PrintFilter", String.class, "", GraalCompilerOptions.class, "PrintFilter", GraalCompilerOptions.PrintFilter);
            case "PrintStackTraceOnException": return OptionDescriptor.create("PrintStackTraceOnException", Boolean.class, "", GraalCompilerOptions.class, "PrintStackTraceOnException", GraalCompilerOptions.PrintStackTraceOnException);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("EmitLIRRepeatCount", Integer.class, "Repeatedly run the LIR code generation pass to improve statistical profiling results.", GraalCompilerOptions.class, "EmitLIRRepeatCount", GraalCompilerOptions.EmitLIRRepeatCount),
            OptionDescriptor.create("ExitVMOnBailout", Boolean.class, "", GraalCompilerOptions.class, "ExitVMOnBailout", GraalCompilerOptions.ExitVMOnBailout),
            OptionDescriptor.create("ExitVMOnException", Boolean.class, "", GraalCompilerOptions.class, "ExitVMOnException", GraalCompilerOptions.ExitVMOnException),
            OptionDescriptor.create("PrintAfterCompilation", Boolean.class, "", GraalCompilerOptions.class, "PrintAfterCompilation", GraalCompilerOptions.PrintAfterCompilation),
            OptionDescriptor.create("PrintBailout", Boolean.class, "", GraalCompilerOptions.class, "PrintBailout", GraalCompilerOptions.PrintBailout),
            OptionDescriptor.create("PrintCompilation", Boolean.class, "", GraalCompilerOptions.class, "PrintCompilation", GraalCompilerOptions.PrintCompilation),
            OptionDescriptor.create("PrintFilter", String.class, "", GraalCompilerOptions.class, "PrintFilter", GraalCompilerOptions.PrintFilter),
            OptionDescriptor.create("PrintStackTraceOnException", Boolean.class, "", GraalCompilerOptions.class, "PrintStackTraceOnException", GraalCompilerOptions.PrintStackTraceOnException)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
