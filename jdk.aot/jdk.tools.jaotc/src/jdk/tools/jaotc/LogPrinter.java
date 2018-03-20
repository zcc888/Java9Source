/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jaotc;

public interface LogPrinter {
    void printInfo(String s);

    void printlnVerbose(String s);

    void printlnInfo(String s);

    void printError(String s);
}
