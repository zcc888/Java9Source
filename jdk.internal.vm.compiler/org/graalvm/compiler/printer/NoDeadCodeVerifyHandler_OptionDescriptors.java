// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: NoDeadCodeVerifyHandler.java
package org.graalvm.compiler.printer;

import java.util.*;
import org.graalvm.compiler.options.*;

public class NoDeadCodeVerifyHandler_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("NDCV")) {
            return OptionDescriptor.create("NDCV", Integer.class, "Run level for NoDeadCodeVerifyHandler (0 = off, 1 = info, 2 = verbose, 3 = fatal)", NoDeadCodeVerifyHandler.Options.class, "NDCV", NoDeadCodeVerifyHandler.Options.NDCV);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("NDCV", Integer.class, "Run level for NoDeadCodeVerifyHandler (0 = off, 1 = info, 2 = verbose, 3 = fatal)", NoDeadCodeVerifyHandler.Options.class, "NDCV", NoDeadCodeVerifyHandler.Options.NDCV)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
