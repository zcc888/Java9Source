/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.impl.shape;

import com.sun.javafx.geom.Path2D;
import com.sun.javafx.geom.RectBounds;
import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.Shape;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.marlin.DMarlinRenderer;
import com.sun.marlin.DMarlinRenderingEngine;
import com.sun.marlin.MaskMarlinAlphaConsumer;
import com.sun.marlin.DRendererContext;
import com.sun.prism.BasicStroke;
import com.sun.prism.impl.PrismSettings;

/**
 * Thread-safe Marlin rasterizer (TL or CLQ storage)
 */
public final class DMarlinRasterizer implements ShapeRasterizer {
    private static final MaskData EMPTY_MASK = MaskData.create(new byte[1], 0, 0, 1, 1);

    @Override
    public MaskData getMaskData(Shape shape,
                                BasicStroke stroke,
                                RectBounds xformBounds,
                                BaseTransform xform,
                                boolean close, boolean antialiasedShape)
    {
        if (stroke != null && stroke.getType() != BasicStroke.TYPE_CENTERED) {
            // RT-27427
            // TODO: Optimize the combinatorial strokes for simple
            // shapes and/or teach the rasterizer to be able to
            // do a "differential fill" between two shapes.
            // Note that most simple shapes will use a more optimized path
            // than this method for the INNER/OUTER strokes anyway.
            shape = stroke.createStrokedShape(shape);
            stroke = null;
        }
        if (xformBounds == null) {
            if (stroke != null) {
                // Note that all places that pass null for xformbounds also
                // pass null for stroke so that the following is not typically
                // executed, but just here as a safety net.
                shape = stroke.createStrokedShape(shape);
                stroke = null;
            }

            xformBounds = new RectBounds();
            //TODO: Need to verify that this is a safe cast ... (RT-27427)
            xformBounds = (RectBounds) xform.transform(shape.getBounds(), xformBounds);
        }
        if (xformBounds.isEmpty()) {
            return EMPTY_MASK;
        }

        final DRendererContext rdrCtx = DMarlinRenderingEngine.getRendererContext();
        DMarlinRenderer renderer = null;
        try {
            final Rectangle rclip = rdrCtx.clip;
            rclip.setBounds(xformBounds);

            if (shape instanceof Path2D) {
                renderer = DMarlinPrismUtils.setupRenderer(rdrCtx, (Path2D) shape, stroke, xform, rclip,
                        antialiasedShape);
            }
            if (renderer == null) {
                renderer = DMarlinPrismUtils.setupRenderer(rdrCtx, shape, stroke, xform, rclip,
                        antialiasedShape);
            }
            final int outpix_xmin = renderer.getOutpixMinX();
            final int outpix_xmax = renderer.getOutpixMaxX();
            final int outpix_ymin = renderer.getOutpixMinY();
            final int outpix_ymax = renderer.getOutpixMaxY();
            final int w = outpix_xmax - outpix_xmin;
            final int h = outpix_ymax - outpix_ymin;
            if ((w <= 0) || (h <= 0)) {
                return EMPTY_MASK;
            }

            MaskMarlinAlphaConsumer consumer = rdrCtx.consumer;
            if (consumer == null || (w * h) > consumer.getAlphaLength()) {
                final int csize = (w * h + 0xfff) & (~0xfff);
                rdrCtx.consumer = consumer = new MaskMarlinAlphaConsumer(csize);
                if (PrismSettings.verbose) {
                    System.out.println("new alphas with length = " + csize);
                }
            }
            consumer.setBoundsNoClone(outpix_xmin, outpix_ymin, w, h);
            renderer.produceAlphas(consumer);
            return consumer.getMaskData();
        } finally {
            if (renderer != null) {
                renderer.dispose();
            }
            // recycle the RendererContext instance
            DMarlinRenderingEngine.returnRendererContext(rdrCtx);
        }
    }
}
