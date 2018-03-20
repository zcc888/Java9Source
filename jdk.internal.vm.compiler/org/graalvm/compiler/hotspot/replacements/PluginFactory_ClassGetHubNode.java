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

import jdk.vm.ci.meta.JavaKind;

@ServiceProvider(NodeIntrinsicPluginFactory.class)
public class PluginFactory_ClassGetHubNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.replacements.ClassGetHubNode
    //       method: readClass(java.lang.Class<?>)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class ClassGetHubNode_readClass_Class extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            org.graalvm.compiler.hotspot.replacements.ClassGetHubNode node = new org.graalvm.compiler.hotspot.replacements.ClassGetHubNode(arg0);
            b.addPush(JavaKind.Object, node);
            return true;
        }
    }

    //        class: org.graalvm.compiler.hotspot.replacements.ClassGetHubNode
    //       method: readClass(java.lang.Class<?>,org.graalvm.compiler.nodes.extended.GuardingNode)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class ClassGetHubNode_readClass_Class_GuardingNode extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            org.graalvm.compiler.hotspot.replacements.ClassGetHubNode node = new org.graalvm.compiler.hotspot.replacements.ClassGetHubNode(arg0, arg1);
            b.addPush(JavaKind.Object, node);
            return true;
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new ClassGetHubNode_readClass_Class(), org.graalvm.compiler.hotspot.replacements.ClassGetHubNode.class, "readClass", java.lang.Class.class);
        plugins.register(new ClassGetHubNode_readClass_Class_GuardingNode(), org.graalvm.compiler.hotspot.replacements.ClassGetHubNode.class, "readClass", java.lang.Class.class, org.graalvm.compiler.nodes.extended.GuardingNode.class);
    }
}
