// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.hotspot.nodes.aot;

import jdk.vm.ci.meta.ResolvedJavaMethod;
import org.graalvm.compiler.serviceprovider.ServiceProvider;

import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

import jdk.vm.ci.meta.JavaKind;

@ServiceProvider(NodeIntrinsicPluginFactory.class)
public class PluginFactory_EncodedSymbolNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.nodes.aot.EncodedSymbolNode
    //       method: encode(java.lang.Object)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class EncodedSymbolNode_encode extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            org.graalvm.compiler.hotspot.nodes.aot.EncodedSymbolNode node = new org.graalvm.compiler.hotspot.nodes.aot.EncodedSymbolNode(arg0);
            node.setStamp(returnStamp);
            b.addPush(JavaKind.Object, node);
            return true;
        }

        private final org.graalvm.compiler.core.common.type.Stamp returnStamp;

        private EncodedSymbolNode_encode(InjectionProvider injection) {
            this.returnStamp = injection.getReturnStamp(org.graalvm.compiler.word.Word.class, false);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new EncodedSymbolNode_encode(injection), org.graalvm.compiler.hotspot.nodes.aot.EncodedSymbolNode.class, "encode", java.lang.Object.class);
    }
}
