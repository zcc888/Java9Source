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
package org.graalvm.compiler.nodes.memory.address;

import static org.graalvm.compiler.nodeinfo.InputType.Association;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.Node.IndirectCanonicalization;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodeinfo.StructuralInput;
import org.graalvm.compiler.nodes.calc.FloatingNode;

/**
 * Base class for nodes that deal with addressing calculation.
 */
@NodeInfo(allowedUsageTypes = Association, size = SIZE_0, cycles = CYCLES_0)
public abstract class AddressNode extends FloatingNode implements IndirectCanonicalization {
    public static final NodeClass<AddressNode> TYPE = NodeClass.create(AddressNode.class);

    protected AddressNode(NodeClass<? extends AddressNode> c) {
        super(c, StampFactory.pointer());
    }

    public abstract static class Address extends StructuralInput.Association {
    }
}
