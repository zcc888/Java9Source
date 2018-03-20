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
package org.graalvm.compiler.lir.util;

import java.util.Map;

import org.graalvm.compiler.core.common.CollectionsFactory;

import jdk.vm.ci.meta.Value;

public final class GenericValueMap<T> extends ValueMap<Value, T> {

    private final Map<Value, T> data;

    public GenericValueMap() {
        data = CollectionsFactory.newMap();
    }

    @Override
    public T get(Value value) {
        return data.get(value);
    }

    @Override
    public void remove(Value value) {
        data.remove(value);
    }

    @Override
    public void put(Value value, T object) {
        data.put(value, object);
    }

}
