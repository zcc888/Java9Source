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
package org.graalvm.compiler.nodes.graphbuilderconf;

import org.graalvm.compiler.core.common.type.Stamp;

public interface NodeIntrinsicPluginFactory {

    public interface InjectionProvider {

        <T> T getInjectedArgument(Class<T> type);

        Stamp getReturnStamp(Class<?> type, boolean nonNull);
    }

    void registerPlugins(InvocationPlugins plugins, InjectionProvider injection);
}
