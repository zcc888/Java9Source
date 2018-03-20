// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: SnippetTemplate.java
package org.graalvm.compiler.replacements;

import java.util.*;
import org.graalvm.compiler.options.*;

public class SnippetTemplate_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        // CheckStyle: stop line length check
        switch (value) {
            case "MaxTemplatesPerSnippet": return OptionDescriptor.create("MaxTemplatesPerSnippet", Integer.class, "", SnippetTemplate.Options.class, "MaxTemplatesPerSnippet", SnippetTemplate.Options.MaxTemplatesPerSnippet);
            case "UseSnippetTemplateCache": return OptionDescriptor.create("UseSnippetTemplateCache", Boolean.class, "Use a LRU cache for snippet templates.", SnippetTemplate.Options.class, "UseSnippetTemplateCache", SnippetTemplate.Options.UseSnippetTemplateCache);
        }
        // CheckStyle: resume line length check
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            OptionDescriptor.create("MaxTemplatesPerSnippet", Integer.class, "", SnippetTemplate.Options.class, "MaxTemplatesPerSnippet", SnippetTemplate.Options.MaxTemplatesPerSnippet),
            OptionDescriptor.create("UseSnippetTemplateCache", Boolean.class, "Use a LRU cache for snippet templates.", SnippetTemplate.Options.class, "UseSnippetTemplateCache", SnippetTemplate.Options.UseSnippetTemplateCache)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
