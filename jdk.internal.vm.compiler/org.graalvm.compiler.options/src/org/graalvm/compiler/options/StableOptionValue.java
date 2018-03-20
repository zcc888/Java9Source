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
package org.graalvm.compiler.options;

/**
 * An option that always returns the same {@linkplain #getValue() value}.
 */
public class StableOptionValue<T> extends OptionValue<T> {

    /**
     * Creates a stable option value.
     */
    public StableOptionValue(T value) {
        super(value);
    }

    /**
     * Used to assert the invariant for stability. Without using locks, this check is not safe
     * against races and so it's only an assertion.
     */
    private boolean getValueCalled;

    /**
     * Creates an uninitialized stable option value for a subclass that initializes itself
     * {@link #defaultValue() lazily}.
     */
    public StableOptionValue() {
    }

    /**
     * Gets the value of this option.
     */
    @Override
    public final T getValue() {
        T result = super.getValue();
        assert initGetValueCalled();
        return result;
    }

    private boolean initGetValueCalled() {
        getValueCalled = true;
        return true;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This must only be called if {@link #getValue()} has never been called.
     */
    @Override
    public final void setValue(Object v) {
        assert !getValueCalled;
        super.setValue(v);
    }
}
