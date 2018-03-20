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

public class JulesTile {
    byte[] imgBuffer;
    long pixmanImgPtr = 0;
    int tilePos;

    public JulesTile() {
    }

    public byte[] getImgBuffer() {
        if(imgBuffer == null) {
            imgBuffer = new byte[1024];
        }

        return imgBuffer;
    }

    public long getPixmanImgPtr() {
        return pixmanImgPtr;
    }

    public void setPixmanImgPtr(long pixmanImgPtr) {
        this.pixmanImgPtr = pixmanImgPtr;
    }

    public boolean hasBuffer() {
        return imgBuffer != null;
    }

    public int getTilePos() {
        return tilePos;
    }

    public void setTilePos(int tilePos) {
        this.tilePos = tilePos;
    }

    public void setImgBuffer(byte[] imgBuffer){
        this.imgBuffer = imgBuffer;
    }
}
