/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.arrayBaseOffset;

import java.util.zip.CRC32;

import org.graalvm.compiler.api.replacements.ClassSubstitution;
import org.graalvm.compiler.api.replacements.Fold;
import org.graalvm.compiler.api.replacements.Fold.InjectedParameter;
import org.graalvm.compiler.api.replacements.MethodSubstitution;
import org.graalvm.compiler.core.common.spi.ForeignCallDescriptor;
import org.graalvm.compiler.graph.Node.ConstantNodeParameter;
import org.graalvm.compiler.graph.Node.NodeIntrinsic;
import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.hotspot.nodes.ComputeObjectAddressNode;
import org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode;
import org.graalvm.compiler.nodes.extended.ForeignCallNode;
import org.graalvm.compiler.word.Word;

import jdk.vm.ci.meta.JavaKind;

// JaCoCo Exclude

/**
 * Substitutions for {@link CRC32}.
 */
@ClassSubstitution(CRC32.class)
public class CRC32Substitutions {

    /**
     * Gets the address of {@code StubRoutines::x86::_crc_table} in {@code stubRoutines_x86.hpp}.
     */
    @Fold
    static long crcTableAddress(@InjectedParameter GraalHotSpotVMConfig config) {
        return config.crcTableAddress;
    }

    @MethodSubstitution(optional = true)
    static int update(int crc, int b) {
        final long crcTableRawAddress = GraalHotSpotVMConfigNode.crcTableAddress();

        int c = ~crc;
        int index = (b ^ c) & 0xFF;
        int offset = index << 2;
        int result = Word.unsigned(crcTableRawAddress).readInt(offset);
        result = result ^ (c >>> 8);
        return ~result;
    }

    @MethodSubstitution(optional = true)
    static int updateBytes(int crc, byte[] buf, int off, int len) {
        Word bufAddr = Word.unsigned(ComputeObjectAddressNode.get(buf, arrayBaseOffset(JavaKind.Byte) + off));
        return updateBytesCRC32(UPDATE_BYTES_CRC32, crc, bufAddr, len);
    }

    /**
     * @since 9
     */
    @MethodSubstitution(optional = true)
    static int updateBytes0(int crc, byte[] buf, int off, int len) {
        Word bufAddr = Word.unsigned(ComputeObjectAddressNode.get(buf, arrayBaseOffset(JavaKind.Byte) + off));
        return updateBytesCRC32(UPDATE_BYTES_CRC32, crc, bufAddr, len);
    }

    @MethodSubstitution(optional = true)
    static int updateByteBuffer(int crc, long addr, int off, int len) {
        Word bufAddr = Word.unsigned(addr).add(off);
        return updateBytesCRC32(UPDATE_BYTES_CRC32, crc, bufAddr, len);
    }

    /**
     * @since 9
     */
    @MethodSubstitution(optional = true)
    static int updateByteBuffer0(int crc, long addr, int off, int len) {
        Word bufAddr = Word.unsigned(addr).add(off);
        return updateBytesCRC32(UPDATE_BYTES_CRC32, crc, bufAddr, len);
    }

    public static final ForeignCallDescriptor UPDATE_BYTES_CRC32 = new ForeignCallDescriptor("updateBytesCRC32", int.class, int.class, Word.class, int.class);

    @NodeIntrinsic(ForeignCallNode.class)
    public static native int updateBytesCRC32(@ConstantNodeParameter ForeignCallDescriptor descriptor, int crc, Word buf, int length);
}
