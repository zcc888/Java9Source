/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
package jdk.tools.jaotc.collect;

public class SearchFor {
    private final String name;
    private final String type;

    public SearchFor(String name) {
        this(name, "");
    }

    public SearchFor(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public boolean isUnknown() {
        return "".equals(type);
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return type + ": " + name;
    }
}
