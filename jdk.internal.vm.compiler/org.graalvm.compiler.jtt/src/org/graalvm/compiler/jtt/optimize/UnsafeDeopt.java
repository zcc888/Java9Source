/*
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.jtt.optimize;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

import org.junit.Test;
import org.junit.internal.AssumptionViolatedException;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.jtt.JTTTest;

import jdk.vm.ci.meta.ResolvedJavaMethod;
import sun.misc.Unsafe;

public class UnsafeDeopt extends JTTTest {
    private static final Unsafe unsafe;

    static {
        try {
            final Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            unsafe = (Unsafe) unsafeField.get(null);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static int readWriteReadUnsafe(long addr, int m) {
        int original = unsafe.getInt(addr);
        if (original != 0) {
            return -m;
        }
        unsafe.putInt(addr, m);
        if (m > 10) {
            if (m > 20) {
                GraalDirectives.deoptimize();
            }
            unsafe.putInt(addr + 4, m);
        }
        return unsafe.getInt(addr);
    }

    public static int readWriteReadByteBuffer(ByteBuffer buffer, int m) {
        int original = buffer.getInt(0);
        if (original != 0) {
            return -m;
        }
        buffer.putInt(0, m);
        if (m > 10) {
            if (m > 20) {
                GraalDirectives.deoptimize();
                buffer.putInt(4, m);
            }
        }
        return buffer.getInt(0);
    }

    public long createBuffer() {
        long addr = unsafe.allocateMemory(32);
        unsafe.setMemory(addr, 32, (byte) 0);
        return addr;
    }

    public void disposeBuffer(long addr) {
        unsafe.freeMemory(addr);
    }

    @Test
    public void testUnsafe() {
        int m = 42;
        long addr1 = createBuffer();
        long addr2 = createBuffer();
        try {
            ResolvedJavaMethod method = getResolvedJavaMethod("readWriteReadUnsafe");
            Object receiver = method.isStatic() ? null : this;
            Result expect = executeExpected(method, receiver, addr1, m);
            if (getCodeCache() == null) {
                return;
            }
            testAgainstExpected(method, expect, receiver, addr2, m);
        } catch (AssumptionViolatedException e) {
            // Suppress so that subsequent calls to this method within the
            // same Junit @Test annotated method can proceed.
        } finally {
            disposeBuffer(addr1);
            disposeBuffer(addr2);
        }
    }

    @Test
    public void testByteBuffer() {
        int m = 42;
        try {
            ResolvedJavaMethod method = getResolvedJavaMethod("readWriteReadByteBuffer");
            Object receiver = method.isStatic() ? null : this;
            Result expect = executeExpected(method, receiver, ByteBuffer.allocateDirect(32), m);
            if (getCodeCache() == null) {
                return;
            }
            ByteBuffer warmupBuffer = ByteBuffer.allocateDirect(32);
            for (int i = 0; i < 10000; ++i) {
                readWriteReadByteBuffer(warmupBuffer, (i % 50) + 1);
                warmupBuffer.putInt(0, 0);
            }
            testAgainstExpected(method, expect, receiver, ByteBuffer.allocateDirect(32), m);
        } catch (AssumptionViolatedException e) {
            // Suppress so that subsequent calls to this method within the
            // same Junit @Test annotated method can proceed.
        }
    }
}
