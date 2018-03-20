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
package org.graalvm.compiler.graph;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.graalvm.compiler.api.collections.DefaultCollectionsProvider;

/**
 * A default implementation of {@link NodeCollectionsProvider} that creates standard JDK collection
 * class objects.
 */
public class DefaultNodeCollectionsProvider extends DefaultCollectionsProvider implements NodeCollectionsProvider {

    @Override
    public <E extends Node> Set<E> newNodeIdentitySet() {
        return Collections.newSetFromMap(newNodeIdentityMap());
    }

    @Override
    public <K extends Node, V> Map<K, V> newNodeIdentityMap() {
        return new IdentityHashMap<>();
    }

    @Override
    public <K extends Node, V> Map<K, V> newNodeIdentityMap(int expectedMaxSize) {
        return new IdentityHashMap<>(expectedMaxSize);
    }

    @Override
    public <K extends Node, V> Map<K, V> newNodeIdentityMap(Map<K, V> initFrom) {
        return new IdentityHashMap<>(initFrom);
    }
}
