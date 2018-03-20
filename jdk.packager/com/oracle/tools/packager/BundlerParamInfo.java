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

package com.oracle.tools.packager;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BundlerParamInfo<T> {

    /**
     * The user friendly name of the parameter
     */
    String name;

    /**
     * A more verbose description of the parameter
     */
    String description;

    /**
     * The command line and hashmap name of the parameter
     */
    String id;

    /**
     * Type of the parameter.  Typically String.class
     */
    Class<T> valueType;

    /**
     * If the value is not set, and no fallback value is found, the parameter uses the value returned by the producer.
     */
    Function<Map<String, ? super Object>, T> defaultValueFunction;

    /**
     * An optional string converter for command line arguments.
     */
    BiFunction<String, Map<String, ? super Object>, T> stringConverter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Class<T> getValueType() {
        return valueType;
    }

    public void setValueType(Class<T> valueType) {
        this.valueType = valueType;
    }

    public Function<Map<String, ? super Object>, T> getDefaultValueFunction() {
        return defaultValueFunction;
    }

    public void setDefaultValueFunction(Function<Map<String, ? super Object>, T> defaultValueFunction) {
        this.defaultValueFunction = defaultValueFunction;
    }

    public BiFunction<String, Map<String, ? super Object>,T> getStringConverter() {
        return stringConverter;
    }

    public void setStringConverter(BiFunction<String, Map<String, ? super Object>, T> stringConverter) {
        this.stringConverter = stringConverter;
    }

    @SuppressWarnings("unchecked")
    public final T fetchFrom(Map<String, ? super Object> params) {
        return fetchFrom(params, true);
    }

    @SuppressWarnings("unchecked")
    public final T fetchFrom(Map<String, ? super Object> params, boolean invokeDefault) {
        Object o = params.get(getID());
        if (o instanceof String && getStringConverter() != null) {
            return getStringConverter().apply((String)o, params);
        }

        Class klass = getValueType();
        if (klass.isInstance(o)) {
            return (T) o;
        }
        if (o != null) {
            throw new IllegalArgumentException("Param " + getID() + " should be of type " + getValueType() + " but is a " + o.getClass());
        }
        if (params.containsKey(getID())) {
            // explicit nulls are allowed
            return null;
        }

        if (invokeDefault && (getDefaultValueFunction() != null)) {
            T result =  getDefaultValueFunction().apply(params);
            if (result != null) {
                params.put(getID(), result);
            }
            return result;
        }

        // ultimate fallback
        return null;
    }
}
