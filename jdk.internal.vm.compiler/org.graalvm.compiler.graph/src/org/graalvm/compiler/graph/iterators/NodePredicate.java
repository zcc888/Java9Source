/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.graph.iterators;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.iterators.NodePredicates.AndPredicate;

public interface NodePredicate {

    boolean apply(Node n);

    default NodePredicate and(NodePredicate np) {
        return new AndPredicate(this, np);
    }
}
