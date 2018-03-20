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

public class ReadOnlyDataContainer extends ByteContainer {

    public ReadOnlyDataContainer(String containerName, SymbolTable symbolTable) {
        super(containerName, symbolTable);
    }
}
