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
public class PluginFactory_DirectCompareAndSwapNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.nodes.DirectCompareAndSwapNode
    //       method: compareAndSwap(org.graalvm.compiler.nodes.memory.address.AddressNode.Address,org.graalvm.compiler.word.Word,org.graalvm.compiler.word.Word,org.graalvm.compiler.core.common.LocationIdentity)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class DirectCompareAndSwapNode_compareAndSwap extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            ValueNode arg2 = args[2];
            org.graalvm.compiler.core.common.LocationIdentity arg3;
            if (args[3].isConstant()) {
                arg3 = snippetReflection.asObject(org.graalvm.compiler.core.common.LocationIdentity.class, args[3].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.hotspot.nodes.DirectCompareAndSwapNode node = new org.graalvm.compiler.hotspot.nodes.DirectCompareAndSwapNode(arg0, arg1, arg2, arg3);
            b.addPush(JavaKind.Object, node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private DirectCompareAndSwapNode_compareAndSwap(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new DirectCompareAndSwapNode_compareAndSwap(injection), org.graalvm.compiler.hotspot.nodes.DirectCompareAndSwapNode.class, "compareAndSwap", org.graalvm.compiler.nodes.memory.address.AddressNode.Address.class, org.graalvm.compiler.word.Word.class, org.graalvm.compiler.word.Word.class, org.graalvm.compiler.core.common.LocationIdentity.class);
    }
}
