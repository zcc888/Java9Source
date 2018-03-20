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

import java.util.*;

public class IdleTileCache {
    static final int IDLE_TILE_SYNC_GRANULARITY = 16;
    static final ArrayList<JulesTile> idleBuffers = new ArrayList<JulesTile>();

    ArrayList<JulesTile> idleTileWorkerCacheList = new ArrayList<JulesTile>();
    ArrayList<JulesTile> idleTileConsumerCacheList =
              new ArrayList<JulesTile>(IDLE_TILE_SYNC_GRANULARITY);

    /**
     * Return a cached Tile, if possible from cache.
     * Allowed caller: Rasterizer/Producer-Thread
     *
     * @param: maxCache - Specify the maximum amount of tiles needed
     */
    public JulesTile getIdleTileWorker(int maxCache) {
        /* Try to fetch idle tiles from the global cache list */
        if (idleTileWorkerCacheList.size() == 0) {
            idleTileWorkerCacheList.ensureCapacity(maxCache);

            synchronized (idleBuffers) {
                for (int i = 0; i < maxCache && idleBuffers.size() > 0; i++) {
                    idleTileWorkerCacheList.add(
                            idleBuffers.remove(idleBuffers.size() - 1));
                }
            }
        }

        if (idleTileWorkerCacheList.size() > 0) {
            return idleTileWorkerCacheList.remove(idleTileWorkerCacheList.size() - 1);
        }

        return new JulesTile();
    }

    /**
     * Release tile and allow it to be re-used by another thread. Allowed
     *  Allowed caller: MaskBlit/Consumer-Thread
     */
    public void releaseTile(JulesTile tile) {
        if (tile != null && tile.hasBuffer()) {
            idleTileConsumerCacheList.add(tile);

            if (idleTileConsumerCacheList.size() > IDLE_TILE_SYNC_GRANULARITY) {
                synchronized (idleBuffers) {
                    idleBuffers.addAll(idleTileConsumerCacheList);
                }
                idleTileConsumerCacheList.clear();
            }
        }
    }

    /**
     * Releases thread-local tiles cached for use by the rasterizing thread.
     * Allowed caller: Rasterizer/Producer-Thread
     */
    public void disposeRasterizerResources() {
        releaseTiles(idleTileWorkerCacheList);
    }

    /**
     * Releases thread-local tiles cached for performance reasons. Allowed
     * Allowed caller: MaskBlit/Consumer-Thread
     */
    public void disposeConsumerResources() {
        releaseTiles(idleTileConsumerCacheList);
    }

    /**
     * Release a list of tiles and allow it to be re-used by another thread.
     * Thread safe.
     */
    public void releaseTiles(List<JulesTile> tileList) {
        if (tileList.size() > 0) {
            synchronized (idleBuffers) {
                idleBuffers.addAll(tileList);
            }
            tileList.clear();
        }
    }
}
