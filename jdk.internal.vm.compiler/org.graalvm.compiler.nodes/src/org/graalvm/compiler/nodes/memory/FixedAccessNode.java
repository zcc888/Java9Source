/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes.memory;

import org.graalvm.compiler.core.common.LocationIdentity;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.DeoptimizingFixedWithNextNode;
import org.graalvm.compiler.nodes.FrameState;
import org.graalvm.compiler.nodes.extended.GuardingNode;
import org.graalvm.compiler.nodes.memory.address.AddressNode;

/**
 * Accesses a value at an memory address specified by an {@linkplain #address address}. The access
 * does not include a null check on the object.
 */
@NodeInfo
public abstract class FixedAccessNode extends DeoptimizingFixedWithNextNode implements Access {
    public static final NodeClass<FixedAccessNode> TYPE = NodeClass.create(FixedAccessNode.class);

    @OptionalInput(InputType.Guard) protected GuardingNode guard;

    @Input(InputType.Association) AddressNode address;
    protected final LocationIdentity location;

    protected boolean nullCheck;
    protected BarrierType barrierType;

    @Override
    public AddressNode getAddress() {
        return address;
    }

    public void setAddress(AddressNode address) {
        updateUsages(this.address, address);
        this.address = address;
    }

    @Override
    public LocationIdentity getLocationIdentity() {
        return location;
    }

    public boolean getNullCheck() {
        return nullCheck;
    }

    public void setNullCheck(boolean check) {
        this.nullCheck = check;
    }

    protected FixedAccessNode(NodeClass<? extends FixedAccessNode> c, AddressNode address, LocationIdentity location, Stamp stamp) {
        this(c, address, location, stamp, BarrierType.NONE);
    }

    protected FixedAccessNode(NodeClass<? extends FixedAccessNode> c, AddressNode address, LocationIdentity location, Stamp stamp, BarrierType barrierType) {
        this(c, address, location, stamp, null, barrierType, false, null);
    }

    protected FixedAccessNode(NodeClass<? extends FixedAccessNode> c, AddressNode address, LocationIdentity location, Stamp stamp, GuardingNode guard, BarrierType barrierType, boolean nullCheck,
                    FrameState stateBefore) {
        super(c, stamp, stateBefore);
        this.address = address;
        this.location = location;
        this.guard = guard;
        this.barrierType = barrierType;
        this.nullCheck = nullCheck;
    }

    @Override
    public boolean canDeoptimize() {
        return nullCheck;
    }

    @Override
    public GuardingNode getGuard() {
        return guard;
    }

    @Override
    public void setGuard(GuardingNode guard) {
        updateUsagesInterface(this.guard, guard);
        this.guard = guard;
    }

    @Override
    public BarrierType getBarrierType() {
        return barrierType;
    }
}
