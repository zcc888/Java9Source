/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.debug;

import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * A factory for creating {@link DebugCounter}s, {@link DebugTimer}s, {@link DebugMemUseTracker}s
 * and {@link DebugMethodMetrics}.
 */
public interface DebugValueFactory {

    DebugCounter createCounter(String name, boolean conditional);

    DebugTimer createTimer(String name, boolean conditional);

    DebugMemUseTracker createMemUseTracker(String name, boolean conditional);

    DebugMethodMetrics createMethodMetrics(ResolvedJavaMethod method);
}
