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
package org.graalvm.compiler.graph;

import java.util.Map;
import java.util.function.Consumer;

/**
 * This class is a container of a graph that needs to be readonly and optionally a lazily created
 * mutable copy of the graph.
 */
public final class CachedGraph<G extends Graph> {

    private final G readonlyCopy;
    private G mutableCopy;

    private CachedGraph(G readonlyCopy, G mutableCopy) {
        this.readonlyCopy = readonlyCopy;
        this.mutableCopy = mutableCopy;
    }

    public static <G extends Graph> CachedGraph<G> fromReadonlyCopy(G graph) {
        return new CachedGraph<>(graph, null);
    }

    public static <G extends Graph> CachedGraph<G> fromMutableCopy(G graph) {
        return new CachedGraph<>(graph, graph);
    }

    public G getReadonlyCopy() {
        if (hasMutableCopy()) {
            return mutableCopy;
        }
        return readonlyCopy;
    }

    public boolean hasMutableCopy() {
        return mutableCopy != null;
    }

    @SuppressWarnings("unchecked")
    public G getMutableCopy(Consumer<Map<Node, Node>> duplicationMapCallback) {
        if (!hasMutableCopy()) {
            mutableCopy = (G) readonlyCopy.copy(duplicationMapCallback);
        }
        return mutableCopy;
    }
}
