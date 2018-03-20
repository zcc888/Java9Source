/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.debug;

import org.graalvm.compiler.debug.Debug.Params;

/**
 * Defines a service that can modify the {@linkplain Params parameters} for {@link Debug}.
 */
public interface DebugInitializationParticipant {

    /**
     * Modifies the given {@link Debug} initialization parameters as necessary.
     */
    void apply(Params params);
}
