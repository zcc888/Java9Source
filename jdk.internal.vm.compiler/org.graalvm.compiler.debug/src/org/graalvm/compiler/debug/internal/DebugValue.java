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
package org.graalvm.compiler.debug.internal;

/**
 * A name and index for a value managed in a thread local value map. All access to the value is made
 * via a {@link DebugValue} instance.
 */
public abstract class DebugValue implements Comparable<DebugValue> {

    private final String name;
    private int index;
    private boolean conditional;

    protected DebugValue(String name, boolean conditional) {
        this.name = name;
        this.index = -1;
        this.conditional = conditional;
    }

    public long getCurrentValue() {
        ensureInitialized();
        return DebugScope.getInstance().getCurrentValue(index);
    }

    protected void setCurrentValue(long l) {
        ensureInitialized();
        DebugScope.getInstance().setCurrentValue(index, l);
    }

    public void setConditional(boolean flag) {
        conditional = flag;
    }

    public boolean isConditional() {
        return conditional;
    }

    private void ensureInitialized() {
        if (index == -1) {
            index = KeyRegistry.register(this);
        }
    }

    protected void addToCurrentValue(long value) {
        setCurrentValue(getCurrentValue() + value);
    }

    /**
     * Gets the globally unique index for the value represented by this object.
     */
    public int getIndex() {
        ensureInitialized();
        return index;
    }

    /**
     * Gets the globally unique name for the value represented by this object.
     */
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(DebugValue o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name + "@" + index;
    }

    public abstract String toString(long value);

    /**
     * The raw unit of the value (e.g. 'us', 'ms'). Use {@code ""} if there is no unit.
     */
    public abstract String rawUnit();

    /**
     * The raw value.
     */
    public abstract String toRawString(long value);
}