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
 *
 *
 */

/**
 * Defines the <em>{@index jlink jlink tool}</em> tool for creating run-time
 * images, the <em>{@index jmod jmod tool}</em> tool for creating and manipulating
 * JMOD files, and the <em>{@index jimage jimage tool}</em> tool for inspecting
 * the JDK implementation-specific container file for classes and resources.
 *
 * <p> This module provides the equivalent of command-line access to the
 * <em>{@extLink jlink_tool_reference jlink}</em> and
 * <em>{@extLink jmod_tool_reference jmod}</em> tools via the
 * {@link java.util.spi.ToolProvider ToolProvider} SPI.
 * Instances of the tools can be obtained by calling
 * {@link java.util.spi.ToolProvider#findFirst ToolProvider.findFirst}
 * or the {@link java.util.ServiceLoader service loader} with the name
 * {@code "jlink"} or {@code "jmod"} as appropriate.
 *
 * <p> <em>{@extLink jimage_tool_reference jimage}</em> only exists
 * as a command-line tool, and does not provide any direct API.
 *
 * <dl style="font-family:'DejaVu Sans', Arial, Helvetica, sans serif">
 * <dt class="simpleTagLabel">Tool Guides:
 * <dd>{@extLink jlink_tool_reference jlink},
 *     {@extLink jmod_tool_reference jmod},
 *     {@extLink jimage_tool_reference jimage}
 * </dl>
 *
 * @provides java.util.spi.ToolProvider
 *
 * @moduleGraph
 * @since 9
 */
module jdk.jlink {
    // source file: file:///scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/jdk/src/jdk.jlink/share/classes/module-info.java
    //              file:///scratch/opt/mach5/mesos/work_dir/jib-master/install/javafx/9.0.4/11/bundles/linux-x64/javafx-exports.zip/modules_src/jdk.jlink/module-info.java.extra
    requires jdk.internal.opt;
    requires jdk.jdeps;
    exports jdk.tools.jlink.internal.packager to jdk.packager;

    uses jdk.tools.jlink.plugin.Plugin;
    provides java.util.spi.ToolProvider with
        jdk.tools.jmod.Main.JmodToolProvider,
        jdk.tools.jlink.internal.Main.JlinkToolProvider;
    provides jdk.tools.jlink.plugin.Plugin with
        jdk.tools.jlink.internal.plugins.StripDebugPlugin,
        jdk.tools.jlink.internal.plugins.ExcludePlugin,
        jdk.tools.jlink.internal.plugins.ExcludeFilesPlugin,
        jdk.tools.jlink.internal.plugins.ExcludeJmodSectionPlugin,
        jdk.tools.jlink.internal.plugins.LegalNoticeFilePlugin,
        jdk.tools.jlink.internal.plugins.SystemModulesPlugin,
        jdk.tools.jlink.internal.plugins.StripNativeCommandsPlugin,
        jdk.tools.jlink.internal.plugins.OrderResourcesPlugin,
        jdk.tools.jlink.internal.plugins.DefaultCompressPlugin,
        jdk.tools.jlink.internal.plugins.ExcludeVMPlugin,
        jdk.tools.jlink.internal.plugins.IncludeLocalesPlugin,
        jdk.tools.jlink.internal.plugins.GenerateJLIClassesPlugin,
        jdk.tools.jlink.internal.plugins.ReleaseInfoPlugin,
        jdk.tools.jlink.internal.plugins.ClassForNamePlugin;
}
