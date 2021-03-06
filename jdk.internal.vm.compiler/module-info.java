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
 *
 *
 */

module jdk.internal.vm.compiler {
    // source file: file:///scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/hotspot/src/jdk.internal.vm.compiler/share/classes/module-info.java
    //              file:///scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/build/linux-x64/support/gensrc/jdk.internal.vm.compiler/module-info.java.extra
    requires java.instrument;
    requires java.management;
    requires jdk.internal.vm.ci;
    requires jdk.management;
    requires jdk.unsupported;   // sun.misc.Unsafe is used
    exports org.graalvm.compiler.api.directives to jdk.aot;
    exports org.graalvm.compiler.api.replacements to jdk.aot;
    exports org.graalvm.compiler.api.runtime to jdk.aot;
    exports org.graalvm.compiler.asm.amd64 to jdk.aot;
    exports org.graalvm.compiler.bytecode to jdk.aot;
    exports org.graalvm.compiler.code to jdk.aot;
    exports org.graalvm.compiler.core to jdk.aot;
    exports org.graalvm.compiler.core.common to jdk.aot;
    exports org.graalvm.compiler.core.target to jdk.aot;
    exports org.graalvm.compiler.debug to jdk.aot;
    exports org.graalvm.compiler.debug.internal to jdk.aot;
    exports org.graalvm.compiler.graph to jdk.aot;
    exports org.graalvm.compiler.hotspot to jdk.aot;
    exports org.graalvm.compiler.hotspot.meta to jdk.aot;
    exports org.graalvm.compiler.hotspot.replacements to jdk.aot;
    exports org.graalvm.compiler.hotspot.stubs to jdk.aot;
    exports org.graalvm.compiler.hotspot.word to jdk.aot;
    exports org.graalvm.compiler.java to jdk.aot;
    exports org.graalvm.compiler.lir.asm to jdk.aot;
    exports org.graalvm.compiler.lir.phases to jdk.aot;
    exports org.graalvm.compiler.nodes to jdk.aot;
    exports org.graalvm.compiler.nodes.graphbuilderconf to jdk.aot;
    exports org.graalvm.compiler.options to jdk.aot;
    exports org.graalvm.compiler.phases to jdk.aot;
    exports org.graalvm.compiler.phases.tiers to jdk.aot;
    exports org.graalvm.compiler.replacements to jdk.aot;
    exports org.graalvm.compiler.runtime to jdk.aot;
    exports org.graalvm.compiler.word to jdk.aot;

