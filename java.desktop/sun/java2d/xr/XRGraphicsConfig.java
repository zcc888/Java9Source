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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sun.java2d.xr;

import sun.awt.*;
import sun.awt.image.*;
import sun.java2d.*;

public class XRGraphicsConfig extends X11GraphicsConfig implements
        SurfaceManager.ProxiedGraphicsConfig {
    private XRGraphicsConfig(X11GraphicsDevice device, int visualnum,
            int depth, int colormap, boolean doubleBuffer) {
        super(device, visualnum, depth, colormap, doubleBuffer);
    }

    public SurfaceData createSurfaceData(X11ComponentPeer peer) {
        return XRSurfaceData.createData(peer);
    }

    public static XRGraphicsConfig getConfig(X11GraphicsDevice device,
            int visualnum, int depth, int colormap, boolean doubleBuffer) {
        if (!X11GraphicsEnvironment.isXRenderAvailable()) {
            return null;
        }

        return new XRGraphicsConfig(device, visualnum, depth, colormap,
                doubleBuffer);
    }

    public Object getProxyKey() {
        return this;
    }
}
