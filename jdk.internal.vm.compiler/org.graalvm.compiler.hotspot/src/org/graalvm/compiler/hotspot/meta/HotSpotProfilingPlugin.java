/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.hotspot.nodes.profiling.ProfileBranchNode;
import org.graalvm.compiler.hotspot.nodes.profiling.ProfileInvokeNode;
import org.graalvm.compiler.hotspot.nodes.profiling.ProfileNode;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.FrameState;
import org.graalvm.compiler.nodes.LogicNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.calc.ConditionalNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.ProfilingPlugin;
import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.OptionValue;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public abstract class HotSpotProfilingPlugin implements ProfilingPlugin {
    public static class Options {
        @Option(help = "Emit profiling of invokes", type = OptionType.Expert)//
        public static final OptionValue<Boolean> ProfileInvokes = new OptionValue<>(true);
        @Option(help = "Emit profiling of backedges", type = OptionType.Expert)//
        public static final OptionValue<Boolean> ProfileBackedges = new OptionValue<>(true);
    }

    public abstract int invokeNotifyFreqLog();

    public abstract int invokeInlineeNotifyFreqLog();

    public abstract int invokeProfilePobabilityLog();

    public abstract int backedgeNotifyFreqLog();

    public abstract int backedgeProfilePobabilityLog();

    @Override
    public boolean shouldProfile(GraphBuilderContext builder, ResolvedJavaMethod method) {
        return !builder.parsingIntrinsic();
    }

    @Override
    public void profileInvoke(GraphBuilderContext builder, ResolvedJavaMethod method, FrameState frameState) {
        assert shouldProfile(builder, method);
        if (Options.ProfileInvokes.getValue() && !method.isClassInitializer()) {
            ProfileNode p = builder.append(new ProfileInvokeNode(method, invokeNotifyFreqLog(), invokeProfilePobabilityLog()));
            p.setStateBefore(frameState);
        }
    }

    @Override
    public void profileGoto(GraphBuilderContext builder, ResolvedJavaMethod method, int bci, int targetBci, FrameState frameState) {
        assert shouldProfile(builder, method);
        if (Options.ProfileBackedges.getValue() && targetBci <= bci) {
            ProfileNode p = builder.append(new ProfileBranchNode(method, backedgeNotifyFreqLog(), backedgeProfilePobabilityLog(), bci, targetBci));
            p.setStateBefore(frameState);
        }
    }

    @Override
    public void profileIf(GraphBuilderContext builder, ResolvedJavaMethod method, int bci, LogicNode condition, int trueBranchBci, int falseBranchBci, FrameState frameState) {
        assert shouldProfile(builder, method);
        if (Options.ProfileBackedges.getValue() && (falseBranchBci <= bci || trueBranchBci <= bci)) {
            boolean negate = false;
            int targetBci = trueBranchBci;
            if (falseBranchBci <= bci) {
                assert trueBranchBci > bci;
                negate = true;
                targetBci = falseBranchBci;
            } else {
                assert trueBranchBci <= bci && falseBranchBci > bci;
            }
            ValueNode trueValue = builder.append(ConstantNode.forBoolean(!negate));
            ValueNode falseValue = builder.append(ConstantNode.forBoolean(negate));
            ConditionalNode branchCondition = builder.append(new ConditionalNode(condition, trueValue, falseValue));
            ProfileNode p = builder.append(new ProfileBranchNode(method, backedgeNotifyFreqLog(), backedgeProfilePobabilityLog(), branchCondition, bci, targetBci));
            p.setStateBefore(frameState);
        }
    }
}
