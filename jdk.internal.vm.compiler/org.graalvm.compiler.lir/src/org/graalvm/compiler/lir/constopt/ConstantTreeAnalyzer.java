/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.lir.constopt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.Debug.Scope;
import org.graalvm.compiler.debug.Indent;
import org.graalvm.compiler.lir.constopt.ConstantTree.Flags;
import org.graalvm.compiler.lir.constopt.ConstantTree.NodeCost;

/**
 * Analyzes a {@link ConstantTree} and marks potential materialization positions.
 */
public final class ConstantTreeAnalyzer {
    private final ConstantTree tree;
    private final BitSet visited;

    @SuppressWarnings("try")
    public static NodeCost analyze(ConstantTree tree, AbstractBlockBase<?> startBlock) {
        try (Scope s = Debug.scope("ConstantTreeAnalyzer")) {
            ConstantTreeAnalyzer analyzer = new ConstantTreeAnalyzer(tree);
            analyzer.analyzeBlocks(startBlock);
            return tree.getCost(startBlock);
        } catch (Throwable e) {
            throw Debug.handle(e);
        }
    }

    private ConstantTreeAnalyzer(ConstantTree tree) {
        this.tree = tree;
        this.visited = new BitSet(tree.size());
    }

    /**
     * Queues all relevant blocks for {@linkplain #process processing}.
     *
     * This is a worklist-style algorithm because a (more elegant) recursive implementation may
     * cause {@linkplain StackOverflowError stack overflows} on larger graphs.
     *
     * @param startBlock The start block of the dominator subtree.
     */
    @SuppressWarnings("try")
    private void analyzeBlocks(AbstractBlockBase<?> startBlock) {
        Deque<AbstractBlockBase<?>> worklist = new ArrayDeque<>();
        worklist.offerLast(startBlock);
        while (!worklist.isEmpty()) {
            AbstractBlockBase<?> block = worklist.pollLast();
            try (Indent i = Debug.logAndIndent(Debug.VERBOSE_LOG_LEVEL, "analyze: %s", block)) {
                assert block != null : "worklist is empty!";
                assert isMarked(block) : "Block not part of the dominator tree: " + block;

                if (isLeafBlock(block)) {
                    Debug.log(Debug.VERBOSE_LOG_LEVEL, "leaf block");
                    leafCost(block);
                    continue;
                }

                if (!visited.get(block.getId())) {
                    // if not yet visited (and not a leaf block) process all children first!
                    Debug.log(Debug.VERBOSE_LOG_LEVEL, "not marked");
                    worklist.offerLast(block);
                    List<? extends AbstractBlockBase<?>> children = block.getDominated();
                    children.forEach(child -> filteredPush(worklist, child));
                    visited.set(block.getId());
                } else {
                    Debug.log(Debug.VERBOSE_LOG_LEVEL, "marked");
                    // otherwise, process block
                    process(block);
                }
            }
        }
    }

    /**
     * Calculates the cost of a {@code block}. It is assumed that all {@code children} have already
     * been {@linkplain #process processed}
     *
     * @param block The block to be processed.
     */
    private void process(AbstractBlockBase<?> block) {
        List<UseEntry> usages = new ArrayList<>();
        double bestCost = 0;
        int numMat = 0;
        List<? extends AbstractBlockBase<?>> children = block.getDominated();
        assert children.stream().anyMatch(this::isMarked) : "no children? should have called leafCost(): " + block;

        // collect children costs
        for (AbstractBlockBase<?> child : children) {
            if (isMarked(child)) {
                NodeCost childCost = tree.getCost(child);
                assert childCost != null : "Child with null cost? block: " + child;
                usages.addAll(childCost.getUsages());
                numMat += childCost.getNumMaterializations();
                bestCost += childCost.getBestCost();
            }
        }
        assert numMat > 0 : "No materialization? " + numMat;

        // choose block
        List<UseEntry> usagesBlock = tree.getUsages(block);
        double probabilityBlock = block.probability();

        if (!usagesBlock.isEmpty() || shouldMaterializerInCurrentBlock(probabilityBlock, bestCost, numMat)) {
            // mark current block as potential materialization position
            usages.addAll(usagesBlock);
            bestCost = probabilityBlock;
            numMat = 1;
            tree.set(Flags.CANDIDATE, block);
        } else {
            // stick with the current solution
        }

        assert (new HashSet<>(usages)).size() == usages.size() : "doulbe entries? " + usages;
        NodeCost nodeCost = new NodeCost(bestCost, usages, numMat);
        tree.setCost(block, nodeCost);
    }

    /**
     * This is the cost function that decides whether a materialization should be inserted in the
     * current block.
     * <p>
     * Note that this function does not take into account if a materialization is required despite
     * the probabilities (e.g. there are usages in the current block).
     *
     * @param probabilityBlock Probability of the current block.
     * @param probabilityChildren Accumulated probability of the children.
     * @param numMat Number of materializations along the subtrees. We use {@code numMat - 1} to
     *            insert materializations as late as possible if the probabilities are the same.
     */
    private static boolean shouldMaterializerInCurrentBlock(double probabilityBlock, double probabilityChildren, int numMat) {
        return probabilityBlock * Math.pow(0.9, numMat - 1) < probabilityChildren;
    }

    private void filteredPush(Deque<AbstractBlockBase<?>> worklist, AbstractBlockBase<?> block) {
        if (isMarked(block)) {
            Debug.log(Debug.VERBOSE_LOG_LEVEL, "adding %s to the worklist", block);
            worklist.offerLast(block);
        }
    }

    private void leafCost(AbstractBlockBase<?> block) {
        tree.set(Flags.CANDIDATE, block);
        tree.getOrInitCost(block);
    }

    private boolean isMarked(AbstractBlockBase<?> block) {
        return tree.isMarked(block);
    }

    private boolean isLeafBlock(AbstractBlockBase<?> block) {
        return tree.isLeafBlock(block);
    }

}
