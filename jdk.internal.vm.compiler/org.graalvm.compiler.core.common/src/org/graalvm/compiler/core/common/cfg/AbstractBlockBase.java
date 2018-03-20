/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.core.common.cfg;

import java.util.Collections;
import java.util.List;

public abstract class AbstractBlockBase<T extends AbstractBlockBase<T>> {

    protected int id;
    protected int domDepth;

    protected T[] predecessors;
    protected T[] successors;

    private T dominator;
    private List<T> dominated;
    private int domNumber;
    private int maxChildDomNumber;

    private boolean align;
    private int linearScanNumber;

    protected AbstractBlockBase() {
        this.id = AbstractControlFlowGraph.BLOCK_ID_INITIAL;
        this.linearScanNumber = -1;
        this.domNumber = -1;
        this.maxChildDomNumber = -1;
    }

    public void setDominatorNumber(int domNumber) {
        this.domNumber = domNumber;
    }

    public void setMaxChildDomNumber(int maxChildDomNumber) {
        this.maxChildDomNumber = maxChildDomNumber;
    }

    public int getDominatorNumber() {
        return domNumber;
    }

    public int getMaxChildDominatorNumber() {
        return this.maxChildDomNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T[] getPredecessors() {
        return predecessors;
    }

    public void setPredecessors(T[] predecessors) {
        this.predecessors = predecessors;
    }

    public T[] getSuccessors() {
        return successors;
    }

    public void setSuccessors(T[] successors) {
        this.successors = successors;
    }

    public T getDominator() {
        return dominator;
    }

    public void setDominator(T dominator) {
        this.dominator = dominator;
        this.domDepth = dominator.domDepth + 1;
    }

    public int getDominatorDepth() {
        return domDepth;
    }

    public List<T> getDominated() {
        if (dominated == null) {
            return Collections.emptyList();
        }
        return dominated;
    }

    public void setDominated(List<T> blocks) {
        dominated = blocks;
    }

    @Override
    public String toString() {
        return "B" + id;
    }

    public int getPredecessorCount() {
        return getPredecessors().length;
    }

    public int getSuccessorCount() {
        return getSuccessors().length;
    }

    public int getLinearScanNumber() {
        return linearScanNumber;
    }

    public void setLinearScanNumber(int linearScanNumber) {
        this.linearScanNumber = linearScanNumber;
    }

    public boolean isAligned() {
        return align;
    }

    public void setAlign(boolean align) {
        this.align = align;
    }

    public abstract boolean isExceptionEntry();

    public abstract Loop<T> getLoop();

    public abstract int getLoopDepth();

    public abstract void delete();

    public abstract boolean isLoopEnd();

    public abstract boolean isLoopHeader();

    public abstract T getPostdominator();

    public abstract double probability();

    public abstract T getDominator(int distance);
}
