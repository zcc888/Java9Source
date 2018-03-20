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
public class PluginFactory_ArrayCopySlowPathNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.replacements.arraycopy.ArrayCopySlowPathNode
    //       method: arraycopy(java.lang.Object,int,java.lang.Object,int,int,org.graalvm.compiler.hotspot.word.KlassPointer,jdk.vm.ci.meta.JavaKind,org.graalvm.compiler.replacements.SnippetTemplate.SnippetInfo,java.lang.Object)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class ArrayCopySlowPathNode_arraycopy extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            ValueNode arg4 = args[4];
            ValueNode arg5 = args[5];
            jdk.vm.ci.meta.JavaKind arg6;
            if (args[6].isConstant()) {
                arg6 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[6].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.replacements.SnippetTemplate.SnippetInfo arg7;
            if (args[7].isConstant()) {
                arg7 = snippetReflection.asObject(org.graalvm.compiler.replacements.SnippetTemplate.SnippetInfo.class, args[7].asJavaConstant());
            } else {
                return false;
            }
            java.lang.Object arg8;
            if (args[8].isConstant()) {
                arg8 = snippetReflection.asObject(java.lang.Object.class, args[8].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.hotspot.replacements.arraycopy.ArrayCopySlowPathNode node = new org.graalvm.compiler.hotspot.replacements.arraycopy.ArrayCopySlowPathNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
            b.add(node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private ArrayCopySlowPathNode_arraycopy(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new ArrayCopySlowPathNode_arraycopy(injection), org.graalvm.compiler.hotspot.replacements.arraycopy.ArrayCopySlowPathNode.class, "arraycopy", java.lang.Object.class, int.class, java.lang.Object.class, int.class, int.class, org.graalvm.compiler.hotspot.word.KlassPointer.class, jdk.vm.ci.meta.JavaKind.class, org.graalvm.compiler.replacements.SnippetTemplate.SnippetInfo.class, java.lang.Object.class);
    }
}
