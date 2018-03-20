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
package org.graalvm.compiler.test;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * Facade for the {@code java.lang.Module} class introduced in JDK9 that allows tests to be
 * developed against JDK8 but use module logic if deployed on JDK9.
 */
public class JLModule {

    static {
        if (GraalTest.Java8OrEarlier) {
            throw new AssertionError("Use of " + JLModule.class + " only allowed if " + GraalTest.class.getName() + ".JDK8OrEarlier is false");
        }
    }

    private final Object realModule;

    public JLModule(Object module) {
        this.realModule = module;
    }

    private static final Class<?> moduleClass;
    private static final Method getModuleMethod;
    private static final Method getUnnamedModuleMethod;
    private static final Method getPackagesMethod;
    private static final Method isExportedMethod;
    private static final Method isExported2Method;
    private static final Method addExportsMethod;
    static {
        try {
            moduleClass = Class.forName("java.lang.Module");
            getModuleMethod = Class.class.getMethod("getModule");
            getUnnamedModuleMethod = ClassLoader.class.getMethod("getUnnamedModule");
            getPackagesMethod = moduleClass.getMethod("getPackages");
            isExportedMethod = moduleClass.getMethod("isExported", String.class);
            isExported2Method = moduleClass.getMethod("isExported", String.class, moduleClass);
            addExportsMethod = moduleClass.getMethod("addExports", String.class, moduleClass);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public static JLModule fromClass(Class<?> cls) {
        try {
            return new JLModule(getModuleMethod.invoke(cls));
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public static JLModule getUnnamedModuleFor(ClassLoader cl) {
        try {
            return new JLModule(getUnnamedModuleMethod.invoke(cl));
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Exports all packages in this module to a given module.
     */
    public void exportAllPackagesTo(JLModule module) {
        if (this != module) {
            for (String pkg : getPackages()) {
                // Export all JVMCI packages dynamically instead
                // of requiring a long list of -XaddExports
                // options on the JVM command line.
                if (!isExported(pkg, module)) {
                    addExports(pkg, module);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Set<String> getPackages() {
        try {
            return (Set<String>) getPackagesMethod.invoke(realModule);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public boolean isExported(String pn) {
        try {
            return (Boolean) isExportedMethod.invoke(realModule, pn);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public boolean isExported(String pn, JLModule other) {
        try {
            return (Boolean) isExported2Method.invoke(realModule, pn, other.realModule);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public void addExports(String pn, JLModule other) {
        try {
            addExportsMethod.invoke(realModule, pn, other.realModule);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
