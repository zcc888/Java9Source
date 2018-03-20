/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.salver.handler;

import java.io.Closeable;
import java.io.IOException;

public interface DumpHandler extends Closeable, AutoCloseable {

    void dump(Object obj, String msg) throws IOException;
}
