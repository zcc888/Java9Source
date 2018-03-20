/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.ws.wsdl.document.http;

import com.sun.tools.internal.ws.wsdl.framework.ExtensionImpl;
import org.xml.sax.Locator;

import javax.xml.namespace.QName;

/**
 * A HTTP operation extension.
 *
 * @author WS Development Team
 */
public class HTTPOperation extends ExtensionImpl {

    public HTTPOperation(Locator locator) {
        super(locator);
    }

    public QName getElementName() {
        return HTTPConstants.QNAME_OPERATION;
    }

    public String getLocation() {
        return _location;
    }

    public void setLocation(String s) {
        _location = s;
    }

    public void validateThis() {
        if (_location == null) {
            failValidation("validation.missingRequiredAttribute", "location");
        }
    }

    private String _location;
}
