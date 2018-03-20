/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.hotspot.replacements.UnsafeAccess.UNSAFE;
import static org.graalvm.compiler.replacements.SnippetTemplate.DEFAULT_REPLACER;

import org.graalvm.compiler.api.replacements.Fold;
import org.graalvm.compiler.api.replacements.Snippet;
import org.graalvm.compiler.api.replacements.Snippet.ConstantParameter;
import org.graalvm.compiler.core.common.LocationIdentity;
import org.graalvm.compiler.hotspot.meta.HotSpotProviders;
import org.graalvm.compiler.nodes.NamedLocationIdentity;
import org.graalvm.compiler.nodes.debug.StringToBytesNode;
import org.graalvm.compiler.nodes.java.NewArrayNode;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.replacements.SnippetTemplate;
import org.graalvm.compiler.replacements.SnippetTemplate.AbstractTemplates;
import org.graalvm.compiler.replacements.SnippetTemplate.Arguments;
import org.graalvm.compiler.replacements.SnippetTemplate.SnippetInfo;
import org.graalvm.compiler.replacements.Snippets;
import org.graalvm.compiler.replacements.nodes.CStringConstant;
import org.graalvm.compiler.word.Word;

import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.meta.JavaKind;

/**
 * The {@code StringToBytesSnippets} contains a snippet for lowering {@link StringToBytesNode}.
 */
public class StringToBytesSnippets implements Snippets {

    public static final LocationIdentity CSTRING_LOCATION = NamedLocationIdentity.immutable("CString location");

    @Fold
    static long arrayBaseOffset() {
        return UNSAFE.arrayBaseOffset(char[].class);
    }

    @Snippet
    public static byte[] transform(@ConstantParameter String compilationTimeString) {
        int i = compilationTimeString.length();
        byte[] array = (byte[]) NewArrayNode.newUninitializedArray(byte.class, i);
        Word cArray = CStringConstant.cstring(compilationTimeString);
        while (i-- > 0) {
            // array[i] = cArray.readByte(i);
            UNSAFE.putByte(array, arrayBaseOffset() + i, cArray.readByte(i, CSTRING_LOCATION));
        }
        return array;
    }

    public static class Templates extends AbstractTemplates {

        private final SnippetInfo create;

        public Templates(HotSpotProviders providers, TargetDescription target) {
            super(providers, providers.getSnippetReflection(), target);
            create = snippet(StringToBytesSnippets.class, "transform", NamedLocationIdentity.getArrayLocation(JavaKind.Byte));
        }

        public void lower(StringToBytesNode stringToBytesNode, LoweringTool tool) {
            Arguments args = new Arguments(create, stringToBytesNode.graph().getGuardsStage(), tool.getLoweringStage());
            args.addConst("compilationTimeString", stringToBytesNode.getValue());
            SnippetTemplate template = template(args);
            template.instantiate(providers.getMetaAccess(), stringToBytesNode, DEFAULT_REPLACER, args);
        }

    }

}
