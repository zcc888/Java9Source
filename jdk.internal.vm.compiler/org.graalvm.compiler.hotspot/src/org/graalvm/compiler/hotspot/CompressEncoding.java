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
package org.graalvm.compiler.hotspot;

/**
 * A compact representation of the different encoding strategies for Objects and metadata.
 */
public class CompressEncoding {
    public final long base;
    public final int shift;
    public final int alignment;

    CompressEncoding(long base, int shift, int alignment) {
        this.base = base;
        this.shift = shift;
        this.alignment = alignment;
    }

    public int compress(long ptr) {
        if (ptr == 0L) {
            return 0;
        } else {
            return (int) ((ptr - base) >>> shift);
        }
    }

    public long uncompress(int ptr) {
        if (ptr == 0) {
            return 0L;
        } else {
            return ((ptr & 0xFFFFFFFFL) << shift) + base;
        }
    }

    @Override
    public String toString() {
        return "base: " + base + " shift: " + shift + " alignment: " + alignment;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + alignment;
        result = prime * result + (int) (base ^ (base >>> 32));
        result = prime * result + shift;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CompressEncoding) {
            CompressEncoding other = (CompressEncoding) obj;
            return alignment == other.alignment && base == other.base && shift == other.shift;
        } else {
            return false;
        }
    }
}
