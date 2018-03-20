/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_100;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_100;

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;

@NodeInfo(cycles = CYCLES_100, size = SIZE_100)
public final class G1ArrayRangePreWriteBarrier extends ArrayRangeWriteBarrier {
    public static final NodeClass<G1ArrayRangePreWriteBarrier> TYPE = NodeClass.create(G1ArrayRangePreWriteBarrier.class);

    public G1ArrayRangePreWriteBarrier(ValueNode object, ValueNode startIndex, ValueNode length) {
        super(TYPE, object, startIndex, length);
    }

}
