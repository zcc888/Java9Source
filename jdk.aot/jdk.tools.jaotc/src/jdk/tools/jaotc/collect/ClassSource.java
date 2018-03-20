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
 */
package jdk.tools.jaotc.collect;

import java.nio.file.Path;
import java.util.function.BiConsumer;

public interface ClassSource {
    static boolean pathIsClassFile(Path entry) {
        String fileName = entry.getFileName().toString();
        return fileName.endsWith(".class") && !fileName.endsWith("module-info.class");
    }

    static String makeClassName(Path path) {
        String fileName = path.toString();

        if (!fileName.endsWith(".class")) {
            throw new IllegalArgumentException("File doesn't end with .class: '" + fileName + "'");
        }

        int start = 0;
        if (fileName.startsWith("/")) {
            start = 1;
        }

        String className = fileName.substring(start, fileName.length() - ".class".length());
        className = className.replace('/', '.');
        return className;
    }

    void eachClass(BiConsumer<String, ClassLoader> consumer);
}
