/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.core.common.util;

import static org.graalvm.compiler.core.common.util.Util.JAVA_SPECIFICATION_VERSION;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Reflection based access to the Module API introduced by JDK 9. This allows the API to be used in
 * code that must be compiled on a JDK prior to 9. Use of this class must be guarded by a test for
 * JDK 9 or later. For example:
 *
 * <pre>
 * if (Util.JAVA_SPECIFICATION_VERSION >= 9) {
 *     // Use of ModuleAPI
 * }
 * </pre>
 */
public final class ModuleAPI {

    private ModuleAPI(Method method) {
        this.method = method;
    }

    private final Method method;

    /**
     * {@code Class.getModule()}.
     */
    public static final ModuleAPI getModule;

    /**
     * {@code java.lang.Module.getResourceAsStream(String)}.
     */
    public static final ModuleAPI getResourceAsStream;

    /**
     * {@code java.lang.Module.canRead(Module)}.
     */
    public static final ModuleAPI canRead;

    /**
     * {@code java.lang.Module.isExported(String)}.
     */
    public static final ModuleAPI isExported;

    /**
     * {@code java.lang.Module.isExported(String, Module)}.
     */
    public static final ModuleAPI isExportedTo;

    /**
     * Invokes the static Module API method represented by this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T invokeStatic(Object... args) {
        checkAvailability();
        assert Modifier.isStatic(method.getModifiers());
        try {
            return (T) method.invoke(null, args);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new InternalError(e);
        }
    }

    /**
     * Invokes the non-static Module API method represented by this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T invoke(Object receiver, Object... args) {
        checkAvailability();
        assert !Modifier.isStatic(method.getModifiers());
        try {
            return (T) method.invoke(receiver, args);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new InternalError(e);
        }
    }

    private void checkAvailability() throws InternalError {
        if (method == null) {
            throw new InternalError("Cannot use Module API on JDK " + JAVA_SPECIFICATION_VERSION);
        }
    }

    static {
        if (JAVA_SPECIFICATION_VERSION >= 9) {
            try {
                getModule = new ModuleAPI(Class.class.getMethod("getModule"));
                Class<?> moduleClass = getModule.method.getReturnType();
                getResourceAsStream = new ModuleAPI(moduleClass.getMethod("getResourceAsStream", String.class));
                canRead = new ModuleAPI(moduleClass.getMethod("canRead", moduleClass));
                isExported = new ModuleAPI(moduleClass.getMethod("isExported", String.class));
                isExportedTo = new ModuleAPI(moduleClass.getMethod("isExported", String.class, moduleClass));
            } catch (NoSuchMethodException | SecurityException e) {
                throw new InternalError(e);
            }
        } else {
            ModuleAPI unavailable = new ModuleAPI(null);
            getModule = unavailable;
            getResourceAsStream = unavailable;
            canRead = unavailable;
            isExported = unavailable;
            isExportedTo = unavailable;
        }
    }
}
