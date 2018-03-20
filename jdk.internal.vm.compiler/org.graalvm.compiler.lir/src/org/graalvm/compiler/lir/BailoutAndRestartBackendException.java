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
package org.graalvm.compiler.lir;

import org.graalvm.compiler.common.PermanentBailoutException;
import org.graalvm.compiler.lir.phases.LIRSuites;
import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.OptionValue;
import org.graalvm.compiler.options.OptionValue.OverrideScope;
import org.graalvm.compiler.options.StableOptionValue;

/**
 * Restarts the {@link LIR low-level} compilation with a modified configuration.
 * {@link BailoutAndRestartBackendException.Options#LIRUnlockBackendRestart LIRUnlockBackendRestart}
 * needs to be enabled. Use only for debugging purposes only.
 */
public abstract class BailoutAndRestartBackendException extends PermanentBailoutException {

    public static class Options {
        // @formatter:off
        @Option(help = "Unlock backend restart feature.", type = OptionType.Debug)
        public static final StableOptionValue<Boolean> LIRUnlockBackendRestart = new StableOptionValue<>(false);
        // @formatter:on
    }

    private static final long serialVersionUID = 792969002851591180L;

    public BailoutAndRestartBackendException(String msg) {
        super(msg);
    }

    public BailoutAndRestartBackendException(Throwable cause, String msg) {
        super(cause, msg);
    }

    /** Returns {@code true} if the low-level compilation should be restarted. */
    public abstract boolean shouldRestart();

    /**
     * Returns an {@link OverrideScope} to change {@link OptionValue OptionValues} or {@code null}
     * if no changes are required.
     */
    public abstract OverrideScope getOverrideScope();

    /**
     * Updates the {@link LIRSuites} used by the low-level compiler. Note that {@link LIRSuites} are
     * usually shared, so a modified input parameter will affect other compilations. In case only
     * the current compilation should be altered, create a copy using {@link LIRSuites#copy()}.
     */
    public abstract LIRSuites updateLIRSuites(LIRSuites lirSuites);

}
