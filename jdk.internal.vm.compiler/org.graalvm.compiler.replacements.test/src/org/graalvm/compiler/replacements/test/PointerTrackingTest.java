/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.graalvm.compiler.replacements.test;

import org.junit.Test;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.DebugConfigScope;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration.Plugins;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins.Registration;
import org.graalvm.compiler.replacements.Snippets;
import org.graalvm.compiler.word.Word;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public class PointerTrackingTest extends GraalCompilerTest implements Snippets {

    @Test
    public void testTracking() {
        Result result = executeActual(getResolvedJavaMethod("trackingSnippet"), null, new Object());
        assertEquals(new Result("OK", null), result);
    }

    public static String trackingSnippet(Object obj) {
        long trackedBeforeGC = getTrackedPointer(obj);
        long untrackedBeforeGC = getUntrackedPointer(obj);

        int i = 0;
        while (untrackedBeforeGC == getTrackedPointer(obj)) {
            System.gc();
            if (i++ > 100) {
                return "Timeout! Object didn't move after 100 GCs.";
            }
        }

        long trackedAfterGC = getTrackedPointer(obj);
        long untrackedAfterGC = getUntrackedPointer(obj);

        if (untrackedBeforeGC == untrackedAfterGC) {
            /*
             * The untracked pointer isn't supposed to be updated, so it should be different before
             * and after GC.
             */
            return "untrackedBeforeGC == untrackedAfterGC";
        }
        if (trackedBeforeGC != trackedAfterGC) {
            /*
             * The trackedBeforeGC variable should be updated to the new location by the GC, so it
             * should be equal to trackedAfterGC.
             */
            return "trackedBeforeGC != trackedAfterGC";
        }

        return "OK";
    }

    @Test(expected = GraalError.class)
    @SuppressWarnings("try")
    public void testVerification() {
        try (DebugConfigScope scope = Debug.disableIntercept()) {
            compile(getResolvedJavaMethod("verificationSnippet"), null);
        }
    }

    public static long verificationSnippet(Object obj) {
        long value = getTrackedPointer(obj) * 7 + 3;

        /*
         * Ensure usage before and after GC to force the value to be alive across the safepoint.
         * This should lead to a compiler error, since value can not be tracked in the reference
         * map.
         */
        GraalDirectives.blackhole(value);
        System.gc();
        return value;
    }

    static long getTrackedPointer(@SuppressWarnings("unused") Object obj) {
        throw GraalError.shouldNotReachHere("should be intrinsified");
    }

    static long getUntrackedPointer(@SuppressWarnings("unused") Object obj) {
        throw GraalError.shouldNotReachHere("should be intrinsified");
    }

    static long getTrackedPointerIntrinsic(Object obj) {
        return Word.objectToTrackedPointer(obj).rawValue();
    }

    static long getUntrackedPointerIntrinsic(Object obj) {
        return Word.objectToUntrackedPointer(obj).rawValue();
    }

    private void register(Registration r, String fnName) {
        ResolvedJavaMethod intrinsic = getResolvedJavaMethod(fnName + "Intrinsic");
        r.register1(fnName, Object.class, new InvocationPlugin() {
            @Override
            public boolean apply(GraphBuilderContext b, ResolvedJavaMethod targetMethod, Receiver receiver, ValueNode arg) {
                return b.intrinsify(getReplacements().getReplacementBytecodeProvider(), targetMethod, intrinsic, receiver, new ValueNode[]{arg});
            }
        });
    }

    @Override
    protected Plugins getDefaultGraphBuilderPlugins() {
        Plugins plugins = super.getDefaultGraphBuilderPlugins();
        Registration r = new Registration(plugins.getInvocationPlugins(), PointerTrackingTest.class);

        register(r, "getTrackedPointer");
        register(r, "getUntrackedPointer");

        return plugins;
    }
}
