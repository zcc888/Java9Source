/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
 * Defines the JMX management agent.
 *
 * <p> This module allows a Java Virtual Machine to be monitored and managed
 * via JMX API.  See more information from the
 * {@extLink monitoring_and_management_using_jmx_technology
 * Monitoring and Management Using JMX} guide.
 *
 * @moduleGraph
 * @since 9
 */
module jdk.management.agent {
    // source file: file:///scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/jdk/src/jdk.management.agent/share/classes/module-info.java
    //              file:///scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/jdk/src/closed/jdk.management.agent/share/classes/module-info.java.extra
    requires java.management;
    requires java.management.rmi;
    exports jdk.internal.agent to jdk.jconsole;
    exports jdk.internal.agent.spi to jdk.snmp;

    uses jdk.internal.agent.spi.AgentProvider;
}
