/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.meta;

import org.graalvm.compiler.core.common.spi.ForeignCallsProvider;

import jdk.vm.ci.meta.Value;

/**
 * HotSpot extension of {@link ForeignCallsProvider}.
 */
public interface HotSpotForeignCallsProvider extends ForeignCallsProvider {

    /**
     * Gets the registers that must be saved across a foreign call into the runtime.
     */
    Value[] getNativeABICallerSaveRegisters();
}
