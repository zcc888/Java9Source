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
package org.graalvm.compiler.salver;

import static org.graalvm.compiler.salver.SalverOptions.Salver;

import org.graalvm.compiler.debug.DebugConfig;
import org.graalvm.compiler.debug.DebugConfigCustomizer;
import org.graalvm.compiler.salver.handler.GraphDumpHandler;
import org.graalvm.compiler.serviceprovider.ServiceProvider;

@ServiceProvider(DebugConfigCustomizer.class)
public class SalverDebugConfigCustomizer implements DebugConfigCustomizer {

    @Override
    public void customize(DebugConfig config, Object... extraArgs) {
        if (Salver.getValue()) {
            config.dumpHandlers().add(new GraphDumpHandler());
        }
    }
}
