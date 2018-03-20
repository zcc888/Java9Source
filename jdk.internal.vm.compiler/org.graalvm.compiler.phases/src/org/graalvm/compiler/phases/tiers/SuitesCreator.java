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
package org.graalvm.compiler.phases.tiers;

import org.graalvm.compiler.lir.phases.LIRSuites;

/**
 * Interface used for composing {@link SuitesProvider}s.
 */
public interface SuitesCreator extends SuitesProvider {
    /**
     * Create a new set of phase suites based on the current option settings.
     */
    Suites createSuites();

    /**
     * Create a new set of low-level phase suites based on the current option settings.
     */
    LIRSuites createLIRSuites();
}
