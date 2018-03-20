/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.test;

import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import org.junit.Test;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.api.replacements.MethodSubstitution;
import org.graalvm.compiler.replacements.test.MethodSubstitutionTest;

/**
 * Tests HotSpot specific {@link MethodSubstitution}s.
 */
public class HotSpotMethodSubstitutionTest extends MethodSubstitutionTest {

    @Test
    public void testObjectSubstitutions() {
        TestClassA obj = new TestClassA();

        testGraph("getClass0");
        testGraph("objectHashCode");

        test("getClass0", "a string");
        test("objectHashCode", obj);
    }

    @SuppressWarnings("all")
    public static Class<?> getClass0(Object obj) {
        return obj.getClass();
    }

    @SuppressWarnings("all")
    public static int objectHashCode(TestClassA obj) {
        return obj.hashCode();
    }

    @Test
    public void testClassSubstitutions() {
        testGraph("getModifiers");
        testGraph("isInterface");
        testGraph("isArray");
        testGraph("isPrimitive");
        testGraph("getSuperClass");
        testGraph("getComponentType");

        for (Class<?> c : new Class<?>[]{getClass(), Cloneable.class, int[].class, String[][].class}) {
            test("getModifiers", c);
            test("isInterface", c);
            test("isArray", c);
            test("isPrimitive", c);
            test("getSuperClass", c);
            test("getComponentType", c);
        }
    }

    @SuppressWarnings("all")
    public static int getModifiers(Class<?> clazz) {
        return clazz.getModifiers();
    }

    @SuppressWarnings("all")
    public static boolean isInterface(Class<?> clazz) {
        return clazz.isInterface();
    }

    @SuppressWarnings("all")
    public static boolean isArray(Class<?> clazz) {
        return clazz.isArray();
    }

    @SuppressWarnings("all")
    public static boolean isPrimitive(Class<?> clazz) {
        return clazz.isPrimitive();
    }

    @SuppressWarnings("all")
    public static Class<?> getSuperClass(Class<?> clazz) {
        return clazz.getSuperclass();
    }

    @SuppressWarnings("all")
    public static Class<?> getComponentType(Class<?> clazz) {
        return clazz.getComponentType();
    }

    @Test
    public void testThreadSubstitutions() {
        testGraph("currentThread");
        testGraph("threadIsInterrupted");
        testGraph("threadInterrupted");

        Thread currentThread = Thread.currentThread();
        test("currentThread", currentThread);
        test("threadIsInterrupted", currentThread);
    }

    @SuppressWarnings("all")
    public static boolean currentThread(Thread other) {
        return Thread.currentThread() == other;
    }

    @SuppressWarnings("all")
    public static boolean threadIsInterrupted(Thread thread) {
        return thread.isInterrupted();
    }

    @SuppressWarnings("all")
    public static boolean threadInterrupted() {
        return Thread.interrupted();
    }

    @Test
    public void testSystemSubstitutions() {
        testGraph("systemTime");
        testGraph("systemIdentityHashCode");

        for (Object o : new Object[]{this, new int[5], new String[2][], new Object()}) {
            test("systemIdentityHashCode", o);
        }
    }

    @SuppressWarnings("all")
    public static long systemTime() {
        return System.currentTimeMillis() + System.nanoTime();
    }

    @SuppressWarnings("all")
    public static int systemIdentityHashCode(Object obj) {
        return System.identityHashCode(obj);
    }

    private static class TestClassA {
    }

    public static String testCallSiteGetTargetSnippet(int i) throws Exception {
        ConstantCallSite site;
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        switch (i) {
            case 1:
                site = GraalDirectives.opaque(new ConstantCallSite(lookup.findVirtual(String.class, "replace", MethodType.methodType(String.class, char.class, char.class))));
                break;
            default:
                site = GraalDirectives.opaque(new ConstantCallSite(lookup.findStatic(java.util.Arrays.class, "asList", MethodType.methodType(java.util.List.class, Object[].class))));
        }
        return site.getTarget().toString();
    }

    public static String testCastSnippet(int i, Object obj) throws Exception {
        Class<?> c;
        switch (i) {
            case 1:
                c = GraalDirectives.opaque(Number.class);
                break;
            default:
                c = GraalDirectives.opaque(Integer.class);
                break;
        }
        return c.cast(obj).toString();
    }

    public static String testGetClassSnippet(int i) {
        Object c;
        switch (i) {
            case 1:
                c = GraalDirectives.opaque(new Object());
                break;
            default:
                c = GraalDirectives.opaque("TEST");
                break;
        }
        return c.getClass().toString();
    }

    /**
     * Tests ambiguous receiver of CallSite.getTarget.
     */
    @Test
    public void testCallSiteGetTarget() {
        test("testCallSiteGetTargetSnippet", 1);
    }

    /**
     * Tests ambiguous receiver of Class.cast.
     */
    @Test
    public void testCast() {
        test("testCastSnippet", 1, new Integer(1));
    }

    /**
     * Tests ambiguous receiver of Object.getClass.
     */
    @Test
    public void testGetClass() {
        test("testGetClassSnippet", 1);
    }
}
