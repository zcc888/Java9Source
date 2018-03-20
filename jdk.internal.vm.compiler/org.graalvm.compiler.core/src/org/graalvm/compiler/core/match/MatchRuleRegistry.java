/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.core.match;

import static org.graalvm.compiler.debug.GraalDebugConfig.Options.LogVerbose;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.graalvm.compiler.core.gen.NodeMatchRules;
import org.graalvm.compiler.debug.Debug;
import org.graalvm.compiler.debug.Debug.Scope;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.graph.Edges;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.Position;
import org.graalvm.compiler.serviceprovider.GraalServices;

public class MatchRuleRegistry {

    /**
     * Convert a list of field names into {@link org.graalvm.compiler.graph.Position} objects that
     * can be used to read them during a match. The names should already have been confirmed to
     * exist in the type.
     *
     * @param nodeClass
     * @param names
     * @return an array of Position objects corresponding to the named fields.
     */
    public static Position[] findPositions(NodeClass<? extends Node> nodeClass, String[] names) {
        Position[] result = new Position[names.length];
        for (int i = 0; i < names.length; i++) {
            Edges edges = nodeClass.getInputEdges();
            for (int e = 0; e < edges.getDirectCount(); e++) {
                if (names[i].equals(edges.getName(e))) {
                    result[i] = new Position(edges, e, Node.NOT_ITERABLE);
                }
            }
            if (result[i] == null) {
                throw new GraalError("unknown field \"%s\" in class %s", names[i], nodeClass);
            }
        }
        return result;
    }

    private static final HashMap<Class<? extends NodeMatchRules>, Map<Class<? extends Node>, List<MatchStatement>>> registry = new HashMap<>();

    /**
     * Collect all the {@link MatchStatement}s defined by the superclass chain of theClass.
     *
     * @param theClass
     * @return the set of {@link MatchStatement}s applicable to theClass.
     */
    @SuppressWarnings("try")
    public static synchronized Map<Class<? extends Node>, List<MatchStatement>> lookup(Class<? extends NodeMatchRules> theClass) {
        Map<Class<? extends Node>, List<MatchStatement>> result = registry.get(theClass);

        if (result == null) {
            Map<Class<? extends Node>, List<MatchStatement>> rules = createRules(theClass);
            registry.put(theClass, rules);
            assert registry.get(theClass) == rules;
            result = rules;

            if (LogVerbose.getValue()) {
                try (Scope s = Debug.scope("MatchComplexExpressions")) {
                    Debug.log("Match rules for %s", theClass.getSimpleName());
                    for (Entry<Class<? extends Node>, List<MatchStatement>> entry : result.entrySet()) {
                        Debug.log("  For node class: %s", entry.getKey());
                        for (MatchStatement statement : entry.getValue()) {
                            Debug.log("    %s", statement.getPattern());
                        }
                    }
                }
            }
        }

        if (result.size() == 0) {
            return null;
        }
        return result;
    }

    /*
     * This is a separate, public method so that external clients can create rules with a custom
     * lookup and without the default caching behavior.
     */
    public static Map<Class<? extends Node>, List<MatchStatement>> createRules(Class<? extends NodeMatchRules> theClass) {
        HashMap<Class<? extends NodeMatchRules>, MatchStatementSet> matchSets = new HashMap<>();
        Iterable<MatchStatementSet> sl = GraalServices.load(MatchStatementSet.class);
        for (MatchStatementSet rules : sl) {
            matchSets.put(rules.forClass(), rules);
        }

        // Walk the class hierarchy collecting lists and merge them together. The subclass
        // rules are first which gives them preference over earlier rules.
        Map<Class<? extends Node>, List<MatchStatement>> rules = new HashMap<>();
        Class<?> currentClass = theClass;
        do {
            MatchStatementSet matchSet = matchSets.get(currentClass);
            if (matchSet != null) {
                List<MatchStatement> statements = matchSet.statements();
                for (MatchStatement statement : statements) {
                    Class<? extends Node> nodeClass = statement.getPattern().nodeClass();
                    List<MatchStatement> current = rules.get(nodeClass);
                    if (current == null) {
                        current = new ArrayList<>();
                        rules.put(nodeClass, current);
                    }
                    current.add(statement);
                }
            }
            currentClass = currentClass.getSuperclass();
        } while (currentClass != NodeMatchRules.class);
        return rules;
    }
}
