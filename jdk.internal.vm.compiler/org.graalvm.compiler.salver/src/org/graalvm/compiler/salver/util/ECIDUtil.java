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
package org.graalvm.compiler.salver.util;

import java.security.SecureRandom;
import java.util.Random;

public class ECIDUtil {

    private static final Random RANDOM = new SecureRandom();

    private static final String BASE58_ALPHABET = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz123456789";

    public static String random() {
        return random(8);
    }

    public static String random(int length) {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = new byte[length];
        RANDOM.nextBytes(bytes);
        for (byte b : bytes) {
            sb.append(BASE58_ALPHABET.charAt((b & 0xff) % 58));
        }
        return sb.toString();
    }
}
