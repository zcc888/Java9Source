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
package org.graalvm.compiler.salver.dumper;

import java.io.IOException;

import org.graalvm.compiler.salver.Salver;
import org.graalvm.compiler.salver.data.DataDict;

public class AbstractGraalDumper extends AbstractSerializerDumper {

    public static final String EVENT_NAMESPACE = "graal";

    private int eventCounter;

    public void beginDump() throws IOException {
        beginDump(EVENT_NAMESPACE);
    }

    protected void beginDump(String namespace) throws IOException {
        beginDump(namespace, getBeginDumpDataDict());
    }

    protected void beginDump(String namespace, DataDict dataDict) throws IOException {
        DataDict eventDict = createEventDict(":begin");
        eventDict.put("@time", System.currentTimeMillis());
        eventDict.put("@ecid", Salver.ECID);
        if (namespace != null) {
            eventDict.put("@namespace", namespace);
        }
        if (dataDict != null) {
            eventDict.put("@data", dataDict);
        }
        serializeAndFlush(eventDict);
    }

    protected DataDict getBeginDumpDataDict() {
        DataDict dataDict = new DataDict();
        dataDict.put("dumper", getClass().getSimpleName());
        dataDict.put("thread", Thread.currentThread().getName());
        return dataDict;
    }

    public void endDump() throws IOException {
        DataDict eventDict = createEventDict(":end");
        eventDict.put("@time", System.currentTimeMillis());
        serializeAndFlush(eventDict);
    }

    @Override
    public void close() throws IOException {
        endDump();
    }

    protected DataDict createEventDict(String name) {
        DataDict eventDict = new DataDict();
        eventDict.put("@event", name);
        eventDict.put("@n", eventCounter++);
        return eventDict;
    }

    protected DataDict createEventDict(String name, DataDict data) {
        DataDict eventDict = createEventDict(name);
        eventDict.put("@data", data);
        return eventDict;
    }
}
