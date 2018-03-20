/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jaotc.jnilibelf;

import jdk.internal.misc.Unsafe;

/**
 * Package private access to the {@link Unsafe} capability.
 */
class UnsafeAccess {

    static final Unsafe UNSAFE = Unsafe.getUnsafe();

}
