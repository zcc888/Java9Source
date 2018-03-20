/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * A set of debug metrics for all compilations of a {@link ResolvedJavaMethod}. A method metrics
 * object is a container for several metrics per compilation of a method {@code <Method,List
 * <CompilationData>>}. Metrics are stored on a per-method per-compilation basis.
 *
 * <pre>
 * DebugMethodMetrics m = Debug.methodMetrics(method);
 * m.incrementMetric("MyPerCompilationmetric");
 * </pre>
 *
 * In contrast to global metrics like {@link DebugCounter}, {@link DebugTimer} or
 * {@linkplain DebugMemUseTracker}, method compilation metrics are always associated with a
 * {@link ResolvedJavaMethod}.
 */
public interface DebugMethodMetrics {

    /**
     * Adds {@code value} to the metric for the current compilation associated with
     * {@code metricName}. If the metric is yet undefined for the current compilation a new metric
     * for the given name is defined and the value for it is set to {@code value}.
     *
     * @param metricName the name for the metric to be incremented
     * @param value the value to add to the metric defined by name
     */
    void addToMetric(long value, String metricName);

    /**
     * @see #addToMetric(long, String)
     */
    void addToMetric(long value, String format, Object arg1);

    /**
     * @see #addToMetric(long, String)
     */
    void addToMetric(long value, String format, Object arg1, Object arg2);

    /**
     * @see #addToMetric(long, String)
     */
    void addToMetric(long value, String format, Object arg1, Object arg2, Object arg3);

    /**
     * Adds {@code 1} to the metric for the current compilation associated with {@code metricName}.
     * If the metric is yet undefined for the current compilation a new metric for the given name is
     * defined and the value for it is set to {@code value}.
     *
     * @param metricName the name for the metric to be incremented
     */
    void incrementMetric(String metricName);

    /**
     * @see #incrementMetric(String)
     */
    void incrementMetric(String format, Object arg1);

    /**
     * @see #incrementMetric(String)
     */
    void incrementMetric(String format, Object arg1, Object arg2);

    /**
     * @see #incrementMetric(String)
     */
    void incrementMetric(String format, Object arg1, Object arg2, Object arg3);

    /**
     * Gets the value of the metric for the current compilation associated with the
     * {@code metricName} . If the metric is yet undefined for the current compilation {@code 0} is
     * returned instead.
     *
     * @param metricName the name of the metric for which the value will be returned
     * @return the value of the metric for the given compilation or {@code 0} if it is not defined
     */
    long getCurrentMetricValue(String metricName);

    /**
     * @see #getCurrentMetricValue(String)
     */
    long getCurrentMetricValue(String format, Object arg1);

    /**
     * @see #getCurrentMetricValue(String)
     */
    long getCurrentMetricValue(String format, Object arg1, Object arg2);

    /**
     * @see #getCurrentMetricValue(String)
     */
    long getCurrentMetricValue(String format, Object arg1, Object arg2, Object arg3);

    /**
     * Gets the {@link ResolvedJavaMethod} associated with this {@linkplain DebugMethodMetrics}.
     *
     * @return the {@link ResolvedJavaMethod} of the current method metric
     */
    ResolvedJavaMethod getMethod();

}
