/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.nodes.aot;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.hotspot.replacements.EncodedSymbolConstant;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.calc.FloatingNode;
import org.graalvm.compiler.nodes.util.GraphUtil;
import org.graalvm.compiler.word.Word;

import jdk.vm.ci.meta.Constant;

@NodeInfo
public final class EncodedSymbolNode extends FloatingNode implements Canonicalizable {

    public static final NodeClass<EncodedSymbolNode> TYPE = NodeClass.create(EncodedSymbolNode.class);

    @OptionalInput protected ValueNode value;

    public EncodedSymbolNode(ValueNode value) {
        super(TYPE, null);
        assert value != null;
        this.value = value;
    }

    @Override
    public Node canonical(CanonicalizerTool tool) {
        if (value != null) {
            Constant constant = GraphUtil.foldIfConstantAndRemove(this, value);
            if (constant != null) {
                return new ConstantNode(new EncodedSymbolConstant(constant), StampFactory.pointer());
            }
        }
        return this;
    }

    @NodeIntrinsic(setStampFromReturnType = true)
    public static native Word encode(Object constant);
}
