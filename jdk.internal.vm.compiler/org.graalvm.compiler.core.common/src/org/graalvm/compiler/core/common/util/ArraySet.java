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
package org.graalvm.compiler.core.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Mimic a set implementation with an ArrayList. Beneficial for small sets (compared to
 * {@link HashSet}).
 */
public class ArraySet<E> extends ArrayList<E> implements Set<E> {
    private static final long serialVersionUID = 4476957522387436654L;

    public ArraySet() {
        super();
    }

    public ArraySet(int i) {
        super(i);
    }

    public ArraySet(Collection<? extends E> c) {
        super(c);
    }

    @Override
    public boolean add(E e) {
        // avoid duplicated entries
        if (contains(e)) {
            return false;
        }
        return super.add(e);
    }
}
