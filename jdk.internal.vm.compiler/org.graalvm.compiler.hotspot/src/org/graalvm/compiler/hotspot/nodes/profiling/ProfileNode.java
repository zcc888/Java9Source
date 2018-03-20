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
package org.graalvm.compiler.hotspot.nodes.profiling;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.iterators.NodeIterable;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.DeoptimizingFixedWithNextNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.OptionValue;

@NodeInfo
public class ProfileNode extends DeoptimizingFixedWithNextNode implements Lowerable {
    public static class Options {
        @Option(help = "Control probabilistic profiling on AMD64", type = OptionType.Expert)//
        public static final OptionValue<Boolean> ProbabilisticProfiling = new OptionValue<>(true);
    }

    public static final NodeClass<ProfileNode> TYPE = NodeClass.create(ProfileNode.class);

    protected ResolvedJavaMethod method;

    // Only used if ProbabilisticProfiling == true and may be ignored by lowerer.
    @OptionalInput protected ValueNode random;

    // logarithm base 2 of the profile probability
    protected int probabilityLog;

    protected ProfileNode(NodeClass<? extends DeoptimizingFixedWithNextNode> c, ResolvedJavaMethod method, int probabilityLog) {
        super(c, StampFactory.forVoid());
        this.method = method;
        this.probabilityLog = probabilityLog;
    }

    public ProfileNode(ResolvedJavaMethod method, int probabilityLog) {
        super(TYPE, StampFactory.forVoid());
        this.method = method;
        this.probabilityLog = probabilityLog;
    }

    @Override
    public boolean canDeoptimize() {
        return true;
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    public ResolvedJavaMethod getProfiledMethod() {
        return method;
    }

    public ValueNode getRandom() {
        return random;
    }

    public void setRandom(ValueNode r) {
        updateUsages(random, r);
        this.random = r;
    }

    /**
     * Get the logarithm base 2 of the profile probability.
     */
    public int getProbabilityLog() {
        return probabilityLog;
    }

    /**
     * Gathers all the {@link ProfileNode}s that are inputs to the
     * {@linkplain StructuredGraph#getNodes() live nodes} in a given graph.
     */
    public static NodeIterable<ProfileNode> getProfileNodes(StructuredGraph graph) {
        return graph.getNodes().filter(ProfileNode.class);
    }
}
