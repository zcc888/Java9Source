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

package jdk.tools.jaotc.binformat;

import java.util.Objects;

import jdk.tools.jaotc.jnilibelf.ELFSymbol;

public class Symbol {

    public enum Binding {
        UNDEFINED,
        LOCAL,
        GLOBAL
    }

    public enum Kind {
        UNDEFINED,
        NATIVE_FUNCTION,
        JAVA_FUNCTION,
        STATIC_STUB_CALL, // static call stub inside the text section
        OBJECT,
        NOTYPE
    }

    private final String name;
    private final int size;
    private final int offset;
    private final Binding binding;
    private final Kind kind;

    private ByteContainer section;
    private ELFSymbol elfSymbol;

    /**
     * Create symbol info.
     *
     * @param offset section offset for the defined symbol
     * @param kind kind of the symbol (UNDEFINED, FUNC, etc)
     * @param binding binding of the symbol (LOCAL, GLOBAL, ...)
     * @param section section in which this symbol is "defined"
     * @param size size of the symbol
     * @param name name of the symbol
     */

    public Symbol(int offset, Kind kind, Binding binding, ByteContainer section, int size, String name) {
        this.binding = binding;
        this.kind = kind;
        this.section = section;
        this.size = size;
        this.offset = offset;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ELFSymbol getElfSymbol() {
        return elfSymbol;
    }

    public void setElfSymbol(ELFSymbol elfSymbol) {
        this.elfSymbol = elfSymbol;
    }

    public Binding getBinding() {
        return binding;
    }

    public Kind getKind() {
        return kind;
    }

    public int getSize() {
        return size;
    }

    public ByteContainer getSection() {
        return section;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Symbol)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Symbol symbol = (Symbol) obj;

        if (size != symbol.size) {
            return false;
        }
        if (offset != symbol.offset) {
            return false;
        }
        if (!name.equals(symbol.name)) {
            return false;
        }
        if (binding != symbol.binding) {
            return false;
        }
        if (kind != symbol.kind) {
            return false;
        }
        return !(section != null ? !section.equals(symbol.section) : symbol.section != null);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, binding, kind, section);
        result = 31 * result + size;
        result = 31 * result + offset;
        return result;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + size + ", " + offset + ", " + binding + ", " + kind + ", " + section + "]";
    }

}
