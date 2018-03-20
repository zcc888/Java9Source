// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: GraalOptions.java
package org.graalvm.compiler.core.common;

import java.util.*;
import org.graalvm.compiler.options.*;

public class GraalOptions_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "AlwaysInlineVTableStubs": return OptionDescriptor.create("AlwaysInlineVTableStubs", Boolean.class, "", GraalOptions.class, "AlwaysInlineVTableStubs", GraalOptions.AlwaysInlineVTableStubs);
            case "CallArrayCopy": return OptionDescriptor.create("CallArrayCopy", Boolean.class, "", GraalOptions.class, "CallArrayCopy", GraalOptions.CallArrayCopy);
            case "CanOmitFrame": return OptionDescriptor.create("CanOmitFrame", Boolean.class, "", GraalOptions.class, "CanOmitFrame", GraalOptions.CanOmitFrame);
            case "ConditionalElimination": return OptionDescriptor.create("ConditionalElimination", Boolean.class, "", GraalOptions.class, "ConditionalElimination", GraalOptions.ConditionalElimination);
            case "DeoptALot": return OptionDescriptor.create("DeoptALot", Boolean.class, "", GraalOptions.class, "DeoptALot", GraalOptions.DeoptALot);
            case "DeoptsToDisableOptimisticOptimization": return OptionDescriptor.create("DeoptsToDisableOptimisticOptimization", Integer.class, "", GraalOptions.class, "DeoptsToDisableOptimisticOptimization", GraalOptions.DeoptsToDisableOptimisticOptimization);
            case "DetailedAsserts": return OptionDescriptor.create("DetailedAsserts", Boolean.class, "Enable expensive assertions", GraalOptions.class, "DetailedAsserts", GraalOptions.DetailedAsserts);
            case "EagerSnippets": return OptionDescriptor.create("EagerSnippets", Boolean.class, "Eagerly construct extra snippet info.", GraalOptions.class, "EagerSnippets", GraalOptions.EagerSnippets);
            case "EscapeAnalysisIterations": return OptionDescriptor.create("EscapeAnalysisIterations", Integer.class, "", GraalOptions.class, "EscapeAnalysisIterations", GraalOptions.EscapeAnalysisIterations);
            case "EscapeAnalysisLoopCutoff": return OptionDescriptor.create("EscapeAnalysisLoopCutoff", Integer.class, "", GraalOptions.class, "EscapeAnalysisLoopCutoff", GraalOptions.EscapeAnalysisLoopCutoff);
            case "EscapeAnalyzeOnly": return OptionDescriptor.create("EscapeAnalyzeOnly", String.class, "", GraalOptions.class, "EscapeAnalyzeOnly", GraalOptions.EscapeAnalyzeOnly);
            case "FullUnroll": return OptionDescriptor.create("FullUnroll", Boolean.class, "", GraalOptions.class, "FullUnroll", GraalOptions.FullUnroll);
            case "GCDebugStartCycle": return OptionDescriptor.create("GCDebugStartCycle", Integer.class, "", GraalOptions.class, "GCDebugStartCycle", GraalOptions.GCDebugStartCycle);
            case "GenLoopSafepoints": return OptionDescriptor.create("GenLoopSafepoints", Boolean.class, "", GraalOptions.class, "GenLoopSafepoints", GraalOptions.GenLoopSafepoints);
            case "GenSafepoints": return OptionDescriptor.create("GenSafepoints", Boolean.class, "", GraalOptions.class, "GenSafepoints", GraalOptions.GenSafepoints);
            case "GeneratePIC": return OptionDescriptor.create("GeneratePIC", Boolean.class, "Generate position independent code", GraalOptions.class, "GeneratePIC", GraalOptions.GeneratePIC);
            case "HotSpotPrintInlining": return OptionDescriptor.create("HotSpotPrintInlining", Boolean.class, "Print inlining optimizations", GraalOptions.class, "HotSpotPrintInlining", GraalOptions.HotSpotPrintInlining);
            case "ImmutableCode": return OptionDescriptor.create("ImmutableCode", Boolean.class, "Try to avoid emitting code where patching is required", GraalOptions.class, "ImmutableCode", GraalOptions.ImmutableCode);
            case "InlineEverything": return OptionDescriptor.create("InlineEverything", Boolean.class, "", GraalOptions.class, "InlineEverything", GraalOptions.InlineEverything);
            case "InlineMegamorphicCalls": return OptionDescriptor.create("InlineMegamorphicCalls", Boolean.class, "Inline calls with megamorphic type profile (i.e., not all types could be recorded).", GraalOptions.class, "InlineMegamorphicCalls", GraalOptions.InlineMegamorphicCalls);
            case "InlineMonomorphicCalls": return OptionDescriptor.create("InlineMonomorphicCalls", Boolean.class, "Inline calls with monomorphic type profile.", GraalOptions.class, "InlineMonomorphicCalls", GraalOptions.InlineMonomorphicCalls);
            case "InlinePolymorphicCalls": return OptionDescriptor.create("InlinePolymorphicCalls", Boolean.class, "Inline calls with polymorphic type profile.", GraalOptions.class, "InlinePolymorphicCalls", GraalOptions.InlinePolymorphicCalls);
            case "InlineVTableStubs": return OptionDescriptor.create("InlineVTableStubs", Boolean.class, "", GraalOptions.class, "InlineVTableStubs", GraalOptions.InlineVTableStubs);
            case "Intrinsify": return OptionDescriptor.create("Intrinsify", Boolean.class, "Use compiler intrinsifications.", GraalOptions.class, "Intrinsify", GraalOptions.Intrinsify);
            case "LimitInlinedInvokes": return OptionDescriptor.create("LimitInlinedInvokes", Double.class, "", GraalOptions.class, "LimitInlinedInvokes", GraalOptions.LimitInlinedInvokes);
            case "LoopMaxUnswitch": return OptionDescriptor.create("LoopMaxUnswitch", Integer.class, "", GraalOptions.class, "LoopMaxUnswitch", GraalOptions.LoopMaxUnswitch);
            case "LoopPeeling": return OptionDescriptor.create("LoopPeeling", Boolean.class, "", GraalOptions.class, "LoopPeeling", GraalOptions.LoopPeeling);
            case "LoopUnswitch": return OptionDescriptor.create("LoopUnswitch", Boolean.class, "", GraalOptions.class, "LoopUnswitch", GraalOptions.LoopUnswitch);
            case "MatchExpressions": return OptionDescriptor.create("MatchExpressions", Boolean.class, "Allow backend to match complex expressions.", GraalOptions.class, "MatchExpressions", GraalOptions.MatchExpressions);
            case "MaximumDesiredSize": return OptionDescriptor.create("MaximumDesiredSize", Integer.class, "Maximum desired size of the compiler graph in nodes.", GraalOptions.class, "MaximumDesiredSize", GraalOptions.MaximumDesiredSize);
            case "MaximumEscapeAnalysisArrayLength": return OptionDescriptor.create("MaximumEscapeAnalysisArrayLength", Integer.class, "", GraalOptions.class, "MaximumEscapeAnalysisArrayLength", GraalOptions.MaximumEscapeAnalysisArrayLength);
            case "MaximumInliningSize": return OptionDescriptor.create("MaximumInliningSize", Integer.class, "Inlining is explored up to this number of nodes in the graph for each call site.", GraalOptions.class, "MaximumInliningSize", GraalOptions.MaximumInliningSize);
            case "MaximumRecursiveInlining": return OptionDescriptor.create("MaximumRecursiveInlining", Integer.class, "Maximum level of recursive inlining.", GraalOptions.class, "MaximumRecursiveInlining", GraalOptions.MaximumRecursiveInlining);
            case "MegamorphicInliningMinMethodProbability": return OptionDescriptor.create("MegamorphicInliningMinMethodProbability", Double.class, "Minimum probability for methods to be inlined for megamorphic type profiles.", GraalOptions.class, "MegamorphicInliningMinMethodProbability", GraalOptions.MegamorphicInliningMinMethodProbability);
            case "MinimumPeelProbability": return OptionDescriptor.create("MinimumPeelProbability", Float.class, "", GraalOptions.class, "MinimumPeelProbability", GraalOptions.MinimumPeelProbability);
            case "OmitHotExceptionStacktrace": return OptionDescriptor.create("OmitHotExceptionStacktrace", Boolean.class, "", GraalOptions.class, "OmitHotExceptionStacktrace", GraalOptions.OmitHotExceptionStacktrace);
            case "OptAssumptions": return OptionDescriptor.create("OptAssumptions", Boolean.class, "", GraalOptions.class, "OptAssumptions", GraalOptions.OptAssumptions);
            case "OptClearNonLiveLocals": return OptionDescriptor.create("OptClearNonLiveLocals", Boolean.class, "", GraalOptions.class, "OptClearNonLiveLocals", GraalOptions.OptClearNonLiveLocals);
            case "OptConvertDeoptsToGuards": return OptionDescriptor.create("OptConvertDeoptsToGuards", Boolean.class, "", GraalOptions.class, "OptConvertDeoptsToGuards", GraalOptions.OptConvertDeoptsToGuards);
            case "OptDeoptimizationGrouping": return OptionDescriptor.create("OptDeoptimizationGrouping", Boolean.class, "", GraalOptions.class, "OptDeoptimizationGrouping", GraalOptions.OptDeoptimizationGrouping);
            case "OptDevirtualizeInvokesOptimistically": return OptionDescriptor.create("OptDevirtualizeInvokesOptimistically", Boolean.class, "", GraalOptions.class, "OptDevirtualizeInvokesOptimistically", GraalOptions.OptDevirtualizeInvokesOptimistically);
            case "OptEliminateGuards": return OptionDescriptor.create("OptEliminateGuards", Boolean.class, "", GraalOptions.class, "OptEliminateGuards", GraalOptions.OptEliminateGuards);
            case "OptEliminatePartiallyRedundantGuards": return OptionDescriptor.create("OptEliminatePartiallyRedundantGuards", Boolean.class, "", GraalOptions.class, "OptEliminatePartiallyRedundantGuards", GraalOptions.OptEliminatePartiallyRedundantGuards);
            case "OptFilterProfiledTypes": return OptionDescriptor.create("OptFilterProfiledTypes", Boolean.class, "", GraalOptions.class, "OptFilterProfiledTypes", GraalOptions.OptFilterProfiledTypes);
            case "OptFloatingReads": return OptionDescriptor.create("OptFloatingReads", Boolean.class, "", GraalOptions.class, "OptFloatingReads", GraalOptions.OptFloatingReads);
            case "OptImplicitNullChecks": return OptionDescriptor.create("OptImplicitNullChecks", Boolean.class, "", GraalOptions.class, "OptImplicitNullChecks", GraalOptions.OptImplicitNullChecks);
            case "OptLoopTransform": return OptionDescriptor.create("OptLoopTransform", Boolean.class, "", GraalOptions.class, "OptLoopTransform", GraalOptions.OptLoopTransform);
            case "OptPushThroughPi": return OptionDescriptor.create("OptPushThroughPi", Boolean.class, "", GraalOptions.class, "OptPushThroughPi", GraalOptions.OptPushThroughPi);
            case "OptReadElimination": return OptionDescriptor.create("OptReadElimination", Boolean.class, "", GraalOptions.class, "OptReadElimination", GraalOptions.OptReadElimination);
            case "OptScheduleOutOfLoops": return OptionDescriptor.create("OptScheduleOutOfLoops", Boolean.class, "", GraalOptions.class, "OptScheduleOutOfLoops", GraalOptions.OptScheduleOutOfLoops);
            case "PEAInliningHints": return OptionDescriptor.create("PEAInliningHints", Boolean.class, "", GraalOptions.class, "PEAInliningHints", GraalOptions.PEAInliningHints);
            case "PartialEscapeAnalysis": return OptionDescriptor.create("PartialEscapeAnalysis", Boolean.class, "", GraalOptions.class, "PartialEscapeAnalysis", GraalOptions.PartialEscapeAnalysis);
            case "PrintProfilingInformation": return OptionDescriptor.create("PrintProfilingInformation", Boolean.class, "Print profiling information when parsing a method's bytecode", GraalOptions.class, "PrintProfilingInformation", GraalOptions.PrintProfilingInformation);
            case "ReadEliminationMaxLoopVisits": return OptionDescriptor.create("ReadEliminationMaxLoopVisits", Integer.class, "", GraalOptions.class, "ReadEliminationMaxLoopVisits", GraalOptions.ReadEliminationMaxLoopVisits);
            case "ReassociateInvariants": return OptionDescriptor.create("ReassociateInvariants", Boolean.class, "", GraalOptions.class, "ReassociateInvariants", GraalOptions.ReassociateInvariants);
            case "RegisterPressure": return OptionDescriptor.create("RegisterPressure", String.class, "Comma separated list of registers that register allocation is limited to.", GraalOptions.class, "RegisterPressure", GraalOptions.RegisterPressure);
            case "RemoveNeverExecutedCode": return OptionDescriptor.create("RemoveNeverExecutedCode", Boolean.class, "", GraalOptions.class, "RemoveNeverExecutedCode", GraalOptions.RemoveNeverExecutedCode);
            case "ResolveClassBeforeStaticInvoke": return OptionDescriptor.create("ResolveClassBeforeStaticInvoke", Boolean.class, "", GraalOptions.class, "ResolveClassBeforeStaticInvoke", GraalOptions.ResolveClassBeforeStaticInvoke);
            case "SmallCompiledLowLevelGraphSize": return OptionDescriptor.create("SmallCompiledLowLevelGraphSize", Integer.class, "If the previous low-level graph size of the method exceeds the threshold, it is not inlined.", GraalOptions.class, "SmallCompiledLowLevelGraphSize", GraalOptions.SmallCompiledLowLevelGraphSize);
            case "SnippetCounters": return OptionDescriptor.create("SnippetCounters", Boolean.class, "Enable counters for various paths in snippets.", GraalOptions.class, "SnippetCounters", GraalOptions.SnippetCounters);
            case "StressExplicitExceptionCode": return OptionDescriptor.create("StressExplicitExceptionCode", Boolean.class, "Stress the code emitting explicit exception throwing code.", GraalOptions.class, "StressExplicitExceptionCode", GraalOptions.StressExplicitExceptionCode);
            case "StressInvokeWithExceptionNode": return OptionDescriptor.create("StressInvokeWithExceptionNode", Boolean.class, "Stress the code emitting invokes with explicit exception edges.", GraalOptions.class, "StressInvokeWithExceptionNode", GraalOptions.StressInvokeWithExceptionNode);
            case "SupportJsrBytecodes": return OptionDescriptor.create("SupportJsrBytecodes", Boolean.class, "", GraalOptions.class, "SupportJsrBytecodes", GraalOptions.SupportJsrBytecodes);
            case "TailDuplicationProbability": return OptionDescriptor.create("TailDuplicationProbability", Double.class, "", GraalOptions.class, "TailDuplicationProbability", GraalOptions.TailDuplicationProbability);
            case "TailDuplicationTrivialSize": return OptionDescriptor.create("TailDuplicationTrivialSize", Integer.class, "", GraalOptions.class, "TailDuplicationTrivialSize", GraalOptions.TailDuplicationTrivialSize);
            case "TraceEscapeAnalysis": return OptionDescriptor.create("TraceEscapeAnalysis", Boolean.class, "", GraalOptions.class, "TraceEscapeAnalysis", GraalOptions.TraceEscapeAnalysis);
            case "TraceRA": return OptionDescriptor.create("TraceRA", Boolean.class, "Enable experimental Trace Register Allocation.", GraalOptions.class, "TraceRA", GraalOptions.TraceRA);
            case "TrivialInliningSize": return OptionDescriptor.create("TrivialInliningSize", Integer.class, "Graphs with less than this number of nodes are trivial and therefore always inlined.", GraalOptions.class, "TrivialInliningSize", GraalOptions.TrivialInliningSize);
            case "UseExceptionProbability": return OptionDescriptor.create("UseExceptionProbability", Boolean.class, "", GraalOptions.class, "UseExceptionProbability", GraalOptions.UseExceptionProbability);
            case "UseExceptionProbabilityForOperations": return OptionDescriptor.create("UseExceptionProbabilityForOperations", Boolean.class, "", GraalOptions.class, "UseExceptionProbabilityForOperations", GraalOptions.UseExceptionProbabilityForOperations);
            case "UseGraalInstrumentation": return OptionDescriptor.create("UseGraalInstrumentation", Boolean.class, "Enable Graal instrumentation", GraalOptions.class, "UseGraalInstrumentation", GraalOptions.UseGraalInstrumentation);
            case "UseLoopLimitChecks": return OptionDescriptor.create("UseLoopLimitChecks", Boolean.class, "", GraalOptions.class, "UseLoopLimitChecks", GraalOptions.UseLoopLimitChecks);
            case "UseSnippetGraphCache": return OptionDescriptor.create("UseSnippetGraphCache", Boolean.class, "Use a cache for snippet graphs.", GraalOptions.class, "UseSnippetGraphCache", GraalOptions.UseSnippetGraphCache);
            case "UseTypeCheckHints": return OptionDescriptor.create("UseTypeCheckHints", Boolean.class, "", GraalOptions.class, "UseTypeCheckHints", GraalOptions.UseTypeCheckHints);
            case "VerifyHeapAtReturn": return OptionDescriptor.create("VerifyHeapAtReturn", Boolean.class, "Perform platform dependent validation of the Java heap at returns", GraalOptions.class, "VerifyHeapAtReturn", GraalOptions.VerifyHeapAtReturn);
            case "VerifyPhases": return OptionDescriptor.create("VerifyPhases", Boolean.class, "", GraalOptions.class, "VerifyPhases", GraalOptions.VerifyPhases);
            case "ZapStackOnMethodEntry": return OptionDescriptor.create("ZapStackOnMethodEntry", Boolean.class, "", GraalOptions.class, "ZapStackOnMethodEntry", GraalOptions.ZapStackOnMethodEntry);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("AlwaysInlineVTableStubs", Boolean.class, "", GraalOptions.class, "AlwaysInlineVTableStubs", GraalOptions.AlwaysInlineVTableStubs),
            OptionDescriptor.create("CallArrayCopy", Boolean.class, "", GraalOptions.class, "CallArrayCopy", GraalOptions.CallArrayCopy),
            OptionDescriptor.create("CanOmitFrame", Boolean.class, "", GraalOptions.class, "CanOmitFrame", GraalOptions.CanOmitFrame),
            OptionDescriptor.create("ConditionalElimination", Boolean.class, "", GraalOptions.class, "ConditionalElimination", GraalOptions.ConditionalElimination),
            OptionDescriptor.create("DeoptALot", Boolean.class, "", GraalOptions.class, "DeoptALot", GraalOptions.DeoptALot),
            OptionDescriptor.create("DeoptsToDisableOptimisticOptimization", Integer.class, "", GraalOptions.class, "DeoptsToDisableOptimisticOptimization", GraalOptions.DeoptsToDisableOptimisticOptimization),
            OptionDescriptor.create("DetailedAsserts", Boolean.class, "Enable expensive assertions", GraalOptions.class, "DetailedAsserts", GraalOptions.DetailedAsserts),
            OptionDescriptor.create("EagerSnippets", Boolean.class, "Eagerly construct extra snippet info.", GraalOptions.class, "EagerSnippets", GraalOptions.EagerSnippets),
            OptionDescriptor.create("EscapeAnalysisIterations", Integer.class, "", GraalOptions.class, "EscapeAnalysisIterations", GraalOptions.EscapeAnalysisIterations),
            OptionDescriptor.create("EscapeAnalysisLoopCutoff", Integer.class, "", GraalOptions.class, "EscapeAnalysisLoopCutoff", GraalOptions.EscapeAnalysisLoopCutoff),
            OptionDescriptor.create("EscapeAnalyzeOnly", String.class, "", GraalOptions.class, "EscapeAnalyzeOnly", GraalOptions.EscapeAnalyzeOnly),
            OptionDescriptor.create("FullUnroll", Boolean.class, "", GraalOptions.class, "FullUnroll", GraalOptions.FullUnroll),
            OptionDescriptor.create("GCDebugStartCycle", Integer.class, "", GraalOptions.class, "GCDebugStartCycle", GraalOptions.GCDebugStartCycle),
            OptionDescriptor.create("GenLoopSafepoints", Boolean.class, "", GraalOptions.class, "GenLoopSafepoints", GraalOptions.GenLoopSafepoints),
            OptionDescriptor.create("GenSafepoints", Boolean.class, "", GraalOptions.class, "GenSafepoints", GraalOptions.GenSafepoints),
            OptionDescriptor.create("GeneratePIC", Boolean.class, "Generate position independent code", GraalOptions.class, "GeneratePIC", GraalOptions.GeneratePIC),
            OptionDescriptor.create("HotSpotPrintInlining", Boolean.class, "Print inlining optimizations", GraalOptions.class, "HotSpotPrintInlining", GraalOptions.HotSpotPrintInlining),
            OptionDescriptor.create("ImmutableCode", Boolean.class, "Try to avoid emitting code where patching is required", GraalOptions.class, "ImmutableCode", GraalOptions.ImmutableCode),
            OptionDescriptor.create("InlineEverything", Boolean.class, "", GraalOptions.class, "InlineEverything", GraalOptions.InlineEverything),
            OptionDescriptor.create("InlineMegamorphicCalls", Boolean.class, "Inline calls with megamorphic type profile (i.e., not all types could be recorded).", GraalOptions.class, "InlineMegamorphicCalls", GraalOptions.InlineMegamorphicCalls),
            OptionDescriptor.create("InlineMonomorphicCalls", Boolean.class, "Inline calls with monomorphic type profile.", GraalOptions.class, "InlineMonomorphicCalls", GraalOptions.InlineMonomorphicCalls),
            OptionDescriptor.create("InlinePolymorphicCalls", Boolean.class, "Inline calls with polymorphic type profile.", GraalOptions.class, "InlinePolymorphicCalls", GraalOptions.InlinePolymorphicCalls),
            OptionDescriptor.create("InlineVTableStubs", Boolean.class, "", GraalOptions.class, "InlineVTableStubs", GraalOptions.InlineVTableStubs),
            OptionDescriptor.create("Intrinsify", Boolean.class, "Use compiler intrinsifications.", GraalOptions.class, "Intrinsify", GraalOptions.Intrinsify),
            OptionDescriptor.create("LimitInlinedInvokes", Double.class, "", GraalOptions.class, "LimitInlinedInvokes", GraalOptions.LimitInlinedInvokes),
            OptionDescriptor.create("LoopMaxUnswitch", Integer.class, "", GraalOptions.class, "LoopMaxUnswitch", GraalOptions.LoopMaxUnswitch),
            OptionDescriptor.create("LoopPeeling", Boolean.class, "", GraalOptions.class, "LoopPeeling", GraalOptions.LoopPeeling),
            OptionDescriptor.create("LoopUnswitch", Boolean.class, "", GraalOptions.class, "LoopUnswitch", GraalOptions.LoopUnswitch),
            OptionDescriptor.create("MatchExpressions", Boolean.class, "Allow backend to match complex expressions.", GraalOptions.class, "MatchExpressions", GraalOptions.MatchExpressions),
            OptionDescriptor.create("MaximumDesiredSize", Integer.class, "Maximum desired size of the compiler graph in nodes.", GraalOptions.class, "MaximumDesiredSize", GraalOptions.MaximumDesiredSize),
            OptionDescriptor.create("MaximumEscapeAnalysisArrayLength", Integer.class, "", GraalOptions.class, "MaximumEscapeAnalysisArrayLength", GraalOptions.MaximumEscapeAnalysisArrayLength),
            OptionDescriptor.create("MaximumInliningSize", Integer.class, "Inlining is explored up to this number of nodes in the graph for each call site.", GraalOptions.class, "MaximumInliningSize", GraalOptions.MaximumInliningSize),
            OptionDescriptor.create("MaximumRecursiveInlining", Integer.class, "Maximum level of recursive inlining.", GraalOptions.class, "MaximumRecursiveInlining", GraalOptions.MaximumRecursiveInlining),
            OptionDescriptor.create("MegamorphicInliningMinMethodProbability", Double.class, "Minimum probability for methods to be inlined for megamorphic type profiles.", GraalOptions.class, "MegamorphicInliningMinMethodProbability", GraalOptions.MegamorphicInliningMinMethodProbability),
            OptionDescriptor.create("MinimumPeelProbability", Float.class, "", GraalOptions.class, "MinimumPeelProbability", GraalOptions.MinimumPeelProbability),
            OptionDescriptor.create("OmitHotExceptionStacktrace", Boolean.class, "", GraalOptions.class, "OmitHotExceptionStacktrace", GraalOptions.OmitHotExceptionStacktrace),
            OptionDescriptor.create("OptAssumptions", Boolean.class, "", GraalOptions.class, "OptAssumptions", GraalOptions.OptAssumptions),
            OptionDescriptor.create("OptClearNonLiveLocals", Boolean.class, "", GraalOptions.class, "OptClearNonLiveLocals", GraalOptions.OptClearNonLiveLocals),
            OptionDescriptor.create("OptConvertDeoptsToGuards", Boolean.class, "", GraalOptions.class, "OptConvertDeoptsToGuards", GraalOptions.OptConvertDeoptsToGuards),
            OptionDescriptor.create("OptDeoptimizationGrouping", Boolean.class, "", GraalOptions.class, "OptDeoptimizationGrouping", GraalOptions.OptDeoptimizationGrouping),
            OptionDescriptor.create("OptDevirtualizeInvokesOptimistically", Boolean.class, "", GraalOptions.class, "OptDevirtualizeInvokesOptimistically", GraalOptions.OptDevirtualizeInvokesOptimistically),
            OptionDescriptor.create("OptEliminateGuards", Boolean.class, "", GraalOptions.class, "OptEliminateGuards", GraalOptions.OptEliminateGuards),
            OptionDescriptor.create("OptEliminatePartiallyRedundantGuards", Boolean.class, "", GraalOptions.class, "OptEliminatePartiallyRedundantGuards", GraalOptions.OptEliminatePartiallyRedundantGuards),
            OptionDescriptor.create("OptFilterProfiledTypes", Boolean.class, "", GraalOptions.class, "OptFilterProfiledTypes", GraalOptions.OptFilterProfiledTypes),
            OptionDescriptor.create("OptFloatingReads", Boolean.class, "", GraalOptions.class, "OptFloatingReads", GraalOptions.OptFloatingReads),
            OptionDescriptor.create("OptImplicitNullChecks", Boolean.class, "", GraalOptions.class, "OptImplicitNullChecks", GraalOptions.OptImplicitNullChecks),
            OptionDescriptor.create("OptLoopTransform", Boolean.class, "", GraalOptions.class, "OptLoopTransform", GraalOptions.OptLoopTransform),
            OptionDescriptor.create("OptPushThroughPi", Boolean.class, "", GraalOptions.class, "OptPushThroughPi", GraalOptions.OptPushThroughPi),
            OptionDescriptor.create("OptReadElimination", Boolean.class, "", GraalOptions.class, "OptReadElimination", GraalOptions.OptReadElimination),
            OptionDescriptor.create("OptScheduleOutOfLoops", Boolean.class, "", GraalOptions.class, "OptScheduleOutOfLoops", GraalOptions.OptScheduleOutOfLoops),
            OptionDescriptor.create("PEAInliningHints", Boolean.class, "", GraalOptions.class, "PEAInliningHints", GraalOptions.PEAInliningHints),
            OptionDescriptor.create("PartialEscapeAnalysis", Boolean.class, "", GraalOptions.class, "PartialEscapeAnalysis", GraalOptions.PartialEscapeAnalysis),
            OptionDescriptor.create("PrintProfilingInformation", Boolean.class, "Print profiling information when parsing a method's bytecode", GraalOptions.class, "PrintProfilingInformation", GraalOptions.PrintProfilingInformation),
            OptionDescriptor.create("ReadEliminationMaxLoopVisits", Integer.class, "", GraalOptions.class, "ReadEliminationMaxLoopVisits", GraalOptions.ReadEliminationMaxLoopVisits),
            OptionDescriptor.create("ReassociateInvariants", Boolean.class, "", GraalOptions.class, "ReassociateInvariants", GraalOptions.ReassociateInvariants),
            OptionDescriptor.create("RegisterPressure", String.class, "Comma separated list of registers that register allocation is limited to.", GraalOptions.class, "RegisterPressure", GraalOptions.RegisterPressure),
            OptionDescriptor.create("RemoveNeverExecutedCode", Boolean.class, "", GraalOptions.class, "RemoveNeverExecutedCode", GraalOptions.RemoveNeverExecutedCode),
            OptionDescriptor.create("ResolveClassBeforeStaticInvoke", Boolean.class, "", GraalOptions.class, "ResolveClassBeforeStaticInvoke", GraalOptions.ResolveClassBeforeStaticInvoke),
            OptionDescriptor.create("SmallCompiledLowLevelGraphSize", Integer.class, "If the previous low-level graph size of the method exceeds the threshold, it is not inlined.", GraalOptions.class, "SmallCompiledLowLevelGraphSize", GraalOptions.SmallCompiledLowLevelGraphSize),
            OptionDescriptor.create("SnippetCounters", Boolean.class, "Enable counters for various paths in snippets.", GraalOptions.class, "SnippetCounters", GraalOptions.SnippetCounters),
            OptionDescriptor.create("StressExplicitExceptionCode", Boolean.class, "Stress the code emitting explicit exception throwing code.", GraalOptions.class, "StressExplicitExceptionCode", GraalOptions.StressExplicitExceptionCode),
            OptionDescriptor.create("StressInvokeWithExceptionNode", Boolean.class, "Stress the code emitting invokes with explicit exception edges.", GraalOptions.class, "StressInvokeWithExceptionNode", GraalOptions.StressInvokeWithExceptionNode),
            OptionDescriptor.create("SupportJsrBytecodes", Boolean.class, "", GraalOptions.class, "SupportJsrBytecodes", GraalOptions.SupportJsrBytecodes),
            OptionDescriptor.create("TailDuplicationProbability", Double.class, "", GraalOptions.class, "TailDuplicationProbability", GraalOptions.TailDuplicationProbability),
            OptionDescriptor.create("TailDuplicationTrivialSize", Integer.class, "", GraalOptions.class, "TailDuplicationTrivialSize", GraalOptions.TailDuplicationTrivialSize),
            OptionDescriptor.create("TraceEscapeAnalysis", Boolean.class, "", GraalOptions.class, "TraceEscapeAnalysis", GraalOptions.TraceEscapeAnalysis),
            OptionDescriptor.create("TraceRA", Boolean.class, "Enable experimental Trace Register Allocation.", GraalOptions.class, "TraceRA", GraalOptions.TraceRA),
            OptionDescriptor.create("TrivialInliningSize", Integer.class, "Graphs with less than this number of nodes are trivial and therefore always inlined.", GraalOptions.class, "TrivialInliningSize", GraalOptions.TrivialInliningSize),
            OptionDescriptor.create("UseExceptionProbability", Boolean.class, "", GraalOptions.class, "UseExceptionProbability", GraalOptions.UseExceptionProbability),
            OptionDescriptor.create("UseExceptionProbabilityForOperations", Boolean.class, "", GraalOptions.class, "UseExceptionProbabilityForOperations", GraalOptions.UseExceptionProbabilityForOperations),
            OptionDescriptor.create("UseGraalInstrumentation", Boolean.class, "Enable Graal instrumentation", GraalOptions.class, "UseGraalInstrumentation", GraalOptions.UseGraalInstrumentation),
            OptionDescriptor.create("UseLoopLimitChecks", Boolean.class, "", GraalOptions.class, "UseLoopLimitChecks", GraalOptions.UseLoopLimitChecks),
            OptionDescriptor.create("UseSnippetGraphCache", Boolean.class, "Use a cache for snippet graphs.", GraalOptions.class, "UseSnippetGraphCache", GraalOptions.UseSnippetGraphCache),
            OptionDescriptor.create("UseTypeCheckHints", Boolean.class, "", GraalOptions.class, "UseTypeCheckHints", GraalOptions.UseTypeCheckHints),
            OptionDescriptor.create("VerifyHeapAtReturn", Boolean.class, "Perform platform dependent validation of the Java heap at returns", GraalOptions.class, "VerifyHeapAtReturn", GraalOptions.VerifyHeapAtReturn),
            OptionDescriptor.create("VerifyPhases", Boolean.class, "", GraalOptions.class, "VerifyPhases", GraalOptions.VerifyPhases),
            OptionDescriptor.create("ZapStackOnMethodEntry", Boolean.class, "", GraalOptions.class, "ZapStackOnMethodEntry", GraalOptions.ZapStackOnMethodEntry)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
