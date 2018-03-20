// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: NodeClass.java
package org.graalvm.compiler.graph;

import java.util.*;
import org.graalvm.compiler.options.*;

public class NodeClass_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        if (value.equals("VerifyNodeCostOnAccess")) {
            return OptionDescriptor.create("VerifyNodeCostOnAccess", Boolean.class, "Verifies that receivers of NodeInfo#size() and NodeInfo#cycles() do not have UNSET values.", NodeClass.Options.class, "VerifyNodeCostOnAccess", NodeClass.Options.VerifyNodeCostOnAccess);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("VerifyNodeCostOnAccess", Boolean.class, "Verifies that receivers of NodeInfo#size() and NodeInfo#cycles() do not have UNSET values.", NodeClass.Options.class, "VerifyNodeCostOnAccess", NodeClass.Options.VerifyNodeCostOnAccess)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
