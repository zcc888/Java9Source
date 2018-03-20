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

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_15;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_20;

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;

@NodeInfo(cycles = CYCLES_15, size = SIZE_20)
public final class SerialArrayRangeWriteBarrier extends ArrayRangeWriteBarrier {

    public static final NodeClass<SerialArrayRangeWriteBarrier> TYPE = NodeClass.create(SerialArrayRangeWriteBarrier.class);

    public SerialArrayRangeWriteBarrier(ValueNode object, ValueNode startIndex, ValueNode length) {
        super(TYPE, object, startIndex, length);
    }

}