    uses org.graalvm.compiler.code.DisassemblerProvider;
    uses org.graalvm.compiler.core.match.MatchStatementSet;
    uses org.graalvm.compiler.debug.DebugConfigCustomizer;
    uses org.graalvm.compiler.debug.DebugInitializationParticipant;
    uses org.graalvm.compiler.debug.TTYStreamProvider;
    uses org.graalvm.compiler.hotspot.CompilerConfigurationFactory;
    uses org.graalvm.compiler.hotspot.HotSpotBackendFactory;
    uses org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;
    uses org.graalvm.compiler.options.OptionDescriptors;
    provides jdk.vm.ci.services.JVMCIServiceLocator with org.graalvm.compiler.hotspot.HotSpotGraalJVMCIServiceLocator;
    provides org.graalvm.compiler.code.DisassemblerProvider with
        org.graalvm.compiler.code.HexCodeFileDisassemblerProvider,
        org.graalvm.compiler.hotspot.meta.HotSpotDisassemblerProvider;
    provides org.graalvm.compiler.core.match.MatchStatementSet with
        org.graalvm.compiler.core.amd64.AMD64NodeMatchRules_MatchStatementSet,
        org.graalvm.compiler.core.sparc.SPARCNodeMatchRules_MatchStatementSet;
    provides org.graalvm.compiler.debug.DebugConfigCustomizer with org.graalvm.compiler.printer.GraalDebugConfigCustomizer;
    provides org.graalvm.compiler.debug.DebugInitializationParticipant with org.graalvm.compiler.core.GraalDebugInitializationParticipant;
    provides org.graalvm.compiler.debug.TTYStreamProvider with org.graalvm.compiler.hotspot.HotSpotTTYStreamProvider;
    provides org.graalvm.compiler.hotspot.CompilerConfigurationFactory with
        org.graalvm.compiler.hotspot.CoreCompilerConfigurationFactory,
        org.graalvm.compiler.hotspot.EconomyCompilerConfigurationFactory;
    provides org.graalvm.compiler.hotspot.HotSpotBackendFactory with
        org.graalvm.compiler.hotspot.aarch64.AArch64HotSpotBackendFactory,
        org.graalvm.compiler.hotspot.amd64.AMD64HotSpotBackendFactory,
        org.graalvm.compiler.hotspot.sparc.SPARCHotSpotBackendFactory;
    provides org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory with
        org.graalvm.compiler.hotspot.PluginFactory_HotSpotBackend,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_AcquiredCASLockNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_AllocaNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_BeginLockScopeNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_CompressionNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_ComputeObjectAddressNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_CurrentJavaThreadNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_CurrentLockNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_DeoptimizationFetchUnrollInfoCallNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_DeoptimizeCallerNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_DimensionsNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_DirectCompareAndSwapNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_EndLockScopeNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_EnterUnpackFramesStackFrameNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_FastAcquireBiasedLockNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_GetObjectAddressNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_GraalHotSpotVMConfigNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_JumpToExceptionHandlerInCallerNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_JumpToExceptionHandlerNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_LeaveCurrentStackFrameNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_LeaveDeoptimizedStackFrameNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_LeaveUnpackFramesStackFrameNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_MonitorCounterNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_PatchReturnAddressNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_PushInterpreterFrameNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_SaveAllRegistersNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_SnippetAnchorNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_SnippetLocationProxyNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_UncommonTrapCallNode,
        org.graalvm.compiler.hotspot.nodes.PluginFactory_VMErrorNode,
        org.graalvm.compiler.hotspot.nodes.aot.PluginFactory_EncodedSymbolNode,
        org.graalvm.compiler.hotspot.nodes.aot.PluginFactory_InitializeKlassStubCall,
        org.graalvm.compiler.hotspot.nodes.aot.PluginFactory_LoadConstantIndirectlyFixedNode,
        org.graalvm.compiler.hotspot.nodes.aot.PluginFactory_LoadConstantIndirectlyNode,
        org.graalvm.compiler.hotspot.nodes.aot.PluginFactory_LoadMethodCountersIndirectlyNode,
        org.graalvm.compiler.hotspot.nodes.aot.PluginFactory_ResolveConstantStubCall,
        org.graalvm.compiler.hotspot.nodes.aot.PluginFactory_ResolveMethodAndLoadCountersStubCall,
        org.graalvm.compiler.hotspot.replacements.PluginFactory_AESCryptSubstitutions,
        org.graalvm.compiler.hotspot.replacements.PluginFactory_AssertionSnippets,
        org.graalvm.compiler.hotspot.replacements.PluginFactory_CRC32Substitutions,
        org.graalvm.compiler.hotspot.replacements.PluginFactory_CipherBlockChainingSubstitutions,
        org.graalvm.compiler.hotspot.replacements.PluginFactory_ClassGetHubNode,
        org.graalvm.compiler.hotspot.replacements.PluginFactory_HotSpotReplacementsUtil,
        org.graalvm.compiler.hotspot.replacements.PluginFactory_HubGetClassNode,
        org.graalvm.compiler.hotspot.replacements.PluginFactory_IdentityHashCodeNode,
        org.graalvm.compiler.hotspot.replacements.PluginFactory_MonitorSnippets,
        org.graalvm.compiler.hotspot.replacements.PluginFactory_NewObjectSnippets,
        org.graalvm.compiler.hotspot.replacements.PluginFactory_StringToBytesSnippets,
        org.graalvm.compiler.hotspot.replacements.PluginFactory_ThreadSubstitutions,
        org.graalvm.compiler.hotspot.replacements.PluginFactory_WriteBarrierSnippets,
        org.graalvm.compiler.hotspot.replacements.arraycopy.PluginFactory_ArrayCopyCallNode,
        org.graalvm.compiler.hotspot.replacements.arraycopy.PluginFactory_ArrayCopySlowPathNode,
        org.graalvm.compiler.hotspot.replacements.arraycopy.PluginFactory_ArrayCopySnippets,
        org.graalvm.compiler.hotspot.replacements.arraycopy.PluginFactory_ArrayCopyUnrollNode,
        org.graalvm.compiler.hotspot.replacements.arraycopy.PluginFactory_CheckcastArrayCopyCallNode,
        org.graalvm.compiler.hotspot.replacements.arraycopy.PluginFactory_UnsafeArrayCopyNode,
        org.graalvm.compiler.hotspot.replacements.arraycopy.PluginFactory_UnsafeArrayCopySnippets,
        org.graalvm.compiler.hotspot.replacements.profiling.PluginFactory_ProbabilisticProfileSnippets,
        org.graalvm.compiler.hotspot.replacements.profiling.PluginFactory_ProfileSnippets,
        org.graalvm.compiler.hotspot.stubs.PluginFactory_CreateExceptionStub,
        org.graalvm.compiler.hotspot.stubs.PluginFactory_DeoptimizationStub,
        org.graalvm.compiler.hotspot.stubs.PluginFactory_ExceptionHandlerStub,
        org.graalvm.compiler.hotspot.stubs.PluginFactory_NewArrayStub,
        org.graalvm.compiler.hotspot.stubs.PluginFactory_NewInstanceStub,
        org.graalvm.compiler.hotspot.stubs.PluginFactory_StubUtil,
        org.graalvm.compiler.hotspot.stubs.PluginFactory_UncommonTrapStub,
        org.graalvm.compiler.hotspot.stubs.PluginFactory_UnwindExceptionToCallerStub,
        org.graalvm.compiler.nodes.PluginFactory_BreakpointNode,
        org.graalvm.compiler.nodes.PluginFactory_DeoptimizeNode,
        org.graalvm.compiler.nodes.PluginFactory_PauseNode,
        org.graalvm.compiler.nodes.PluginFactory_PiArrayNode,
        org.graalvm.compiler.nodes.PluginFactory_PiNode,
        org.graalvm.compiler.nodes.PluginFactory_PrefetchAllocateNode,
        org.graalvm.compiler.nodes.calc.PluginFactory_IsNullNode,
        org.graalvm.compiler.nodes.calc.PluginFactory_ReinterpretNode,
        org.graalvm.compiler.nodes.calc.PluginFactory_UnsignedDivNode,
        org.graalvm.compiler.nodes.calc.PluginFactory_UnsignedRemNode,
        org.graalvm.compiler.nodes.debug.PluginFactory_DynamicCounterNode,
        org.graalvm.compiler.nodes.extended.PluginFactory_BranchProbabilityNode,
        org.graalvm.compiler.nodes.extended.PluginFactory_FixedValueAnchorNode,
        org.graalvm.compiler.nodes.extended.PluginFactory_MembarNode,
        org.graalvm.compiler.nodes.extended.PluginFactory_NullCheckNode,
        org.graalvm.compiler.nodes.extended.PluginFactory_StoreHubNode,
        org.graalvm.compiler.nodes.extended.PluginFactory_UnsafeCopyNode,
        org.graalvm.compiler.nodes.extended.PluginFactory_UnsafeLoadNode,
        org.graalvm.compiler.nodes.java.PluginFactory_ArrayLengthNode,
        org.graalvm.compiler.nodes.java.PluginFactory_DynamicNewArrayNode,
        org.graalvm.compiler.nodes.java.PluginFactory_NewArrayNode,
        org.graalvm.compiler.nodes.java.PluginFactory_RegisterFinalizerNode,
        org.graalvm.compiler.nodes.memory.PluginFactory_MemoryAnchorNode,
        org.graalvm.compiler.nodes.memory.PluginFactory_WriteNode,
        org.graalvm.compiler.nodes.memory.address.PluginFactory_OffsetAddressNode,
        org.graalvm.compiler.nodes.memory.address.PluginFactory_RawAddressNode,
        org.graalvm.compiler.replacements.PluginFactory_Log,
        org.graalvm.compiler.replacements.PluginFactory_SnippetCounterNode,
        org.graalvm.compiler.replacements.aarch64.PluginFactory_AArch64FloatArithmeticSnippets,
        org.graalvm.compiler.replacements.aarch64.PluginFactory_AArch64IntegerArithmeticSnippets,
        org.graalvm.compiler.replacements.amd64.PluginFactory_AMD64MathSubstitutions,
        org.graalvm.compiler.replacements.nodes.PluginFactory_ArrayEqualsNode,
        org.graalvm.compiler.replacements.nodes.PluginFactory_AssertionNode,
        org.graalvm.compiler.replacements.nodes.PluginFactory_BinaryMathIntrinsicNode,
        org.graalvm.compiler.replacements.nodes.PluginFactory_BitScanForwardNode,
        org.graalvm.compiler.replacements.nodes.PluginFactory_BitScanReverseNode,
        org.graalvm.compiler.replacements.nodes.PluginFactory_CStringConstant,
        org.graalvm.compiler.replacements.nodes.PluginFactory_DirectObjectStoreNode,
        org.graalvm.compiler.replacements.nodes.PluginFactory_DirectStoreNode,
        org.graalvm.compiler.replacements.nodes.PluginFactory_ExplodeLoopNode,
        org.graalvm.compiler.replacements.nodes.PluginFactory_UnaryMathIntrinsicNode;
    provides org.graalvm.compiler.options.OptionDescriptors with
        org.graalvm.compiler.hotspot.HotSpotTTYStreamProvider_OptionDescriptors,
        org.graalvm.compiler.hotspot.BootstrapWatchDog_OptionDescriptors,
        org.graalvm.compiler.hotspot.HotSpotBackend_OptionDescriptors,
        org.graalvm.compiler.hotspot.CompilationCounters_OptionDescriptors,
        org.graalvm.compiler.hotspot.stubs.StubOptions_OptionDescriptors,
        org.graalvm.compiler.hotspot.phases.aot.AOTInliningPolicy_OptionDescriptors,
        org.graalvm.compiler.hotspot.phases.profiling.FinalizeProfileNodesPhase_OptionDescriptors,
        org.graalvm.compiler.hotspot.HotSpotGraalCompilerFactory_OptionDescriptors,
        org.graalvm.compiler.hotspot.CompilationStatistics_OptionDescriptors,
        org.graalvm.compiler.hotspot.CompilerConfigurationFactory_OptionDescriptors,
        org.graalvm.compiler.hotspot.debug.BenchmarkCounters_OptionDescriptors,
        org.graalvm.compiler.hotspot.CompileTheWorldOptions_OptionDescriptors,
        org.graalvm.compiler.hotspot.meta.HotSpotProfilingPlugin_OptionDescriptors,
        org.graalvm.compiler.hotspot.meta.HotSpotAOTProfilingPlugin_OptionDescriptors,
        org.graalvm.compiler.hotspot.nodes.profiling.ProfileNode_OptionDescriptors,
        org.graalvm.compiler.hotspot.replacements.HotspotSnippetsOptions_OptionDescriptors,
        org.graalvm.compiler.hotspot.CompilationWatchDog_OptionDescriptors,
        org.graalvm.compiler.loop.DefaultLoopPolicies_OptionDescriptors,
        org.graalvm.compiler.lir.alloc.lsra.LinearScan_OptionDescriptors,
        org.graalvm.compiler.lir.alloc.lsra.OptimizingLinearScanWalker_OptionDescriptors,
        org.graalvm.compiler.lir.alloc.lsra.LinearScanEliminateSpillMovePhase_OptionDescriptors,
        org.graalvm.compiler.lir.alloc.trace.lsra.TraceLinearScanPhase_OptionDescriptors,
        org.graalvm.compiler.lir.alloc.trace.DefaultTraceRegisterAllocationPolicy_OptionDescriptors,
        org.graalvm.compiler.lir.alloc.trace.TraceRegisterAllocationPhase_OptionDescriptors,
        org.graalvm.compiler.lir.alloc.trace.TraceBuilderPhase_OptionDescriptors,
        org.graalvm.compiler.lir.phases.LIRPhase_OptionDescriptors,
        org.graalvm.compiler.lir.phases.PostAllocationOptimizationStage_OptionDescriptors,
        org.graalvm.compiler.lir.asm.CompilationResultBuilder_OptionDescriptors,
        org.graalvm.compiler.lir.BailoutAndRestartBackendException_OptionDescriptors,
        org.graalvm.compiler.lir.stackslotalloc.LSStackSlotAllocator_OptionDescriptors,
        org.graalvm.compiler.lir.constopt.ConstantLoadOptimization_OptionDescriptors,
        org.graalvm.compiler.lir.amd64.phases.StackMoveOptimizationPhase_OptionDescriptors,
        org.graalvm.compiler.lir.profiling.MoveProfilingPhase_OptionDescriptors,
        org.graalvm.compiler.lir.gen.LIRGenerator_OptionDescriptors,
        org.graalvm.compiler.lir.ssi.SSIConstructionPhase_OptionDescriptors,
        org.graalvm.compiler.printer.NoDeadCodeVerifyHandler_OptionDescriptors,
        org.graalvm.compiler.phases.BasePhase_OptionDescriptors,
        org.graalvm.compiler.phases.common.DeadCodeEliminationPhase_OptionDescriptors,
        org.graalvm.compiler.phases.common.inlining.InliningPhase_OptionDescriptors,
        org.graalvm.compiler.core.phases.HighTier_OptionDescriptors,
        org.graalvm.compiler.core.phases.LowTier_OptionDescriptors,
        org.graalvm.compiler.core.GraalCompilerOptions_OptionDescriptors,
        org.graalvm.compiler.core.common.util.CompilationAlarm_OptionDescriptors,
        org.graalvm.compiler.core.common.GraalOptions_OptionDescriptors,
        org.graalvm.compiler.core.common.spi.JavaConstantFieldProvider_OptionDescriptors,
        org.graalvm.compiler.java.BytecodeParserOptions_OptionDescriptors,
        org.graalvm.compiler.debug.GraalDebugConfig_OptionDescriptors,
        org.graalvm.compiler.debug.Fingerprint_OptionDescriptors,
        org.graalvm.compiler.debug.internal.method.MethodMetricsPrinter_OptionDescriptors,
        org.graalvm.compiler.graph.Graph_OptionDescriptors,
        org.graalvm.compiler.graph.NodeClass_OptionDescriptors,
        org.graalvm.compiler.virtual.phases.ea.PartialEscapePhase_OptionDescriptors,
        org.graalvm.compiler.nodes.util.GraphUtil_OptionDescriptors,
        org.graalvm.compiler.replacements.SnippetTemplate_OptionDescriptors,
        org.graalvm.compiler.replacements.PEGraphDecoder_OptionDescriptors;
}
