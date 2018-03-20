/*
 * Copyright (c) 2010, 2012, Oracle and/or its affiliates. All rights reserved.
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

import sun.java2d.xr.GrowableIntArray;

class TileTrapContainer {
    int tileAlpha;
    GrowableIntArray traps;

    public TileTrapContainer(GrowableIntArray traps) {
        this.traps = traps;
    }

    public void setTileAlpha(int tileAlpha) {
        this.tileAlpha = tileAlpha;
    }

    public int getTileAlpha() {
        return tileAlpha;
    }

    public GrowableIntArray getTraps() {
        return traps;
    }
}
