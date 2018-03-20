// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.hotspot.stubs;

import jdk.vm.ci.meta.ResolvedJavaMethod;
import org.graalvm.compiler.serviceprovider.ServiceProvider;

import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaKind;
import org.graalvm.compiler.nodes.ConstantNode;

@ServiceProvider(NodeIntrinsicPluginFactory.class)
public class PluginFactory_UncommonTrapStub implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.stubs.UncommonTrapStub
    //       method: deoptimizationUnpackDeopt(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class UncommonTrapStub_deoptimizationUnpackDeopt extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.deoptimizationUnpackDeopt(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private UncommonTrapStub_deoptimizationUnpackDeopt(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.UncommonTrapStub
    //       method: deoptimizationUnpackUncommonTrap(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class UncommonTrapStub_deoptimizationUnpackUncommonTrap extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.deoptimizationUnpackUncommonTrap(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private UncommonTrapStub_deoptimizationUnpackUncommonTrap(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.UncommonTrapStub
    //       method: deoptimizationUnrollBlockCallerAdjustmentOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class UncommonTrapStub_deoptimizationUnrollBlockCallerAdjustmentOffset extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.deoptimizationUnrollBlockCallerAdjustmentOffset(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private UncommonTrapStub_deoptimizationUnrollBlockCallerAdjustmentOffset(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.UncommonTrapStub
    //       method: deoptimizationUnrollBlockFramePcsOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class UncommonTrapStub_deoptimizationUnrollBlockFramePcsOffset extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.deoptimizationUnrollBlockFramePcsOffset(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private UncommonTrapStub_deoptimizationUnrollBlockFramePcsOffset(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.UncommonTrapStub
    //       method: deoptimizationUnrollBlockFrameSizesOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class UncommonTrapStub_deoptimizationUnrollBlockFrameSizesOffset extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.deoptimizationUnrollBlockFrameSizesOffset(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private UncommonTrapStub_deoptimizationUnrollBlockFrameSizesOffset(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.UncommonTrapStub
    //       method: deoptimizationUnrollBlockInitialInfoOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class UncommonTrapStub_deoptimizationUnrollBlockInitialInfoOffset extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.deoptimizationUnrollBlockInitialInfoOffset(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private UncommonTrapStub_deoptimizationUnrollBlockInitialInfoOffset(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.UncommonTrapStub
    //       method: deoptimizationUnrollBlockNumberOfFramesOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class UncommonTrapStub_deoptimizationUnrollBlockNumberOfFramesOffset extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.deoptimizationUnrollBlockNumberOfFramesOffset(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private UncommonTrapStub_deoptimizationUnrollBlockNumberOfFramesOffset(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.UncommonTrapStub
    //       method: deoptimizationUnrollBlockSizeOfDeoptimizedFrameOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class UncommonTrapStub_deoptimizationUnrollBlockSizeOfDeoptimizedFrameOffset extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.deoptimizationUnrollBlockSizeOfDeoptimizedFrameOffset(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private UncommonTrapStub_deoptimizationUnrollBlockSizeOfDeoptimizedFrameOffset(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.UncommonTrapStub
    //       method: deoptimizationUnrollBlockTotalFrameSizesOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class UncommonTrapStub_deoptimizationUnrollBlockTotalFrameSizesOffset extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.deoptimizationUnrollBlockTotalFrameSizesOffset(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private UncommonTrapStub_deoptimizationUnrollBlockTotalFrameSizesOffset(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.UncommonTrapStub
    //       method: stackBias(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class UncommonTrapStub_stackBias extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            @SuppressWarnings({"deprecation"})
            int result = org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.stackBias(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private UncommonTrapStub_stackBias(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.UncommonTrapStub
    //       method: stackShadowPages(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class UncommonTrapStub_stackShadowPages extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.stackShadowPages(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private UncommonTrapStub_stackShadowPages(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.UncommonTrapStub
    //       method: unpackFrames(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.word.Word,int)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class UncommonTrapStub_unpackFrames extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            org.graalvm.compiler.core.common.spi.ForeignCallsProvider arg0 = injectedForeignCallsProvider;
            org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg1;
            if (args[0].isConstant()) {
                arg1 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
            } else {
                return false;
            }
            ValueNode arg2 = args[1];
            ValueNode arg3 = args[2];
            org.graalvm.compiler.hotspot.nodes.StubForeignCallNode node = new org.graalvm.compiler.hotspot.nodes.StubForeignCallNode(arg0, arg1, arg2, arg3);
            node.setStamp(returnStamp);
            b.addPush(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
        private final org.graalvm.compiler.core.common.type.Stamp returnStamp;

        private UncommonTrapStub_unpackFrames(InjectionProvider injection) {
            this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
            this.returnStamp = injection.getReturnStamp(int.class, false);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new UncommonTrapStub_deoptimizationUnpackDeopt(injection), org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.class, "deoptimizationUnpackDeopt", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new UncommonTrapStub_deoptimizationUnpackUncommonTrap(injection), org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.class, "deoptimizationUnpackUncommonTrap", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new UncommonTrapStub_deoptimizationUnrollBlockCallerAdjustmentOffset(injection), org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.class, "deoptimizationUnrollBlockCallerAdjustmentOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new UncommonTrapStub_deoptimizationUnrollBlockFramePcsOffset(injection), org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.class, "deoptimizationUnrollBlockFramePcsOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new UncommonTrapStub_deoptimizationUnrollBlockFrameSizesOffset(injection), org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.class, "deoptimizationUnrollBlockFrameSizesOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new UncommonTrapStub_deoptimizationUnrollBlockInitialInfoOffset(injection), org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.class, "deoptimizationUnrollBlockInitialInfoOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new UncommonTrapStub_deoptimizationUnrollBlockNumberOfFramesOffset(injection), org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.class, "deoptimizationUnrollBlockNumberOfFramesOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new UncommonTrapStub_deoptimizationUnrollBlockSizeOfDeoptimizedFrameOffset(injection), org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.class, "deoptimizationUnrollBlockSizeOfDeoptimizedFrameOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new UncommonTrapStub_deoptimizationUnrollBlockTotalFrameSizesOffset(injection), org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.class, "deoptimizationUnrollBlockTotalFrameSizesOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new UncommonTrapStub_stackBias(injection), org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.class, "stackBias", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new UncommonTrapStub_stackShadowPages(injection), org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.class, "stackShadowPages", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new UncommonTrapStub_unpackFrames(injection), org.graalvm.compiler.hotspot.stubs.UncommonTrapStub.class, "unpackFrames", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.word.Word.class, int.class);
    }
}
