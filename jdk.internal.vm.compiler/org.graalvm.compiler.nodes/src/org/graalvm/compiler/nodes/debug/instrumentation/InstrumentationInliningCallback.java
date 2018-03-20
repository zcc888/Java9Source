/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes.debug.instrumentation;

/**
 * Nodes implementing {@code InstrumentationInliningCallback} will be notify of the
 * preInlineInstrumentation event and the postInlineInstrumentation event upon inlining
 * instrumentation.
 */
public interface InstrumentationInliningCallback {

    void preInlineInstrumentation(InstrumentationNode instrumentation);

    void postInlineInstrumentation(InstrumentationNode instrumentation);

}
