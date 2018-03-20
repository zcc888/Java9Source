/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.util.concurrent.atomic.AtomicInteger;
import com.sun.util.reentrant.ReentrantContext;
import com.sun.javafx.geom.Rectangle;
import com.sun.marlin.ArrayCacheConst.CacheStats;

/**
 * This class is a renderer context dedicated to a single thread
 */
public final class RendererContext extends ReentrantContext implements MarlinConst {

    // RendererContext creation counter
    private static final AtomicInteger CTX_COUNT = new AtomicInteger(1);

    /**
     * Create a new renderer context
     *
     * @return new RendererContext instance
     */
    public static RendererContext createContext() {
        return new RendererContext("ctx"
                       + Integer.toString(CTX_COUNT.getAndIncrement()));
    }

    // Smallest object used as Cleaner's parent reference
    private final Object cleanerObj;
    // dirty flag indicating an exception occured during pipeline in pathTo()
    public boolean dirty = false;
    // shared data
    public final float[] float6 = new float[6];
    // shared curve (dirty) (Renderer / Stroker)
    final Curve curve = new Curve();
    // MarlinRenderingEngine.TransformingPathConsumer2D
    public final TransformingPathConsumer2D transformerPC2D;
    public final Renderer renderer;
    private RendererNoAA rendererNoAA = null;
    public final Stroker stroker;
    // Simplifies out collinear lines
    public final CollinearSimplifier simplifier = new CollinearSimplifier();
    public final Dasher dasher;
    // flag indicating the shape is stroked (1) or filled (0)
    int stroking = 0;

// MarlinFX specific:
    // dirty bbox rectangle
    public final Rectangle clip = new Rectangle();
    // dirty MaskMarlinAlphaConsumer
    public MaskMarlinAlphaConsumer consumer = null;

    // Array caches:
    /* clean int[] cache (zero-filled) = 5 refs */
    private final IntArrayCache cleanIntCache = new IntArrayCache(true, 5);
    /* dirty int[] cache = 4 refs */
    private final IntArrayCache dirtyIntCache = new IntArrayCache(false, 4);
    /* dirty float[] cache = 3 refs */
    private final FloatArrayCache dirtyFloatCache = new FloatArrayCache(false, 3);
    /* dirty byte[] cache = 1 ref */
    private final ByteArrayCache dirtyByteCache = new ByteArrayCache(false, 1);

    // RendererContext statistics
    final RendererStats stats;

    /**
     * Constructor
     *
     * @param name context name (debugging)
     */
    RendererContext(final String name) {
        if (LOG_CREATE_CONTEXT) {
            MarlinUtils.logInfo("new RendererContext = " + name);
        }
        this.cleanerObj = new Object();

        // create first stats (needed by newOffHeapArray):
        if (DO_STATS || DO_MONITORS) {
            stats = RendererStats.createInstance(cleanerObj, name);
            // push cache stats:
            stats.cacheStats = new CacheStats[] { cleanIntCache.stats,
                dirtyIntCache.stats, dirtyFloatCache.stats, dirtyByteCache.stats
            };
        } else {
            stats = null;
        }

        // MarlinRenderingEngine.TransformingPathConsumer2D
        transformerPC2D = new TransformingPathConsumer2D();

        // Renderer:
        renderer = new Renderer(this);

        stroker = new Stroker(this);
        dasher = new Dasher(this);
    }

    /**
     * Disposes this renderer context:
     * clean up before reusing this context
     */
    public void dispose() {
        if (DO_STATS) {
            if (stats.totalOffHeap > stats.totalOffHeapMax) {
                stats.totalOffHeapMax = stats.totalOffHeap;
            }
            stats.totalOffHeap = 0L;
        }
        stroking = 0;
        // if context is maked as DIRTY:
        if (dirty) {
            // may happen if an exception if thrown in the pipeline processing:
            // force cleanup of all possible pipelined blocks (except Renderer):

            // Dasher:
            this.dasher.dispose();
            // Stroker:
            this.stroker.dispose();

            // mark context as CLEAN:
            dirty = false;
        }
    }

    public RendererNoAA getRendererNoAA() {
        if (rendererNoAA == null) {
            rendererNoAA = new RendererNoAA(this);
        }
        return rendererNoAA;
    }

    OffHeapArray newOffHeapArray(final long initialSize) {
        if (DO_STATS) {
            stats.totalOffHeapInitial += initialSize;
        }
        return new OffHeapArray(cleanerObj, initialSize);
    }

    IntArrayCache.Reference newCleanIntArrayRef(final int initialSize) {
        return cleanIntCache.createRef(initialSize);
    }

    IntArrayCache.Reference newDirtyIntArrayRef(final int initialSize) {
        return dirtyIntCache.createRef(initialSize);
    }

    FloatArrayCache.Reference newDirtyFloatArrayRef(final int initialSize) {
        return dirtyFloatCache.createRef(initialSize);
    }

    ByteArrayCache.Reference newDirtyByteArrayRef(final int initialSize) {
        return dirtyByteCache.createRef(initialSize);
    }
}
