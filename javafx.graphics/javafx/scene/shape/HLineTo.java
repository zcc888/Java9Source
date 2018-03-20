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

package javafx.scene.shape;

import com.sun.javafx.geom.Path2D;
import com.sun.javafx.scene.shape.HLineToHelper;
import com.sun.javafx.sg.prism.NGPath;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;


/**
 * Creates a horizontal line path element from the current point to x.
 *
 * <p>For more information on path elements see the {@link Path} and
 * {@link PathElement} classes.
 *
 * <p>Example:
 *
<PRE>
import javafx.scene.shape.*;

Path path = new Path();
path.getElements().add(new MoveTo(0.0f, 0.0f));
path.getElements().add(new HLineTo(80.0f));
</PRE>
 * @since JavaFX 2.0
 */
public class HLineTo extends PathElement {
    static {
        HLineToHelper.setHLineToAccessor(new HLineToHelper.HLineToAccessor() {
            @Override
            public void doAddTo(PathElement pathElement, Path2D path) {
                ((HLineTo) pathElement).doAddTo(path);
            }
        });
    }

    /**
     * Creates an empty instance of HLineTo.
     */
    public HLineTo() {
        HLineToHelper.initHelper(this);
    }

    /**
     * Creates an instance of HLineTo.
     * @param x the horizontal coordinate to line to
     */
    public HLineTo(double x) {
        setX(x);
        HLineToHelper.initHelper(this);
    }

    /**
     * Defines the X coordinate.
     *
     * @defaultValue 0.0
     */
    private DoubleProperty x = new DoublePropertyBase() {

        @Override
        public void invalidated() {
            u();
        }

        @Override
        public Object getBean() {
            return HLineTo.this;
        }

        @Override
        public String getName() {
            return "x";
        }
    };


    public final void setX(double value) {
        x.set(value);
    }

    public final double getX() {
        return x.get();
    }

    public final DoubleProperty xProperty() {
        return x;
    }

    @Override
    void addTo(NGPath pgPath) {
        if (isAbsolute()) {
            pgPath.addLineTo((float)getX(), pgPath.getCurrentY());
        } else {
            pgPath.addLineTo((float)(pgPath.getCurrentX() + getX()), pgPath.getCurrentY());
        }
    }

    /*
     * Note: This method MUST only be called via its accessor method.
     */
    private void doAddTo(Path2D path) {
        if (isAbsolute()) {
            path.lineTo((float)getX(), path.getCurrentY());
        } else {
            path.lineTo((float)(path.getCurrentX() + getX()), path.getCurrentY());
        }
    }

    /**
     * Returns a string representation of this {@code HLineTo} object.
     * @return a string representation of this {@code HLineTo} object.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HLineTo[");
        sb.append("x=").append(getX());
        return sb.append("]").toString();
    }
}

