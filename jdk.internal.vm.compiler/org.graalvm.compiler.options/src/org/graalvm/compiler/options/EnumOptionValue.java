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
package org.graalvm.compiler.options;

import java.util.EnumSet;

public class EnumOptionValue<T extends Enum<T>> extends OptionValue<T> {
    final Class<T> enumClass;

    @SuppressWarnings("unchecked")
    public EnumOptionValue(T value) {
        super(value);
        if (value == null) {
            throw new IllegalArgumentException("Value must not be null");
        }
        this.enumClass = (Class<T>) value.getClass();
    }

    /**
     *
     * @return the set of possible values for this option.
     */
    public EnumSet<T> getOptionValues() {
        return EnumSet.allOf(enumClass);
    }

    @Override
    public void setValue(Object v) {
        try {
            super.setValue(Enum.valueOf(enumClass, (String) v));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("\"" + v + "\" is not a valid option for " + getName() + ".  Valid values are " + EnumSet.allOf(enumClass));
        }
    }
}
