/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.javafx.scene.control.behavior;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import com.sun.javafx.scene.control.inputmap.InputMap;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.util.List;

import static javafx.scene.input.KeyCode.*;
import static com.sun.javafx.scene.control.inputmap.InputMap.KeyMapping;

public class SpinnerBehavior<T> extends BehaviorBase<Spinner<T>> {

    // this specifies how long the mouse has to be pressed on a button
    // before the value steps. As the mouse is held down longer, we begin
    // to cut down the duration of subsequent steps (and also increase the
    // step size)
    private static final double INITIAL_DURATION_MS = 750;

    private final InputMap<Spinner<T>> spinnerInputMap;

    private static final int STEP_AMOUNT = 1;

    private boolean isIncrementing = false;

    private Timeline timeline;

    final EventHandler<ActionEvent> spinningKeyFrameEventHandler = event -> {
        final SpinnerValueFactory<T> valueFactory = getNode().getValueFactory();
        if (valueFactory == null) {
            return;
        }

        if (isIncrementing) {
            increment(STEP_AMOUNT);
        } else {
            decrement(STEP_AMOUNT);
        }
    };



    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    public SpinnerBehavior(Spinner<T> spinner) {
        super(spinner);

        // create a map for spinner-specific mappings (this reuses the default
        // InputMap installed on the control, if it is non-null, allowing us to pick up any user-specified mappings)
        spinnerInputMap = createInputMap();

        // then spinner-specific mappings for key and mouse input
        addDefaultMapping(spinnerInputMap,
            new KeyMapping(UP, KeyEvent.KEY_PRESSED, e -> {
                if (arrowsAreVertical()) increment(1); else FocusTraversalInputMap.traverseUp(e);
            }),
            new KeyMapping(RIGHT, KeyEvent.KEY_PRESSED, e -> {
                if (! arrowsAreVertical()) increment(1); else FocusTraversalInputMap.traverseRight(e);
            }),
            new KeyMapping(LEFT, KeyEvent.KEY_PRESSED, e -> {
                if (! arrowsAreVertical()) decrement(1); else FocusTraversalInputMap.traverseLeft(e);
            }),
            new KeyMapping(DOWN, KeyEvent.KEY_PRESSED, e -> {
                if (arrowsAreVertical()) decrement(1); else FocusTraversalInputMap.traverseDown(e);
            })
        );
    }



    /***************************************************************************
     *                                                                         *
     * API                                                                     *
     *                                                                         *
     **************************************************************************/

    @Override public InputMap<Spinner<T>> getInputMap() {
        return spinnerInputMap;
    }

    public void increment(int steps) {
        getNode().increment(steps);
    }

    public void decrement(int steps) {
        getNode().decrement(steps);
    }

    public void startSpinning(boolean increment) {
        isIncrementing = increment;

        if (timeline != null) {
            timeline.stop();
        }
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        final KeyFrame kf = new KeyFrame(Duration.millis(INITIAL_DURATION_MS), spinningKeyFrameEventHandler);
        timeline.getKeyFrames().setAll(kf);
        timeline.playFromStart();
        timeline.play();
        spinningKeyFrameEventHandler.handle(null);
    }

    public void stopSpinning() {
        if (timeline != null) {
            timeline.stop();
        }
    }



    /***************************************************************************
     *                                                                         *
     * Implementation                                                          *
     *                                                                         *
     **************************************************************************/

    private boolean arrowsAreVertical() {
        final List<String> styleClass = getNode().getStyleClass();

        return ! (styleClass.contains(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL)  ||
                  styleClass.contains(Spinner.STYLE_CLASS_ARROWS_ON_RIGHT_HORIZONTAL) ||
                  styleClass.contains(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL));
    }
}
