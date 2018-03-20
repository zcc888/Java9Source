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
package org.graalvm.compiler.graph.spi;

import jdk.vm.ci.meta.Assumptions;
import jdk.vm.ci.meta.ConstantReflectionProvider;
import jdk.vm.ci.meta.MetaAccessProvider;

import org.graalvm.compiler.core.common.spi.ConstantFieldProvider;
import org.graalvm.compiler.graph.Node;

public interface CanonicalizerTool {

    Assumptions getAssumptions();

    MetaAccessProvider getMetaAccess();

    ConstantReflectionProvider getConstantReflection();

    ConstantFieldProvider getConstantFieldProvider();

    boolean canonicalizeReads();

    /**
     * If this method returns false, not all {@link Node#usages() usages of a node} are yet
     * available. So a node must not be canonicalized base on, e.g., information returned from
     * {@link Node#hasNoUsages()}.
     */
    boolean allUsagesAvailable();

    /**
     * Indicates whether the target platform supports comparison of integers of a particular bit
     * width. This check is used by canonicalizations that might introduce subword compares.
     */
    boolean supportSubwordCompare(int bits);
}
