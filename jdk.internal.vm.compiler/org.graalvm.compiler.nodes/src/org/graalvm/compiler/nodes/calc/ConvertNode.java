/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes.calc;

import org.graalvm.compiler.core.common.calc.Condition;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.ValueNodeInterface;

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.ConstantReflectionProvider;

/**
 * Represents a conversion between primitive types.
 */
public interface ConvertNode extends ValueNodeInterface {

    ValueNode getValue();

    Constant convert(Constant c, ConstantReflectionProvider constantReflection);

    Constant reverse(Constant c, ConstantReflectionProvider constantReflection);

    /**
     * Check whether a conversion is lossless.
     *
     * @return true iff reverse(convert(c)) == c for all c
     */
    boolean isLossless();

    /**
     * Check whether a conversion preserves comparison order.
     *
     * @param op a comparison operator
     * @return true iff (c1 op c2) == (convert(c1) op convert(c2)) for all c1, c2
     */
    default boolean preservesOrder(Condition op) {
        return isLossless();
    }

    /**
     * Check whether a conversion preserves comparison order against a particular constant value.
     *
     * @param op a comparison operator
     * @param value
     * @param constantReflection
     * @return true iff (c1 op value) == (convert(c1) op convert(value)) for value and all c1
     */
    default boolean preservesOrder(Condition op, Constant value, ConstantReflectionProvider constantReflection) {
        return preservesOrder(op);
    }
}
