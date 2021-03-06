/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.options;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class UniquePathUtilities {

    private static final AtomicLong globalTimeStamp = new AtomicLong();
    /**
     * This generates a per thread persistent id to aid mapping related dump files with each other.
     */
    private static final ThreadLocal<Integer> threadDumpId = new ThreadLocal<>();
    private static final AtomicInteger dumpId = new AtomicInteger();

    private static int getThreadDumpId() {
        Integer id = threadDumpId.get();
        if (id == null) {
            id = dumpId.incrementAndGet();
            threadDumpId.set(id);
        }
        return id;
    }

    private static String formatExtension(String ext) {
        if (ext == null || ext.length() == 0) {
            return "";
        }
        return "." + ext;
    }

    public static long getGlobalTimeStamp() {
        if (globalTimeStamp.get() == 0) {
            globalTimeStamp.compareAndSet(0, System.currentTimeMillis());
        }
        return globalTimeStamp.get();
    }

    /**
     * Generate a {@link Path} using the format "%s-%d_%d%s" with the {@link OptionValue#getValue()
     * base filename}, a {@link #globalTimeStamp global timestamp}, {@link #getThreadDumpId a per
     * thread unique id} and an optional {@code extension}.
     *
     * @return the output file path or null if the flag is null
     */
    public static Path getPath(OptionValue<String> option, OptionValue<String> defaultDirectory, String extension) {
        return getPath(option, defaultDirectory, extension, true);
    }

    /**
     * Generate a {@link Path} using the format "%s-%d_%s" with the {@link OptionValue#getValue()
     * base filename}, a {@link #globalTimeStamp global timestamp} and an optional {@code extension}
     * .
     *
     * @return the output file path or null if the flag is null
     */
    public static Path getPathGlobal(OptionValue<String> option, OptionValue<String> defaultDirectory, String extension) {
        return getPath(option, defaultDirectory, extension, false);
    }

    private static Path getPath(OptionValue<String> option, OptionValue<String> defaultDirectory, String extension, boolean includeThreadId) {
        if (option.getValue() == null) {
            return null;
        }
        final String name = includeThreadId
                        ? String.format("%s-%d_%d%s", option.getValue(), getGlobalTimeStamp(), getThreadDumpId(), formatExtension(extension))
                        : String.format("%s-%d%s", option.getValue(), getGlobalTimeStamp(), formatExtension(extension));
        Path result = Paths.get(name);
        if (result.isAbsolute() || defaultDirectory == null) {
            return result;
        }
        return Paths.get(defaultDirectory.getValue(), name);
    }

}
