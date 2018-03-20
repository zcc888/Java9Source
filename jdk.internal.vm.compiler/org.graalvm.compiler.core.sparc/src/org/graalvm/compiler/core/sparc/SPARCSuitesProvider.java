/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.core.sparc;

import java.util.ListIterator;

import org.graalvm.compiler.java.DefaultSuitesProvider;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration.Plugins;
import org.graalvm.compiler.phases.BasePhase;
import org.graalvm.compiler.phases.PhaseSuite;
import org.graalvm.compiler.phases.common.ExpandLogicPhase;
import org.graalvm.compiler.phases.tiers.CompilerConfiguration;
import org.graalvm.compiler.phases.tiers.LowTierContext;
import org.graalvm.compiler.phases.tiers.Suites;

public class SPARCSuitesProvider extends DefaultSuitesProvider {
    public SPARCSuitesProvider(CompilerConfiguration compilerConfiguration, Plugins plugins) {
        super(compilerConfiguration, plugins);
    }

    @Override
    public Suites createSuites() {
        Suites s = super.createSuites();
        ListIterator<BasePhase<? super LowTierContext>> l = s.getLowTier().findPhase(ExpandLogicPhase.class);
        while (PhaseSuite.findNextPhase(l, ExpandLogicPhase.class)) {
            // Search for last occurrence of ExpandLogicPhase
        }
        l.previous();
        l.add(new SPARCIntegerCompareCanonicalizationPhase());
        return s;
    }
}
