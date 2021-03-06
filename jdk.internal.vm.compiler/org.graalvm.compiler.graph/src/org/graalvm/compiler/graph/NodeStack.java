/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.graph;

public final class NodeStack {

    private static final int INITIAL_SIZE = 8;

    protected Node[] values;
    public int tos;

    public NodeStack() {
        values = new Node[INITIAL_SIZE];
    }

    public void push(Node n) {
        int newIndex = tos++;
        int valuesLength = values.length;
        if (newIndex >= valuesLength) {
            grow();
        }
        values[newIndex] = n;
    }

    private void grow() {
        int valuesLength = values.length;
        Node[] newValues = new Node[valuesLength << 1];
        System.arraycopy(values, 0, newValues, 0, valuesLength);
        values = newValues;
    }

    public Node pop() {
        assert tos > 0 : "stack must be non-empty";
        return values[--tos];
    }

    public Node peek() {
        assert tos > 0 : "stack must be non-empty";
        return values[tos - 1];
    }

    public boolean isEmpty() {
        return tos == 0;
    }

    @Override
    public String toString() {
        if (tos == 0) {
            return "NodeStack: []";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tos; i++) {
            sb.append(", ");
            sb.append(values[i]);
        }
        return "NodeStack: [" + sb.substring(2) + "]";
    }
}
