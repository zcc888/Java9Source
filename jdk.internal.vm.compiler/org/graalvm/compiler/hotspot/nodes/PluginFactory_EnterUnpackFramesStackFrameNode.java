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
public class PluginFactory_EnterUnpackFramesStackFrameNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.nodes.EnterUnpackFramesStackFrameNode
    //       method: enterUnpackFramesStackFrame(org.graalvm.compiler.word.Word,org.graalvm.compiler.word.Word,org.graalvm.compiler.word.Word,long)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class EnterUnpackFramesStackFrameNode_enterUnpackFramesStackFrame extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            org.graalvm.compiler.hotspot.nodes.EnterUnpackFramesStackFrameNode node = new org.graalvm.compiler.hotspot.nodes.EnterUnpackFramesStackFrameNode(arg0, arg1, arg2, arg3);
            b.add(node);
            return true;
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new EnterUnpackFramesStackFrameNode_enterUnpackFramesStackFrame(), org.graalvm.compiler.hotspot.nodes.EnterUnpackFramesStackFrameNode.class, "enterUnpackFramesStackFrame", org.graalvm.compiler.word.Word.class, org.graalvm.compiler.word.Word.class, org.graalvm.compiler.word.Word.class, long.class);
    }
}
