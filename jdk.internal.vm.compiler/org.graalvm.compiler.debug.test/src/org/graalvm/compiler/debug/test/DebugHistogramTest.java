/*
 * Copyright (c) 2013, 2013, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.debug.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.DebugHistogram;
import org.graalvm.compiler.debug.internal.DebugHistogramAsciiPrinter;
import org.graalvm.compiler.debug.internal.DebugHistogramRPrinter;

public class DebugHistogramTest {

    @Test
    public void testEmptyHistogram() {
        DebugHistogram histogram = Debug.createHistogram("TestHistogram");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        new DebugHistogramAsciiPrinter(new PrintStream(outputStream)).print(histogram);
        String line = outputStream.toString().split("\r?\n")[0];
        Assert.assertEquals("TestHistogram is empty.", line);

        outputStream.reset();
        new DebugHistogramRPrinter(new PrintStream(outputStream)).print(histogram);
        Assert.assertEquals("", outputStream.toString());
    }

    @Test
    public void testSingleEntryHistogram() {
        DebugHistogram histogram = Debug.createHistogram("TestHistogram");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        histogram.add(new Integer(1));
        histogram.add(new Integer(1));
        new DebugHistogramAsciiPrinter(new PrintStream(outputStream)).print(histogram);
        String[] lines = outputStream.toString().split("\r?\n");
        // @formatter:off
        String[] expected = {
            "TestHistogram has 1 unique elements and 2 total elements:",
            "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------",
            "| 1                                                  | 2          | ==================================================================================================== |",
            "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
        };
        // @formatter:on
        Assert.assertArrayEquals(expected, lines);

        outputStream.reset();
        new DebugHistogramRPrinter(new PrintStream(outputStream)).print(histogram);
        lines = outputStream.toString().split("\r?\n");
        // @formatter:off
        expected = new String[] {
            "TestHistogram <- c(2);",
            "names(TestHistogram) <- c(\"1\");"
        };
        // @formatter:on
        Assert.assertArrayEquals(expected, lines);
    }

    @Test
    public void testMultipleEntryHistogram() {
        DebugHistogram histogram = Debug.createHistogram("TestHistogram");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        histogram.add(new Integer(1));
        histogram.add(new Integer(2));
        histogram.add(new Integer(2));
        new DebugHistogramAsciiPrinter(new PrintStream(outputStream)).print(histogram);
        String[] lines = outputStream.toString().split("\r?\n");
        // @formatter:off
        String[] expected = new String[] {
            "TestHistogram has 2 unique elements and 3 total elements:",
            "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------",
            "| 2                                                  | 2          | ==================================================================================================== |",
            "| 1                                                  | 1          | ==================================================                                                   |",
            "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
        };
        // @formatter:on
        Assert.assertArrayEquals(expected, lines);

        outputStream.reset();
        new DebugHistogramRPrinter(new PrintStream(outputStream)).print(histogram);
        lines = outputStream.toString().split("\r?\n");
        // @formatter:off
        expected = new String[] {
            "TestHistogram <- c(2, 1);",
            "names(TestHistogram) <- c(\"2\", \"1\");"
        };
        // @formatter:on
        Assert.assertArrayEquals(expected, lines);
    }

    @Test
    public void testTooLongValueString() {
        DebugHistogram histogram = Debug.createHistogram("TestHistogram");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        histogram.add("MyCustomValue");
        new DebugHistogramAsciiPrinter(new PrintStream(outputStream), Integer.MAX_VALUE, 10, 10, 1).print(histogram);
        String[] lines = outputStream.toString().split("\r?\n");
        Assert.assertEquals(4, lines.length);
        Assert.assertEquals("TestHistogram has 1 unique elements and 1 total elements:", lines[0]);
        Assert.assertEquals("----------------------------------------", lines[1]);
        Assert.assertEquals("| MyCusto... | 1          | ========== |", lines[2]);
        Assert.assertEquals("----------------------------------------", lines[3]);
    }
}
