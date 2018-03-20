// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.hotspot.nodes;

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
public class PluginFactory_CompressionNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.nodes.CompressionNode
    //       method: compression(org.graalvm.compiler.hotspot.nodes.CompressionNode.CompressionOp,java.lang.Object,org.graalvm.compiler.hotspot.CompressEncoding)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class CompressionNode_compression extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            org.graalvm.compiler.hotspot.nodes.CompressionNode.CompressionOp arg0;
            if (args[0].isConstant()) {
                arg0 = snippetReflection.asObject(org.graalvm.compiler.hotspot.nodes.CompressionNode.CompressionOp.class, args[0].asJavaConstant());
            } else {
                return false;
            }
            ValueNode arg1 = args[1];
            org.graalvm.compiler.hotspot.CompressEncoding arg2;
            if (args[2].isConstant()) {
                arg2 = snippetReflection.asObject(org.graalvm.compiler.hotspot.CompressEncoding.class, args[2].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.hotspot.nodes.CompressionNode node = new org.graalvm.compiler.hotspot.nodes.CompressionNode(arg0, arg1, arg2);
            b.addPush(JavaKind.Object, node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private CompressionNode_compression(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new CompressionNode_compression(injection), org.graalvm.compiler.hotspot.nodes.CompressionNode.class, "compression", org.graalvm.compiler.hotspot.nodes.CompressionNode.CompressionOp.class, java.lang.Object.class, org.graalvm.compiler.hotspot.CompressEncoding.class);
    }
}
