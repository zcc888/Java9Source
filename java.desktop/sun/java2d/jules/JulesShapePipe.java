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
import sun.awt.*;
import sun.java2d.*;
import sun.java2d.pipe.*;
import sun.java2d.xr.*;

public class JulesShapePipe implements ShapeDrawPipe {

    XRCompositeManager compMan;
    JulesPathBuf buf = new JulesPathBuf();

    public JulesShapePipe(XRCompositeManager compMan) {
        this.compMan = compMan;
    }

    /**
     * Common validate method, used by all XRRender functions to validate the
     * destination context.
     */
    private final void validateSurface(SunGraphics2D sg2d) {
        XRSurfaceData xrsd = (XRSurfaceData) sg2d.surfaceData;
        xrsd.validateAsDestination(sg2d, sg2d.getCompClip());
        xrsd.maskBuffer.validateCompositeState(sg2d.composite, sg2d.transform,
                                               sg2d.paint, sg2d);
    }

    public void draw(SunGraphics2D sg2d, Shape s) {
        try {
            SunToolkit.awtLock();
            validateSurface(sg2d);
            XRSurfaceData xrsd = (XRSurfaceData) sg2d.surfaceData;

            BasicStroke bs;

            if (sg2d.stroke instanceof BasicStroke) {
                bs = (BasicStroke) sg2d.stroke;
            } else { //TODO: What happens in the case of a !BasicStroke??
                s = sg2d.stroke.createStrokedShape(s);
                bs = null;
            }

            boolean adjust =
                (bs != null && sg2d.strokeHint != SunHints.INTVAL_STROKE_PURE);
            boolean thin = (sg2d.strokeState <= SunGraphics2D.STROKE_THINDASHED);

            TrapezoidList traps =
                 buf.tesselateStroke(s, bs, thin, adjust, true,
                                     sg2d.transform, sg2d.getCompClip());
            compMan.XRCompositeTraps(xrsd.picture,
                                     sg2d.transX, sg2d.transY, traps);

            buf.clear();

        } finally {
            SunToolkit.awtUnlock();
        }
    }

    public void fill(SunGraphics2D sg2d, Shape s) {
        try {
            SunToolkit.awtLock();
            validateSurface(sg2d);

            XRSurfaceData xrsd = (XRSurfaceData) sg2d.surfaceData;

            TrapezoidList traps = buf.tesselateFill(s, sg2d.transform,
                                                    sg2d.getCompClip());
            compMan.XRCompositeTraps(xrsd.picture, 0, 0, traps);

            buf.clear();
        } finally {
            SunToolkit.awtUnlock();
        }
    }
}
