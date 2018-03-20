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

package com.sun.javafx.scene.media;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.scene.NodeHelper;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.javafx.util.Utils;
import javafx.scene.Node;
import javafx.scene.media.MediaView;

/**
 * Used to access internal methods of MediaView.
 */
public class MediaViewHelper extends NodeHelper {

    private static final MediaViewHelper theInstance;
    private static MediaViewAccessor mediaViewAccessor;

    static {
        theInstance = new MediaViewHelper();
        Utils.forceInit(MediaView.class);
    }

    private static MediaViewHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(MediaView mediaView) {
        setHelper(mediaView, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return mediaViewAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        mediaViewAccessor.doUpdatePeer(node);
    }

    protected void transformsChangedImpl(Node node) {
        super.transformsChangedImpl(node);
        mediaViewAccessor.doTransformsChanged(node);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return mediaViewAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected boolean computeContainsImpl(Node node, double localX, double localY) {
        return mediaViewAccessor.doComputeContains(node, localX, localY);
    }

    @Override
    protected Object processMXNodeImpl(Node node, MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
        return mediaViewAccessor.doProcessMXNode(node, alg, ctx);
    }

    public static void setMediaViewAccessor(final MediaViewAccessor newAccessor) {
        if (mediaViewAccessor != null) {
            throw new IllegalStateException();
        }

        mediaViewAccessor = newAccessor;
    }

    public interface MediaViewAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        void doTransformsChanged(Node node);
        boolean doComputeContains(Node node, double localX, double localY);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        Object doProcessMXNode(Node node, MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx);
    }

}
