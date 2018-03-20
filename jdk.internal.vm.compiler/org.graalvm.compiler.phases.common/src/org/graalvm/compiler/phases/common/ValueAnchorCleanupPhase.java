/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.phases.common;

import java.util.List;
import java.util.Set;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.nodes.AbstractMergeNode;
import org.graalvm.compiler.nodes.FixedNode;
import org.graalvm.compiler.nodes.StartNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.extended.ValueAnchorNode;
import org.graalvm.compiler.phases.Phase;
import org.graalvm.compiler.phases.graph.MergeableState;
import org.graalvm.compiler.phases.graph.SinglePassNodeIterator;

/**
 * This phase performs a bit of hygiene on {@link ValueAnchorNode} by removing inputs that have
 * already been anchored in a dominating value anchor. Value anchors that lose their last input,
 * have no usages and are not marked as permanent are removed.
 */
public class ValueAnchorCleanupPhase extends Phase {

    private static class State extends MergeableState<State> implements Cloneable {

        private final Set<Node> anchoredValues;

        State() {
            anchoredValues = Node.newSet();
        }

        State(State other) {
            anchoredValues = Node.newSet(other.anchoredValues);
        }

        @Override
        public boolean merge(AbstractMergeNode merge, List<State> withStates) {
            for (State other : withStates) {
                anchoredValues.retainAll(other.anchoredValues);
            }
            return true;
        }

        @Override
        public State clone() {
            return new State(this);
        }
    }

    private static class CleanupValueAnchorsClosure extends SinglePassNodeIterator<State> {

        CleanupValueAnchorsClosure(StartNode start) {
            super(start, new State());
        }

        @Override
        protected void node(FixedNode node) {
            if (node instanceof ValueAnchorNode) {
                ValueAnchorNode anchor = (ValueAnchorNode) node;
                ValueNode anchored = anchor.getAnchoredNode();
                if (anchored != null) {
                    if (state.anchoredValues.contains(anchored)) {
                        anchor.removeAnchoredNode();
                    } else {
                        state.anchoredValues.add(anchored);
                    }
                }
                if (anchor.getAnchoredNode() == null && anchor.hasNoUsages()) {
                    node.graph().removeFixed(anchor);
                }
            }
        }
    }

    @Override
    protected void run(StructuredGraph graph) {
        CleanupValueAnchorsClosure closure = new CleanupValueAnchorsClosure(graph.start());
        closure.apply();
    }
}
