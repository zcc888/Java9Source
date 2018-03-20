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
package org.graalvm.compiler.nodes.spi;

import org.graalvm.compiler.api.replacements.MethodSubstitution;
import org.graalvm.compiler.api.replacements.SnippetTemplateCache;
import org.graalvm.compiler.bytecode.BytecodeProvider;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;

import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Interface for managing replacements.
 */
public interface Replacements {

    /**
     * Gets the snippet graph derived from a given method.
     *
     * @param args arguments to the snippet if available, otherwise {@code null}
     * @return the snippet graph, if any, that is derived from {@code method}
     */
    StructuredGraph getSnippet(ResolvedJavaMethod method, Object[] args);

    /**
     * Gets the snippet graph derived from a given method.
     *
     * @param recursiveEntry if the snippet contains a call to this method, it's considered as
     *            recursive call and won't be processed for {@linkplain MethodSubstitution
     *            substitutions}.
     * @param args arguments to the snippet if available, otherwise {@code null}
     * @return the snippet graph, if any, that is derived from {@code method}
     */
    StructuredGraph getSnippet(ResolvedJavaMethod method, ResolvedJavaMethod recursiveEntry, Object[] args);

    /**
     * Registers a method as snippet.
     */
    void registerSnippet(ResolvedJavaMethod method);

    /**
     * Gets a graph that is a substitution for a given method.
     *
     * @param invokeBci the call site BCI if this request is made for inlining a substitute
     *            otherwise {@code -1}
     * @return the graph, if any, that is a substitution for {@code method}
     */
    StructuredGraph getSubstitution(ResolvedJavaMethod method, int invokeBci);

    /**
     * Gets a method that is a substitution for a given method.
     *
     * @return the method, if any, whose bytecode are a substitution for {@code method}
     */
    ResolvedJavaMethod getSubstitutionMethod(ResolvedJavaMethod method);

    /**
     * Determines if there may be a {@linkplain #getSubstitution(ResolvedJavaMethod, int)
     * substitution graph} for a given method.
     *
     * A call to {@link #getSubstitution} may still return {@code null} for {@code method} and
     * {@code invokeBci}. A substitution may be based on an {@link InvocationPlugin} that returns
     * {@code false} for {@link InvocationPlugin#execute} making it impossible to create a
     * substitute graph.
     *
     * @param invokeBci the call site BCI if this request is made for inlining a substitute
     *            otherwise {@code -1}
     * @return true iff there may be a substitution graph available for {@code method}
     */
    boolean hasSubstitution(ResolvedJavaMethod method, int invokeBci);

    /**
     * Gets the provider for accessing the bytecode of a substitution method.
     */
    BytecodeProvider getReplacementBytecodeProvider();

    /**
     * Register snippet templates.
     */
    void registerSnippetTemplateCache(SnippetTemplateCache snippetTemplates);

    /**
     * Get snippet templates that were registered with
     * {@link Replacements#registerSnippetTemplateCache(SnippetTemplateCache)}.
     */
    <T extends SnippetTemplateCache> T getSnippetTemplateCache(Class<T> templatesClass);
}
