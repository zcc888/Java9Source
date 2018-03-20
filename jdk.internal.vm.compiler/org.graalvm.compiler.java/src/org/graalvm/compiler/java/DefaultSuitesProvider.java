/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.java;

import org.graalvm.compiler.lir.phases.LIRSuites;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration.Plugins;
import org.graalvm.compiler.phases.PhaseSuite;
import org.graalvm.compiler.phases.tiers.CompilerConfiguration;
import org.graalvm.compiler.phases.tiers.HighTierContext;
import org.graalvm.compiler.phases.tiers.Suites;

public class DefaultSuitesProvider extends SuitesProviderBase {

    private final CompilerConfiguration compilerConfiguration;

    public DefaultSuitesProvider(CompilerConfiguration compilerConfiguration, Plugins plugins) {
        super();
        this.defaultGraphBuilderSuite = createGraphBuilderSuite(plugins);
        this.compilerConfiguration = compilerConfiguration;
    }

    @Override
    public Suites createSuites() {
        return Suites.createSuites(compilerConfiguration);
    }

    protected PhaseSuite<HighTierContext> createGraphBuilderSuite(Plugins plugins) {
        PhaseSuite<HighTierContext> suite = new PhaseSuite<>();
        suite.appendPhase(new GraphBuilderPhase(GraphBuilderConfiguration.getDefault(plugins)));
        return suite;
    }

    @Override
    public LIRSuites createLIRSuites() {
        return Suites.createLIRSuites(compilerConfiguration);
    }
}
