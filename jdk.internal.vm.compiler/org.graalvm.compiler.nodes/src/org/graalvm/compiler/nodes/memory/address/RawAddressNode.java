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

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;

/**
 * Convert a word-sized integer to a raw address.
 */
@NodeInfo(allowedUsageTypes = InputType.Association)
public class RawAddressNode extends AddressNode {
    public static final NodeClass<RawAddressNode> TYPE = NodeClass.create(RawAddressNode.class);

    @Input ValueNode address;

    public RawAddressNode(ValueNode address) {
        super(TYPE);
        this.address = address;
    }

    public ValueNode getAddress() {
        return address;
    }

    public void setAddress(ValueNode address) {
        updateUsages(this.address, address);
        this.address = address;
    }

    @NodeIntrinsic
    public static native Address address(long address);

    @NodeIntrinsic
    public static native Address address(Object address);
}
