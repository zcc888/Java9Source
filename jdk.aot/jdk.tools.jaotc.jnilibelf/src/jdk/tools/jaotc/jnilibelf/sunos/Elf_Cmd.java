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

package jdk.tools.jaotc.jnilibelf.sunos;

/**
 * Represent Elf_Cmd enums defined in libelf.h on SunOS as they slightly different from libelf.h on
 * Linux.
 */
public enum Elf_Cmd {
    /** Must be first, 0. */
    ELF_C_NULL,

    ELF_C_READ,
    ELF_C_WRITE,
    ELF_C_CLR,
    ELF_C_SET,
    ELF_C_FDDONE,
    ELF_C_FDREAD,
    ELF_C_RDWR,
    ELF_C_WRIMAGE,
    ELF_C_IMAGE,

    /** Must be last. */
    ELF_C_NUM

}
