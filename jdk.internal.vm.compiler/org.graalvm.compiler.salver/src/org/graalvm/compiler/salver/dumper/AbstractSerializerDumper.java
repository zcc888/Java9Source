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
package org.graalvm.compiler.salver.dumper;

import java.io.IOException;

import org.graalvm.compiler.salver.serialize.Serializer;

public abstract class AbstractSerializerDumper implements Dumper {

    protected Serializer serializer;

    public AbstractSerializerDumper() {
    }

    public AbstractSerializerDumper(Serializer serializer) {
        this.serializer = serializer;
    }

    public Serializer getSerializer() {
        return serializer;
    }

    public void setSerializer(Serializer serializer) {
        this.serializer = serializer;
    }

    protected void serialize(Object obj) throws IOException {
        if (serializer != null) {
            serializer.serialize(obj);
        }
    }

    protected void serializeAndFlush(Object obj) throws IOException {
        if (serializer != null) {
            serializer.serialize(obj);
            serializer.flush();
        }
    }

    @Override
    public void close() throws IOException {
    }
}
