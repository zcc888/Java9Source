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

import static org.graalvm.compiler.nodeinfo.InputType.Memory;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_10;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_8;

import org.graalvm.compiler.core.common.LocationIdentity;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.core.common.type.TypeReference;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.AbstractBeginNode;
import org.graalvm.compiler.nodes.BeginStateSplitNode;
import org.graalvm.compiler.nodes.InvokeWithExceptionNode;
import org.graalvm.compiler.nodes.KillingBeginNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.memory.MemoryCheckpoint;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;

import jdk.vm.ci.meta.MetaAccessProvider;

/**
 * The entry to an exception handler with the exception coming from a call (as opposed to a local
 * throw instruction or implicit exception).
 */
@NodeInfo(allowedUsageTypes = Memory, cycles = CYCLES_10, size = SIZE_8)
public final class ExceptionObjectNode extends BeginStateSplitNode implements Lowerable, MemoryCheckpoint.Single {
    public static final NodeClass<ExceptionObjectNode> TYPE = NodeClass.create(ExceptionObjectNode.class);

    public ExceptionObjectNode(MetaAccessProvider metaAccess) {
        super(TYPE, StampFactory.objectNonNull(TypeReference.createTrustedWithoutAssumptions(metaAccess.lookupJavaType(Throwable.class))));
    }

    @Override
    public LocationIdentity getLocationIdentity() {
        return LocationIdentity.any();
    }

    @Override
    public void lower(LoweringTool tool) {
        if (graph().getGuardsStage() == StructuredGraph.GuardsStage.FIXED_DEOPTS) {
            /*
             * Now the lowering to BeginNode+LoadExceptionNode can be performed, since no more
             * deopts can float in between the begin node and the load exception node.
             */
            LocationIdentity locationsKilledByInvoke = ((InvokeWithExceptionNode) predecessor()).getLocationIdentity();
            AbstractBeginNode entry = graph().add(new KillingBeginNode(locationsKilledByInvoke));
            LoadExceptionObjectNode loadException = graph().add(new LoadExceptionObjectNode(stamp()));

            loadException.setStateAfter(stateAfter());
            replaceAtUsages(InputType.Value, loadException);
            graph().replaceFixedWithFixed(this, entry);
            entry.graph().addAfterFixed(entry, loadException);

            loadException.lower(tool);
        }
    }

    @Override
    public boolean verify() {
        assertTrue(stateAfter() != null, "an exception handler needs a frame state");
        return super.verify();
    }
}
