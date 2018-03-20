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
package org.graalvm.compiler.hotspot.nodes.aot;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_3;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_3;

import org.graalvm.compiler.common.PermanentBailoutException;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.hotspot.HotSpotLIRGenerator;
import org.graalvm.compiler.hotspot.meta.HotSpotConstantLoadAction;
import org.graalvm.compiler.hotspot.word.KlassPointer;
import org.graalvm.compiler.hotspot.word.MethodPointer;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import org.graalvm.compiler.nodes.util.GraphUtil;

import jdk.vm.ci.hotspot.HotSpotMetaspaceConstant;
import jdk.vm.ci.hotspot.HotSpotObjectConstant;
import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.Value;

@NodeInfo(cycles = CYCLES_3, size = SIZE_3)
public class LoadConstantIndirectlyFixedNode extends FixedWithNextNode implements Canonicalizable, LIRLowerable {

    public static final NodeClass<LoadConstantIndirectlyFixedNode> TYPE = NodeClass.create(LoadConstantIndirectlyFixedNode.class);

    @OptionalInput protected ValueNode value;
    protected Constant constant;
    protected HotSpotConstantLoadAction action;

    public LoadConstantIndirectlyFixedNode(ValueNode value) {
        super(TYPE, value.stamp().unrestricted());
        this.value = value;
        this.constant = null;
        this.action = HotSpotConstantLoadAction.RESOLVE;
    }

    public LoadConstantIndirectlyFixedNode(ValueNode value, HotSpotConstantLoadAction action) {
        super(TYPE, value.stamp().unrestricted());
        this.value = value;
        this.constant = null;
        this.action = action;
    }

    @Override
    public Node canonical(CanonicalizerTool tool) {
        if (value != null) {
            constant = GraphUtil.foldIfConstantAndRemove(this, value);
        }
        return this;
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        assert constant != null : "Expected the value to fold: " + value;
        Value result;
        if (constant instanceof HotSpotObjectConstant) {
            result = ((HotSpotLIRGenerator) gen.getLIRGeneratorTool()).emitLoadObjectAddress(constant);
        } else if (constant instanceof HotSpotMetaspaceConstant) {
            result = ((HotSpotLIRGenerator) gen.getLIRGeneratorTool()).emitLoadMetaspaceAddress(constant, action);
        } else {
            throw new PermanentBailoutException("Unsupported constant type: " + constant);
        }
        gen.setResult(this, result);
    }

    @NodeIntrinsic
    public static native KlassPointer loadKlass(KlassPointer klassPointer, @ConstantNodeParameter HotSpotConstantLoadAction action);

    @NodeIntrinsic
    public static native KlassPointer loadKlass(KlassPointer klassPointer);

    @NodeIntrinsic
    public static native MethodPointer loadMethod(MethodPointer klassPointer);

    @NodeIntrinsic
    public static native Object loadObject(Object object);

}
