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
 * Constants representing an estimation of the number of CPU cycles needed to execute a certain
 * compiler node.
 */
public enum NodeCycles {

    /**
     * The default value of the {@link NodeInfo#cycles()} property.
     * <p>
     * For further information about the use of {@code CYCLES_UNSET} see {@link NodeInfo#cycles()}.
     */
    CYCLES_UNSET(0),
    /**
     * Nodes for which, due to arbitrary reasons, no estimation can be made either (1) statically
     * without inspecting the properties of a node or (2) at all (like e.g. for an invocation).
     * <p>
     * Nodes annotated with {@code CYCLES_UNKNOWN} should specify the
     * {@link NodeInfo#cyclesRationale()} property to clarify why an estimation cannot be done.
     */
    CYCLES_UNKNOWN(0),
    /**
     * Nodes for which runtime information is irrelevant and can be ignored, e.g. for test nodes.
     */
    CYCLES_IGNORED(0),
    /**
     * Nodes that do not consume any CPU time during the "execution", e.g. Constants.
     */
    CYCLES_0(0),
    CYCLES_1(1),
    CYCLES_2(2),
    CYCLES_3(3),
    CYCLES_4(4),
    CYCLES_5(5),
    CYCLES_6(6),
    CYCLES_8(8),
    CYCLES_10(10),
    CYCLES_15(15),
    CYCLES_20(20),
    CYCLES_30(30),
    CYCLES_40(40),
    CYCLES_50(50),
    CYCLES_80(80),
    CYCLES_100(100),
    CYCLES_200(200),
    CYCLES_500(500);

    public final int estimatedCPUCycles;

    NodeCycles(int estimatedCPUCycles) {
        this.estimatedCPUCycles = estimatedCPUCycles;
    }

    public static final int IGNORE_CYCLES_CONTRACT_FACTOR = 0xFFFF;

}
