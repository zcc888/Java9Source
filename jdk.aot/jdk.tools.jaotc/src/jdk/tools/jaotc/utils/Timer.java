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

package jdk.tools.jaotc.utils;

import jdk.tools.jaotc.Main;

public class Timer implements AutoCloseable {

    private final Main main;
    private final long start;

    public Timer(Main main, String message) {
        this.main = main;
        start = System.currentTimeMillis();
        main.printInfo(message);
    }

    public void close() {
        final long end = System.currentTimeMillis();
        main.printlnInfo(" (" + (end - start) + " ms)");
    }

}
