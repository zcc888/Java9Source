/*
 * Copyright (c) 2009, 2017, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */

/**
 * IOUtils: A collection of IO-related public static methods.
 */

package sun.security.util;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class IOUtils {

    /**
     * Read up to {@code length} of bytes from {@code in}
     * until EOF is detected.
     * @param is input stream, must not be null
     * @param length number of bytes to read, -1 or Integer.MAX_VALUE means
     *        read as much as possible
     * @param readAll if true, an EOFException will be thrown if not enough
     *        bytes are read. Ignored when length is -1 or Integer.MAX_VALUE
     * @return bytes read
     * @throws IOException Any IO error or a premature EOF is detected
     */
    public static byte[] readFully(InputStream is, int length, boolean readAll)
            throws IOException {
        byte[] output = {};
        if (length == -1) length = Integer.MAX_VALUE;
        int pos = 0;
        while (pos < length) {
            int bytesToRead;
            if (pos >= output.length) { // Only expand when there's no room
                bytesToRead = Math.min(length - pos, output.length + 1024);
                if (output.length < pos + bytesToRead) {
                    output = Arrays.copyOf(output, pos + bytesToRead);
                }
            } else {
                bytesToRead = output.length - pos;
            }
            int cc = is.read(output, pos, bytesToRead);
            if (cc < 0) {
                if (readAll && length != Integer.MAX_VALUE) {
                    throw new EOFException("Detect premature EOF");
                } else {
                    if (output.length != pos) {
                        output = Arrays.copyOf(output, pos);
                    }
                    break;
                }
            }
            pos += cc;
        }
        return output;
    }

    /**
     * Read {@code length} of bytes from {@code in}. An exception is
     * thrown if there are not enough bytes in the stream.
     *
     * @param is input stream, must not be null
     * @param length number of bytes to read, must not be negative
     * @return bytes read
     * @throws IOException if any IO error or a premature EOF is detected, or
     *      if {@code length} is negative since this length is usually also
     *      read from {@code is}.
     */
    public static byte[] readNBytes(InputStream is, int length) throws IOException {
        if (length < 0) {
            throw new IOException("length cannot be negative: " + length);
        }
        return readFully(is, length, true);
    }
}
