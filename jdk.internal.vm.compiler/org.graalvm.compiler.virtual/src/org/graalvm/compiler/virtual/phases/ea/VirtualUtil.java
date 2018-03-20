/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.virtual.phases.ea;

import static org.graalvm.compiler.core.common.GraalOptions.TraceEscapeAnalysis;

import java.util.List;
import java.util.Map;

import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.debug.TTY;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeFlood;
import org.graalvm.compiler.nodes.AbstractEndNode;
import org.graalvm.compiler.nodes.FixedNode;
import org.graalvm.compiler.nodes.StructuredGraph;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public final class VirtualUtil {

    private VirtualUtil() {
        GraalError.shouldNotReachHere();
    }

    public static boolean assertNonReachable(StructuredGraph graph, List<Node> obsoleteNodes) {
        // helper code that determines the paths that keep obsolete nodes alive:

        NodeFlood flood = graph.createNodeFlood();
        Map<Node, Node> path = Node.newIdentityMap();
        flood.add(graph.start());
        for (Node current : flood) {
            if (current instanceof AbstractEndNode) {
                AbstractEndNode end = (AbstractEndNode) current;
                flood.add(end.merge());
                if (!path.containsKey(end.merge())) {
                    path.put(end.merge(), end);
                }
            } else {
                for (Node successor : current.successors()) {
                    flood.add(successor);
                    if (!path.containsKey(successor)) {
                        path.put(successor, current);
                    }
                }
            }
        }

        for (Node node : obsoleteNodes) {
            if (node instanceof FixedNode && !node.isDeleted()) {
                assert !flood.isMarked(node) : node;
            }
        }

        for (Node node : graph.getNodes()) {
            if (flood.isMarked(node)) {
                for (Node input : node.inputs()) {
                    flood.add(input);
                    if (!path.containsKey(input)) {
                        path.put(input, node);
                    }
                }
            }
        }
        for (Node current : flood) {
            for (Node input : current.inputs()) {
                flood.add(input);
                if (!path.containsKey(input)) {
                    path.put(input, current);
                }
            }
        }
        boolean success = true;
        for (Node node : obsoleteNodes) {
            if (!node.isDeleted() && flood.isMarked(node)) {
                TTY.println("offending node path:");
                Node current = node;
                TTY.print(current.toString());
                while (true) {
                    current = path.get(current);
                    if (current != null) {
                        TTY.print(" -> " + current.toString());
                        if (current instanceof FixedNode && !obsoleteNodes.contains(current)) {
                            break;
                        }
                    }
                }
                success = false;
            }
        }
        if (!success) {
            TTY.println();
            Debug.dump(Debug.BASIC_LOG_LEVEL, graph, "assertNonReachable");
        }
        return success;
    }

    public static void trace(String format) {
        if (Debug.isEnabled() && TraceEscapeAnalysis.getValue() && Debug.isLogEnabled()) {
            Debug.logv(format);
        }
    }

    public static void trace(String format, Object obj) {
        if (Debug.isEnabled() && TraceEscapeAnalysis.getValue() && Debug.isLogEnabled()) {
            Debug.logv(format, obj);
        }
    }

    public static void trace(String format, Object obj, Object obj2) {
        if (Debug.isEnabled() && TraceEscapeAnalysis.getValue() && Debug.isLogEnabled()) {
            Debug.logv(format, obj, obj2);
        }
    }

    public static void trace(String format, Object obj, Object obj2, Object obj3) {
        if (Debug.isEnabled() && TraceEscapeAnalysis.getValue() && Debug.isLogEnabled()) {
            Debug.logv(format, obj, obj2, obj3);
        }
    }

    public static void trace(String format, Object obj, Object obj2, Object obj3, Object obj4) {
        if (Debug.isEnabled() && TraceEscapeAnalysis.getValue() && Debug.isLogEnabled()) {
            Debug.logv(format, obj, obj2, obj3, obj4);
        }
    }

    public static boolean matches(StructuredGraph graph, String filter) {
        if (filter != null) {
            return matchesHelper(graph, filter);
        }
        return true;
    }

    private static boolean matchesHelper(StructuredGraph graph, String filter) {
        if (filter.startsWith("~")) {
            ResolvedJavaMethod method = graph.method();
            return method == null || !method.format("%H.%n").contains(filter.substring(1));
        } else {
            ResolvedJavaMethod method = graph.method();
            return method != null && method.format("%H.%n").contains(filter);
        }
    }
}
