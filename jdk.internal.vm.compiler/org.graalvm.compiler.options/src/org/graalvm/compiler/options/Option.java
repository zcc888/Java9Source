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
package org.graalvm.compiler.options;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Describes the attributes of an option whose {@link OptionValue value} is in a static field
 * annotated by this annotation type.
 *
 * @see OptionDescriptor
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface Option {

    /**
     * Gets a help message for the option. New lines can be embedded in the message with
     * {@code "%n"}.
     */
    String help();

    /**
     * The name of the option. By default, the name of the annotated field should be used.
     */
    String name() default "";

    /**
     * Specifies the type of the option.
     */
    OptionType type() default OptionType.Debug;
}
