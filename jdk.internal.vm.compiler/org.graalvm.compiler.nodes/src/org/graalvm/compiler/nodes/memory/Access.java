/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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
import org.graalvm.compiler.nodes.extended.GuardedNode;
import org.graalvm.compiler.nodes.memory.address.AddressNode;

public interface Access extends GuardedNode, HeapAccess {

    AddressNode getAddress();

    LocationIdentity getLocationIdentity();

    boolean canNullCheck();

}
