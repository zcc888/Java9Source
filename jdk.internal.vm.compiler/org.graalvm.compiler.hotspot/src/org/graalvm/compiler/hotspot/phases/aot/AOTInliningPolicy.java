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
package org.graalvm.compiler.hotspot.phases.aot;

import static org.graalvm.compiler.core.common.GraalOptions.InlineEverything;
import static org.graalvm.compiler.core.common.GraalOptions.TrivialInliningSize;

import java.util.Map;

import org.graalvm.compiler.hotspot.FingerprintUtil;
import org.graalvm.compiler.nodes.Invoke;
import org.graalvm.compiler.nodes.spi.Replacements;
import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.OptionValue;
import org.graalvm.compiler.phases.common.inlining.InliningUtil;
import org.graalvm.compiler.phases.common.inlining.info.InlineInfo;
import org.graalvm.compiler.phases.common.inlining.policy.GreedyInliningPolicy;
import org.graalvm.compiler.phases.common.inlining.walker.MethodInvocation;

import jdk.vm.ci.hotspot.HotSpotResolvedObjectType;

public class AOTInliningPolicy extends GreedyInliningPolicy {
    public static class Options {
        // @formatter:off
        @Option(help = "", type = OptionType.Expert)
        public static final OptionValue<Double> AOTInliningDepthToSizeRate = new OptionValue<>(2.5);
        @Option(help = "", type = OptionType.Expert)
        public static final OptionValue<Integer> AOTInliningSizeMaximum = new OptionValue<>(300);
        @Option(help = "", type = OptionType.Expert)
        public static final OptionValue<Integer> AOTInliningSizeMinimum = new OptionValue<>(50);
        // @formatter:on
    }

    public AOTInliningPolicy(Map<Invoke, Double> hints) {
        super(hints);
    }

    protected double maxInliningSize(int inliningDepth) {
        return Math.max(Options.AOTInliningSizeMaximum.getValue() / (inliningDepth * Options.AOTInliningDepthToSizeRate.getValue()), Options.AOTInliningSizeMinimum.getValue());
    }

    @Override
    public boolean isWorthInlining(Replacements replacements, MethodInvocation invocation, int inliningDepth, boolean fullyProcessed) {
        final InlineInfo info = invocation.callee();

        for (int i = 0; i < info.numberOfMethods(); ++i) {
            HotSpotResolvedObjectType t = (HotSpotResolvedObjectType) info.methodAt(i).getDeclaringClass();
            if (FingerprintUtil.getFingerprint(t) == 0) {
                return false;
            }
        }

        final double probability = invocation.probability();
        final double relevance = invocation.relevance();

        if (InlineEverything.getValue()) {
            InliningUtil.logInlinedMethod(info, inliningDepth, fullyProcessed, "inline everything");
            return true;
        }

        if (isIntrinsic(replacements, info)) {
            InliningUtil.logInlinedMethod(info, inliningDepth, fullyProcessed, "intrinsic");
            return true;
        }

        if (info.shouldInline()) {
            InliningUtil.logInlinedMethod(info, inliningDepth, fullyProcessed, "forced inlining");
            return true;
        }

        double inliningBonus = getInliningBonus(info);
        int nodes = info.determineNodeCount();

        if (nodes < TrivialInliningSize.getValue() * inliningBonus) {
            InliningUtil.logInlinedMethod(info, inliningDepth, fullyProcessed, "trivial (relevance=%f, probability=%f, bonus=%f, nodes=%d)", relevance, probability, inliningBonus, nodes);
            return true;
        }

        double maximumNodes = computeMaximumSize(relevance, (int) (maxInliningSize(inliningDepth) * inliningBonus));
        if (nodes <= maximumNodes) {
            InliningUtil.logInlinedMethod(info, inliningDepth, fullyProcessed, "relevance-based (relevance=%f, probability=%f, bonus=%f, nodes=%d <= %f)", relevance, probability, inliningBonus,
                            nodes, maximumNodes);
            return true;
        }

        InliningUtil.logNotInlinedMethod(info, inliningDepth, "relevance-based (relevance=%f, probability=%f, bonus=%f, nodes=%d > %f)", relevance, probability, inliningBonus, nodes, maximumNodes);
        return false;
    }
}
