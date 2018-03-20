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
package org.graalvm.compiler.nodes.spi;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.nodeinfo.NodeCycles;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodeinfo.NodeSize;

/**
 * A provider that enables overriding and customization of the {@link NodeCycles} and
 * {@link NodeSize} values for a {@linkplain Node node}.
 */
public interface NodeCostProvider {

    /**
     * Gets the estimated size of machine code generated for {@code n}.
     */
    int getEstimatedCodeSize(Node n);

    /**
     * Gets the estimated execution cost for {@code n} in terms of CPU cycles.
     */
    int getEstimatedCPUCycles(Node n);

    /**
     * @see NodeInfo#size()
     */
    NodeSize size(Node n);

    /**
     * @see NodeInfo#cycles()
     */
    NodeCycles cycles(Node n);

}
