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
package org.graalvm.compiler.salver.handler;

import java.io.IOException;

import org.graalvm.compiler.graph.Graph;
import org.graalvm.compiler.salver.dumper.GraphDumper;

public class GraphDumpHandler extends AbstractGraalDumpHandler<GraphDumper> {

    @Override
    protected GraphDumper createDumper() {
        return new GraphDumper();
    }

    @Override
    public void handle(Object obj, String msg) throws IOException {
        if (obj instanceof Graph) {
            ensureInitialized();
            dumper.dump((Graph) obj, msg);
        }
    }
}
