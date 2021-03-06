/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes.virtual;

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodeinfo.Verbosity;
import org.graalvm.compiler.nodes.FixedNode;
import org.graalvm.compiler.nodes.ValueNode;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ResolvedJavaField;
import jdk.vm.ci.meta.ResolvedJavaType;

@NodeInfo(nameTemplate = "VirtualInstance {p#type/s}")
public class VirtualInstanceNode extends VirtualObjectNode {

    public static final NodeClass<VirtualInstanceNode> TYPE = NodeClass.create(VirtualInstanceNode.class);
    protected final ResolvedJavaType type;
    protected final ResolvedJavaField[] fields;

    public VirtualInstanceNode(ResolvedJavaType type, boolean hasIdentity) {
        this(type, type.getInstanceFields(true), hasIdentity);
    }

    public VirtualInstanceNode(ResolvedJavaType type, ResolvedJavaField[] fields, boolean hasIdentity) {
        this(TYPE, type, fields, hasIdentity);
    }

    protected VirtualInstanceNode(NodeClass<? extends VirtualInstanceNode> c, ResolvedJavaType type, boolean hasIdentity) {
        this(c, type, type.getInstanceFields(true), hasIdentity);
    }

    protected VirtualInstanceNode(NodeClass<? extends VirtualInstanceNode> c, ResolvedJavaType type, ResolvedJavaField[] fields, boolean hasIdentity) {
        super(c, type, hasIdentity);
        this.type = type;
        this.fields = fields;
    }

    @Override
    public ResolvedJavaType type() {
        return type;
    }

    @Override
    public int entryCount() {
        return fields.length;
    }

    public ResolvedJavaField field(int index) {
        return fields[index];
    }

    public ResolvedJavaField[] getFields() {
        return fields;
    }

    @Override
    public String toString(Verbosity verbosity) {
        if (verbosity == Verbosity.Name) {
            return super.toString(Verbosity.Name) + " " + type.toJavaName(false);
        } else {
            return super.toString(verbosity);
        }
    }

    @Override
    public String entryName(int index) {
        return fields[index].getName();
    }

    public int fieldIndex(ResolvedJavaField field) {
        // on average fields.length == ~6, so a linear search is fast enough
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].equals(field)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int entryIndexForOffset(long constantOffset, JavaKind expectedEntryKind) {
        return fieldIndex(type.findInstanceFieldWithOffset(constantOffset, expectedEntryKind));
    }

    @Override
    public JavaKind entryKind(int index) {
        assert index >= 0 && index < fields.length;
        return fields[index].getJavaKind();
    }

    @Override
    public VirtualInstanceNode duplicate() {
        return new VirtualInstanceNode(type, fields, super.hasIdentity());
    }

    @Override
    public ValueNode getMaterializedRepresentation(FixedNode fixed, ValueNode[] entries, LockState locks) {
        return new AllocatedObjectNode(this);
    }
}
