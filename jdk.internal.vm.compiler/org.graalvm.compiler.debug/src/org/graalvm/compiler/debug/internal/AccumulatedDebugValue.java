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
package org.graalvm.compiler.debug.internal;

public abstract class AccumulatedDebugValue extends DebugValue {
    protected final DebugValue flat;

    public AccumulatedDebugValue(String name, boolean conditional, DebugValue flat) {
        super(name + "_Accm", conditional);
        this.flat = flat;
    }
}
