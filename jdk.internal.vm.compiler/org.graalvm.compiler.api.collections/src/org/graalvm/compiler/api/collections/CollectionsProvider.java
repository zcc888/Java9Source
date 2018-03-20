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

import java.util.Map;
import java.util.Set;

/**
 * A factory for creating collections.
 */
public interface CollectionsProvider {

    /**
     * Creates a set that uses reference-equality in place of object-equality when comparing
     * entries.
     */
    <E> Set<E> newIdentitySet();

    /**
     * Creates a map that uses reference-equality in place of object-equality when comparing keys.
     */
    <K, V> Map<K, V> newIdentityMap();

    /**
     * Creates a map that uses reference-equality in place of object-equality when comparing keys.
     *
     * @param expectedMaxSize the expected maximum size of the map
     */
    <K, V> Map<K, V> newIdentityMap(int expectedMaxSize);

    /**
     * Creates a map that uses reference-equality in place of object-equality when comparing keys.
     *
     * @param initFrom the returned map is populated with the entries in this map
     */
    <K, V> Map<K, V> newIdentityMap(Map<K, V> initFrom);
}
