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
package org.graalvm.compiler.salver.writer;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface DumpWriter extends Closeable, Flushable, AutoCloseable {

    DumpWriter write(byte b) throws IOException;

    DumpWriter write(byte[] arr) throws IOException;

    DumpWriter write(ByteBuffer buf) throws IOException;

    DumpWriter write(CharSequence csq) throws IOException;

    DumpWriter writeChar(char v) throws IOException;

    DumpWriter writeShort(short v) throws IOException;

    DumpWriter writeInt(int v) throws IOException;

    DumpWriter writeLong(long v) throws IOException;

    DumpWriter writeFloat(float v) throws IOException;

    DumpWriter writeDouble(double v) throws IOException;
}
