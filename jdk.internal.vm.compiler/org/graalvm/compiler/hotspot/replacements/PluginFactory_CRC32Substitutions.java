// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.hotspot.replacements;

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
public class PluginFactory_CRC32Substitutions implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.replacements.CRC32Substitutions
    //       method: crcTableAddress(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class CRC32Substitutions_crcTableAddress extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            assert checkInjectedArgument(b, args[0], targetMethod);
            org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
            long result = org.graalvm.compiler.hotspot.replacements.CRC32Substitutions.crcTableAddress(arg0);
            JavaConstant constant = JavaConstant.forLong(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Long, node);
            return true;
        }

        private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

        private CRC32Substitutions_crcTableAddress(InjectionProvider injection) {
            this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.replacements.CRC32Substitutions
    //       method: updateBytesCRC32(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,int,org.graalvm.compiler.word.Word,int)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
    private static final class CRC32Substitutions_updateBytesCRC32 extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            org.graalvm.compiler.core.common.type.Stamp arg0 = returnStamp;
            org.graalvm.compiler.core.common.spi.ForeignCallsProvider arg1 = injectedForeignCallsProvider;
            org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg2;
            if (args[0].isConstant()) {
                arg2 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
            } else {
                return false;
            }
            ValueNode arg3 = args[1];
            ValueNode arg4 = args[2];
            ValueNode arg5 = args[3];
            return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3, arg4, arg5);
        }

        private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
        private final org.graalvm.compiler.core.common.type.Stamp returnStamp;

        private CRC32Substitutions_updateBytesCRC32(InjectionProvider injection) {
            this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
            this.returnStamp = injection.getReturnStamp(int.class, false);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new CRC32Substitutions_crcTableAddress(injection), org.graalvm.compiler.hotspot.replacements.CRC32Substitutions.class, "crcTableAddress", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new CRC32Substitutions_updateBytesCRC32(injection), org.graalvm.compiler.hotspot.replacements.CRC32Substitutions.class, "updateBytesCRC32", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, int.class, org.graalvm.compiler.word.Word.class, int.class);
    }
}
