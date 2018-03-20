/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jaotc;

import jdk.vm.ci.hotspot.HotSpotJVMCIRuntime;

/**
 * Constants used to mark special positions in code being installed into the code cache by Graal C++
 * code.
 */
enum MarkId {
    VERIFIED_ENTRY("CodeInstaller::VERIFIED_ENTRY"),
    UNVERIFIED_ENTRY("CodeInstaller::UNVERIFIED_ENTRY"),
    OSR_ENTRY("CodeInstaller::OSR_ENTRY"),
    EXCEPTION_HANDLER_ENTRY("CodeInstaller::EXCEPTION_HANDLER_ENTRY"),
    DEOPT_HANDLER_ENTRY("CodeInstaller::DEOPT_HANDLER_ENTRY"),
    INVOKEINTERFACE("CodeInstaller::INVOKEINTERFACE"),
    INVOKEVIRTUAL("CodeInstaller::INVOKEVIRTUAL"),
    INVOKESTATIC("CodeInstaller::INVOKESTATIC"),
    INVOKESPECIAL("CodeInstaller::INVOKESPECIAL"),
    INLINE_INVOKE("CodeInstaller::INLINE_INVOKE"),
    POLL_NEAR("CodeInstaller::POLL_NEAR"),
    POLL_RETURN_NEAR("CodeInstaller::POLL_RETURN_NEAR"),
    POLL_FAR("CodeInstaller::POLL_FAR"),
    POLL_RETURN_FAR("CodeInstaller::POLL_RETURN_FAR"),
    CARD_TABLE_ADDRESS("CodeInstaller::CARD_TABLE_ADDRESS"),
    HEAP_TOP_ADDRESS("CodeInstaller::HEAP_TOP_ADDRESS"),
    HEAP_END_ADDRESS("CodeInstaller::HEAP_END_ADDRESS"),
    NARROW_KLASS_BASE_ADDRESS("CodeInstaller::NARROW_KLASS_BASE_ADDRESS"),
    NARROW_OOP_BASE_ADDRESS("CodeInstaller::NARROW_OOP_BASE_ADDRESS"),
    CRC_TABLE_ADDRESS("CodeInstaller::CRC_TABLE_ADDRESS"),
    LOG_OF_HEAP_REGION_GRAIN_BYTES("CodeInstaller::LOG_OF_HEAP_REGION_GRAIN_BYTES"),
    INLINE_CONTIGUOUS_ALLOCATION_SUPPORTED("CodeInstaller::INLINE_CONTIGUOUS_ALLOCATION_SUPPORTED");

    private final int value;

    private MarkId(String name) {
        this.value = (int) (long) HotSpotJVMCIRuntime.runtime().getConfigStore().getConstants().get(name);
    }

    public static MarkId getEnum(int value) {
        for (MarkId e : values()) {
            if (e.value == value) {
                return e;
            }
        }
        throw new InternalError("Unknown enum value: " + value);
    }
}
