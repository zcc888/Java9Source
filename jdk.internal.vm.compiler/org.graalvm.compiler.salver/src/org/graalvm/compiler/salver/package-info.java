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
/**
 * <p>
 * This package provides the basic functionality to send debug dumps to a server that is able to
 * process Salver trace events.
 * </p>
 *
 * <p>
 * Salver is a Web Application Framework for Trace Visualization which defines an interface for
 * sending trace information via serializable events, e.g. as JSON text representation. Events are
 * grouped into separate namespaces to simplify event processing. Listeners can register for a
 * certain namespace and will receive all relevant events.
 * </p>
 *
 * <p>
 * In order to process trace events of this package the server needs to listen for the "graal/graph"
 * namespace.
 * </p>
 *
 * <p>
 * See {@link org.graalvm.compiler.salver.SalverOptions SalverOptions} for all available options.
 * <p>
 *
 * <p>
 * Basic components of this package:
 * <ul>
 * <li>DumpHandler:<br/>
 * Initialization of the corresponding Dumper in case a given object can be processed.</li>
 * <li>Dumper:<br/>
 * Processing the object about to be dumped and extract all necessary information in order to
 * produce a serializable data object.</li>
 * <li>Serializer:<br/>
 * Serializing a given data object, e.g. to a JSON text representation.</li>
 * <li>Writer:<br/>
 * Writing the actual data, e.g. to a WritableByteChannel.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Currently available {@link org.graalvm.compiler.debug.DebugDumpHandler DebugDumpHandlers}:
 * <ul>
 * <li>{@link org.graalvm.compiler.salver.handler.GraphDumpHandler GraphDumpHandler}:<br>
 * Dumps {@link org.graalvm.compiler.graph.Graph Graphs} (extracts almost the same information as
 * IGV's dump handler).</li>
 * </ul>
 * </p>
 */
package org.graalvm.compiler.salver;
