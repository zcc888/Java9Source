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
package org.graalvm.compiler.nodeinfo;

/**
 * Constants representing an estimation of of the size needed to represent a compiler node in
 * machine code.
 */
public enum NodeSize {

    /**
     * The default value of the {@link NodeInfo#size()} property.
     * <p>
     * For further information about the use of {@code SIZE_UNSET} see {@link NodeInfo#size()}.
     */
    SIZE_UNSET(0),
    /**
     * Nodes for which, due to arbitrary reasons, no estimation can be made either (1) statically
     * without inspecting the properties of a node or (2) at all (like e.g. for an invocation).
     * <p>
     * Nodes annotated with {@code SIZE_UNKNOWN} should specify the {@link NodeInfo#sizeRationale()}
     * property to clarify why an estimation cannot be done.
     */
    SIZE_UNKNOWN(0),
    /**
     * Nodes for which code size information is irrelevant and can be ignored, e.g. for test nodes.
     */
    SIZE_IGNORED(0),
    /**
     * Nodes that do not require any code to be generated in order to be "executed", e.g. a phi
     * node.
     */
    SIZE_0(0),
    SIZE_1(1),
    SIZE_2(2),
    SIZE_3(3),
    SIZE_4(4),
    SIZE_6(6),
    SIZE_8(8),
    SIZE_10(10),
    SIZE_15(15),
    SIZE_20(20),
    SIZE_30(30),
    SIZE_40(40),
    SIZE_50(50),
    SIZE_80(80),
    SIZE_100(100),
    SIZE_200(200);

    public final int estimatedCodeSize;

    NodeSize(int estimatedCodeSize) {
        this.estimatedCodeSize = estimatedCodeSize;
    }

    public static final int IGNORE_SIZE_CONTRACT_FACTOR = 0xFFFF;
}
