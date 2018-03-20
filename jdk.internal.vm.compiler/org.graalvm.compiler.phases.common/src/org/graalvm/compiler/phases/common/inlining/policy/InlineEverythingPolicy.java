/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.phases.common.inlining.policy;

import static org.graalvm.compiler.core.common.GraalOptions.MaximumDesiredSize;

import org.graalvm.compiler.common.PermanentBailoutException;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.spi.Replacements;
import org.graalvm.compiler.phases.common.inlining.InliningUtil;
import org.graalvm.compiler.phases.common.inlining.walker.MethodInvocation;

public class InlineEverythingPolicy implements InliningPolicy {

    @Override
    public boolean continueInlining(StructuredGraph graph) {
        if (InliningUtil.getNodeCount(graph) >= MaximumDesiredSize.getValue()) {
            throw new PermanentBailoutException("Inline all calls failed. The resulting graph is too large.");
        }
        return true;
    }

    @Override
    public boolean isWorthInlining(Replacements replacements, MethodInvocation invocation, int inliningDepth, boolean fullyProcessed) {
        return true;
    }
}
