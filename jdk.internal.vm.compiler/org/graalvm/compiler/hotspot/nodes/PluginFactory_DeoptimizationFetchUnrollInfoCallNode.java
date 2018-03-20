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
public class PluginFactory_DeoptimizationFetchUnrollInfoCallNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.nodes.DeoptimizationFetchUnrollInfoCallNode
    //       method: fetchUnrollInfo(long,int)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class DeoptimizationFetchUnrollInfoCallNode_fetchUnrollInfo extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            org.graalvm.compiler.core.common.spi.ForeignCallsProvider arg0 = injectedForeignCallsProvider;
            ValueNode arg1 = args[0];
            ValueNode arg2 = args[1];
            org.graalvm.compiler.hotspot.nodes.DeoptimizationFetchUnrollInfoCallNode node = new org.graalvm.compiler.hotspot.nodes.DeoptimizationFetchUnrollInfoCallNode(arg0, arg1, arg2);
            b.addPush(JavaKind.Object, node);
            return true;
        }

        private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;

        private DeoptimizationFetchUnrollInfoCallNode_fetchUnrollInfo(InjectionProvider injection) {
            this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new DeoptimizationFetchUnrollInfoCallNode_fetchUnrollInfo(injection), org.graalvm.compiler.hotspot.nodes.DeoptimizationFetchUnrollInfoCallNode.class, "fetchUnrollInfo", long.class, int.class);
    }
}
