// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: HotSpotGraalCompilerFactory.java
package org.graalvm.compiler.hotspot;

import java.util.*;
import org.graalvm.compiler.options.*;

public class HotSpotGraalCompilerFactory_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "CompileGraalWithC1Only": return OptionDescriptor.create("CompileGraalWithC1Only", Boolean.class, "In tiered mode compile Graal and JVMCI using optimized first tier code.", HotSpotGraalCompilerFactory.Options.class, "CompileGraalWithC1Only", HotSpotGraalCompilerFactory.Options.CompileGraalWithC1Only);
            case "GraalCompileOnly": return OptionDescriptor.create("GraalCompileOnly", String.class, "A method filter selecting what should be compiled by Graal.  All other requests will be reduced to CompilationLevel.Simple.", HotSpotGraalCompilerFactory.Options.class, "GraalCompileOnly", HotSpotGraalCompilerFactory.Options.GraalCompileOnly);
            case "UseTrivialPrefixes": return OptionDescriptor.create("UseTrivialPrefixes", Boolean.class, "Hook into VM-level mechanism for denoting compilations to be performed in first tier.", HotSpotGraalCompilerFactory.Options.class, "UseTrivialPrefixes", HotSpotGraalCompilerFactory.Options.UseTrivialPrefixes);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("CompileGraalWithC1Only", Boolean.class, "In tiered mode compile Graal and JVMCI using optimized first tier code.", HotSpotGraalCompilerFactory.Options.class, "CompileGraalWithC1Only", HotSpotGraalCompilerFactory.Options.CompileGraalWithC1Only),
            OptionDescriptor.create("GraalCompileOnly", String.class, "A method filter selecting what should be compiled by Graal.  All other requests will be reduced to CompilationLevel.Simple.", HotSpotGraalCompilerFactory.Options.class, "GraalCompileOnly", HotSpotGraalCompilerFactory.Options.GraalCompileOnly),
            OptionDescriptor.create("UseTrivialPrefixes", Boolean.class, "Hook into VM-level mechanism for denoting compilations to be performed in first tier.", HotSpotGraalCompilerFactory.Options.class, "UseTrivialPrefixes", HotSpotGraalCompilerFactory.Options.UseTrivialPrefixes)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
