/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */

/**
 * Defines tools for analysing dependencies in Java libraries and programs,
 * including the <em>{@index jdeps jdeps tool}</em>,
 * <em>{@index javap javap tool}</em>, and
 * <em>{@index jdeprscan jdeprscan tool}</em> tools.
 *
 * <p>
 * This module provides the equivalent of command-line access to the
 * <em>javap</em> and <em>jdeps</em> tools via the
 * {@link java.util.spi.ToolProvider ToolProvider} service provider
 * interface (SPI)</p>
 *
 * <p> Instances of the tools can be obtained by calling
 * {@link java.util.spi.ToolProvider#findFirst ToolProvider.findFirst}
 * or the {@linkplain java.util.ServiceLoader service loader} with the name
 * {@code "javap"} or {@code "jdeps"} as appropriate.
 *
 * <p>
 * <em>jdeprscan</em> only exists as a command line tool, and does not provide
 * any direct API.
 *
 * <dl style="font-family:'DejaVu Sans', Arial, Helvetica, sans serif">
 * <dt class="simpleTagLabel">Tool Guides:
 * <dd>{@extLink javap_tool_reference javap},
 *     {@extLink jdeprscan_tool_reference jdeprscan},
 *     {@extLink jdeps_tool_reference jdeps}
 * </dl>
 *
 * @provides java.util.spi.ToolProvider
 *
 * @moduleGraph
 * @since 9
 */
module jdk.jdeps {
    // source file: file:///scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/langtools/src/jdk.jdeps/share/classes/module-info.java
    //              file:///scratch/opt/mach5/mesos/work_dir/jib-master/install/javafx/9.0.4/11/bundles/linux-x64/javafx-exports.zip/modules_src/jdk.jdeps/module-info.java.extra
    requires java.compiler;
    requires jdk.compiler;
    exports com.sun.tools.classfile to jdk.jlink;
    exports com.sun.tools.jdeps to jdk.packager;

    provides java.util.spi.ToolProvider with
        com.sun.tools.javap.Main.JavapToolProvider,
        com.sun.tools.jdeps.Main.JDepsToolProvider;
}
