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
package org.graalvm.compiler.salver;

import static org.graalvm.compiler.salver.SalverOptions.SalverAddress;
import static org.graalvm.compiler.salver.SalverOptions.SalverPort;

import java.net.InetSocketAddress;

import org.graalvm.compiler.salver.util.ECIDUtil;

public final class Salver {

    /**
     * The Execution Context Identifier is a unique identifier that simplifies the grouping of
     * events created in different DumpHandlers or Threads. It should be added as a special property
     * to all :begin trace events.
     */
    public static final String ECID = ECIDUtil.random();

    private Salver() {
    }

    public static InetSocketAddress getSocketAddress() {
        return new InetSocketAddress(SalverAddress.getValue(), SalverPort.getValue());
    }
}
