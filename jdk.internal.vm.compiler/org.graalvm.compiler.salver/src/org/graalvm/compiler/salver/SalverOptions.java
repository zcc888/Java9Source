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

import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.OptionValue;

public final class SalverOptions {

    //@formatter:off
    @Option(help = "Enable dumps via Salver trace events.", type = OptionType.Debug)
    public static final OptionValue<Boolean> Salver = new OptionValue<>(false);

    @Option(help = "Network address (Salver).", type = OptionType.Debug)
    public static final OptionValue<String> SalverAddress = new OptionValue<>("127.0.0.1");

    @Option(help = "Network port (Salver).", type = OptionType.Debug)
    public static final OptionValue<Integer> SalverPort = new OptionValue<>(2343);

    @Option(help = "Dump to files as opposed to sending them over the network (Salver).", type = OptionType.Debug)
    public static final OptionValue<Boolean> SalverToFile = new OptionValue<>(false);

    //@Option(help = "Use binary format for dumps (Salver).", type = OptionType.Debug)
    //public static final OptionValue<Boolean> SalverDumpBinary = new OptionValue<>(false);
    //@formatter:on
}
