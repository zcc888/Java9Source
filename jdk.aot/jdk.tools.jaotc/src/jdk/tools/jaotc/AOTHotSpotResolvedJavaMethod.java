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

package jdk.tools.jaotc;

import org.graalvm.compiler.code.CompilationResult;
import org.graalvm.compiler.hotspot.HotSpotCompiledCodeBuilder;
import jdk.vm.ci.hotspot.HotSpotCompiledCode;
import jdk.vm.ci.hotspot.HotSpotResolvedJavaMethod;

public class AOTHotSpotResolvedJavaMethod implements JavaMethodInfo {

    private final HotSpotResolvedJavaMethod method;

    public AOTHotSpotResolvedJavaMethod(HotSpotResolvedJavaMethod method) {
        this.method = method;
    }

    public String getSymbolName() {
        return MiscUtils.uniqueMethodName(method);
    }

    public String getNameAndSignature() {
        String className = method.getDeclaringClass().getName();
        return className + "." + method.getName() + method.getSignature().toMethodDescriptor();
    }

    public HotSpotCompiledCode compiledCode(CompilationResult result) {
        return HotSpotCompiledCodeBuilder.createCompiledCode(method, null, result);
    }

}
