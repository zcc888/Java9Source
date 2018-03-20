/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.loop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.graalvm.compiler.core.common.CollectionsFactory;
import org.graalvm.compiler.core.common.cfg.Loop;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.Debug.Scope;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.nodes.LoopBeginNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.cfg.Block;
import org.graalvm.compiler.nodes.cfg.ControlFlowGraph;

public class LoopsData {

    private Map<Loop<Block>, LoopEx> loopToEx = CollectionsFactory.newIdentityMap();
    private Map<LoopBeginNode, LoopEx> loopBeginToEx = Node.newIdentityMap();
    private ControlFlowGraph cfg;

    @SuppressWarnings("try")
    public LoopsData(final StructuredGraph graph) {
        try (Scope s = Debug.scope("ControlFlowGraph")) {
            cfg = ControlFlowGraph.compute(graph, true, true, true, true);
        } catch (Throwable e) {
            throw Debug.handle(e);
        }

        for (Loop<Block> loop : cfg.getLoops()) {
            LoopEx ex = new LoopEx(loop, this);
            loopToEx.put(loop, ex);
            loopBeginToEx.put(ex.loopBegin(), ex);
        }
    }

    public LoopEx loop(Loop<?> loop) {
        return loopToEx.get(loop);
    }

    public LoopEx loop(LoopBeginNode loopBegin) {
        return loopBeginToEx.get(loopBegin);
    }

    public Collection<LoopEx> loops() {
        return loopToEx.values();
    }

    public List<LoopEx> outerFirst() {
        ArrayList<LoopEx> loops = new ArrayList<>(loops());
        Collections.sort(loops, new Comparator<LoopEx>() {

            @Override
            public int compare(LoopEx o1, LoopEx o2) {
                return o1.loop().getDepth() - o2.loop().getDepth();
            }
        });
        return loops;
    }

    public List<LoopEx> innerFirst() {
        ArrayList<LoopEx> loops = new ArrayList<>(loops());
        Collections.sort(loops, new Comparator<LoopEx>() {

            @Override
            public int compare(LoopEx o1, LoopEx o2) {
                return o2.loop().getDepth() - o1.loop().getDepth();
            }
        });
        return loops;
    }

    public Collection<LoopEx> countedLoops() {
        List<LoopEx> counted = new LinkedList<>();
        for (LoopEx loop : loops()) {
            if (loop.isCounted()) {
                counted.add(loop);
            }
        }
        return counted;
    }

    public void detectedCountedLoops() {
        for (LoopEx loop : loops()) {
            loop.detectCounted();
        }
    }

    public ControlFlowGraph getCFG() {
        return cfg;
    }

    public InductionVariable getInductionVariable(ValueNode value) {
        InductionVariable match = null;
        for (LoopEx loop : loops()) {
            InductionVariable iv = loop.getInductionVariables().get(value);
            if (iv != null) {
                if (match != null) {
                    return null;
                }
                match = iv;
            }
        }
        return match;
    }

    /**
     * Deletes any nodes created within the scope of this object that have no usages.
     */
    public void deleteUnusedNodes() {
        for (LoopEx loop : loops()) {
            loop.deleteUnusedNodes();
        }
    }
}
