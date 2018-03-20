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

import java.io.Flushable;
import java.io.IOException;

import org.graalvm.compiler.salver.writer.DumpWriter;

public interface Serializer extends Flushable {

    DumpWriter getWriter();

    void setWriter(DumpWriter writer);

    Serializer serialize(Object obj) throws IOException;

    void reset() throws IOException;
}
