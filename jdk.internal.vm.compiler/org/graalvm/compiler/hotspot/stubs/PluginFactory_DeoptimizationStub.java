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
public class PluginFactory_DeoptimizationStub implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.stubs.DeoptimizationStub
    //       method: deoptimizationUnpackDeopt(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class DeoptimizationStub_deoptimizationUnpackDeopt extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.deoptimizationUnpackDeopt(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private DeoptimizationStub_deoptimizationUnpackDeopt(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.DeoptimizationStub
    //       method: deoptimizationUnpackUncommonTrap(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class DeoptimizationStub_deoptimizationUnpackUncommonTrap extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.deoptimizationUnpackUncommonTrap(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private DeoptimizationStub_deoptimizationUnpackUncommonTrap(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.DeoptimizationStub
    //       method: deoptimizationUnrollBlockCallerAdjustmentOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class DeoptimizationStub_deoptimizationUnrollBlockCallerAdjustmentOffset extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.deoptimizationUnrollBlockCallerAdjustmentOffset(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private DeoptimizationStub_deoptimizationUnrollBlockCallerAdjustmentOffset(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.DeoptimizationStub
    //       method: deoptimizationUnrollBlockFramePcsOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class DeoptimizationStub_deoptimizationUnrollBlockFramePcsOffset extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.deoptimizationUnrollBlockFramePcsOffset(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private DeoptimizationStub_deoptimizationUnrollBlockFramePcsOffset(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.DeoptimizationStub
    //       method: deoptimizationUnrollBlockFrameSizesOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class DeoptimizationStub_deoptimizationUnrollBlockFrameSizesOffset extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.deoptimizationUnrollBlockFrameSizesOffset(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private DeoptimizationStub_deoptimizationUnrollBlockFrameSizesOffset(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.DeoptimizationStub
    //       method: deoptimizationUnrollBlockInitialInfoOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class DeoptimizationStub_deoptimizationUnrollBlockInitialInfoOffset extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.deoptimizationUnrollBlockInitialInfoOffset(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private DeoptimizationStub_deoptimizationUnrollBlockInitialInfoOffset(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.DeoptimizationStub
    //       method: deoptimizationUnrollBlockNumberOfFramesOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class DeoptimizationStub_deoptimizationUnrollBlockNumberOfFramesOffset extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.deoptimizationUnrollBlockNumberOfFramesOffset(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private DeoptimizationStub_deoptimizationUnrollBlockNumberOfFramesOffset(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.DeoptimizationStub
    //       method: deoptimizationUnrollBlockSizeOfDeoptimizedFrameOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class DeoptimizationStub_deoptimizationUnrollBlockSizeOfDeoptimizedFrameOffset extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.deoptimizationUnrollBlockSizeOfDeoptimizedFrameOffset(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private DeoptimizationStub_deoptimizationUnrollBlockSizeOfDeoptimizedFrameOffset(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.DeoptimizationStub
    //       method: deoptimizationUnrollBlockTotalFrameSizesOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class DeoptimizationStub_deoptimizationUnrollBlockTotalFrameSizesOffset extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.deoptimizationUnrollBlockTotalFrameSizesOffset(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private DeoptimizationStub_deoptimizationUnrollBlockTotalFrameSizesOffset(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.DeoptimizationStub
    //       method: deoptimizationUnrollBlockUnpackKindOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class DeoptimizationStub_deoptimizationUnrollBlockUnpackKindOffset extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.deoptimizationUnrollBlockUnpackKindOffset(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private DeoptimizationStub_deoptimizationUnrollBlockUnpackKindOffset(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.DeoptimizationStub
    //       method: stackBias(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class DeoptimizationStub_stackBias extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            @SuppressWarnings({"deprecation"})
            int result = org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.stackBias(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private DeoptimizationStub_stackBias(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.DeoptimizationStub
    //       method: stackShadowPages(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class DeoptimizationStub_stackShadowPages extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            int result = org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.stackShadowPages(arg0);
            JavaConstant constant = JavaConstant.forInt(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private DeoptimizationStub_stackShadowPages(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.stubs.DeoptimizationStub
    //       method: unpackFrames(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.word.Word,int)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class DeoptimizationStub_unpackFrames extends GeneratedInvocationPlugin {

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

        private DeoptimizationStub_unpackFrames(InjectionProvider injection) {
            this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
            this.returnStamp = injection.getReturnStamp(int.class, false);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new DeoptimizationStub_deoptimizationUnpackDeopt(injection), org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.class, "deoptimizationUnpackDeopt", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new DeoptimizationStub_deoptimizationUnpackUncommonTrap(injection), org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.class, "deoptimizationUnpackUncommonTrap", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new DeoptimizationStub_deoptimizationUnrollBlockCallerAdjustmentOffset(injection), org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.class, "deoptimizationUnrollBlockCallerAdjustmentOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new DeoptimizationStub_deoptimizationUnrollBlockFramePcsOffset(injection), org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.class, "deoptimizationUnrollBlockFramePcsOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new DeoptimizationStub_deoptimizationUnrollBlockFrameSizesOffset(injection), org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.class, "deoptimizationUnrollBlockFrameSizesOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new DeoptimizationStub_deoptimizationUnrollBlockInitialInfoOffset(injection), org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.class, "deoptimizationUnrollBlockInitialInfoOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new DeoptimizationStub_deoptimizationUnrollBlockNumberOfFramesOffset(injection), org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.class, "deoptimizationUnrollBlockNumberOfFramesOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new DeoptimizationStub_deoptimizationUnrollBlockSizeOfDeoptimizedFrameOffset(injection), org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.class, "deoptimizationUnrollBlockSizeOfDeoptimizedFrameOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new DeoptimizationStub_deoptimizationUnrollBlockTotalFrameSizesOffset(injection), org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.class, "deoptimizationUnrollBlockTotalFrameSizesOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new DeoptimizationStub_deoptimizationUnrollBlockUnpackKindOffset(injection), org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.class, "deoptimizationUnrollBlockUnpackKindOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new DeoptimizationStub_stackBias(injection), org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.class, "stackBias", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new DeoptimizationStub_stackShadowPages(injection), org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.class, "stackShadowPages", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new DeoptimizationStub_unpackFrames(injection), org.graalvm.compiler.hotspot.stubs.DeoptimizationStub.class, "unpackFrames", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.word.Word.class, int.class);
    }
}
