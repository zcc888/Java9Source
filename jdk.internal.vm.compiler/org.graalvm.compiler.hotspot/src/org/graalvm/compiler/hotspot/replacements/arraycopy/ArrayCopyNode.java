/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.replacements.arraycopy;

import jdk.vm.ci.meta.JavaKind;

import static org.graalvm.compiler.core.common.LocationIdentity.any;

import org.graalvm.compiler.core.common.LocationIdentity;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.NamedLocationIdentity;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.nodes.spi.Virtualizable;
import org.graalvm.compiler.replacements.nodes.BasicArrayCopyNode;

@NodeInfo
public final class ArrayCopyNode extends BasicArrayCopyNode implements Virtualizable, Lowerable {

    public static final NodeClass<ArrayCopyNode> TYPE = NodeClass.create(ArrayCopyNode.class);

    private JavaKind elementKind;

    public ArrayCopyNode(int bci, ValueNode src, ValueNode srcPos, ValueNode dst, ValueNode dstPos, ValueNode length) {
        super(TYPE, src, srcPos, dst, dstPos, length, null, bci);
        elementKind = ArrayCopySnippets.Templates.selectComponentKind(this);
    }

    @Override
    public LocationIdentity getLocationIdentity() {
        if (elementKind == null) {
            elementKind = ArrayCopySnippets.Templates.selectComponentKind(this);
        }
        if (elementKind != null) {
            return NamedLocationIdentity.getArrayLocation(elementKind);
        }
        return any();
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }
}
