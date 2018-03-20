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
package org.graalvm.compiler.salver.serialize;

import java.io.IOException;

import org.graalvm.compiler.salver.writer.DumpWriter;

public abstract class AbstractSerializer implements Serializer {

    protected DumpWriter writer;

    public AbstractSerializer() {
    }

    public AbstractSerializer(DumpWriter writer) {
        if (writer != null) {
            setWriter(writer);
        }
    }

    @Override
    public DumpWriter getWriter() {
        return writer;
    }

    @Override
    public void setWriter(DumpWriter writer) {
        this.writer = writer;
    }

    @Override
    public void reset() throws IOException {
    }

    @Override
    public void flush() throws IOException {
        if (writer != null) {
            writer.flush();
        }
    }
}
