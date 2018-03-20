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

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;

import org.graalvm.compiler.salver.dumper.Dumper;
import org.graalvm.compiler.salver.writer.ChannelDumpWriter;
import org.graalvm.compiler.salver.writer.DumpWriter;

public abstract class AbstractDumpHandler<D extends Dumper> implements DumpHandler {

    protected String label;

    protected DumpWriter writer;
    protected D dumper;

    public AbstractDumpHandler() {
        setLabel(getClass().getSimpleName() + ":" + Thread.currentThread().getName());
    }

    public String getLabel() {
        return label;
    }

    protected void setLabel(String label) {
        this.label = label;
    }

    public DumpWriter getWriter() {
        return writer;
    }

    protected void setWriter(DumpWriter writer) {
        this.writer = writer;
    }

    protected void setWriter(WritableByteChannel channel) {
        setWriter(new ChannelDumpWriter(channel));
    }

    protected void setWriter(SocketAddress remote) throws IOException {
        setWriter(SocketChannel.open(remote));
    }

    protected void setWriter(Path path) throws IOException {
        setWriter(path, WRITE, TRUNCATE_EXISTING, CREATE);
    }

    protected void setWriter(Path path, OpenOption... options) throws IOException {
        setWriter(FileChannel.open(path, options));
    }

    public D getDumper() {
        return dumper;
    }

    protected void setDumper(D dumper) {
        this.dumper = dumper;
    }

    @Override
    public void close() throws IOException {
        if (dumper != null) {
            try {
                dumper.close();
            } finally {
                dumper = null;
            }
        }
        if (writer != null) {
            try {
                writer.close();
            } finally {
                writer = null;
            }
        }
    }
}
