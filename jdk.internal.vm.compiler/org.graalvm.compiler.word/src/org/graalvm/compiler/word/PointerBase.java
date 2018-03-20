/*
 * Copyright (c) 2013, 2013, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.word;

/**
 * Marker interface for all {@link WordBase word types} that have the semantic of a pointer (but not
 * necessarily all the memory access methods defined in {@link Pointer}).
 */
public interface PointerBase extends ComparableWord {
}
