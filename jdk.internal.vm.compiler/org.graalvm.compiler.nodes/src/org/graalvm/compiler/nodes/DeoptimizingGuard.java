/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes;

import jdk.vm.ci.meta.DeoptimizationAction;
import jdk.vm.ci.meta.DeoptimizationReason;
import jdk.vm.ci.meta.JavaConstant;

/**
 * Shared interface to capture core methods of {@link AbstractFixedGuardNode} and {@link GuardNode}.
 *
 */
public interface DeoptimizingGuard extends ValueNodeInterface {

    LogicNode getCondition();

    void setCondition(LogicNode x, boolean negated);

    DeoptimizationReason getReason();

    DeoptimizationAction getAction();

    JavaConstant getSpeculation();

    boolean isNegated();
}
