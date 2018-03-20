/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.api.replacements;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A snippet is a Graal graph expressed as a Java source method. Snippets are used for lowering
 * nodes that have runtime dependent semantics (e.g. the {@code CHECKCAST} bytecode).
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Snippet {

    /**
     * Denotes a snippet parameter representing 0 or more arguments that will be bound during
     * snippet template instantiation. During snippet template creation, its value must be an array
     * whose length specifies the number of arguments (the contents of the array are ignored) bound
     * to the parameter during instantiation.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    public @interface VarargsParameter {
    }

    /**
     * Denotes a snippet parameter that will bound to a constant value during snippet template
     * instantiation.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    public @interface ConstantParameter {
    }
}
