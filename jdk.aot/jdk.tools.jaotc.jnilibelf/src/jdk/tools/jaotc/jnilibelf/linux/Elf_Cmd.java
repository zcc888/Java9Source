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

package jdk.tools.jaotc.jnilibelf.linux;

/**
 * Represent Elf_Cmd enums defined in libelf.h on Linux as they slightly different from libelf.h on
 * SunOS.
 */
public enum Elf_Cmd {
    /** Nothing, terminate, or compute only. */
    ELF_C_NULL,

    /** Read. */
    ELF_C_READ,

    /** Read and write. */
    ELF_C_RDWR,

    /** Write. */
    ELF_C_WRITE,

    /** Clear flag. */
    ELF_C_CLR,

    /** Set flag. */
    ELF_C_SET,

    /**
     * Signal that file descriptor will not be used anymore.
     */
    ELF_C_FDDONE,

    /**
     * Read rest of data so that file descriptor is not used anymore.
     */
    ELF_C_FDREAD,

    /* The following are extensions. */

    /** Read, but mmap the file if possible. */
    ELF_C_READ_MMAP,

    /** Read and write, with mmap. */
    ELF_C_RDWR_MMAP,

    /** Write, with mmap. */
    ELF_C_WRITE_MMAP,

    /**
     * Read, but memory is writable, results are not written to the file.
     */
    ELF_C_READ_MMAP_PRIVATE,

    /** Copy basic file data but not the content. */
    ELF_C_EMPTY,

    /** Keep this the last entry. */
    ELF_C_NUM;
}
