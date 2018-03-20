/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.nodes.spi.LoweringProvider;

/**
 * HotSpot implementation of {@link LoweringProvider}.
 */
public interface HotSpotLoweringProvider extends LoweringProvider {

    void initialize(HotSpotProviders providers, GraalHotSpotVMConfig config);
}
