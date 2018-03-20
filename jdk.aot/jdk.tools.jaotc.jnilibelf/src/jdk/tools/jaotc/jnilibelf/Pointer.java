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

package jdk.tools.jaotc.jnilibelf;

import jdk.internal.misc.Unsafe;

import static jdk.tools.jaotc.jnilibelf.UnsafeAccess.UNSAFE;

public class Pointer {

    private final long address;

    public Pointer(long val) {
        address = val;
    }

    /**
     * Put (i.e., copy) content of byte array at consecutive addresses beginning at this Pointer.
     *
     * @param src source byte array
     */
    public void put(byte[] src) {
        UNSAFE.copyMemory(src, Unsafe.ARRAY_BYTE_BASE_OFFSET, null, address, src.length);
    }

    /**
     * Get (i.e., copy) content at this Pointer to the given byte array.
     *
     * @param dst destination byte array
     */
    public void get(byte[] dst) {
        UNSAFE.copyMemory(null, address, dst, Unsafe.ARRAY_BYTE_BASE_OFFSET, dst.length);
    }

    /**
     * Read {@code readSize} number of bytes to copy them starting at {@code startIndex} of
     * {@code byteArray}
     *
     * @param byteArray target array to copy bytes
     * @param readSize number of bytes to copy
     * @param startIndex index of the array to start copy at
     */
    public void copyBytesTo(byte[] byteArray, int readSize, int startIndex) {
        long end = (long)startIndex + (long)readSize;
        if (end > byteArray.length) {
            throw new IllegalArgumentException("writing beyond array bounds");
        }
        UNSAFE.copyMemory(null, address, byteArray, Unsafe.ARRAY_BYTE_BASE_OFFSET+startIndex, readSize);
    }

}
