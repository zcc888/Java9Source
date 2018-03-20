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
package org.graalvm.compiler.nodes.debug.instrumentation;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_IGNORED;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_IGNORED;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.calc.FloatingNode;
import org.graalvm.compiler.nodes.java.MonitorIdNode;
import org.graalvm.compiler.nodes.java.RawMonitorEnterNode;

/**
 * The {@code MonitorProxyNode} represents the InstrumentationNode's target when the original
 * MonitorEnterNode is invalid. Such situation occurs when the escape analysis removes the
 * MonitorEnterNode and aggregates the monitor logic in a CommitAllocationNode.
 */
@NodeInfo(cycles = CYCLES_IGNORED, size = SIZE_IGNORED)
public class MonitorProxyNode extends FloatingNode {

    public static final NodeClass<MonitorProxyNode> TYPE = NodeClass.create(MonitorProxyNode.class);

    @OptionalInput(value = InputType.Unchecked) protected ValueNode object;
    @OptionalInput(value = InputType.Association) protected MonitorIdNode monitorId;

    public MonitorProxyNode(ValueNode object, MonitorIdNode monitorId) {
        super(TYPE, StampFactory.forVoid());
        this.object = object;
        this.monitorId = monitorId;
    }

    public ValueNode object() {
        return object;
    }

    public MonitorIdNode getMonitorId() {
        return monitorId;
    }

    /**
     * @return the first RawMonitorEnterNode that shares the same MonitorIdNode and the same lock
     *         object with this MonitorProxyNode.
     */
    public RawMonitorEnterNode findFirstMatch() {
        for (RawMonitorEnterNode monitorEnter : monitorId.usages().filter(RawMonitorEnterNode.class)) {
            if (monitorEnter.object() == object) {
                return monitorEnter;
            }
        }
        return null;
    }

}
