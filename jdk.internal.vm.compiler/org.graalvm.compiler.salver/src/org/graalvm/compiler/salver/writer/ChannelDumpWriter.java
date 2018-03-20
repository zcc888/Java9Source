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

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;

public class ChannelDumpWriter implements DumpWriter {

    private static final int BUFFER_CAPACITY = 256 * 1024;

    protected final WritableByteChannel channel;
    protected final ByteBuffer buffer;

    public ChannelDumpWriter(WritableByteChannel channel) {
        this(channel, ByteBuffer.allocateDirect(BUFFER_CAPACITY));
    }

    public ChannelDumpWriter(WritableByteChannel channel, ByteBuffer buffer) {
        this.channel = channel;
        this.buffer = buffer;
    }

    private void ensureAvailable(int len) throws IOException {
        if (buffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (buffer.capacity() < len) {
            throw new IllegalArgumentException();
        }
        while (buffer.remaining() < len) {
            flush();
        }
    }

    @Override
    public ChannelDumpWriter write(byte b) throws IOException {
        ensureAvailable(1);
        buffer.put(b);
        return this;
    }

    @Override
    public ChannelDumpWriter write(byte[] arr) throws IOException {
        if (buffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        int offset = 0;
        while (offset < arr.length) {
            int available = buffer.remaining();
            int length = Math.min(available, arr.length - offset);
            buffer.put(arr, offset, length);
            if (!buffer.hasRemaining()) {
                flush();
            }
            offset += length;
        }
        return this;
    }

    @Override
    public ChannelDumpWriter write(ByteBuffer buf) throws IOException {
        if (buf == buffer) {
            throw new IllegalArgumentException();
        }
        if (buffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        while (buf.hasRemaining()) {
            int available = buffer.remaining();
            int remaining = buf.remaining();
            for (int i = 0, n = Math.min(available, remaining); i < n; i++) {
                buffer.put(buf.get());
            }
            if (!buffer.hasRemaining()) {
                flush();
            }
        }
        return this;
    }

    @Override
    public ChannelDumpWriter write(CharSequence csq) throws IOException {
        if (buffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        CharsetEncoder encoder = StandardCharsets.UTF_8.newEncoder();
        CharBuffer buf = CharBuffer.wrap(csq);
        while (true) {
            CoderResult result = encoder.encode(buf, buffer, true);
            if (result.isError()) {
                throw new IOException(result.toString());
            }
            if (!buffer.hasRemaining()) {
                flush();
            }
            if (result.isOverflow()) {
                continue;
            }
            break;
        }
        return this;
    }

    @Override
    public ChannelDumpWriter writeChar(char v) throws IOException {
        ensureAvailable(1 << 1);
        buffer.putChar(v);
        return this;
    }

    @Override
    public ChannelDumpWriter writeShort(short v) throws IOException {
        ensureAvailable(1 << 1);
        buffer.putShort(v);
        return this;
    }

    @Override
    public ChannelDumpWriter writeInt(int v) throws IOException {
        ensureAvailable(1 << 2);
        buffer.putInt(v);
        return this;
    }

    @Override
    public ChannelDumpWriter writeLong(long v) throws IOException {
        ensureAvailable(1 << 3);
        buffer.putLong(v);
        return this;
    }

    @Override
    public ChannelDumpWriter writeFloat(float v) throws IOException {
        ensureAvailable(1 << 2);
        buffer.putFloat(v);
        return this;
    }

    @Override
    public ChannelDumpWriter writeDouble(double v) throws IOException {
        ensureAvailable(1 << 3);
        buffer.putDouble(v);
        return this;
    }

    @Override
    public void flush() throws IOException {
        if (buffer != null && channel != null) {
            buffer.flip();
            channel.write(buffer);
            buffer.compact();
        }
    }

    @Override
    public void close() throws IOException {
        if (channel != null) {
            try {
                flush();
            } finally {
                channel.close();
            }
        }
    }
}
