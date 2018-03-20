/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.replacements.test;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.UnwindNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.extended.BytecodeExceptionNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;

public abstract class BytecodeExceptionTest extends GraalCompilerTest {

    protected boolean throwBytecodeException(GraphBuilderContext b, Class<? extends Throwable> exception, ValueNode... arguments) {
        BytecodeExceptionNode exceptionNode = b.add(new BytecodeExceptionNode(b.getMetaAccess(), exception, arguments));
        b.add(new UnwindNode(exceptionNode));
        return true;
    }

    protected abstract void registerPlugin(InvocationPlugins plugins);

    @Override
    protected GraphBuilderConfiguration editGraphBuilderConfiguration(GraphBuilderConfiguration conf) {
        GraphBuilderConfiguration ret = super.editGraphBuilderConfiguration(conf);
        registerPlugin(ret.getPlugins().getInvocationPlugins());
        return ret;
    }
}
