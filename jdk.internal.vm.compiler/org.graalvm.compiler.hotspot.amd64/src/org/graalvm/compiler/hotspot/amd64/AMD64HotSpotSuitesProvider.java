/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.amd64;

import org.graalvm.compiler.core.amd64.AMD64SuitesProvider;
import org.graalvm.compiler.core.common.GraalOptions;
import org.graalvm.compiler.hotspot.lir.HotSpotZapRegistersPhase;
import org.graalvm.compiler.lir.phases.LIRSuites;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration.Plugins;
import org.graalvm.compiler.phases.tiers.CompilerConfiguration;

public class AMD64HotSpotSuitesProvider extends AMD64SuitesProvider {

    public AMD64HotSpotSuitesProvider(CompilerConfiguration compilerConfiguration, Plugins plugins) {
        super(compilerConfiguration, plugins);
    }

    @Override
    public LIRSuites createLIRSuites() {
        LIRSuites lirSuites = super.createLIRSuites();
        if (GraalOptions.DetailedAsserts.getValue()) {
            lirSuites.getPostAllocationOptimizationStage().appendPhase(new HotSpotZapRegistersPhase());
        }
        return lirSuites;
    }
}
