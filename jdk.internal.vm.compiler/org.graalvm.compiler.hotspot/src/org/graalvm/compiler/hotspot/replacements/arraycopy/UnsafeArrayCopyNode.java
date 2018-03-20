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

import static org.graalvm.compiler.core.common.LocationIdentity.any;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_200;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_200;

import org.graalvm.compiler.core.common.LocationIdentity;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.NamedLocationIdentity;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.extended.ArrayRangeWriteNode;
import org.graalvm.compiler.nodes.memory.MemoryAccess;
import org.graalvm.compiler.nodes.memory.MemoryCheckpoint;
import org.graalvm.compiler.nodes.memory.MemoryNode;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.replacements.SnippetTemplate.Arguments;

import jdk.vm.ci.meta.JavaKind;

@NodeInfo(allowedUsageTypes = {InputType.Memory}, cycles = CYCLES_200, size = SIZE_200)
public final class UnsafeArrayCopyNode extends ArrayRangeWriteNode implements Lowerable, MemoryCheckpoint.Single, MemoryAccess {

    public static final NodeClass<UnsafeArrayCopyNode> TYPE = NodeClass.create(UnsafeArrayCopyNode.class);
    @Input ValueNode src;
    @Input ValueNode srcPos;
    @Input ValueNode dest;
    @Input ValueNode destPos;
    @Input ValueNode length;
    @OptionalInput ValueNode layoutHelper;

    @OptionalInput(InputType.Memory) MemoryNode lastLocationAccess;

    protected JavaKind elementKind;

    public UnsafeArrayCopyNode(ValueNode src, ValueNode srcPos, ValueNode dest, ValueNode destPos, ValueNode length, ValueNode layoutHelper, JavaKind elementKind) {
        super(TYPE, StampFactory.forVoid());
        assert layoutHelper == null || elementKind == null;
        this.src = src;
        this.srcPos = srcPos;
        this.dest = dest;
        this.destPos = destPos;
        this.length = length;
        this.layoutHelper = layoutHelper;
        this.elementKind = elementKind;
    }

    public UnsafeArrayCopyNode(ValueNode src, ValueNode srcPos, ValueNode dest, ValueNode destPos, ValueNode length, JavaKind elementKind) {
        this(src, srcPos, dest, destPos, length, null, elementKind);
    }

    public UnsafeArrayCopyNode(ValueNode src, ValueNode srcPos, ValueNode dest, ValueNode destPos, ValueNode length, ValueNode layoutHelper) {
        this(src, srcPos, dest, destPos, length, layoutHelper, null);
    }

    @Override
    public ValueNode getArray() {
        return dest;
    }

    @Override
    public ValueNode getIndex() {
        return destPos;
    }

    @Override
    public ValueNode getLength() {
        return length;
    }

    @Override
    public boolean isObjectArray() {
        return elementKind == JavaKind.Object;
    }

    @Override
    public boolean isInitialization() {
        return false;
    }

    public JavaKind getElementKind() {
        return elementKind;
    }

    @Override
    public void lower(LoweringTool tool) {
        if (graph().getGuardsStage().areFrameStatesAtDeopts()) {
            UnsafeArrayCopySnippets.Templates templates = tool.getReplacements().getSnippetTemplateCache(UnsafeArrayCopySnippets.Templates.class);
            templates.lower(this, tool);
        }
    }

    public void addSnippetArguments(Arguments args) {
        args.add("src", src);
        args.add("srcPos", srcPos);
        args.add("dest", dest);
        args.add("destPos", destPos);
        args.add("length", length);
        if (layoutHelper != null) {
            args.add("layoutHelper", layoutHelper);
        }
    }

    @Override
    public LocationIdentity getLocationIdentity() {
        if (elementKind != null) {
            return NamedLocationIdentity.getArrayLocation(elementKind);
        }
        return any();
    }

    @Override
    public MemoryNode getLastLocationAccess() {
        return lastLocationAccess;
    }

    @Override
    public void setLastLocationAccess(MemoryNode lla) {
        updateUsagesInterface(lastLocationAccess, lla);
        lastLocationAccess = lla;
    }

    @NodeIntrinsic
    public static native void arraycopy(Object src, int srcPos, Object dest, int destPos, int length, @ConstantNodeParameter JavaKind elementKind);

    @NodeIntrinsic
    public static native void arraycopyPrimitive(Object src, int srcPos, Object dest, int destPos, int length, int layoutHelper);
}
