/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jaotc.jnilibelf;

/**
 * This class represents a {@code Elf32_Sym} or {@code Elf64_Sym} as defined in {@code elf.h}.
 */
public class ELFSymbol {
    /** Symbol name. */
    private final String name;

    /** String table index. */
    private final int index;

    /** Native memory address of ELF sym entry. */
    private final Pointer address;
    private final boolean isLocal;

    public ELFSymbol(String name, int index, Pointer address, boolean isLocal) {
        this.name = name;
        this.index = index;
        this.address = address;
        this.isLocal = isLocal;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @return the address
     */
    public Pointer getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "name=" + name + ", index=" + index + ", address=" + address;
    }

    public boolean isLocal() {
        return isLocal;
    }
}
