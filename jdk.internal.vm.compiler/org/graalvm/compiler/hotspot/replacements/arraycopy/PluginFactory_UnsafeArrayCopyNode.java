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
public class PluginFactory_UnsafeArrayCopyNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.replacements.arraycopy.UnsafeArrayCopyNode
    //       method: arraycopy(java.lang.Object,int,java.lang.Object,int,int,jdk.vm.ci.meta.JavaKind)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class UnsafeArrayCopyNode_arraycopy extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            ValueNode arg4 = args[4];
            jdk.vm.ci.meta.JavaKind arg5;
            if (args[5].isConstant()) {
                arg5 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[5].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.hotspot.replacements.arraycopy.UnsafeArrayCopyNode node = new org.graalvm.compiler.hotspot.replacements.arraycopy.UnsafeArrayCopyNode(arg0, arg1, arg2, arg3, arg4, arg5);
            b.add(node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private UnsafeArrayCopyNode_arraycopy(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.replacements.arraycopy.UnsafeArrayCopyNode
    //       method: arraycopyPrimitive(java.lang.Object,int,java.lang.Object,int,int,int)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class UnsafeArrayCopyNode_arraycopyPrimitive extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            ValueNode arg4 = args[4];
            ValueNode arg5 = args[5];
            org.graalvm.compiler.hotspot.replacements.arraycopy.UnsafeArrayCopyNode node = new org.graalvm.compiler.hotspot.replacements.arraycopy.UnsafeArrayCopyNode(arg0, arg1, arg2, arg3, arg4, arg5);
            b.add(node);
            return true;
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new UnsafeArrayCopyNode_arraycopy(injection), org.graalvm.compiler.hotspot.replacements.arraycopy.UnsafeArrayCopyNode.class, "arraycopy", java.lang.Object.class, int.class, java.lang.Object.class, int.class, int.class, jdk.vm.ci.meta.JavaKind.class);
        plugins.register(new UnsafeArrayCopyNode_arraycopyPrimitive(), org.graalvm.compiler.hotspot.replacements.arraycopy.UnsafeArrayCopyNode.class, "arraycopyPrimitive", java.lang.Object.class, int.class, java.lang.Object.class, int.class, int.class, int.class);
    }
}
