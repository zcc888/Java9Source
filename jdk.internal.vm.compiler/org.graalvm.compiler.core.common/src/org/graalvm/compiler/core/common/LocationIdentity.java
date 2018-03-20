/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.util.IdentityHashMap;

// JaCoCo Exclude

/**
 * Marker interface for location identities. A different location identity of two memory accesses
 * guarantees that the two accesses do not interfere.
 *
 * Clients of {@link LocationIdentity} must use {@link #equals(Object)}, not {@code ==}, when
 * comparing two {@link LocationIdentity} values for equality. Likewise, they must not use
 * {@link IdentityHashMap}s with {@link LocationIdentity} values as keys.
 */
public abstract class LocationIdentity {

    private static final class AnyLocationIdentity extends LocationIdentity {
        @Override
        public boolean isImmutable() {
            return false;
        }

        @Override
        public String toString() {
            return "ANY_LOCATION";
        }
    }

    public static final LocationIdentity ANY_LOCATION = new AnyLocationIdentity();

    public static LocationIdentity any() {
        return ANY_LOCATION;
    }

    /**
     * Denotes a location is unchanging in all cases. Not that this is different than the Java
     * notion of final which only requires definite assignment.
     */
    public abstract boolean isImmutable();

    public final boolean isMutable() {
        return !isImmutable();
    }

    public final boolean isAny() {
        return this == ANY_LOCATION;
    }

    public final boolean isSingle() {
        return this != ANY_LOCATION;
    }

    public final boolean overlaps(LocationIdentity other) {
        return isAny() || other.isAny() || this.equals(other);
    }
}
