/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes;

import static org.graalvm.compiler.nodeinfo.InputType.Memory;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.core.common.LocationIdentity;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.memory.MemoryCheckpoint;

@NodeInfo(allowedUsageTypes = {Memory}, cycles = CYCLES_0, size = SIZE_0)
public final class KillingBeginNode extends AbstractBeginNode implements MemoryCheckpoint.Single {

    public static final NodeClass<KillingBeginNode> TYPE = NodeClass.create(KillingBeginNode.class);
    protected LocationIdentity locationIdentity;

    public KillingBeginNode(LocationIdentity locationIdentity) {
        super(TYPE);
        this.locationIdentity = locationIdentity;
    }

    public static KillingBeginNode begin(FixedNode with, LocationIdentity locationIdentity) {
        if (with instanceof KillingBeginNode) {
            return (KillingBeginNode) with;
        }
        KillingBeginNode begin = with.graph().add(new KillingBeginNode(locationIdentity));
        begin.setNext(with);
        return begin;
    }

    @Override
    public LocationIdentity getLocationIdentity() {
        return locationIdentity;
    }
}
