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
package org.graalvm.compiler.phases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.graalvm.compiler.nodes.StructuredGraph;

/**
 * A compiler phase that can apply an ordered collection of phases to a graph.
 */
public class PhaseSuite<C> extends BasePhase<C> {

    private List<BasePhase<? super C>> phases;
    private boolean immutable;

    public PhaseSuite() {
        this.phases = new ArrayList<>();
    }

    @Override
    public boolean checkContract() {
        return false;
    }

    public boolean isImmutable() {
        return immutable;
    }

    public synchronized void setImmutable() {
        if (!immutable) {
            phases = Collections.unmodifiableList(phases);
            immutable = true;
        }
    }

    /**
     * Add a new phase at the beginning of this suite.
     */
    public final void prependPhase(BasePhase<? super C> phase) {
        phases.add(0, phase);
    }

    /**
     * Add a new phase at the end of this suite.
     */
    public final void appendPhase(BasePhase<? super C> phase) {
        phases.add(phase);
    }

    /**
     * Returns a {@link ListIterator} at the position of the first phase which is an instance of
     * {@code phaseClass} or null if no such phase can be found.
     *
     * Calling {@link ListIterator#previous()} would return the phase that was found.
     *
     * @param phaseClass the type of phase to look for.
     */
    public final ListIterator<BasePhase<? super C>> findPhase(Class<? extends BasePhase<? super C>> phaseClass) {
        return findPhase(phaseClass, false);
    }

    /**
     * Returns a {@link ListIterator} at the position of the first phase which is an instance of
     * {@code phaseClass} or, if {@code recursive} is true, is a {@link PhaseSuite} containing a
     * phase which is an instance of {@code phaseClass}. This method returns null if no such phase
     * can be found.
     *
     * Calling {@link ListIterator#previous()} would return the phase or phase suite that was found.
     *
     * @param phaseClass the type of phase to look for
     * @param recursive whether to recursively look into phase suites.
     */
    public final ListIterator<BasePhase<? super C>> findPhase(Class<? extends BasePhase<? super C>> phaseClass, boolean recursive) {
        ListIterator<BasePhase<? super C>> it = phases.listIterator();
        if (findNextPhase(it, phaseClass, recursive)) {
            return it;
        } else {
            return null;
        }
    }

    public static <C> boolean findNextPhase(ListIterator<BasePhase<? super C>> it, Class<? extends BasePhase<? super C>> phaseClass) {
        return findNextPhase(it, phaseClass, false);
    }

    public static <C> boolean findNextPhase(ListIterator<BasePhase<? super C>> it, Class<? extends BasePhase<? super C>> phaseClass, boolean recursive) {
        while (it.hasNext()) {
            BasePhase<? super C> phase = it.next();
            if (phaseClass.isInstance(phase)) {
                return true;
            } else if (recursive && phase instanceof PhaseSuite) {
                @SuppressWarnings("unchecked")
                PhaseSuite<C> suite = (PhaseSuite<C>) phase;
                if (suite.findPhase(phaseClass, true) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes the first instance of the given phase class, looking recursively into inner phase
     * suites.
     */
    public boolean removePhase(Class<? extends BasePhase<? super C>> phaseClass) {
        ListIterator<BasePhase<? super C>> it = phases.listIterator();
        while (it.hasNext()) {
            BasePhase<? super C> phase = it.next();
            if (phaseClass.isInstance(phase)) {
                it.remove();
                return true;
            } else if (phase instanceof PhaseSuite) {
                @SuppressWarnings("unchecked")
                PhaseSuite<C> innerSuite = (PhaseSuite<C>) phase;
                if (innerSuite.removePhase(phaseClass)) {
                    if (innerSuite.phases.isEmpty()) {
                        it.remove();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void run(StructuredGraph graph, C context) {
        for (BasePhase<? super C> phase : phases) {
            phase.apply(graph, context);
        }
    }

    public PhaseSuite<C> copy() {
        PhaseSuite<C> suite = new PhaseSuite<>();
        suite.phases.addAll(phases);
        return suite;
    }
}
