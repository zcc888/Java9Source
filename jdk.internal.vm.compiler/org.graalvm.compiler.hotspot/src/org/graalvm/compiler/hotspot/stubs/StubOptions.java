/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.stubs;

import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.OptionValue;

//JaCoCo Exclude

/**
 * Options related to HotSpot Graal-generated stubs.
 *
 * Note: This must be a top level class to work around for
 * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=477597">Eclipse bug 477597</a>.
 */
public class StubOptions {
    // @formatter:off
    @Option(help = "Trace execution of stub used to handle an exception thrown by a callee.", type = OptionType.Debug)
    static final OptionValue<Boolean> TraceExceptionHandlerStub = new OptionValue<>(false);

    @Option(help = "Trace execution of the stub that routes an exception to a handler in the calling frame.", type = OptionType.Debug)
    static final OptionValue<Boolean> TraceUnwindStub = new OptionValue<>(false);

    @Option(help = "Trace execution of slow path stub for array allocation.", type = OptionType.Debug)
    static final OptionValue<Boolean> TraceNewArrayStub = new OptionValue<>(false);

    @Option(help = "Trace execution of slow path stub for non-array object allocation.", type = OptionType.Debug)
    static final OptionValue<Boolean> TraceNewInstanceStub = new OptionValue<>(false);

    @Option(help = "Force non-array object allocation to always use the slow path.", type = OptionType.Debug)
    static final OptionValue<Boolean> ForceUseOfNewInstanceStub = new OptionValue<>(false);
    //@formatter:on
}
