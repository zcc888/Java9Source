// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.hotspot.replacements.arraycopy;

import jdk.vm.ci.meta.ResolvedJavaMethod;
import org.graalvm.compiler.serviceprovider.ServiceProvider;

import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

@ServiceProvider(NodeIntrinsicPluginFactory.class)
public class PluginFactory_ArrayCopyUnrollNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.replacements.arraycopy.ArrayCopyUnrollNode
    //       method: arraycopy(java.lang.Object,int,java.lang.Object,int,int,int,jdk.vm.ci.meta.JavaKind)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class ArrayCopyUnrollNode_arraycopy extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            ValueNode arg4 = args[4];
            int arg5;
            if (args[5].isConstant()) {
                arg5 = args[5].asJavaConstant().asInt();
            } else {
                return false;
            }
            jdk.vm.ci.meta.JavaKind arg6;
            if (args[6].isConstant()) {
                arg6 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[6].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.hotspot.replacements.arraycopy.ArrayCopyUnrollNode node = new org.graalvm.compiler.hotspot.replacements.arraycopy.ArrayCopyUnrollNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
            b.add(node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private ArrayCopyUnrollNode_arraycopy(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new ArrayCopyUnrollNode_arraycopy(injection), org.graalvm.compiler.hotspot.replacements.arraycopy.ArrayCopyUnrollNode.class, "arraycopy", java.lang.Object.class, int.class, java.lang.Object.class, int.class, int.class, int.class, jdk.vm.ci.meta.JavaKind.class);
    }
}
