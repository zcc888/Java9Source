/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes;

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.java.ArrayLengthNode;
import org.graalvm.compiler.nodes.spi.ArrayLengthProvider;
import org.graalvm.compiler.nodes.util.GraphUtil;

/**
 * A {@link PiNode} that also provides an array length in addition to a more refined stamp. A usage
 * that reads the array length, such as an {@link ArrayLengthNode}, can be canonicalized based on
 * this information.
 */
@NodeInfo
public final class PiArrayNode extends PiNode implements ArrayLengthProvider {

    public static final NodeClass<PiArrayNode> TYPE = NodeClass.create(PiArrayNode.class);
    @Input ValueNode length;

    @Override
    public ValueNode length() {
        return length;
    }

    public PiArrayNode(ValueNode object, ValueNode length, Stamp stamp) {
        super(TYPE, object, stamp, null);
        this.length = length;
    }

    @Override
    public Node canonical(CanonicalizerTool tool) {
        if (GraphUtil.arrayLength(object()) != length()) {
            return this;
        }
        return super.canonical(tool);
    }

    @NodeIntrinsic
    public static native Object piArrayCast(Object object, int length, @ConstantNodeParameter Stamp stamp);
}
