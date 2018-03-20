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
package org.graalvm.compiler.hotspot.nodes;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.calc.FloatingNode;
import org.graalvm.compiler.nodes.extended.GuardingNode;

@NodeInfo(allowedUsageTypes = {InputType.Association, InputType.Value}, cycles = CYCLES_0, size = SIZE_0)
public final class SnippetLocationProxyNode extends FloatingNode implements Canonicalizable, Node.ValueNumberable {

    public static final NodeClass<SnippetLocationProxyNode> TYPE = NodeClass.create(SnippetLocationProxyNode.class);
    @Input(InputType.Unchecked) ValueNode location;

    public SnippetLocationProxyNode(ValueNode location) {
        super(TYPE, StampFactory.object());
        this.location = location;
    }

    @Override
    public Node canonical(CanonicalizerTool tool) {
        return location.isAllowedUsageType(InputType.Association) ? location : this;
    }

    @NodeIntrinsic
    public static native GuardingNode location(Object location);
}
