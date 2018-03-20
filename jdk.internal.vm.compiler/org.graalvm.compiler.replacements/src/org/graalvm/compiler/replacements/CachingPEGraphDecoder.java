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
package org.graalvm.compiler.replacements;

import static org.graalvm.compiler.core.common.CompilationIdentifier.INVALID_COMPILATION_ID;
import static org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext.CompilationContext.INLINE_AFTER_PARSING;

import java.util.HashMap;
import java.util.Map;

import org.graalvm.compiler.bytecode.BytecodeProvider;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.java.GraphBuilderPhase;
import org.graalvm.compiler.nodes.EncodedGraph;
import org.graalvm.compiler.nodes.GraphEncoder;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration;
import org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext;
import org.graalvm.compiler.phases.OptimisticOptimizations;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.common.ConvertDeoptimizeToGuardPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;
import org.graalvm.compiler.phases.util.Providers;

import jdk.vm.ci.code.Architecture;
import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * A graph decoder that provides all necessary encoded graphs on-the-fly (by parsing the methods and
 * encoding the graphs).
 */
public class CachingPEGraphDecoder extends PEGraphDecoder {

    protected final Providers providers;
    protected final GraphBuilderConfiguration graphBuilderConfig;
    protected final OptimisticOptimizations optimisticOpts;
    private final AllowAssumptions allowAssumptions;
    private final Map<ResolvedJavaMethod, EncodedGraph> graphCache;

    public CachingPEGraphDecoder(Providers providers, GraphBuilderConfiguration graphBuilderConfig, OptimisticOptimizations optimisticOpts, AllowAssumptions allowAssumptions,
                    Architecture architecture) {
        super(providers.getMetaAccess(), providers.getConstantReflection(), providers.getConstantFieldProvider(), providers.getStampProvider(), architecture);

        this.providers = providers;
        this.graphBuilderConfig = graphBuilderConfig;
        this.optimisticOpts = optimisticOpts;
        this.allowAssumptions = allowAssumptions;
        this.graphCache = new HashMap<>();
    }

    protected GraphBuilderPhase.Instance createGraphBuilderPhaseInstance(IntrinsicContext initialIntrinsicContext) {
        return new GraphBuilderPhase.Instance(providers.getMetaAccess(), providers.getStampProvider(), providers.getConstantReflection(), providers.getConstantFieldProvider(), graphBuilderConfig,
                        optimisticOpts, initialIntrinsicContext);
    }

    @SuppressWarnings("try")
    private EncodedGraph createGraph(ResolvedJavaMethod method, BytecodeProvider intrinsicBytecodeProvider) {
        StructuredGraph graph = new StructuredGraph(method, allowAssumptions, INVALID_COMPILATION_ID);
        try (Debug.Scope scope = Debug.scope("createGraph", graph)) {
            IntrinsicContext initialIntrinsicContext = intrinsicBytecodeProvider != null ? new IntrinsicContext(method, method, intrinsicBytecodeProvider, INLINE_AFTER_PARSING) : null;
            GraphBuilderPhase.Instance graphBuilderPhaseInstance = createGraphBuilderPhaseInstance(initialIntrinsicContext);
            graphBuilderPhaseInstance.apply(graph);

            PhaseContext context = new PhaseContext(providers);
            new CanonicalizerPhase().apply(graph, context);
            /*
             * ConvertDeoptimizeToGuardPhase reduces the number of merges in the graph, so that
             * fewer frame states will be created. This significantly reduces the number of nodes in
             * the initial graph.
             */
            new ConvertDeoptimizeToGuardPhase().apply(graph, context);

            EncodedGraph encodedGraph = GraphEncoder.encodeSingleGraph(graph, architecture);
            graphCache.put(method, encodedGraph);
            return encodedGraph;

        } catch (Throwable ex) {
            throw Debug.handle(ex);
        }
    }

    @Override
    protected EncodedGraph lookupEncodedGraph(ResolvedJavaMethod method, BytecodeProvider intrinsicBytecodeProvider) {
        EncodedGraph result = graphCache.get(method);
        if (result == null && method.hasBytecodes()) {
            result = createGraph(method, intrinsicBytecodeProvider);
        }
        return result;
    }
}
