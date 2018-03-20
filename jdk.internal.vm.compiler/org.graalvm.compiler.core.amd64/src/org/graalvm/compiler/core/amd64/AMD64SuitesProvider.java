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
package org.graalvm.compiler.core.amd64;

import org.graalvm.compiler.java.DefaultSuitesProvider;
import org.graalvm.compiler.lir.amd64.phases.StackMoveOptimizationPhase;
import org.graalvm.compiler.lir.phases.LIRSuites;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration.Plugins;
import org.graalvm.compiler.phases.tiers.CompilerConfiguration;

public class AMD64SuitesProvider extends DefaultSuitesProvider {

    public AMD64SuitesProvider(CompilerConfiguration compilerConfiguration, Plugins plugins) {
        super(compilerConfiguration, plugins);
    }

    @Override
    public LIRSuites createLIRSuites() {
        LIRSuites lirSuites = super.createLIRSuites();
        if (StackMoveOptimizationPhase.Options.LIROptStackMoveOptimizer.getValue()) {
            /* Note: this phase must be inserted <b>after</b> RedundantMoveElimination */
            lirSuites.getPostAllocationOptimizationStage().appendPhase(new StackMoveOptimizationPhase());
        }
        return lirSuites;
    }
}
