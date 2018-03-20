/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.traversal;

import java.util.List;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;

import static com.sun.javafx.scene.traversal.Direction.*;

/**
 * First search for on-axis nodes. A node is on-axis if any part of its
 * closest edge lies between the pair of rays cast in the traversal direction
 * from the corners of the originating node.
 *
 * If there are multiple on-axis nodes, the closest is chosen.
 *
 * If there is a tie for the closest on-axis node, the tie is broken
 * by choosing the one whose center is closest to the center of the
 * originating node. TODO: investigate alternative tiebreaker algorithms
 * (filed as RT-19470).
 *
 * If there are no on-axis nodes, compute the distance OUT (in the traversal
 * direction) and the distance to the SIDE (perpendicular to the traversal
 * direction) and compute a distance metric OUT + WEIGHT * SIDE. Choose the
 * node with the smallest distance metric.
 *
 * TODO: presumably WEIGHT is greater than one, so that nodes farther OUT
 * but close (and not on) axis are chosen in preference to nodes that are
 * physically closer but are farther off to the side. Determine WEIGHT
 * somehow, possibly empirically (filed as RT-19471).
 */

public class WeightedClosestCorner implements Algorithm {


    WeightedClosestCorner() {
    }

    private boolean isOnAxis(Direction dir, Bounds cur, Bounds tgt) {

        final double cmin, cmax, tmin, tmax;

        if (dir == UP || dir == DOWN) {
            cmin = cur.getMinX();
            cmax = cur.getMaxX();
            tmin = tgt.getMinX();
            tmax = tgt.getMaxX();
        }
        else { // dir == LEFT || dir == RIGHT
            cmin = cur.getMinY();
            cmax = cur.getMaxY();
            tmin = tgt.getMinY();
            tmax = tgt.getMaxY();
        }

        return tmin <= cmax && tmax >= cmin;
    }

    /**
     * Compute the out-distance to the near edge of the target in the
     * traversal direction. Negative means the near edge is "behind".
     */
    private double outDistance(Direction dir, Bounds cur, Bounds tgt) {

        final double distance;

        if (dir == UP) {
            distance = cur.getMinY() - tgt.getMaxY();
        }
        else if (dir == DOWN) {
            distance = tgt.getMinY() - cur.getMaxY();
        }
        else if (dir == LEFT) {
            distance = cur.getMinX() - tgt.getMaxX();
        }
        else { // dir == RIGHT
            distance = tgt.getMinX() - cur.getMaxX();
        }

        return distance;
    }

    /**
     * Computes the side distance from current center to target center.
     * Always positive. This is only used for on-axis nodes.
     */
    private double centerSideDistance(Direction dir, Bounds cur, Bounds tgt) {

        final double cc; // current center
        final double tc; // target center

        if (dir == UP || dir == DOWN) {
            cc = cur.getMinX() + cur.getWidth() / 2.0f;
            tc = tgt.getMinX() + tgt.getWidth() / 2.0f;
        }
        else { // dir == LEFT || dir == RIGHT
            cc = cur.getMinY() + cur.getHeight() / 2.0f;
            tc = tgt.getMinY() + tgt.getHeight() / 2.0f;
        }

        return Math.abs(tc - cc);
        //return (tc > cc) ? tc - cc : cc - tc;
    }

    /**
     * Computes the side distance between the closest corners of the current
     * and target. Always positive. This is only used for off-axis nodes.
     */
    private double cornerSideDistance(Direction dir, Bounds cur, Bounds tgt) {

        final double distance;

        if (dir == UP || dir == DOWN) {

            if (tgt.getMinX() > cur.getMaxX()) {
                // on the right
                distance = tgt.getMinX() - cur.getMaxX();
            }
            else {
                // on the left
                distance = cur.getMinX() - tgt.getMaxX();
            }
        }
        else { // dir == LEFT or dir == RIGHT

            if (tgt.getMinY() > cur.getMaxY()) {
                // below
                distance = tgt.getMinY() - cur.getMaxY();
            }
            else {
                // above
                distance = cur.getMinY() - tgt.getMaxY();
            }
        }
        return distance;
    }

    public Node select(Node node, Direction dir, TraversalContext context) {
        Node newNode = null;
        List<Node> nodes = context.getAllTargetNodes();

        int target = traverse(context.getSceneLayoutBounds(node), dir, nodes, context);
        if (target != -1) {
            newNode = nodes.get(target);
        }

        return newNode;
    }

