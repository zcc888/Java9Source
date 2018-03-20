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
package org.graalvm.compiler.phases.common;

import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.DebugCounter;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.nodes.PiNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.spi.PiPushable;
import org.graalvm.compiler.phases.Phase;

public class PushThroughPiPhase extends Phase {

    public static final DebugCounter PUSHED_NODES = Debug.counter("NodesPushedThroughPi");

    @Override
    protected void run(StructuredGraph graph) {
        for (PiNode pi : graph.getNodes(PiNode.TYPE)) {
            for (Node n : pi.usages().snapshot()) {
                if (n instanceof PiPushable) {
                    PiPushable pip = (PiPushable) n;
                    if (pip.push(pi)) {
                        PUSHED_NODES.add(1);
                    }
                }
            }
        }
    }
}
