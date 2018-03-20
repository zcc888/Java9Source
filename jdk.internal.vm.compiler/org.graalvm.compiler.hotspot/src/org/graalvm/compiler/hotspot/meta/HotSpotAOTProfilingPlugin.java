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
package org.graalvm.compiler.hotspot.meta;

import org.graalvm.compiler.hotspot.FingerprintUtil;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.OptionValue;

import jdk.vm.ci.hotspot.HotSpotResolvedObjectType;
import jdk.vm.ci.meta.ResolvedJavaMethod;

public class HotSpotAOTProfilingPlugin extends HotSpotProfilingPlugin {
    public static class Options {
        @Option(help = "Do profiling and callbacks to tiered runtime", type = OptionType.User)//
        public static final OptionValue<Boolean> TieredAOT = new OptionValue<>(false);
        @Option(help = "Invocation notification frequency", type = OptionType.Expert)//
        public static final OptionValue<Integer> TierAInvokeNotifyFreqLog = new OptionValue<>(13);
        @Option(help = "Inlinee invocation notification frequency (-1 means count, but do not notify)", type = OptionType.Expert)//
        public static final OptionValue<Integer> TierAInvokeInlineeNotifyFreqLog = new OptionValue<>(-1);
        @Option(help = "Invocation profile probability", type = OptionType.Expert)//
        public static final OptionValue<Integer> TierAInvokeProfileProbabilityLog = new OptionValue<>(8);
        @Option(help = "Backedge notification frequency", type = OptionType.Expert)//
        public static final OptionValue<Integer> TierABackedgeNotifyFreqLog = new OptionValue<>(16);
        @Option(help = "Backedge profile probability", type = OptionType.Expert)//
        public static final OptionValue<Integer> TierABackedgeProfileProbabilityLog = new OptionValue<>(12);
    }

    @Override
    public boolean shouldProfile(GraphBuilderContext builder, ResolvedJavaMethod method) {
        return super.shouldProfile(builder, method) && FingerprintUtil.getFingerprint(((HotSpotResolvedObjectType) method.getDeclaringClass())) != 0;
    }

    @Override
    public int invokeNotifyFreqLog() {
        return Options.TierAInvokeNotifyFreqLog.getValue();
    }

    @Override
    public int invokeInlineeNotifyFreqLog() {
        return Options.TierAInvokeInlineeNotifyFreqLog.getValue();
    }

    @Override
    public int invokeProfilePobabilityLog() {
        return Options.TierAInvokeProfileProbabilityLog.getValue();
    }

    @Override
    public int backedgeNotifyFreqLog() {
        return Options.TierABackedgeNotifyFreqLog.getValue();
    }

    @Override
    public int backedgeProfilePobabilityLog() {
        return Options.TierABackedgeProfileProbabilityLog.getValue();
    }
}
