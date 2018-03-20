/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.debug.DebugHistogram;

public class DebugHistogramImpl implements DebugHistogram {

    private final String name;
    private HashMap<Object, CountedValue> map = new HashMap<>();

    public DebugHistogramImpl(String name) {
        this.name = name;
    }

    @Override
    public void add(Object value) {
        CountedValue cv = map.get(value);
        if (cv == null) {
            map.put(value, new CountedValue(1, value));
        } else {
            cv.inc();
        }
    }

    @Override
    public void add(Object value, long count) {
        CountedValue cv = map.get(value);
        if (cv == null) {
            map.put(value, new CountedValue(count, value));
        } else {
            cv.add(count);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<CountedValue> getValues() {
        ArrayList<CountedValue> res = new ArrayList<>(map.values());
        Collections.sort(res);
        return res;
    }
}
