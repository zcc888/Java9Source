/*
 * Copyright (c) 2009, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes.java;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_30;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_30;

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.core.common.type.TypeReference;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.BinaryOpLogicNode;
import org.graalvm.compiler.nodes.LogicConstantNode;
import org.graalvm.compiler.nodes.LogicNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.calc.IsNullNode;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;

import jdk.vm.ci.meta.Assumptions;
import jdk.vm.ci.meta.ConstantReflectionProvider;
import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ResolvedJavaType;
import jdk.vm.ci.meta.TriState;

/**
 * The {@code InstanceOfDynamicNode} represents a type check where the type being checked is not
 * known at compile time. This is used, for instance, to intrinsify {@link Class#isInstance(Object)}
 * .
 */
@NodeInfo(cycles = CYCLES_30, size = SIZE_30)
public class InstanceOfDynamicNode extends BinaryOpLogicNode implements Canonicalizable.Binary<ValueNode>, Lowerable {
    public static final NodeClass<InstanceOfDynamicNode> TYPE = NodeClass.create(InstanceOfDynamicNode.class);

    private final boolean allowNull;

    public static LogicNode create(Assumptions assumptions, ConstantReflectionProvider constantReflection, ValueNode mirror, ValueNode object, boolean allowNull) {
        LogicNode synonym = findSynonym(assumptions, constantReflection, mirror, object, allowNull);
        if (synonym != null) {
            return synonym;
        }
        return new InstanceOfDynamicNode(mirror, object, allowNull);
    }

    protected InstanceOfDynamicNode(ValueNode mirror, ValueNode object, boolean allowNull) {
        super(TYPE, mirror, object);
        this.allowNull = allowNull;
        assert mirror.getStackKind() == JavaKind.Object || mirror.getStackKind() == JavaKind.Illegal : mirror.getStackKind();
    }

    public boolean isMirror() {
        return getMirrorOrHub().getStackKind() == JavaKind.Object;
    }

    public boolean isHub() {
        return !isMirror();
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    private static LogicNode findSynonym(Assumptions assumptions, ConstantReflectionProvider constantReflection, ValueNode forMirror, ValueNode forObject,
                    boolean allowNull) {
        if (forMirror.isConstant()) {
            ResolvedJavaType t = constantReflection.asJavaType(forMirror.asConstant());
            if (t != null) {
                if (t.isPrimitive()) {
                    if (allowNull) {
                        return IsNullNode.create(forObject);
                    } else {
                        return LogicConstantNode.contradiction();
                    }
                } else {
                    TypeReference type = TypeReference.createTrusted(assumptions, t);
                    if (allowNull) {
                        return InstanceOfNode.createAllowNull(type, forObject, null, null);
                    } else {
                        return InstanceOfNode.create(type, forObject);
                    }
                }
            }
        }
        return null;
    }

    public ValueNode getMirrorOrHub() {
        return this.getX();
    }

    public ValueNode getObject() {
        return this.getY();
    }

    @Override
    public LogicNode canonical(CanonicalizerTool tool, ValueNode forMirror, ValueNode forObject) {
        LogicNode result = findSynonym(tool.getAssumptions(), tool.getConstantReflection(), forMirror, forObject, allowNull);
        if (result != null) {
            return result;
        }
        return this;
    }

    public void setMirror(ValueNode newObject) {
        this.updateUsages(x, newObject);
        this.x = newObject;
    }

    public boolean allowsNull() {
        return allowNull;
    }

    @Override
    public Stamp getSucceedingStampForX(boolean negated) {
        return null;
    }

    @Override
    public Stamp getSucceedingStampForY(boolean negated) {
        return null;
    }

    @Override
    public TriState tryFold(Stamp xStamp, Stamp yStamp) {
        return TriState.UNKNOWN;
    }
}