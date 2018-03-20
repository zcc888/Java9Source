/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.core.common.calc;

import org.graalvm.compiler.debug.GraalError;

public enum FloatConvert {
    F2I,
    D2I,
    F2L,
    D2L,
    I2F,
    L2F,
    D2F,
    I2D,
    L2D,
    F2D;

    public FloatConvert reverse() {
        switch (this) {
            case D2F:
                return F2D;
            case D2I:
                return I2D;
            case D2L:
                return L2D;
            case F2D:
                return D2F;
            case F2I:
                return I2F;
            case F2L:
                return L2F;
            case I2D:
                return D2I;
            case I2F:
                return F2I;
            case L2D:
                return D2L;
            case L2F:
                return F2L;
            default:
                throw GraalError.shouldNotReachHere();
        }
    }
}
