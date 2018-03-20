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
public class PluginFactory_ReinterpretNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.nodes.calc.ReinterpretNode
    //       method: reinterpret(jdk.vm.ci.meta.JavaKind,double)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class ReinterpretNode_reinterpret_JavaKind_double extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            jdk.vm.ci.meta.JavaKind arg0;
            if (args[0].isConstant()) {
                arg0 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[0].asJavaConstant());
            } else {
                return false;
            }
            ValueNode arg1 = args[1];
            org.graalvm.compiler.nodes.calc.ReinterpretNode node = new org.graalvm.compiler.nodes.calc.ReinterpretNode(arg0, arg1);
            b.addPush(JavaKind.Long, node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private ReinterpretNode_reinterpret_JavaKind_double(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    //        class: org.graalvm.compiler.nodes.calc.ReinterpretNode
    //       method: reinterpret(jdk.vm.ci.meta.JavaKind,float)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class ReinterpretNode_reinterpret_JavaKind_float extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            jdk.vm.ci.meta.JavaKind arg0;
            if (args[0].isConstant()) {
                arg0 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[0].asJavaConstant());
            } else {
                return false;
            }
            ValueNode arg1 = args[1];
            org.graalvm.compiler.nodes.calc.ReinterpretNode node = new org.graalvm.compiler.nodes.calc.ReinterpretNode(arg0, arg1);
            b.addPush(JavaKind.Int, node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private ReinterpretNode_reinterpret_JavaKind_float(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    //        class: org.graalvm.compiler.nodes.calc.ReinterpretNode
    //       method: reinterpret(jdk.vm.ci.meta.JavaKind,int)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class ReinterpretNode_reinterpret_JavaKind_int extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            jdk.vm.ci.meta.JavaKind arg0;
            if (args[0].isConstant()) {
                arg0 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[0].asJavaConstant());
            } else {
                return false;
            }
            ValueNode arg1 = args[1];
            org.graalvm.compiler.nodes.calc.ReinterpretNode node = new org.graalvm.compiler.nodes.calc.ReinterpretNode(arg0, arg1);
            b.addPush(JavaKind.Float, node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private ReinterpretNode_reinterpret_JavaKind_int(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    //        class: org.graalvm.compiler.nodes.calc.ReinterpretNode
    //       method: reinterpret(jdk.vm.ci.meta.JavaKind,long)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class ReinterpretNode_reinterpret_JavaKind_long extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            jdk.vm.ci.meta.JavaKind arg0;
            if (args[0].isConstant()) {
                arg0 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[0].asJavaConstant());
            } else {
                return false;
            }
            ValueNode arg1 = args[1];
            org.graalvm.compiler.nodes.calc.ReinterpretNode node = new org.graalvm.compiler.nodes.calc.ReinterpretNode(arg0, arg1);
            b.addPush(JavaKind.Double, node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private ReinterpretNode_reinterpret_JavaKind_long(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new ReinterpretNode_reinterpret_JavaKind_double(injection), org.graalvm.compiler.nodes.calc.ReinterpretNode.class, "reinterpret", jdk.vm.ci.meta.JavaKind.class, double.class);
        plugins.register(new ReinterpretNode_reinterpret_JavaKind_float(injection), org.graalvm.compiler.nodes.calc.ReinterpretNode.class, "reinterpret", jdk.vm.ci.meta.JavaKind.class, float.class);
        plugins.register(new ReinterpretNode_reinterpret_JavaKind_int(injection), org.graalvm.compiler.nodes.calc.ReinterpretNode.class, "reinterpret", jdk.vm.ci.meta.JavaKind.class, int.class);
        plugins.register(new ReinterpretNode_reinterpret_JavaKind_long(injection), org.graalvm.compiler.nodes.calc.ReinterpretNode.class, "reinterpret", jdk.vm.ci.meta.JavaKind.class, long.class);
    }
}
