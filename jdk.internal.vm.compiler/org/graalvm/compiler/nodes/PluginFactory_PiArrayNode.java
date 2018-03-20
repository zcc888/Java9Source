// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.nodes;

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
public class PluginFactory_PiArrayNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.nodes.PiArrayNode
    //       method: piArrayCast(java.lang.Object,int,org.graalvm.compiler.core.common.type.Stamp)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class PiArrayNode_piArrayCast extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            org.graalvm.compiler.core.common.type.Stamp arg2;
            if (args[2].isConstant()) {
                arg2 = snippetReflection.asObject(org.graalvm.compiler.core.common.type.Stamp.class, args[2].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.nodes.PiArrayNode node = new org.graalvm.compiler.nodes.PiArrayNode(arg0, arg1, arg2);
            b.addPush(JavaKind.Object, node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private PiArrayNode_piArrayCast(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new PiArrayNode_piArrayCast(injection), org.graalvm.compiler.nodes.PiArrayNode.class, "piArrayCast", java.lang.Object.class, int.class, org.graalvm.compiler.core.common.type.Stamp.class);
    }
}
