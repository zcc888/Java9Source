// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.nodes.extended;

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
public class PluginFactory_UnsafeLoadNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.nodes.extended.UnsafeLoadNode
    //       method: load(java.lang.Object,long,jdk.vm.ci.meta.JavaKind,org.graalvm.compiler.core.common.LocationIdentity)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class UnsafeLoadNode_load extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            jdk.vm.ci.meta.JavaKind arg2;
            if (args[2].isConstant()) {
                arg2 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[2].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.core.common.LocationIdentity arg3;
            if (args[3].isConstant()) {
                arg3 = snippetReflection.asObject(org.graalvm.compiler.core.common.LocationIdentity.class, args[3].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.nodes.extended.UnsafeLoadNode node = new org.graalvm.compiler.nodes.extended.UnsafeLoadNode(arg0, arg1, arg2, arg3);
            b.addPush(JavaKind.Object, node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private UnsafeLoadNode_load(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new UnsafeLoadNode_load(injection), org.graalvm.compiler.nodes.extended.UnsafeLoadNode.class, "load", java.lang.Object.class, long.class, jdk.vm.ci.meta.JavaKind.class, org.graalvm.compiler.core.common.LocationIdentity.class);
    }
}
