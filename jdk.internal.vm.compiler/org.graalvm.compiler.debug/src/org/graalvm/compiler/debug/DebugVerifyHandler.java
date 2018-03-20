/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Performs some kind of verification on an object.
 */
public interface DebugVerifyHandler {

    /**
     * Verifies that a given object satisfies some invariants.
     *
     * @param object object to verify
     * @param message description of verification context
     */
    void verify(Object object, String message);
}
