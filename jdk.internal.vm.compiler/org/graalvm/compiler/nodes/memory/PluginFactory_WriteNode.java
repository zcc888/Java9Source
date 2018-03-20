// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.nodes.memory;

import jdk.vm.ci.meta.ResolvedJavaMethod;
import org.graalvm.compiler.serviceprovider.ServiceProvider;

import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

@ServiceProvider(NodeIntrinsicPluginFactory.class)
public class PluginFactory_WriteNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.nodes.memory.WriteNode
    //       method: writeMemory(org.graalvm.compiler.nodes.memory.address.AddressNode.Address,org.graalvm.compiler.core.common.LocationIdentity,java.lang.Object,org.graalvm.compiler.nodes.memory.HeapAccess.BarrierType)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class WriteNode_writeMemory extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            org.graalvm.compiler.core.common.LocationIdentity arg1;
            if (args[1].isConstant()) {
                arg1 = snippetReflection.asObject(org.graalvm.compiler.core.common.LocationIdentity.class, args[1].asJavaConstant());
            } else {
                return false;
            }
            ValueNode arg2 = args[2];
            org.graalvm.compiler.nodes.memory.HeapAccess.BarrierType arg3;
            if (args[3].isConstant()) {
                arg3 = snippetReflection.asObject(org.graalvm.compiler.nodes.memory.HeapAccess.BarrierType.class, args[3].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.nodes.memory.WriteNode node = new org.graalvm.compiler.nodes.memory.WriteNode(arg0, arg1, arg2, arg3);
            b.add(node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private WriteNode_writeMemory(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new WriteNode_writeMemory(injection), org.graalvm.compiler.nodes.memory.WriteNode.class, "writeMemory", org.graalvm.compiler.nodes.memory.address.AddressNode.Address.class, org.graalvm.compiler.core.common.LocationIdentity.class, java.lang.Object.class, org.graalvm.compiler.nodes.memory.HeapAccess.BarrierType.class);
    }
}
