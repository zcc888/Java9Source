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
import org.graalvm.compiler.core.target.Backend;
import org.graalvm.compiler.hotspot.HotSpotCompiledCodeBuilder;
import org.graalvm.compiler.hotspot.stubs.Stub;

import jdk.vm.ci.hotspot.HotSpotCompiledCode;

public class AOTStub implements JavaMethodInfo {

    private final Stub stub;
    private final Backend backend;

    public AOTStub(Stub stub, Backend backend) {
        this.stub = stub;
        this.backend = backend;
    }

    public String getSymbolName() {
        return stub.toString();
    }

    public String getNameAndSignature() {
        return stub.toString();
    }

    public HotSpotCompiledCode compiledCode(CompilationResult result) {
        return HotSpotCompiledCodeBuilder.createCompiledCode(null, null, result);
    }

}
