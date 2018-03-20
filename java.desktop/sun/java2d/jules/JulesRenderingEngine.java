/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.jules;

import java.awt.*;

import java.awt.geom.*;
import sun.java2d.pipe.*;
import sun.java2d.pisces.*;

public class JulesRenderingEngine extends PiscesRenderingEngine {

    @Override
    public AATileGenerator
         getAATileGenerator(Shape s, AffineTransform at, Region clip,
                            BasicStroke bs, boolean thin,
                            boolean normalize, int[] bbox) {

        if (JulesPathBuf.isCairoAvailable()) {
            return new JulesAATileGenerator(s, at, clip, bs, thin,
                                            normalize, bbox);
        } else {
            return super.getAATileGenerator(s, at, clip, bs, thin,
                                            normalize, bbox);
        }
    }

    public float getMinimumAAPenSize() {
        return 0.5f;
    }
}
