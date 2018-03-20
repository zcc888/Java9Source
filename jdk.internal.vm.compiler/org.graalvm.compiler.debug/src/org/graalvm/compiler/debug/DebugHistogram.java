/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
 */
package org.graalvm.compiler.debug;

import java.util.List;

/**
 * Facility for recording value frequencies.
 */
public interface DebugHistogram {

    /**
     * Gets the name specified when this objected was {@linkplain Debug#createHistogram(String)
     * created}.
     */
    String getName();

    /**
     * Increments the count for a given value.
     */
    void add(Object value);

    void add(Object value, long count);

    /**
     * A value and a frequency. The ordering imposed by {@link #compareTo(CountedValue)} places
     * values with higher frequencies first.
     */
    class CountedValue implements Comparable<CountedValue> {

        private long count;
        private final Object value;

        public CountedValue(long count, Object value) {
            this.count = count;
            this.value = value;
        }

        @Override
        public int compareTo(CountedValue o) {
            if (count < o.count) {
                return 1;
            } else if (count > o.count) {
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return count + " -> " + value;
        }

        public void inc() {
            count++;
        }

        public void add(long n) {
            count += n;
        }

        public long getCount() {
            return count;
        }

        public Object getValue() {
            return value;
        }
    }

    /**
     * Gets a list of the counted values, sorted in descending order of frequency.
     */
    List<CountedValue> getValues();

    /**
     * Interface for a service that can render a visualization of a histogram.
     */
    public interface Printer {

        void print(DebugHistogram histogram);
    }
}
