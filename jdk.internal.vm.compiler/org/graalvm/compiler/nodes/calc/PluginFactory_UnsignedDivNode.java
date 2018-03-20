// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.nodes.calc;

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
public class PluginFactory_UnsignedDivNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.nodes.calc.UnsignedDivNode
    //       method: unsignedDivide(int,int)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class UnsignedDivNode_unsignedDivide_int_int extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            org.graalvm.compiler.nodes.calc.UnsignedDivNode node = new org.graalvm.compiler.nodes.calc.UnsignedDivNode(arg0, arg1);
            b.addPush(JavaKind.Int, node);
            return true;
        }
    }

    //        class: org.graalvm.compiler.nodes.calc.UnsignedDivNode
    //       method: unsignedDivide(long,long)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class UnsignedDivNode_unsignedDivide_long_long extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            org.graalvm.compiler.nodes.calc.UnsignedDivNode node = new org.graalvm.compiler.nodes.calc.UnsignedDivNode(arg0, arg1);
            b.addPush(JavaKind.Long, node);
            return true;
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new UnsignedDivNode_unsignedDivide_int_int(), org.graalvm.compiler.nodes.calc.UnsignedDivNode.class, "unsignedDivide", int.class, int.class);
        plugins.register(new UnsignedDivNode_unsignedDivide_long_long(), org.graalvm.compiler.nodes.calc.UnsignedDivNode.class, "unsignedDivide", long.class, long.class);
    }
}
