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
package org.graalvm.compiler.nodes.graphbuilderconf;

import org.graalvm.compiler.core.common.spi.ConstantFieldProvider;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.StampProvider;

import jdk.vm.ci.meta.Assumptions;
import jdk.vm.ci.meta.ConstantReflectionProvider;
import jdk.vm.ci.meta.MetaAccessProvider;

/**
 * Used by a {@link GraphBuilderPlugin} to interface with an object that builds a graph.
 */
public interface GraphBuilderTool {

    /**
     * Raw operation for adding a node to the graph.
     *
     * @return either the node added or an equivalent node
     */
    <T extends ValueNode> T append(T value);

    /**
     * Adds the given node to the graph and also adds recursively all referenced inputs.
     *
     * @param value the node to be added to the graph
     * @return either the node added or an equivalent node
     */
    <T extends ValueNode> T recursiveAppend(T value);

    StampProvider getStampProvider();

    MetaAccessProvider getMetaAccess();

    default Assumptions getAssumptions() {
        return getGraph().getAssumptions();
    }

    ConstantReflectionProvider getConstantReflection();

    ConstantFieldProvider getConstantFieldProvider();

    /**
     * Gets the graph being constructed.
     */
    StructuredGraph getGraph();

    /**
     * Determines if this parsing context is within the bytecode of an intrinsic or a method inlined
     * by an intrinsic.
     */
    boolean parsingIntrinsic();
}
