/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.microbenchmarks.graal.util;

import jdk.vm.ci.meta.MetaAccessProvider;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import org.graalvm.compiler.api.test.Graal;
import org.graalvm.compiler.core.target.Backend;
import org.graalvm.compiler.phases.util.Providers;
import org.graalvm.compiler.runtime.RuntimeProvider;

/**
 * Read-only, benchmark-wide state providing Graal runtime context.
 */
@State(Scope.Benchmark)
public class GraalState {

    public final Backend backend;
    public final Providers providers;
    public final MetaAccessProvider metaAccess;

    public GraalState() {
        backend = Graal.getRequiredCapability(RuntimeProvider.class).getHostBackend();
        providers = backend.getProviders();
        metaAccess = providers.getMetaAccess();
    }
}
