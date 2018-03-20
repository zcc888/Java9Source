// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.nodes.memory.address;

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
public class PluginFactory_RawAddressNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.nodes.memory.address.RawAddressNode
    //       method: address(java.lang.Object)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class RawAddressNode_address_Object extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            org.graalvm.compiler.nodes.memory.address.RawAddressNode node = new org.graalvm.compiler.nodes.memory.address.RawAddressNode(arg0);
            b.addPush(JavaKind.Object, node);
            return true;
        }
    }

    //        class: org.graalvm.compiler.nodes.memory.address.RawAddressNode
    //       method: address(long)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class RawAddressNode_address_long extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            org.graalvm.compiler.nodes.memory.address.RawAddressNode node = new org.graalvm.compiler.nodes.memory.address.RawAddressNode(arg0);
            b.addPush(JavaKind.Object, node);
            return true;
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new RawAddressNode_address_Object(), org.graalvm.compiler.nodes.memory.address.RawAddressNode.class, "address", java.lang.Object.class);
        plugins.register(new RawAddressNode_address_long(), org.graalvm.compiler.nodes.memory.address.RawAddressNode.class, "address", long.class);
    }
}
