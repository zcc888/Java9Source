/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.amd64;

import static org.graalvm.compiler.hotspot.HotSpotBackend.Options.GraalArithmeticStubs;
import static org.graalvm.compiler.hotspot.amd64.AMD64HotSpotForeignCallsProvider.ARITHMETIC_COS_STUB;
import static org.graalvm.compiler.hotspot.amd64.AMD64HotSpotForeignCallsProvider.ARITHMETIC_EXP_STUB;
import static org.graalvm.compiler.hotspot.amd64.AMD64HotSpotForeignCallsProvider.ARITHMETIC_LOG10_STUB;
import static org.graalvm.compiler.hotspot.amd64.AMD64HotSpotForeignCallsProvider.ARITHMETIC_LOG_STUB;
import static org.graalvm.compiler.hotspot.amd64.AMD64HotSpotForeignCallsProvider.ARITHMETIC_SIN_STUB;
import static org.graalvm.compiler.hotspot.amd64.AMD64HotSpotForeignCallsProvider.ARITHMETIC_POW_STUB;
import static org.graalvm.compiler.hotspot.amd64.AMD64HotSpotForeignCallsProvider.ARITHMETIC_TAN_STUB;

import org.graalvm.compiler.core.common.spi.ForeignCallDescriptor;
import org.graalvm.compiler.core.common.spi.ForeignCallsProvider;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.hotspot.HotSpotGraalRuntimeProvider;
import org.graalvm.compiler.hotspot.meta.DefaultHotSpotLoweringProvider;
import org.graalvm.compiler.hotspot.meta.HotSpotProviders;
import org.graalvm.compiler.hotspot.meta.HotSpotRegistersProvider;
import org.graalvm.compiler.hotspot.nodes.profiling.ProfileNode;
import org.graalvm.compiler.hotspot.replacements.profiling.ProbabilisticProfileSnippets;
import org.graalvm.compiler.nodes.calc.FloatConvertNode;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.replacements.amd64.AMD64ConvertSnippets;
import org.graalvm.compiler.replacements.nodes.BinaryMathIntrinsicNode.BinaryOperation;
import org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode.UnaryOperation;

import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.hotspot.HotSpotConstantReflectionProvider;
import jdk.vm.ci.meta.MetaAccessProvider;

public class AMD64HotSpotLoweringProvider extends DefaultHotSpotLoweringProvider {

    private AMD64ConvertSnippets.Templates convertSnippets;
    private ProbabilisticProfileSnippets.Templates profileSnippets;

    public AMD64HotSpotLoweringProvider(HotSpotGraalRuntimeProvider runtime, MetaAccessProvider metaAccess, ForeignCallsProvider foreignCalls, HotSpotRegistersProvider registers,
                    HotSpotConstantReflectionProvider constantReflection, TargetDescription target) {
        super(runtime, metaAccess, foreignCalls, registers, constantReflection, target);
    }

    @Override
    public void initialize(HotSpotProviders providers, GraalHotSpotVMConfig config) {
        convertSnippets = new AMD64ConvertSnippets.Templates(providers, providers.getSnippetReflection(), providers.getCodeCache().getTarget());
        profileSnippets = ProfileNode.Options.ProbabilisticProfiling.getValue() ? new ProbabilisticProfileSnippets.Templates(providers, providers.getCodeCache().getTarget()) : null;
        super.initialize(providers, config);
    }

    @Override
    public void lower(Node n, LoweringTool tool) {
        if (n instanceof FloatConvertNode) {
            convertSnippets.lower((FloatConvertNode) n, tool);
        } else if (profileSnippets != null && n instanceof ProfileNode) {
            profileSnippets.lower((ProfileNode) n, tool);
        } else {
            super.lower(n, tool);
        }
    }

    @Override
    protected ForeignCallDescriptor toForeignCall(UnaryOperation operation) {
        if (GraalArithmeticStubs.getValue()) {
            switch (operation) {
                case LOG:
                    return ARITHMETIC_LOG_STUB;
                case LOG10:
                    return ARITHMETIC_LOG10_STUB;
                case SIN:
                    return ARITHMETIC_SIN_STUB;
                case COS:
                    return ARITHMETIC_COS_STUB;
                case TAN:
                    return ARITHMETIC_TAN_STUB;
                case EXP:
                    return ARITHMETIC_EXP_STUB;
            }
        } else if (operation == UnaryOperation.EXP) {
            return operation.foreignCallDescriptor;
        }
        // Lower only using LIRGenerator
        return null;
    }

    @Override
    protected ForeignCallDescriptor toForeignCall(BinaryOperation operation) {
        if (GraalArithmeticStubs.getValue()) {
            switch (operation) {
                case POW:
                    return ARITHMETIC_POW_STUB;
            }
        } else if (operation == BinaryOperation.POW) {
            return operation.foreignCallDescriptor;
        }
        // Lower only using LIRGenerator
        return null;
    }

    @Override
    public boolean supportSubwordCompare(int bits) {
        return true;
    }
}
