/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

import java.io.Serializable;
import java.util.function.Supplier;

import org.graalvm.compiler.options.OptionValue.OverrideScope;

/**
 * A cached value that needs to be recomputed when an option changes.
 */
public class DerivedOptionValue<T> {

    public interface OptionSupplier<T> extends Supplier<T>, Serializable {
    }

    private T initialValue;
    private final OptionSupplier<T> supplier;

    public DerivedOptionValue(OptionSupplier<T> supplier) {
        this.supplier = supplier;
    }

    public T getValue() {
        OverrideScope overrideScope = OptionValue.getOverrideScope();
        if (overrideScope != null) {
            return overrideScope.getDerived(this);
        } else {
            if (initialValue == null) {
                initialValue = createValue();
            }
            return initialValue;
        }
    }

    T createValue() {
        return supplier.get();
    }
}
