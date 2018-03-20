/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.graalvm.compiler.debug.internal;

import java.io.PrintStream;
import java.util.List;

import org.graalvm.compiler.debug.DebugHistogram;
import org.graalvm.compiler.debug.DebugHistogram.CountedValue;
import org.graalvm.compiler.debug.DebugHistogram.Printer;

/**
 * Renders a histogram as an R script to a given print stream. The R script emitted for a histogram
 * is a simple set of statements for defining a vector of named objects.
 */
public class DebugHistogramRPrinter implements Printer {

    private PrintStream os;
    private int limit;

    public DebugHistogramRPrinter(PrintStream os) {
        this(os, Integer.MAX_VALUE);
    }

    /**
     * @param os where to print
     * @param limit limits printing to the {@code limit} most frequent values
     */
    public DebugHistogramRPrinter(PrintStream os, int limit) {
        this.os = os;
        this.limit = limit;
    }

    @Override
    public void print(DebugHistogram histogram) {
        List<CountedValue> list = histogram.getValues();
        if (list.isEmpty()) {
            return;
        }

        String var = histogram.getName().replace('-', '.').replace(' ', '_');
        os.print(var + " <- c(");
        for (int i = 0; i < list.size() && i < limit; ++i) {
            CountedValue cv = list.get(i);
            if (i != 0) {
                os.print(", ");
            }
            os.print(cv.getCount());
        }
        os.println(");");

        os.print("names(" + var + ") <- c(");
        for (int i = 0; i < list.size() && i < limit; ++i) {
            CountedValue cv = list.get(i);
            if (i != 0) {
                os.print(", ");
            }
            os.print("\"" + cv.getValue() + "\"");
        }
        os.println(");");
    }
}
