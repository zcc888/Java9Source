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

package org.graalvm.compiler.hotspot;

import java.lang.reflect.Method;

import jdk.vm.ci.hotspot.HotSpotResolvedObjectType;

/**
 * Reflective wrapper around the fingerprint generation functionality in JDK9.
 */
public class FingerprintUtil {
    private static Method getFingerprint;
    static {
        try {
            getFingerprint = HotSpotResolvedObjectType.class.getMethod("getFingerprint");
        } catch (Exception e) {
        }
    }

    public static long getFingerprint(HotSpotResolvedObjectType type) {
        if (getFingerprint != null) {
            try {
                return ((Long) getFingerprint.invoke(type)).longValue();
            } catch (Exception e) {
            }
        }
        return 0;
    }
}
