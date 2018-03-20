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

import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaKind;
import org.graalvm.compiler.nodes.ConstantNode;

@ServiceProvider(NodeIntrinsicPluginFactory.class)
public class PluginFactory_NewObjectSnippets implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
    //       method: createName(java.lang.String,java.lang.String)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class NewObjectSnippets_createName extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            java.lang.String arg0;
            if (args[0].isConstant()) {
                arg0 = snippetReflection.asObject(java.lang.String.class, args[0].asJavaConstant());
            } else {
                return false;
            }
            java.lang.String arg1;
            if (args[1].isConstant()) {
                arg1 = snippetReflection.asObject(java.lang.String.class, args[1].asJavaConstant());
            } else {
                return false;
            }
            java.lang.String result = org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.createName(arg0, arg1);
            JavaConstant constant = b.getConstantReflection().forString(result);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Object, node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private NewObjectSnippets_createName(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    //        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
    //       method: doProfile()
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class NewObjectSnippets_doProfile extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            boolean result = org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.doProfile();
            JavaConstant constant = JavaConstant.forInt(result ? 1 : 0);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }
    }

    //        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
    //       method: dynamicNewArrayStub(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,java.lang.Class<?>,int)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
    private static final class NewObjectSnippets_dynamicNewArrayStub extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            org.graalvm.compiler.core.common.type.Stamp arg0 = returnStamp;
            org.graalvm.compiler.core.common.spi.ForeignCallsProvider arg1 = injectedForeignCallsProvider;
            org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg2;
            if (args[0].isConstant()) {
                arg2 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
            } else {
                return false;
            }
            ValueNode arg3 = args[1];
            ValueNode arg4 = args[2];
            return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3, arg4);
        }

        private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
        private final org.graalvm.compiler.core.common.type.Stamp returnStamp;

        private NewObjectSnippets_dynamicNewArrayStub(InjectionProvider injection) {
            this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
            this.returnStamp = injection.getReturnStamp(java.lang.Object.class, true);
        }
    }

    //        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
    //       method: dynamicNewInstanceStubCall(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,java.lang.Class<?>)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
    private static final class NewObjectSnippets_dynamicNewInstanceStubCall extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            org.graalvm.compiler.core.common.type.Stamp arg0 = returnStamp;
            org.graalvm.compiler.core.common.spi.ForeignCallsProvider arg1 = injectedForeignCallsProvider;
            org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg2;
            if (args[0].isConstant()) {
                arg2 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
            } else {
                return false;
            }
            ValueNode arg3 = args[1];
            return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3);
        }

        private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
        private final org.graalvm.compiler.core.common.type.Stamp returnStamp;

        private NewObjectSnippets_dynamicNewInstanceStubCall(InjectionProvider injection) {
            this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
            this.returnStamp = injection.getReturnStamp(java.lang.Object.class, true);
        }
    }

    //        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
    //       method: newArray(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.hotspot.word.KlassPointer,int,boolean)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
    private static final class NewObjectSnippets_newArray extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            org.graalvm.compiler.core.common.type.Stamp arg0 = returnStamp;
            org.graalvm.compiler.core.common.spi.ForeignCallsProvider arg1 = injectedForeignCallsProvider;
            org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg2;
            if (args[0].isConstant()) {
                arg2 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
            } else {
                return false;
            }
            ValueNode arg3 = args[1];
            ValueNode arg4 = args[2];
            ValueNode arg5 = args[3];
            return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3, arg4, arg5);
        }

        private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
        private final org.graalvm.compiler.core.common.type.Stamp returnStamp;

        private NewObjectSnippets_newArray(InjectionProvider injection) {
            this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
            this.returnStamp = injection.getReturnStamp(java.lang.Object.class, true);
        }
    }

    //        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
    //       method: newArrayCall(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.hotspot.word.KlassPointer,int,org.graalvm.compiler.word.Word)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
    private static final class NewObjectSnippets_newArrayCall extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            org.graalvm.compiler.core.common.type.Stamp arg0 = returnStamp;
            org.graalvm.compiler.core.common.spi.ForeignCallsProvider arg1 = injectedForeignCallsProvider;
            org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg2;
            if (args[0].isConstant()) {
                arg2 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
            } else {
                return false;
            }
            ValueNode arg3 = args[1];
            ValueNode arg4 = args[2];
            ValueNode arg5 = args[3];
            return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3, arg4, arg5);
        }

        private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
        private final org.graalvm.compiler.core.common.type.Stamp returnStamp;

        private NewObjectSnippets_newArrayCall(InjectionProvider injection) {
            this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
            this.returnStamp = injection.getReturnStamp(java.lang.Object.class, true);
        }
    }

    //        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
    //       method: newInstance(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.hotspot.word.KlassPointer)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
    private static final class NewObjectSnippets_newInstance extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            org.graalvm.compiler.core.common.type.Stamp arg0 = returnStamp;
            org.graalvm.compiler.core.common.spi.ForeignCallsProvider arg1 = injectedForeignCallsProvider;
            org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg2;
            if (args[0].isConstant()) {
                arg2 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
            } else {
                return false;
            }
            ValueNode arg3 = args[1];
            return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3);
        }

        private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
        private final org.graalvm.compiler.core.common.type.Stamp returnStamp;

        private NewObjectSnippets_newInstance(InjectionProvider injection) {
            this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
            this.returnStamp = injection.getReturnStamp(java.lang.Object.class, true);
        }
    }

    //        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
    //       method: withContext()
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedFoldPlugin
    private static final class NewObjectSnippets_withContext extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            boolean result = org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.withContext();
            JavaConstant constant = JavaConstant.forInt(result ? 1 : 0);
            ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
            b.push(JavaKind.Int, node);
            return true;
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new NewObjectSnippets_createName(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "createName", java.lang.String.class, java.lang.String.class);
        plugins.register(new NewObjectSnippets_doProfile(), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "doProfile");
        plugins.register(new NewObjectSnippets_dynamicNewArrayStub(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "dynamicNewArrayStub", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, java.lang.Class.class, int.class);
        plugins.register(new NewObjectSnippets_dynamicNewInstanceStubCall(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "dynamicNewInstanceStubCall", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, java.lang.Class.class);
        plugins.register(new NewObjectSnippets_newArray(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "newArray", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.hotspot.word.KlassPointer.class, int.class, boolean.class);
        plugins.register(new NewObjectSnippets_newArrayCall(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "newArrayCall", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.hotspot.word.KlassPointer.class, int.class, org.graalvm.compiler.word.Word.class);
        plugins.register(new NewObjectSnippets_newInstance(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "newInstance", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.hotspot.word.KlassPointer.class);
        plugins.register(new NewObjectSnippets_withContext(), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "withContext");
    }
}
