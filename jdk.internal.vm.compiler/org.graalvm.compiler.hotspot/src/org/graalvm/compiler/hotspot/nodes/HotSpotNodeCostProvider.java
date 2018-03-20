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
package org.graalvm.compiler.hotspot.nodes;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_20;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_30;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_20;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_30;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.hotspot.replacements.ObjectCloneNode;
import org.graalvm.compiler.nodeinfo.NodeCycles;
import org.graalvm.compiler.nodeinfo.NodeSize;
import org.graalvm.compiler.nodes.spi.DefaultNodeCostProvider;
import org.graalvm.compiler.nodes.type.StampTool;

import jdk.vm.ci.meta.ResolvedJavaType;

public abstract class HotSpotNodeCostProvider extends DefaultNodeCostProvider {

    @Override
    public NodeSize size(Node n) {
        if (n instanceof ObjectCloneNode) {
            ResolvedJavaType type = StampTool.typeOrNull(((ObjectCloneNode) n).getObject());
            if (type != null) {
                if (type.isArray()) {
                    return SIZE_30;
                } else {
                    return SIZE_20;
                }
            }
        }
        return super.size(n);
    }

    @Override
    public NodeCycles cycles(Node n) {
        if (n instanceof ObjectCloneNode) {
            ResolvedJavaType type = StampTool.typeOrNull(((ObjectCloneNode) n).getObject());
            if (type != null) {
                if (type.isArray()) {
                    return CYCLES_30;
                } else {
                    return CYCLES_20;
                }
            }
        }
        return super.cycles(n);
    }

}
