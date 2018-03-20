/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.debug.internal.method;

import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.internal.DebugScope;
import org.graalvm.compiler.debug.internal.DebugScope.ExtraInfo;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public class MethodMetricsRootScopeInfo implements ExtraInfo {
    protected final ResolvedJavaMethod rootMethod;

    MethodMetricsRootScopeInfo(ResolvedJavaMethod rootMethod) {
        this.rootMethod = rootMethod;
    }

    public ResolvedJavaMethod getRootMethod() {
        return rootMethod;
    }

    public static MethodMetricsRootScopeInfo create(ResolvedJavaMethod rootMethod) {
        return new MethodMetricsRootScopeInfo(rootMethod);
    }

    /**
     * Creates and returns a {@link org.graalvm.compiler.debug.Debug.Scope scope} iff there is no
     * existing {@linkplain org.graalvm.compiler.debug.internal.DebugScope.ExtraInfo extraInfo}
     * object of type {@link MethodMetricsRootScopeInfo} present in the current {@link DebugScope
     * scope}.
     *
     * @param method
     * @return a new {@link org.graalvm.compiler.debug.Debug.Scope scope} or {@code null} iff there
     *         is already an existing one on the scope
     */
    public static Debug.Scope createRootScopeIfAbsent(ResolvedJavaMethod method) {
        /*
         * if the current compilation is not triggered from JVMCI we need a valid context root
         * method for method metrics
         */
        return DebugScope.getInstance().getExtraInfo() instanceof MethodMetricsRootScopeInfo ? null : Debug.methodMetricsScope("GraalCompilerRoot", MethodMetricsRootScopeInfo.create(method), true);
    }

}
