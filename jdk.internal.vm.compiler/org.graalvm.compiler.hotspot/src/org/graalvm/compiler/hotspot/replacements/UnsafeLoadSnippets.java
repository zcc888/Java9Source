/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.replacements;

import static org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.referentOffset;
import static org.graalvm.compiler.replacements.SnippetTemplate.DEFAULT_REPLACER;

import org.graalvm.compiler.api.replacements.Snippet;
import org.graalvm.compiler.hotspot.meta.HotSpotProviders;
import org.graalvm.compiler.nodes.extended.FixedValueAnchorNode;
import org.graalvm.compiler.nodes.extended.UnsafeLoadNode;
import org.graalvm.compiler.nodes.memory.HeapAccess.BarrierType;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.replacements.SnippetTemplate.AbstractTemplates;
import org.graalvm.compiler.replacements.SnippetTemplate.Arguments;
import org.graalvm.compiler.replacements.SnippetTemplate.SnippetInfo;
import org.graalvm.compiler.replacements.Snippets;
import org.graalvm.compiler.word.Word;

import jdk.vm.ci.code.TargetDescription;

public class UnsafeLoadSnippets implements Snippets {

    @Snippet
    public static Object lowerUnsafeLoad(Object object, long offset) {
        Object fixedObject = FixedValueAnchorNode.getObject(object);
        if (object instanceof java.lang.ref.Reference && referentOffset() == offset) {
            return Word.objectToTrackedPointer(fixedObject).readObject((int) offset, BarrierType.PRECISE);
        } else {
            return Word.objectToTrackedPointer(fixedObject).readObject((int) offset, BarrierType.NONE);
        }
    }

    public static class Templates extends AbstractTemplates {

        private final SnippetInfo unsafeLoad = snippet(UnsafeLoadSnippets.class, "lowerUnsafeLoad");

        public Templates(HotSpotProviders providers, TargetDescription target) {
            super(providers, providers.getSnippetReflection(), target);
        }

        public void lower(UnsafeLoadNode load, LoweringTool tool) {
            Arguments args = new Arguments(unsafeLoad, load.graph().getGuardsStage(), tool.getLoweringStage());
            args.add("object", load.object());
            args.add("offset", load.offset());
            template(args).instantiate(providers.getMetaAccess(), load, DEFAULT_REPLACER, args);
        }
    }
}
