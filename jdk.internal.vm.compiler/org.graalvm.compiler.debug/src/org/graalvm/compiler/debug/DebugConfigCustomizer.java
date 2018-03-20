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
package org.graalvm.compiler.debug;

public interface DebugConfigCustomizer {
    void customize(DebugConfig config, Object... extraArgs);

    static <T> T lookupArg(Class<T> c, Object... extraArgs) {
        for (Object arg : extraArgs) {
            if (c.isInstance(arg)) {
                return c.cast(arg);
            }
        }
        return null;
    }
}
