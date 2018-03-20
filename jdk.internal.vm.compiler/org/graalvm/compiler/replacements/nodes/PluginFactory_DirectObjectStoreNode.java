// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.replacements.nodes;

import jdk.vm.ci.meta.ResolvedJavaMethod;
import org.graalvm.compiler.serviceprovider.ServiceProvider;

import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

@ServiceProvider(NodeIntrinsicPluginFactory.class)
public class PluginFactory_DirectObjectStoreNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode
    //       method: storeBoolean(java.lang.Object,int,long,boolean,org.graalvm.compiler.core.common.LocationIdentity,jdk.vm.ci.meta.JavaKind)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class DirectObjectStoreNode_storeBoolean extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            int arg1;
            if (args[1].isConstant()) {
                arg1 = args[1].asJavaConstant().asInt();
            } else {
                return false;
            }
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            org.graalvm.compiler.core.common.LocationIdentity arg4;
            if (args[4].isConstant()) {
                arg4 = snippetReflection.asObject(org.graalvm.compiler.core.common.LocationIdentity.class, args[4].asJavaConstant());
            } else {
                return false;
            }
            jdk.vm.ci.meta.JavaKind arg5;
            if (args[5].isConstant()) {
                arg5 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[5].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode node = new org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode(arg0, arg1, arg2, arg3, arg4, arg5);
            b.add(node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private DirectObjectStoreNode_storeBoolean(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    //        class: org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode
    //       method: storeByte(java.lang.Object,int,long,byte,org.graalvm.compiler.core.common.LocationIdentity,jdk.vm.ci.meta.JavaKind)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class DirectObjectStoreNode_storeByte extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            int arg1;
            if (args[1].isConstant()) {
                arg1 = args[1].asJavaConstant().asInt();
            } else {
                return false;
            }
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            org.graalvm.compiler.core.common.LocationIdentity arg4;
            if (args[4].isConstant()) {
                arg4 = snippetReflection.asObject(org.graalvm.compiler.core.common.LocationIdentity.class, args[4].asJavaConstant());
            } else {
                return false;
            }
            jdk.vm.ci.meta.JavaKind arg5;
            if (args[5].isConstant()) {
                arg5 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[5].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode node = new org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode(arg0, arg1, arg2, arg3, arg4, arg5);
            b.add(node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private DirectObjectStoreNode_storeByte(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    //        class: org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode
    //       method: storeChar(java.lang.Object,int,long,char,org.graalvm.compiler.core.common.LocationIdentity,jdk.vm.ci.meta.JavaKind)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class DirectObjectStoreNode_storeChar extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            int arg1;
            if (args[1].isConstant()) {
                arg1 = args[1].asJavaConstant().asInt();
            } else {
                return false;
            }
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            org.graalvm.compiler.core.common.LocationIdentity arg4;
            if (args[4].isConstant()) {
                arg4 = snippetReflection.asObject(org.graalvm.compiler.core.common.LocationIdentity.class, args[4].asJavaConstant());
            } else {
                return false;
            }
            jdk.vm.ci.meta.JavaKind arg5;
            if (args[5].isConstant()) {
                arg5 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[5].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode node = new org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode(arg0, arg1, arg2, arg3, arg4, arg5);
            b.add(node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private DirectObjectStoreNode_storeChar(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    //        class: org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode
    //       method: storeDouble(java.lang.Object,int,long,double,org.graalvm.compiler.core.common.LocationIdentity,jdk.vm.ci.meta.JavaKind)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class DirectObjectStoreNode_storeDouble extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            int arg1;
            if (args[1].isConstant()) {
                arg1 = args[1].asJavaConstant().asInt();
            } else {
                return false;
            }
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            org.graalvm.compiler.core.common.LocationIdentity arg4;
            if (args[4].isConstant()) {
                arg4 = snippetReflection.asObject(org.graalvm.compiler.core.common.LocationIdentity.class, args[4].asJavaConstant());
            } else {
                return false;
            }
            jdk.vm.ci.meta.JavaKind arg5;
            if (args[5].isConstant()) {
                arg5 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[5].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode node = new org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode(arg0, arg1, arg2, arg3, arg4, arg5);
            b.add(node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private DirectObjectStoreNode_storeDouble(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    //        class: org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode
    //       method: storeFloat(java.lang.Object,int,long,float,org.graalvm.compiler.core.common.LocationIdentity,jdk.vm.ci.meta.JavaKind)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class DirectObjectStoreNode_storeFloat extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            int arg1;
            if (args[1].isConstant()) {
                arg1 = args[1].asJavaConstant().asInt();
            } else {
                return false;
            }
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            org.graalvm.compiler.core.common.LocationIdentity arg4;
            if (args[4].isConstant()) {
                arg4 = snippetReflection.asObject(org.graalvm.compiler.core.common.LocationIdentity.class, args[4].asJavaConstant());
            } else {
                return false;
            }
            jdk.vm.ci.meta.JavaKind arg5;
            if (args[5].isConstant()) {
                arg5 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[5].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode node = new org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode(arg0, arg1, arg2, arg3, arg4, arg5);
            b.add(node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private DirectObjectStoreNode_storeFloat(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    //        class: org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode
    //       method: storeInt(java.lang.Object,int,long,int,org.graalvm.compiler.core.common.LocationIdentity,jdk.vm.ci.meta.JavaKind)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class DirectObjectStoreNode_storeInt extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            int arg1;
            if (args[1].isConstant()) {
                arg1 = args[1].asJavaConstant().asInt();
            } else {
                return false;
            }
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            org.graalvm.compiler.core.common.LocationIdentity arg4;
            if (args[4].isConstant()) {
                arg4 = snippetReflection.asObject(org.graalvm.compiler.core.common.LocationIdentity.class, args[4].asJavaConstant());
            } else {
                return false;
            }
            jdk.vm.ci.meta.JavaKind arg5;
            if (args[5].isConstant()) {
                arg5 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[5].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode node = new org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode(arg0, arg1, arg2, arg3, arg4, arg5);
            b.add(node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private DirectObjectStoreNode_storeInt(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    //        class: org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode
    //       method: storeLong(java.lang.Object,int,long,long,org.graalvm.compiler.core.common.LocationIdentity,jdk.vm.ci.meta.JavaKind)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class DirectObjectStoreNode_storeLong extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            int arg1;
            if (args[1].isConstant()) {
                arg1 = args[1].asJavaConstant().asInt();
            } else {
                return false;
            }
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            org.graalvm.compiler.core.common.LocationIdentity arg4;
            if (args[4].isConstant()) {
                arg4 = snippetReflection.asObject(org.graalvm.compiler.core.common.LocationIdentity.class, args[4].asJavaConstant());
            } else {
                return false;
            }
            jdk.vm.ci.meta.JavaKind arg5;
            if (args[5].isConstant()) {
                arg5 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[5].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode node = new org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode(arg0, arg1, arg2, arg3, arg4, arg5);
            b.add(node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private DirectObjectStoreNode_storeLong(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    //        class: org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode
    //       method: storeObject(java.lang.Object,int,long,java.lang.Object,org.graalvm.compiler.core.common.LocationIdentity,jdk.vm.ci.meta.JavaKind)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class DirectObjectStoreNode_storeObject extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            int arg1;
            if (args[1].isConstant()) {
                arg1 = args[1].asJavaConstant().asInt();
            } else {
                return false;
            }
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            org.graalvm.compiler.core.common.LocationIdentity arg4;
            if (args[4].isConstant()) {
                arg4 = snippetReflection.asObject(org.graalvm.compiler.core.common.LocationIdentity.class, args[4].asJavaConstant());
            } else {
                return false;
            }
            jdk.vm.ci.meta.JavaKind arg5;
            if (args[5].isConstant()) {
                arg5 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[5].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode node = new org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode(arg0, arg1, arg2, arg3, arg4, arg5);
            b.add(node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private DirectObjectStoreNode_storeObject(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    //        class: org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode
    //       method: storeShort(java.lang.Object,int,long,short,org.graalvm.compiler.core.common.LocationIdentity,jdk.vm.ci.meta.JavaKind)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class DirectObjectStoreNode_storeShort extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            int arg1;
            if (args[1].isConstant()) {
                arg1 = args[1].asJavaConstant().asInt();
            } else {
                return false;
            }
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            org.graalvm.compiler.core.common.LocationIdentity arg4;
            if (args[4].isConstant()) {
                arg4 = snippetReflection.asObject(org.graalvm.compiler.core.common.LocationIdentity.class, args[4].asJavaConstant());
            } else {
                return false;
            }
            jdk.vm.ci.meta.JavaKind arg5;
            if (args[5].isConstant()) {
                arg5 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[5].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode node = new org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode(arg0, arg1, arg2, arg3, arg4, arg5);
            b.add(node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private DirectObjectStoreNode_storeShort(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new DirectObjectStoreNode_storeBoolean(injection), org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode.class, "storeBoolean", java.lang.Object.class, int.class, long.class, boolean.class, org.graalvm.compiler.core.common.LocationIdentity.class, jdk.vm.ci.meta.JavaKind.class);
        plugins.register(new DirectObjectStoreNode_storeByte(injection), org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode.class, "storeByte", java.lang.Object.class, int.class, long.class, byte.class, org.graalvm.compiler.core.common.LocationIdentity.class, jdk.vm.ci.meta.JavaKind.class);
        plugins.register(new DirectObjectStoreNode_storeChar(injection), org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode.class, "storeChar", java.lang.Object.class, int.class, long.class, char.class, org.graalvm.compiler.core.common.LocationIdentity.class, jdk.vm.ci.meta.JavaKind.class);
        plugins.register(new DirectObjectStoreNode_storeDouble(injection), org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode.class, "storeDouble", java.lang.Object.class, int.class, long.class, double.class, org.graalvm.compiler.core.common.LocationIdentity.class, jdk.vm.ci.meta.JavaKind.class);
        plugins.register(new DirectObjectStoreNode_storeFloat(injection), org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode.class, "storeFloat", java.lang.Object.class, int.class, long.class, float.class, org.graalvm.compiler.core.common.LocationIdentity.class, jdk.vm.ci.meta.JavaKind.class);
        plugins.register(new DirectObjectStoreNode_storeInt(injection), org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode.class, "storeInt", java.lang.Object.class, int.class, long.class, int.class, org.graalvm.compiler.core.common.LocationIdentity.class, jdk.vm.ci.meta.JavaKind.class);
        plugins.register(new DirectObjectStoreNode_storeLong(injection), org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode.class, "storeLong", java.lang.Object.class, int.class, long.class, long.class, org.graalvm.compiler.core.common.LocationIdentity.class, jdk.vm.ci.meta.JavaKind.class);
        plugins.register(new DirectObjectStoreNode_storeObject(injection), org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode.class, "storeObject", java.lang.Object.class, int.class, long.class, java.lang.Object.class, org.graalvm.compiler.core.common.LocationIdentity.class, jdk.vm.ci.meta.JavaKind.class);
        plugins.register(new DirectObjectStoreNode_storeShort(injection), org.graalvm.compiler.replacements.nodes.DirectObjectStoreNode.class, "storeShort", java.lang.Object.class, int.class, long.class, short.class, org.graalvm.compiler.core.common.LocationIdentity.class, jdk.vm.ci.meta.JavaKind.class);
    }
}
