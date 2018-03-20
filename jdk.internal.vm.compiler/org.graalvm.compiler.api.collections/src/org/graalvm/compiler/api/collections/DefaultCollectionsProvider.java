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
package org.graalvm.compiler.api.collections;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

/**
 * A default implementation of {@link CollectionsProvider} that creates standard JDK collection
 * class objects.
 */
public class DefaultCollectionsProvider implements CollectionsProvider {

    @Override
    public <E> Set<E> newIdentitySet() {
        return Collections.newSetFromMap(newIdentityMap());
    }

    @Override
    public <K, V> Map<K, V> newIdentityMap() {
        return new IdentityHashMap<>();
    }

    @Override
    public <K, V> Map<K, V> newIdentityMap(int expectedMaxSize) {
        return new IdentityHashMap<>(expectedMaxSize);
    }

    @Override
    public <K, V> Map<K, V> newIdentityMap(Map<K, V> initFrom) {
        return new IdentityHashMap<>(initFrom);
    }
}
