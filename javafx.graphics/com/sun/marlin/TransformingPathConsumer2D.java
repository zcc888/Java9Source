/*
 * Copyright (c) 2007, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.marlin;

import com.sun.javafx.geom.PathConsumer2D;
import com.sun.javafx.geom.transform.BaseTransform;

public final class TransformingPathConsumer2D {

    TransformingPathConsumer2D() {
        // used by RendererContext
    }

    // recycled PathConsumer2D instances from deltaTransformConsumer()
    private final DeltaScaleFilter     dt_DeltaScaleFilter     = new DeltaScaleFilter();
    private final DeltaTransformFilter dt_DeltaTransformFilter = new DeltaTransformFilter();

    public PathConsumer2D deltaTransformConsumer(PathConsumer2D out,
                                                 BaseTransform at)
    {
        if (at == null) {
            return out;
        }
        float mxx = (float) at.getMxx();
        float mxy = (float) at.getMxy();
        float myx = (float) at.getMyx();
        float myy = (float) at.getMyy();

        if (mxy == 0f && myx == 0f) {
            if (mxx == 1f && myy == 1f) {
                return out;
            } else {
                return dt_DeltaScaleFilter.init(out, mxx, myy);
            }
        } else {
            return dt_DeltaTransformFilter.init(out, mxx, mxy, myx, myy);
        }
    }

    // recycled PathConsumer2D instances from inverseDeltaTransformConsumer()
    private final DeltaScaleFilter     iv_DeltaScaleFilter     = new DeltaScaleFilter();
    private final DeltaTransformFilter iv_DeltaTransformFilter = new DeltaTransformFilter();

    public PathConsumer2D inverseDeltaTransformConsumer(PathConsumer2D out,
                                                        BaseTransform at)
    {
        if (at == null) {
            return out;
        }
        float mxx = (float) at.getMxx();
        float mxy = (float) at.getMxy();
        float myx = (float) at.getMyx();
        float myy = (float) at.getMyy();

        if (mxy == 0f && myx == 0f) {
            if (mxx == 1f && myy == 1f) {
                return out;
            } else {
                return iv_DeltaScaleFilter.init(out, 1.0f/mxx, 1.0f/myy);
            }
        } else {
            float det = mxx * myy - mxy * myx;
            return iv_DeltaTransformFilter.init(out,
                                                myy / det,
                                               -mxy / det,
                                               -myx / det,
                                                mxx / det);
        }
    }


    static final class DeltaScaleFilter implements PathConsumer2D {
        private PathConsumer2D out;
        private float sx, sy;

        DeltaScaleFilter() {}

        DeltaScaleFilter init(PathConsumer2D out,
                              float mxx, float myy)
        {
            this.out = out;
            sx = mxx;
            sy = myy;
            return this; // fluent API
        }

        @Override
        public void moveTo(float x0, float y0) {
            out.moveTo(x0 * sx, y0 * sy);
        }

        @Override
        public void lineTo(float x1, float y1) {
            out.lineTo(x1 * sx, y1 * sy);
        }

        @Override
        public void quadTo(float x1, float y1,
                           float x2, float y2)
        {
            out.quadTo(x1 * sx, y1 * sy,
                       x2 * sx, y2 * sy);
        }

        @Override
        public void curveTo(float x1, float y1,
                            float x2, float y2,
                            float x3, float y3)
        {
            out.curveTo(x1 * sx, y1 * sy,
                        x2 * sx, y2 * sy,
                        x3 * sx, y3 * sy);
        }

        @Override
        public void closePath() {
            out.closePath();
        }

        @Override
        public void pathDone() {
            out.pathDone();
        }
    }

    static final class DeltaTransformFilter implements PathConsumer2D {
        private PathConsumer2D out;
        private float mxx, mxy, myx, myy;

        DeltaTransformFilter() {}

        DeltaTransformFilter init(PathConsumer2D out,
                                  float mxx, float mxy,
                                  float myx, float myy)
        {
            this.out = out;
            this.mxx = mxx;
            this.mxy = mxy;
            this.myx = myx;
            this.myy = myy;
            return this; // fluent API
        }

        @Override
        public void moveTo(float x0, float y0) {
            out.moveTo(x0 * mxx + y0 * mxy,
                       x0 * myx + y0 * myy);
        }

        @Override
        public void lineTo(float x1, float y1) {
            out.lineTo(x1 * mxx + y1 * mxy,
                       x1 * myx + y1 * myy);
        }

        @Override
        public void quadTo(float x1, float y1,
                           float x2, float y2)
        {
            out.quadTo(x1 * mxx + y1 * mxy,
                       x1 * myx + y1 * myy,
                       x2 * mxx + y2 * mxy,
                       x2 * myx + y2 * myy);
        }

        @Override
        public void curveTo(float x1, float y1,
                            float x2, float y2,
                            float x3, float y3)
        {
            out.curveTo(x1 * mxx + y1 * mxy,
                        x1 * myx + y1 * myy,
                        x2 * mxx + y2 * mxy,
                        x2 * myx + y2 * myy,
                        x3 * mxx + y3 * mxy,
                        x3 * myx + y3 * myy);
        }

        @Override
        public void closePath() {
            out.closePath();
        }

        @Override
        public void pathDone() {
            out.pathDone();
        }
    }
}
