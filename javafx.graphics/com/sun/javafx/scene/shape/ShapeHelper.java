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
 *
 *
 */

package com.sun.javafx.scene.shape;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.scene.DirtyBits;
import com.sun.javafx.scene.NodeHelper;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.javafx.sg.prism.NGShape;
import com.sun.javafx.util.Utils;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 * Used to access internal methods of Shape.
 */
public abstract class ShapeHelper extends NodeHelper {
    private static ShapeAccessor shapeAccessor;

    static {
        Utils.forceInit(Shape.class);
    }

    /*
     * Static helper methods for cases where the implementation is done in an
     * instance method that is overridden by subclasses.
     * These methods exist in the base class only.
     */

    public static Paint cssGetFillInitialValue(Shape shape) {
        return ((ShapeHelper) getHelper(shape)).cssGetFillInitialValueImpl(shape);
    }

    public static Paint cssGetStrokeInitialValue(Shape shape) {
        return ((ShapeHelper) getHelper(shape)).cssGetStrokeInitialValueImpl(shape);
    }

    public static com.sun.javafx.geom.Shape configShape(Shape shape) {
        return ((ShapeHelper) getHelper(shape)).configShapeImpl(shape);
    }

    /*
     * Methods that will be overridden by subclasses
     */

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        shapeAccessor.doUpdatePeer(node);
    }

    @Override
    protected void markDirtyImpl(Node node, DirtyBits dirtyBit) {
        shapeAccessor.doMarkDirty(node, dirtyBit);
        super.markDirtyImpl(node, dirtyBit);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return shapeAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected boolean computeContainsImpl(Node node, double localX, double localY) {
        return shapeAccessor.doComputeContains(node, localX, localY);
    }

    @Override
    protected Object processMXNodeImpl(Node node, MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
        return shapeAccessor.doProcessMXNode(node, alg, ctx);
    }

    protected Paint cssGetFillInitialValueImpl(Shape shape) {
        return shapeAccessor.doCssGetFillInitialValue(shape);
    }

    protected Paint cssGetStrokeInitialValueImpl(Shape shape) {
        return shapeAccessor.doCssGetStrokeInitialValue(shape);
    }

    protected abstract com.sun.javafx.geom.Shape configShapeImpl(Shape shape);

    /*
     * Methods used by Shape (base) class only
     */

    public static NGShape.Mode getMode(Shape shape) {
        return shapeAccessor.getMode(shape);
    }

    public static void setMode(Shape shape, NGShape.Mode mode) {
        shapeAccessor.setMode(shape, mode);
    }

    public static void setShapeChangeListener(Shape shape, Runnable listener) {
        shapeAccessor.setShapeChangeListener(shape, listener);
    }

    public static void setShapeAccessor(final ShapeAccessor newAccessor) {
        if (shapeAccessor != null) {
            throw new IllegalStateException();
        }

        shapeAccessor = newAccessor;
    }

    public interface ShapeAccessor {
        void doUpdatePeer(Node node);
        void doMarkDirty(Node node, DirtyBits dirtyBit);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        boolean doComputeContains(Node node, double localX, double localY);
        Object doProcessMXNode(Node node, MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx);
        Paint doCssGetFillInitialValue(Shape shape);
        Paint doCssGetStrokeInitialValue(Shape shape);
        NGShape.Mode getMode(Shape shape);
        void setMode(Shape shape, NGShape.Mode mode);
        void setShapeChangeListener(Shape shape, Runnable listener);
    }

}
