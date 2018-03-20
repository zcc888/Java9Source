// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: DefaultLoopPolicies.java
package org.graalvm.compiler.loop;

import java.util.*;
import org.graalvm.compiler.options.*;

public class DefaultLoopPolicies_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "ExactFullUnrollMaxNodes": return OptionDescriptor.create("ExactFullUnrollMaxNodes", Integer.class, "", DefaultLoopPolicies.class, "ExactFullUnrollMaxNodes", DefaultLoopPolicies.ExactFullUnrollMaxNodes);
            case "FullUnrollMaxIterations": return OptionDescriptor.create("FullUnrollMaxIterations", Integer.class, "", DefaultLoopPolicies.class, "FullUnrollMaxIterations", DefaultLoopPolicies.FullUnrollMaxIterations);
            case "FullUnrollMaxNodes": return OptionDescriptor.create("FullUnrollMaxNodes", Integer.class, "", DefaultLoopPolicies.class, "FullUnrollMaxNodes", DefaultLoopPolicies.FullUnrollMaxNodes);
            case "LoopUnswitchFrequencyBoost": return OptionDescriptor.create("LoopUnswitchFrequencyBoost", Double.class, "", DefaultLoopPolicies.class, "LoopUnswitchFrequencyBoost", DefaultLoopPolicies.LoopUnswitchFrequencyBoost);
            case "LoopUnswitchMaxIncrease": return OptionDescriptor.create("LoopUnswitchMaxIncrease", Integer.class, "", DefaultLoopPolicies.class, "LoopUnswitchMaxIncrease", DefaultLoopPolicies.LoopUnswitchMaxIncrease);
            case "LoopUnswitchTrivial": return OptionDescriptor.create("LoopUnswitchTrivial", Integer.class, "", DefaultLoopPolicies.class, "LoopUnswitchTrivial", DefaultLoopPolicies.LoopUnswitchTrivial);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("ExactFullUnrollMaxNodes", Integer.class, "", DefaultLoopPolicies.class, "ExactFullUnrollMaxNodes", DefaultLoopPolicies.ExactFullUnrollMaxNodes),
            OptionDescriptor.create("FullUnrollMaxIterations", Integer.class, "", DefaultLoopPolicies.class, "FullUnrollMaxIterations", DefaultLoopPolicies.FullUnrollMaxIterations),
            OptionDescriptor.create("FullUnrollMaxNodes", Integer.class, "", DefaultLoopPolicies.class, "FullUnrollMaxNodes", DefaultLoopPolicies.FullUnrollMaxNodes),
            OptionDescriptor.create("LoopUnswitchFrequencyBoost", Double.class, "", DefaultLoopPolicies.class, "LoopUnswitchFrequencyBoost", DefaultLoopPolicies.LoopUnswitchFrequencyBoost),
            OptionDescriptor.create("LoopUnswitchMaxIncrease", Integer.class, "", DefaultLoopPolicies.class, "LoopUnswitchMaxIncrease", DefaultLoopPolicies.LoopUnswitchMaxIncrease),
            OptionDescriptor.create("LoopUnswitchTrivial", Integer.class, "", DefaultLoopPolicies.class, "LoopUnswitchTrivial", DefaultLoopPolicies.LoopUnswitchTrivial)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
