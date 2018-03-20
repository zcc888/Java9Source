// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: GraphUtil.java
package org.graalvm.compiler.nodes.util;

import java.util.*;
import org.graalvm.compiler.options.*;

public class GraphUtil_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("VerifyKillCFGUnusedNodes")) {
            return OptionDescriptor.create("VerifyKillCFGUnusedNodes", Boolean.class, "Verify that there are no new unused nodes when performing killCFG", GraphUtil.Options.class, "VerifyKillCFGUnusedNodes", GraphUtil.Options.VerifyKillCFGUnusedNodes);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("VerifyKillCFGUnusedNodes", Boolean.class, "Verify that there are no new unused nodes when performing killCFG", GraphUtil.Options.class, "VerifyKillCFGUnusedNodes", GraphUtil.Options.VerifyKillCFGUnusedNodes)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
