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
package org.graalvm.compiler.phases.common.instrumentation;

import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.debug.instrumentation.InstrumentationNode;
import org.graalvm.compiler.nodes.debug.instrumentation.MonitorProxyNode;
import org.graalvm.compiler.nodes.extended.FixedValueAnchorNode;
import org.graalvm.compiler.nodes.java.RawMonitorEnterNode;
import org.graalvm.compiler.nodes.util.GraphUtil;
import org.graalvm.compiler.phases.Phase;

/**
 * The {@code MidTierReconcileInstrumentationPhase} reconciles the InstrumentationNodes right after
 * lowering in the mid tier. Concretely, it attempts to unproxify the targets of the
 * InstrumentationNodes.
 */
public class MidTierReconcileInstrumentationPhase extends Phase {

    @Override
    protected void run(StructuredGraph graph) {
        for (InstrumentationNode instrumentationNode : graph.getNodes().filter(InstrumentationNode.class)) {
            ValueNode target = instrumentationNode.getTarget();
            if (target instanceof MonitorProxyNode) {
                RawMonitorEnterNode monitorEnter = ((MonitorProxyNode) target).findFirstMatch();
                if (monitorEnter != null) {
                    instrumentationNode.replaceFirstInput(target, monitorEnter);
                } else {
                    // we cannot find valid AccessMonitorNode for the proxy, detach the
                    // instrumentation
                    graph.removeFixed(instrumentationNode);
                }
            } else if (target instanceof FixedValueAnchorNode) {
                instrumentationNode.replaceFirstInput(target, GraphUtil.unproxify(target));
            }
        }
    }

    @Override
    public boolean checkContract() {
        return false;
    }
}
