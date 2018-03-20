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

@ServiceProvider(NodeIntrinsicPluginFactory.class)
public class PluginFactory_PushInterpreterFrameNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.nodes.PushInterpreterFrameNode
    //       method: pushInterpreterFrame(org.graalvm.compiler.word.Word,org.graalvm.compiler.word.Word,org.graalvm.compiler.word.Word,org.graalvm.compiler.word.Word)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class PushInterpreterFrameNode_pushInterpreterFrame extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            org.graalvm.compiler.hotspot.nodes.PushInterpreterFrameNode node = new org.graalvm.compiler.hotspot.nodes.PushInterpreterFrameNode(arg0, arg1, arg2, arg3);
            b.add(node);
            return true;
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new PushInterpreterFrameNode_pushInterpreterFrame(), org.graalvm.compiler.hotspot.nodes.PushInterpreterFrameNode.class, "pushInterpreterFrame", org.graalvm.compiler.word.Word.class, org.graalvm.compiler.word.Word.class, org.graalvm.compiler.word.Word.class, org.graalvm.compiler.word.Word.class);
    }
}
