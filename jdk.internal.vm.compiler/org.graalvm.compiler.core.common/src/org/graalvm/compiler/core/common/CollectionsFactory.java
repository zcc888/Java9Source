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
package org.graalvm.compiler.core.common;

import static org.graalvm.compiler.core.common.CollectionsFactory.Mode.STANDARD;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Factory for creating collection objects used during compilation.
 */
public class CollectionsFactory {

    private static final ThreadLocal<Mode> tl = new ThreadLocal<>();

    public static class ModeScope implements AutoCloseable {
        private final Mode previousMode;

        public ModeScope(Mode previousMode) {
            this.previousMode = previousMode;
        }

        @Override
        public void close() {
            tl.set(previousMode);
        }
    }

    /**
     * Constants denoting what type of collections are {@link CollectionsFactory#getMode()
     * currently} returned by the factory.
     */
    public enum Mode {
        /**
         * Denotes standard collections such as {@link HashSet} and {@link HashMap}.
         */
        STANDARD,

        /**
         * Denotes collections that have a deterministic iteration order over their keys/entries.
         */
        DETERMINISTIC_ITERATION_ORDER;
    }

    /**
     * Gets the current mode determining the type of collection objects created by this factory.
     */
    public static Mode getMode() {
        Mode mode = tl.get();
        return mode == null ? Mode.STANDARD : mode;
    }

    /**
     * Updates the mode for the current thread.
     *
     * @return an object which when {@linkplain ModeScope#close() closed} will revert the mode of
     *         the current thread to the state before calling this method
     */
    public static ModeScope changeMode(Mode mode) {
        Mode previousMode = tl.get();
        tl.set(mode);
        return new ModeScope(previousMode);
    }

    public static <K, V> HashMap<K, V> newMap() {
        return getMode() == STANDARD ? new HashMap<>() : new LinkedHashMap<>();
    }

    public static <K, V> HashMap<K, V> newMap(Map<K, V> m) {
        return getMode() == STANDARD ? new HashMap<>(m) : new LinkedHashMap<>(m);
    }

    public static <K, V> HashMap<K, V> newMap(int initialCapacity) {
        return getMode() == STANDARD ? new HashMap<>(initialCapacity) : new LinkedHashMap<>(initialCapacity);
    }

    public static <K, V> Map<K, V> newIdentityMap() {
        return getMode() == STANDARD ? new IdentityHashMap<>() : new LinkedIdentityHashMap<>();
    }

    public static <K, V> Map<K, V> newIdentityMap(int expectedMaxSize) {
        return getMode() == STANDARD ? new IdentityHashMap<>(expectedMaxSize) : new LinkedIdentityHashMap<>();
    }

    public static <K, V> Map<K, V> newIdentityMap(Map<K, V> m) {
        return getMode() == STANDARD ? new IdentityHashMap<>(m) : new LinkedIdentityHashMap<>(m);
    }

    /**
     * Creates a set. If the current thread is {@linkplain CollectionsFactory#getMode() using}
     * {@link Mode#DETERMINISTIC_ITERATION_ORDER} collections, the returned set will have an
     * iteration order determined by the order in which elements are inserted in the set.
     */
    public static <E> Set<E> newSet() {
        return CollectionsFactory.getMode() == Mode.STANDARD ? new HashSet<>() : new LinkedHashSet<>();
    }

    /**
     * @see #newSet()
     */
    public static <E> Set<E> newSet(Collection<? extends E> c) {
        return CollectionsFactory.getMode() == Mode.STANDARD ? new HashSet<>(c) : new LinkedHashSet<>(c);
    }

}
