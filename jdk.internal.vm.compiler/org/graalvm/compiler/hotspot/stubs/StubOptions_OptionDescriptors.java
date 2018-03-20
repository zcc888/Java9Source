// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: StubOptions.java
package org.graalvm.compiler.hotspot.stubs;

import java.util.*;
import org.graalvm.compiler.options.*;

public class StubOptions_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "ForceUseOfNewInstanceStub": return OptionDescriptor.create("ForceUseOfNewInstanceStub", Boolean.class, "Force non-array object allocation to always use the slow path.", StubOptions.class, "ForceUseOfNewInstanceStub", StubOptions.ForceUseOfNewInstanceStub);
            case "TraceExceptionHandlerStub": return OptionDescriptor.create("TraceExceptionHandlerStub", Boolean.class, "Trace execution of stub used to handle an exception thrown by a callee.", StubOptions.class, "TraceExceptionHandlerStub", StubOptions.TraceExceptionHandlerStub);
            case "TraceNewArrayStub": return OptionDescriptor.create("TraceNewArrayStub", Boolean.class, "Trace execution of slow path stub for array allocation.", StubOptions.class, "TraceNewArrayStub", StubOptions.TraceNewArrayStub);
            case "TraceNewInstanceStub": return OptionDescriptor.create("TraceNewInstanceStub", Boolean.class, "Trace execution of slow path stub for non-array object allocation.", StubOptions.class, "TraceNewInstanceStub", StubOptions.TraceNewInstanceStub);
            case "TraceUnwindStub": return OptionDescriptor.create("TraceUnwindStub", Boolean.class, "Trace execution of the stub that routes an exception to a handler in the calling frame.", StubOptions.class, "TraceUnwindStub", StubOptions.TraceUnwindStub);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("ForceUseOfNewInstanceStub", Boolean.class, "Force non-array object allocation to always use the slow path.", StubOptions.class, "ForceUseOfNewInstanceStub", StubOptions.ForceUseOfNewInstanceStub),
            OptionDescriptor.create("TraceExceptionHandlerStub", Boolean.class, "Trace execution of stub used to handle an exception thrown by a callee.", StubOptions.class, "TraceExceptionHandlerStub", StubOptions.TraceExceptionHandlerStub),
            OptionDescriptor.create("TraceNewArrayStub", Boolean.class, "Trace execution of slow path stub for array allocation.", StubOptions.class, "TraceNewArrayStub", StubOptions.TraceNewArrayStub),
            OptionDescriptor.create("TraceNewInstanceStub", Boolean.class, "Trace execution of slow path stub for non-array object allocation.", StubOptions.class, "TraceNewInstanceStub", StubOptions.TraceNewInstanceStub),
            OptionDescriptor.create("TraceUnwindStub", Boolean.class, "Trace execution of the stub that routes an exception to a handler in the calling frame.", StubOptions.class, "TraceUnwindStub", StubOptions.TraceUnwindStub)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
