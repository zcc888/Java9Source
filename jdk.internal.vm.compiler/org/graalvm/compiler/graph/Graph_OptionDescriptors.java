// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: Graph.java
package org.graalvm.compiler.graph;

import java.util.*;
import org.graalvm.compiler.options.*;

public class Graph_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "CloneNodesWithUnsafe": return OptionDescriptor.create("CloneNodesWithUnsafe", Boolean.class, "Use Unsafe to clone graph nodes thus avoiding copying fields that will be re-initialized anyway", Graph.Options.class, "CloneNodesWithUnsafe", Graph.Options.CloneNodesWithUnsafe);
            case "GraphCompressionThreshold": return OptionDescriptor.create("GraphCompressionThreshold", Integer.class, "Graal graph compression is performed when percent of live nodes falls below this value", Graph.Options.class, "GraphCompressionThreshold", Graph.Options.GraphCompressionThreshold);
            case "VerifyGraalGraphEdges": return OptionDescriptor.create("VerifyGraalGraphEdges", Boolean.class, "Perform expensive verification of graph inputs, usages, successors and predecessors", Graph.Options.class, "VerifyGraalGraphEdges", Graph.Options.VerifyGraalGraphEdges);
            case "VerifyGraalGraphs": return OptionDescriptor.create("VerifyGraalGraphs", Boolean.class, "Verify graphs often during compilation when assertions are turned on", Graph.Options.class, "VerifyGraalGraphs", Graph.Options.VerifyGraalGraphs);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("CloneNodesWithUnsafe", Boolean.class, "Use Unsafe to clone graph nodes thus avoiding copying fields that will be re-initialized anyway", Graph.Options.class, "CloneNodesWithUnsafe", Graph.Options.CloneNodesWithUnsafe),
            OptionDescriptor.create("GraphCompressionThreshold", Integer.class, "Graal graph compression is performed when percent of live nodes falls below this value", Graph.Options.class, "GraphCompressionThreshold", Graph.Options.GraphCompressionThreshold),
            OptionDescriptor.create("VerifyGraalGraphEdges", Boolean.class, "Perform expensive verification of graph inputs, usages, successors and predecessors", Graph.Options.class, "VerifyGraalGraphEdges", Graph.Options.VerifyGraalGraphEdges),
            OptionDescriptor.create("VerifyGraalGraphs", Boolean.class, "Verify graphs often during compilation when assertions are turned on", Graph.Options.class, "VerifyGraalGraphs", Graph.Options.VerifyGraalGraphs)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
