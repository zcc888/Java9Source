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

import jdk.tools.jaotc.binformat.BinaryContainer;
import jdk.tools.jaotc.binformat.Symbol.Binding;

/**
 * Call to a Graal stub, the symbol name should be direct.
 */
final class StubDirectCallSiteRelocationSymbol extends CallSiteRelocationSymbol {

    public StubDirectCallSiteRelocationSymbol(CallSiteRelocationInfo callSiteRelocation, BinaryContainer binaryContainer) {
        super(binaryContainer.getSymbol(callSiteRelocation.targetSymbol));
        assert symbol != null && symbol.getBinding() == Binding.LOCAL : "Stub symbol must exist and must be LOCAL";
    }

}
