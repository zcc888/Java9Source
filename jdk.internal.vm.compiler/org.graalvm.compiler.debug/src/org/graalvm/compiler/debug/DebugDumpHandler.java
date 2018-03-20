/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.debug;

import java.io.Closeable;

public interface DebugDumpHandler extends Closeable {

    void dump(Object object, String message);

    /**
     * Flushes and releases resources managed by this dump handler. A subsequent call to
     * {@link #dump(Object, String)} will create and open new resources. That is, this method can be
     * used to reset the handler.
     */
    @Override
    void close();
}
