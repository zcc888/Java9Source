/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.sparc;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.hotspot.nodes.HotSpotNodeCostProvider;
import org.graalvm.compiler.hotspot.nodes.JumpToExceptionHandlerNode;
import org.graalvm.compiler.nodeinfo.NodeCycles;
import org.graalvm.compiler.nodeinfo.NodeSize;
import org.graalvm.compiler.nodes.ReturnNode;

public class SPARCHotSpotNodeCostProvider extends HotSpotNodeCostProvider {

    @Override
    public NodeCycles cycles(Node n) {
        if (n instanceof ReturnNode) {
            return NodeCycles.CYCLES_6;
        } else if (n instanceof JumpToExceptionHandlerNode) {
            // restore caller window
            return NodeCycles.CYCLES_3;
        }
        return super.cycles(n);
    }

    @Override
    public NodeSize size(Node n) {
        if (n instanceof ReturnNode) {
            return NodeSize.SIZE_4;
        } else if (n instanceof JumpToExceptionHandlerNode) {
            // restore caller window
            return NodeSize.SIZE_3;
        }
        return super.size(n);
    }
}
