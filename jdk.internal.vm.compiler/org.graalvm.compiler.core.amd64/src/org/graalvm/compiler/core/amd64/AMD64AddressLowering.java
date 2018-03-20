/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

package org.graalvm.compiler.core.amd64;

import jdk.vm.ci.meta.JavaConstant;

import org.graalvm.compiler.asm.NumUtil;
import org.graalvm.compiler.asm.amd64.AMD64Address.Scale;
import org.graalvm.compiler.core.common.type.IntegerStamp;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.calc.AddNode;
import org.graalvm.compiler.nodes.calc.LeftShiftNode;
import org.graalvm.compiler.nodes.calc.ZeroExtendNode;
import org.graalvm.compiler.nodes.memory.address.AddressNode;
import org.graalvm.compiler.phases.common.AddressLoweringPhase.AddressLowering;

public class AMD64AddressLowering extends AddressLowering {

    @Override
    public AddressNode lower(ValueNode address) {
        return lower(address, null);
    }

    @Override
    public AddressNode lower(ValueNode base, ValueNode offset) {
        AMD64AddressNode ret = new AMD64AddressNode(base, offset);
        boolean changed;
        do {
            changed = improve(ret);
        } while (changed);
        return base.graph().unique(ret);
    }

    protected boolean improve(AMD64AddressNode ret) {
        ValueNode newBase = improveInput(ret, ret.getBase(), 0);
        if (newBase != ret.getBase()) {
            ret.setBase(newBase);
            return true;
        }

        ValueNode newIdx = improveInput(ret, ret.getIndex(), ret.getScale().log2);
        if (newIdx != ret.getIndex()) {
            ret.setIndex(newIdx);
            return true;
        }

        if (ret.getIndex() instanceof LeftShiftNode) {
            LeftShiftNode shift = (LeftShiftNode) ret.getIndex();
            if (shift.getY().isConstant()) {
                int amount = ret.getScale().log2 + shift.getY().asJavaConstant().asInt();
                Scale scale = Scale.fromShift(amount);
                if (scale != null) {
                    ret.setIndex(shift.getX());
                    ret.setScale(scale);
                    return true;
                }
            }
        }

        if (ret.getScale() == Scale.Times1) {
            if (ret.getBase() == null || ret.getIndex() == null) {
                if (ret.getBase() instanceof AddNode) {
                    AddNode add = (AddNode) ret.getBase();
                    ret.setBase(add.getX());
                    ret.setIndex(add.getY());
                    return true;
                } else if (ret.getIndex() instanceof AddNode) {
                    AddNode add = (AddNode) ret.getIndex();
                    ret.setBase(add.getX());
                    ret.setIndex(add.getY());
                    return true;
                }
            }

            if (ret.getBase() instanceof LeftShiftNode && !(ret.getIndex() instanceof LeftShiftNode)) {
                ValueNode tmp = ret.getBase();
                ret.setBase(ret.getIndex());
                ret.setIndex(tmp);
                return true;
            }
        }

        return false;
    }

    private static ValueNode improveInput(AMD64AddressNode address, ValueNode node, int shift) {
        if (node == null) {
            return null;
        }

        JavaConstant c = node.asJavaConstant();
        if (c != null) {
            return improveConstDisp(address, node, c, null, shift);
        } else {
            if (node.stamp() instanceof IntegerStamp && ((IntegerStamp) node.stamp()).getBits() == 64) {
                if (node instanceof ZeroExtendNode) {
                    if (((ZeroExtendNode) node).getInputBits() == 32) {
                        /*
                         * We can just swallow a zero-extend from 32 bit to 64 bit because the upper
                         * half of the register will always be zero.
                         */
                        return ((ZeroExtendNode) node).getValue();
                    }
                } else if (node instanceof AddNode) {
                    AddNode add = (AddNode) node;
                    if (add.getX().isConstant()) {
                        return improveConstDisp(address, node, add.getX().asJavaConstant(), add.getY(), shift);
                    } else if (add.getY().isConstant()) {
                        return improveConstDisp(address, node, add.getY().asJavaConstant(), add.getX(), shift);
                    }
                }
            }
        }

        return node;
    }

    private static ValueNode improveConstDisp(AMD64AddressNode address, ValueNode original, JavaConstant c, ValueNode other, int shift) {
        if (c.getJavaKind().isNumericInteger()) {
            long disp = address.getDisplacement();
            disp += c.asLong() << shift;
            if (NumUtil.isInt(disp)) {
                address.setDisplacement((int) disp);
                return other;
            }
        }
        return original;
    }
}
