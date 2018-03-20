/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.core.common.alloc;

import java.util.List;

import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.Debug.Scope;
import org.graalvm.compiler.debug.Indent;

public final class TraceStatisticsPrinter {
    private static final String SEP = ";";

    @SuppressWarnings("try")
    public static void printTraceStatistics(TraceBuilderResult result, String compilationUnitName) {
        try (Scope s = Debug.scope("DumpTraceStatistics")) {
            if (Debug.isLogEnabled(Debug.VERBOSE_LOG_LEVEL)) {
                print(result, compilationUnitName);
            }
        } catch (Throwable e) {
            Debug.handle(e);
        }
    }

    @SuppressWarnings("try")
    protected static void print(TraceBuilderResult result, String compilationUnitName) {
        List<Trace> traces = result.getTraces();
        int numTraces = traces.size();

        try (Indent indent0 = Debug.logAndIndent(Debug.VERBOSE_LOG_LEVEL, "<tracestatistics>")) {
            Debug.log(Debug.VERBOSE_LOG_LEVEL, "<name>%s</name>", compilationUnitName != null ? compilationUnitName : "null");
            try (Indent indent1 = Debug.logAndIndent(Debug.VERBOSE_LOG_LEVEL, "<traces>")) {
                printRawLine("tracenumber", "total", "min", "max", "numBlocks");
                for (int i = 0; i < numTraces; i++) {
                    AbstractBlockBase<?>[] t = traces.get(i).getBlocks();
                    double total = 0;
                    double max = Double.NEGATIVE_INFINITY;
                    double min = Double.POSITIVE_INFINITY;
                    for (AbstractBlockBase<?> block : t) {
                        double probability = block.probability();
                        total += probability;
                        if (probability < min) {
                            min = probability;
                        }
                        if (probability > max) {
                            max = probability;
                        }
                    }
                    printLine(i, total, min, max, t.length);
                }
            }
            Debug.log(Debug.VERBOSE_LOG_LEVEL, "</traces>");
        }
        Debug.log(Debug.VERBOSE_LOG_LEVEL, "</tracestatistics>");

    }

    private static void printRawLine(Object tracenr, Object totalTime, Object minProb, Object maxProb, Object numBlocks) {
        Debug.log(Debug.VERBOSE_LOG_LEVEL, "%s", String.join(SEP, tracenr.toString(), totalTime.toString(), minProb.toString(), maxProb.toString(), numBlocks.toString()));
    }

    private static void printLine(int tracenr, double totalTime, double minProb, double maxProb, int numBlocks) {
        printRawLine(tracenr, totalTime, minProb, maxProb, numBlocks);
    }
}
