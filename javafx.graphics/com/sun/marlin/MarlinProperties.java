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
 *
 *
 */

package com.sun.marlin;

import java.security.AccessController;
import static com.sun.marlin.MarlinUtils.logInfo;
import java.security.PrivilegedAction;

public final class MarlinProperties {

    private MarlinProperties() {
        // no-op
    }

    // marlin system properties

    public static boolean isUseThreadLocal() {
        return getBoolean("prism.marlin.useThreadLocal", "true");
    }

    /**
     * Return the initial edge capacity used to define initial arrays
     * (edges, polystack, crossings)
     *
     * @return 256 < initial edges < 65536 (4096 by default)
     */
    public static int getInitialEdges() {
        return align(
            getInteger("prism.marlin.edges", 4096, 64, 64 * 1024),
            64);
    }

    /**
     * Return the initial pixel size used to define initial arrays
     * (tile AA chunk, alpha line, buckets)
     *
     * @return 64 < initial pixel size < 32768 (2048 by default)
     */
    public static int getInitialImageSize() {
        return align(
            getInteger("prism.marlin.pixelsize", 2048, 64, 32 * 1024),
            64);
    }

    /**
     * Return the log(2) corresponding to subpixel on x-axis (
     *
     * @return 0 (1 subpixels) < initial pixel size < 4 (256 subpixels)
     * (3 by default ie 8 subpixels)
     */
    public static int getSubPixel_Log2_X() {
        return getInteger("prism.marlin.subPixel_log2_X", 3, 0, 8);
    }

    /**
     * Return the log(2) corresponding to subpixel on y-axis (
     *
     * @return 0 (1 subpixels) < initial pixel size < 8 (256 subpixels)
     * (3 by default ie 8 subpixels)
     */
    public static int getSubPixel_Log2_Y() {
        return getInteger("prism.marlin.subPixel_log2_Y", 3, 0, 8);
    }

    /**
     * Return the log(2) corresponding to the block size in pixels
     *
     * @return 3 (8 pixels) < block size < 8 (256 pixels)
     * (5 by default ie 32 pixels)
     */
    public static int getBlockSize_Log2() {
        return getInteger("prism.marlin.blockSize_log2", 5, 3, 8);
    }

    // RLE / blockFlags settings

    public static boolean isForceRLE() {
        return getBoolean("prism.marlin.forceRLE", "false");
    }

    public static boolean isForceNoRLE() {
        return getBoolean("prism.marlin.forceNoRLE", "false");
    }

    public static boolean isUseTileFlags() {
        return getBoolean("prism.marlin.useTileFlags", "true");
    }

    public static boolean isUseTileFlagsWithHeuristics() {
        return isUseTileFlags()
        && getBoolean("prism.marlin.useTileFlags.useHeuristics", "true");
    }

    public static int getRLEMinWidth() {
        return getInteger("prism.marlin.rleMinWidth", 64, 0, Integer.MAX_VALUE);
    }

    // optimisation parameters

    public static boolean isUseSimplifier() {
        return getBoolean("prism.marlin.useSimplifier", "false");
    }

    // debugging parameters

    public static boolean isDoStats() {
        return getBoolean("prism.marlin.doStats", "false");
    }

    public static boolean isDoMonitors() {
        return getBoolean("prism.marlin.doMonitors", "false");
    }

    public static boolean isDoChecks() {
        return getBoolean("prism.marlin.doChecks", "false");
    }

    // logging parameters

    public static boolean isLoggingEnabled() {
        return getBoolean("prism.marlin.log", "false");
    }

    public static boolean isUseLogger() {
        return getBoolean("prism.marlin.useLogger", "false");
    }

    public static boolean isLogCreateContext() {
        return getBoolean("prism.marlin.logCreateContext", "false");
    }

    public static boolean isLogUnsafeMalloc() {
        return getBoolean("prism.marlin.logUnsafeMalloc", "false");
    }

    // system property utilities
    static boolean getBoolean(final String key, final String def) {
        return Boolean.valueOf(AccessController.doPrivileged(
            (PrivilegedAction<String>) () -> {
                String value = System.getProperty(key);
                return (value == null) ? def : value;
            }));
    }

    static int getInteger(final String key, final int def,
                                 final int min, final int max)
    {
        final String property = AccessController.doPrivileged(
                    (PrivilegedAction<String>) () -> System.getProperty(key));

        int value = def;
        if (property != null) {
            try {
                value = Integer.decode(property);
            } catch (NumberFormatException e) {
                logInfo("Invalid integer value for " + key + " = " + property);
            }
        }

        // check for invalid values
        if ((value < min) || (value > max)) {
            logInfo("Invalid value for " + key + " = " + value
                    + "; expected value in range[" + min + ", " + max + "] !");
            value = def;
        }
        return value;
    }

    static int align(final int val, final int norm) {
        final int ceil = FloatMath.ceil_int( ((float)val) / norm);
        return ceil * norm;
    }
}
