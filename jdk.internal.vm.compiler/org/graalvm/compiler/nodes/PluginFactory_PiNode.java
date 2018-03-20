// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.nodes;

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
public class PluginFactory_PiNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.nodes.PiNode
    //       method: asNonNullClassIntrinsic(java.lang.Object,java.lang.Class<?>,boolean,boolean)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class PiNode_asNonNullClassIntrinsic extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            jdk.vm.ci.meta.ResolvedJavaType arg1;
            if (args[1].isConstant()) {
                arg1 = b.getConstantReflection().asJavaType(args[1].asConstant());
            } else {
                return false;
            }
            boolean arg2;
            if (args[2].isConstant()) {
                arg2 = args[2].asJavaConstant().asInt() != 0;
            } else {
                return false;
            }
            boolean arg3;
            if (args[3].isConstant()) {
                arg3 = args[3].asJavaConstant().asInt() != 0;
            } else {
                return false;
            }
            org.graalvm.compiler.nodes.PiNode node = new org.graalvm.compiler.nodes.PiNode(arg0, arg1, arg2, arg3);
            b.addPush(JavaKind.Object, node);
            return true;
        }
    }

    //        class: org.graalvm.compiler.nodes.PiNode
    //       method: piCastNonNull(java.lang.Object,org.graalvm.compiler.nodes.extended.GuardingNode)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class PiNode_piCastNonNull extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            org.graalvm.compiler.nodes.PiNode node = new org.graalvm.compiler.nodes.PiNode(arg0, arg1);
            b.addPush(JavaKind.Object, node);
            return true;
        }
    }

    //        class: org.graalvm.compiler.nodes.PiNode
    //       method: piCast(java.lang.Object,java.lang.Class<?>,boolean,boolean)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class PiNode_piCast_Object_Class_boolean_boolean extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            jdk.vm.ci.meta.ResolvedJavaType arg1;
            if (args[1].isConstant()) {
                arg1 = b.getConstantReflection().asJavaType(args[1].asConstant());
            } else {
                return false;
            }
            boolean arg2;
            if (args[2].isConstant()) {
                arg2 = args[2].asJavaConstant().asInt() != 0;
            } else {
                return false;
            }
            boolean arg3;
            if (args[3].isConstant()) {
                arg3 = args[3].asJavaConstant().asInt() != 0;
            } else {
                return false;
            }
            org.graalvm.compiler.nodes.PiNode node = new org.graalvm.compiler.nodes.PiNode(arg0, arg1, arg2, arg3);
            b.addPush(JavaKind.Object, node);
            return true;
        }
    }

    //        class: org.graalvm.compiler.nodes.PiNode
    //       method: piCast(java.lang.Object,org.graalvm.compiler.core.common.type.Stamp)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class PiNode_piCast_Object_Stamp extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            org.graalvm.compiler.core.common.type.Stamp arg1;
            if (args[1].isConstant()) {
                arg1 = snippetReflection.asObject(org.graalvm.compiler.core.common.type.Stamp.class, args[1].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.nodes.PiNode node = new org.graalvm.compiler.nodes.PiNode(arg0, arg1);
            b.addPush(JavaKind.Object, node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private PiNode_piCast_Object_Stamp(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    //        class: org.graalvm.compiler.nodes.PiNode
    //       method: piCast(java.lang.Object,org.graalvm.compiler.core.common.type.Stamp,org.graalvm.compiler.nodes.extended.GuardingNode)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class PiNode_piCast_Object_Stamp_GuardingNode extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            org.graalvm.compiler.core.common.type.Stamp arg1;
            if (args[1].isConstant()) {
                arg1 = snippetReflection.asObject(org.graalvm.compiler.core.common.type.Stamp.class, args[1].asJavaConstant());
            } else {
                return false;
            }
            ValueNode arg2 = args[2];
            org.graalvm.compiler.nodes.PiNode node = new org.graalvm.compiler.nodes.PiNode(arg0, arg1, arg2);
            b.addPush(JavaKind.Object, node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private PiNode_piCast_Object_Stamp_GuardingNode(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new PiNode_asNonNullClassIntrinsic(), org.graalvm.compiler.nodes.PiNode.class, "asNonNullClassIntrinsic", java.lang.Object.class, java.lang.Class.class, boolean.class, boolean.class);
        plugins.register(new PiNode_piCastNonNull(), org.graalvm.compiler.nodes.PiNode.class, "piCastNonNull", java.lang.Object.class, org.graalvm.compiler.nodes.extended.GuardingNode.class);
        plugins.register(new PiNode_piCast_Object_Class_boolean_boolean(), org.graalvm.compiler.nodes.PiNode.class, "piCast", java.lang.Object.class, java.lang.Class.class, boolean.class, boolean.class);
        plugins.register(new PiNode_piCast_Object_Stamp(injection), org.graalvm.compiler.nodes.PiNode.class, "piCast", java.lang.Object.class, org.graalvm.compiler.core.common.type.Stamp.class);
        plugins.register(new PiNode_piCast_Object_Stamp_GuardingNode(injection), org.graalvm.compiler.nodes.PiNode.class, "piCast", java.lang.Object.class, org.graalvm.compiler.core.common.type.Stamp.class, org.graalvm.compiler.nodes.extended.GuardingNode.class);
    }
}
