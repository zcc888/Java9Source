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

import org.graalvm.compiler.debug.GraalDebugConfig;
import org.graalvm.compiler.debug.internal.DebugScope;
import org.graalvm.compiler.debug.internal.DebugScope.ExtraInfo;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public class MethodMetricsInlineeScopeInfo extends MethodMetricsRootScopeInfo {

    MethodMetricsInlineeScopeInfo(ResolvedJavaMethod rootMethod) {
        super(rootMethod);
    }

    public static MethodMetricsInlineeScopeInfo create(ResolvedJavaMethod rootMethod) {
        if (GraalDebugConfig.isGlobalMetricsInterceptedByMethodMetricsEnabled()) {
            return new MethodMetricsInlineeScopeInfo(rootMethod);
        }
        return null;
    }

    public static MethodMetricsInlineeScopeInfo create() {
        if (GraalDebugConfig.isGlobalMetricsInterceptedByMethodMetricsEnabled()) {
            ExtraInfo rootInfo = DebugScope.getInstance().getExtraInfo();
            if (rootInfo instanceof MethodMetricsRootScopeInfo) {
                return new MethodMetricsInlineeScopeInfo(((MethodMetricsRootScopeInfo) rootInfo).getRootMethod());
            }
        }
        return null;
    }

}
