/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.debug.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Registry for allocating a globally unique integer id to each {@link DebugValue}.
 */
public class KeyRegistry {

    private static final Map<String, Integer> keyMap = new HashMap<>();
    private static final List<DebugValue> debugValues = new ArrayList<>();

    /**
     * Ensures a given debug value is registered.
     *
     * @return the globally unique id for {@code value}
     */
    public static synchronized int register(DebugValue value) {
        String name = value.getName();
        if (!keyMap.containsKey(name)) {
            keyMap.put(name, debugValues.size());
            debugValues.add(value);
        }
        return keyMap.get(name);
    }

    /**
     * Gets a immutable view of the registered debug values.
     *
     * @return a list where {@code get(i).getIndex() == i}
     */
    public static synchronized List<DebugValue> getDebugValues() {
        return Collections.unmodifiableList(debugValues);
    }
}