    @Override
    public Node selectFirst(TraversalContext context) {
        List<Node> nodes = context.getAllTargetNodes();
        Point2D zeroZero = new Point2D(0,0);

        if (nodes.size() > 0) {
            int nodeIndex;
            Node nearestNode = nodes.get(0);
            double nearestDistance = zeroZero.distance(context.getSceneLayoutBounds(nodes.get(0)).getMinX(),
                    context.getSceneLayoutBounds(nodes.get(0)).getMinY());
            double distance;

            for (nodeIndex = 1; nodeIndex < nodes.size(); nodeIndex++) {
                distance = zeroZero.distance(context.getSceneLayoutBounds(nodes.get(nodeIndex)).getMinX(),
                        context.getSceneLayoutBounds(nodes.get(nodeIndex)).getMinY());
                if (nearestDistance > distance) {
                    nearestDistance = distance;
                    nearestNode = nodes.get(nodeIndex);
                }
            }
            return nearestNode;
        }
        return null;
    }

    @Override
    public Node selectLast(TraversalContext context) {
        return null;
    }

    public int traverse(Bounds origin, Direction dir, List<Node> targets, TraversalContext context) {

        final int target;

        if (dir == NEXT || dir == NEXT_IN_LINE || dir == PREVIOUS) {
            target = trav1D(origin, dir, targets, context);
        } else {
            target = trav2D(origin, dir, targets, context);
        }

        return target;
    }

    private int trav2D(Bounds origin, Direction dir, List<Node> targets, TraversalContext context) {

        Bounds bestBounds = null;
        double bestMetric = 0.0;
        int bestIndex = -1;

        for (int i = 0; i < targets.size(); i++) {
            final Bounds targetBounds = context.getSceneLayoutBounds(targets.get(i));
            final double outd = outDistance(dir, origin, targetBounds);
            final double metric;

            if (isOnAxis(dir, origin, targetBounds)) {
                metric = outd + centerSideDistance(dir, origin, targetBounds) / 100;
            }
            else {
                final double cosd = cornerSideDistance(dir, origin, targetBounds);
                metric = 100000 + outd*outd + 9*cosd*cosd;
            }

            if (outd < 0.0) {
                continue;
            }

            if (bestBounds == null || metric < bestMetric) {
                bestBounds = targetBounds;
                bestMetric = metric;
                bestIndex = i;
            }
        }

        return bestIndex;
    }

    /*
     * Consider focus targets to have a total order using values
     * (minY, minX, hashCode).
     */
    private int compare1D(Bounds a, Bounds b) {

        int res = 0;

        // the following use the node's center
        final double metric1a = (a.getMinY() + a.getMaxY()) / 2;
        final double metric1b = (b.getMinY() + b.getMaxY()) / 2;
        final double metric2a = (a.getMinX() + a.getMaxX()) / 2;
        final double metric2b = (b.getMinX() + b.getMaxX()) / 2;
        final double metric3a = a.hashCode();
        final double metric3b = b.hashCode();

        if (metric1a < metric1b) {
            res = -1;
        }
        else if (metric1a > metric1b) {
            res = 1;
        }
        else if (metric2a < metric2b) {
            res = -1;
        }
        else if (metric2a > metric2b) {
            res = 1;
        }
        else if (metric3a < metric3b) {
            res = -1;
        }
        else if (metric3a > metric3b) {
            res = 1;
        }

        return res;
    }


    private int compare1D(Bounds a, Bounds b, Direction dir) {
        return (dir != PREVIOUS) ? -compare1D(a, b) : compare1D(a, b);
    }

    private int trav1D(Bounds origin, Direction dir, List<Node> targets, TraversalContext context) {
        int bestSoFar = -1;
        int leastSoFar = -1;

        for (int i = 0; i < targets.size(); i++) {
            if (leastSoFar == -1 ||
                    compare1D(context.getSceneLayoutBounds(targets.get(i)),
                            context.getSceneLayoutBounds(targets.get(leastSoFar)), dir) < 0) {
                leastSoFar = i;
            }

            if (compare1D(context.getSceneLayoutBounds(targets.get(i)), origin, dir) < 0) {
                continue;
            }

            if (bestSoFar == -1 ||
                    compare1D(context.getSceneLayoutBounds(targets.get(i)), context.getSceneLayoutBounds(targets.get(bestSoFar)), dir) < 0) {
                bestSoFar = i;
            }
        }

        return (bestSoFar == -1) ? leastSoFar : bestSoFar;
    }

}
