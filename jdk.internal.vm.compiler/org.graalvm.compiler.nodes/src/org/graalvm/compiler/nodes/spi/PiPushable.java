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
package org.graalvm.compiler.nodes.spi;

import org.graalvm.compiler.nodes.PiNode;

/**
 * This interface marks nodes, which are able to be pushed through a PiNode.
 */
public interface PiPushable {

    /**
     *
     * @param parent PiNode
     * @return true if node was moved
     */
    boolean push(PiNode parent);
}
