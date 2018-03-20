/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.phases.common;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.memory.address.AddressNode;
import org.graalvm.compiler.nodes.memory.address.OffsetAddressNode;
import org.graalvm.compiler.nodes.memory.address.RawAddressNode;
import org.graalvm.compiler.nodes.util.GraphUtil;
import org.graalvm.compiler.phases.Phase;

public class AddressLoweringPhase extends Phase {

    public abstract static class AddressLowering {

        public abstract AddressNode lower(ValueNode address);

        public abstract AddressNode lower(ValueNode base, ValueNode offset);
    }

    private final AddressLowering lowering;

    public AddressLoweringPhase(AddressLowering lowering) {
        this.lowering = lowering;
        assert lowering != null;
    }

    @Override
    protected void run(StructuredGraph graph) {
        for (Node node : graph.getNodes()) {
            AddressNode lowered;
            if (node instanceof RawAddressNode) {
                RawAddressNode address = (RawAddressNode) node;
                lowered = lowering.lower(address.getAddress());
            } else if (node instanceof OffsetAddressNode) {
                OffsetAddressNode address = (OffsetAddressNode) node;
                lowered = lowering.lower(address.getBase(), address.getOffset());
            } else {
                continue;
            }
            node.replaceAtUsages(lowered);
            GraphUtil.killWithUnusedFloatingInputs(node);
        }
    }
}
