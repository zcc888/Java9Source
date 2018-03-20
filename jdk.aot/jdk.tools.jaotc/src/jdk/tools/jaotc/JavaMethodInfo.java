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
import jdk.vm.ci.hotspot.HotSpotCompiledCode;

public interface JavaMethodInfo {

    /**
     * @return unique symbol name for this method.
     */
    String getSymbolName();

    /**
     * Name a java method with J.L.S. class name and signature.
     *
     * @return unique name for this method including class and signature
     */
    String getNameAndSignature();

    HotSpotCompiledCode compiledCode(CompilationResult result);

}
