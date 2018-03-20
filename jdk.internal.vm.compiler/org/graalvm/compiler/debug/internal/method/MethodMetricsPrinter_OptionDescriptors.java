// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: MethodMetricsPrinter.java
package org.graalvm.compiler.debug.internal.method;

import java.util.*;
import org.graalvm.compiler.options.*;

public class MethodMetricsPrinter_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "MethodMeterFile": return OptionDescriptor.create("MethodMeterFile", String.class, "Dump method metrics to the given file in CSV format on shutdown.", MethodMetricsPrinter.Options.class, "MethodMeterFile", MethodMetricsPrinter.Options.MethodMeterFile);
            case "MethodMeterPrintAscii": return OptionDescriptor.create("MethodMeterPrintAscii", Boolean.class, "Dump method metrics to stdout on shutdown.", MethodMetricsPrinter.Options.class, "MethodMeterPrintAscii", MethodMetricsPrinter.Options.MethodMeterPrintAscii);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("MethodMeterFile", String.class, "Dump method metrics to the given file in CSV format on shutdown.", MethodMetricsPrinter.Options.class, "MethodMeterFile", MethodMetricsPrinter.Options.MethodMeterFile),
            OptionDescriptor.create("MethodMeterPrintAscii", Boolean.class, "Dump method metrics to stdout on shutdown.", MethodMetricsPrinter.Options.class, "MethodMeterPrintAscii", MethodMetricsPrinter.Options.MethodMeterPrintAscii)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
