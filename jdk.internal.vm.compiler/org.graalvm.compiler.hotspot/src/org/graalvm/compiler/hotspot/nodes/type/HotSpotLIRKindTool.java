/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.nodes.type;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.core.common.spi.LIRKindTool;

/**
 * Extension of {@link LIRKindTool} that includes support for compressed pointer kinds.
 */
public interface HotSpotLIRKindTool extends LIRKindTool {

    /**
     * Get the platform specific kind used to represent compressed oops.
     */
    LIRKind getNarrowOopKind();

    /**
     * Gets the platform specific kind used to represent compressed metaspace pointers.
     */
    LIRKind getNarrowPointerKind();
}
