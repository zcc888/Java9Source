/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes.extended;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ResolvedJavaMethod;

import org.graalvm.compiler.core.common.LocationIdentity;
import org.graalvm.compiler.graph.Node.ConstantNodeParameter;
import org.graalvm.compiler.graph.Node.NodeIntrinsic;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;

/**
 * Copy a value at a location specified as an offset relative to a source object to another location
 * specified as an offset relative to destination object. No null checks are performed.
 */
public final class UnsafeCopyNode {

    public static boolean intrinsify(GraphBuilderContext b, @SuppressWarnings("unused") ResolvedJavaMethod targetMethod, ValueNode sourceObject, ValueNode sourceOffset, ValueNode destinationObject,
                    ValueNode destinationOffset, JavaKind accessKind, LocationIdentity locationIdentity) {
        UnsafeLoadNode value = b.add(new UnsafeLoadNode(sourceObject, sourceOffset, accessKind, locationIdentity));
        b.add(new UnsafeStoreNode(destinationObject, destinationOffset, value, accessKind, locationIdentity));
        return true;
    }

    @NodeIntrinsic
    public static native void copy(Object srcObject, long srcOffset, Object destObject, long destOffset, @ConstantNodeParameter JavaKind kind,
                    @ConstantNodeParameter LocationIdentity locationIdentity);
}
