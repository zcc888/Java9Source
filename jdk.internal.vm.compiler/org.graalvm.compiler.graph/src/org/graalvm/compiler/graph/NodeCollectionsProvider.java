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

import java.util.Map;
import java.util.Set;

import org.graalvm.compiler.api.collections.CollectionsProvider;

/**
 * Extends {@link CollectionsProvider} with support for creating {@link Node} based collections.
 */
public interface NodeCollectionsProvider extends CollectionsProvider {

    /**
     * Creates a set of {@link Node}s that uses reference-equality in place of object-equality when
     * comparing entries.
     */
    <E extends Node> Set<E> newNodeIdentitySet();

    /**
     * Creates a map whose keys are {@link Node}s that uses reference-equality in place of
     * object-equality when comparing keys. All {@link Node} keys must be in the same graph.
     */
    <K extends Node, V> Map<K, V> newNodeIdentityMap();

    /**
     * Creates a map whose keys are {@link Node}s that uses reference-equality in place of
     * object-equality when comparing keys. All {@link Node} keys must be in the same graph.
     */
    <K extends Node, V> Map<K, V> newNodeIdentityMap(int expectedMaxSize);

    /**
     * Creates a map whose keys are {@link Node}s that uses reference-equality in place of
     * object-equality when comparing keys. All {@link Node} keys must be in the same graph.
     *
     * @param initFrom the returned map is populated with the entries in this map
     */
    <K extends Node, V> Map<K, V> newNodeIdentityMap(Map<K, V> initFrom);
}
