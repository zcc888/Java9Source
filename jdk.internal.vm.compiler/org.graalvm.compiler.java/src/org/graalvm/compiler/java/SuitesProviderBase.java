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
import org.graalvm.compiler.options.DerivedOptionValue;
import org.graalvm.compiler.options.DerivedOptionValue.OptionSupplier;
import org.graalvm.compiler.phases.PhaseSuite;
import org.graalvm.compiler.phases.tiers.HighTierContext;
import org.graalvm.compiler.phases.tiers.Suites;
import org.graalvm.compiler.phases.tiers.SuitesCreator;

public abstract class SuitesProviderBase implements SuitesCreator {

    protected final DerivedOptionValue<Suites> defaultSuites;
    protected PhaseSuite<HighTierContext> defaultGraphBuilderSuite;
    protected final DerivedOptionValue<LIRSuites> defaultLIRSuites;

    private class SuitesSupplier implements OptionSupplier<Suites> {

        private static final long serialVersionUID = 2677805381215454728L;

        @Override
        public Suites get() {
            Suites suites = createSuites();
            suites.setImmutable();
            return suites;
        }

    }

    private class LIRSuitesSupplier implements OptionSupplier<LIRSuites> {

        private static final long serialVersionUID = 312070237227476252L;

        @Override
        public LIRSuites get() {
            LIRSuites lirSuites = createLIRSuites();
            lirSuites.setImmutable();
            return lirSuites;
        }

    }

    public SuitesProviderBase() {
        this.defaultSuites = new DerivedOptionValue<>(new SuitesSupplier());
        this.defaultLIRSuites = new DerivedOptionValue<>(new LIRSuitesSupplier());
    }

    @Override
    public final Suites getDefaultSuites() {
        return defaultSuites.getValue();
    }

    @Override
    public PhaseSuite<HighTierContext> getDefaultGraphBuilderSuite() {
        return defaultGraphBuilderSuite;
    }

    @Override
    public final LIRSuites getDefaultLIRSuites() {
        return defaultLIRSuites.getValue();
    }

    @Override
    public abstract LIRSuites createLIRSuites();

    @Override
    public abstract Suites createSuites();
}
