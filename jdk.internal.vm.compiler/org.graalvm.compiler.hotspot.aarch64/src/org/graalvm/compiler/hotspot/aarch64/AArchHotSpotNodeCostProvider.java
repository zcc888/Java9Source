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
package org.graalvm.compiler.hotspot.aarch64;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.hotspot.nodes.HotSpotNodeCostProvider;
import org.graalvm.compiler.nodeinfo.NodeCycles;
import org.graalvm.compiler.nodeinfo.NodeSize;

public class AArchHotSpotNodeCostProvider extends HotSpotNodeCostProvider {

    @Override
    public NodeCycles cycles(Node n) {
        return super.cycles(n);
    }

    @Override
    public NodeSize size(Node n) {
        return super.size(n);
    }
}
