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

import jdk.tools.jaotc.CompiledMethodInfo.StubInformation;
import jdk.tools.jaotc.amd64.AMD64ELFMacroAssembler;

import jdk.vm.ci.amd64.AMD64;
import jdk.vm.ci.code.Architecture;
import jdk.vm.ci.code.TargetDescription;

public interface ELFMacroAssembler {

    public static ELFMacroAssembler getELFMacroAssembler(TargetDescription target) {
        Architecture architecture = target.arch;
        if (architecture instanceof AMD64) {
            return new AMD64ELFMacroAssembler(target);
        } else {
            throw new InternalError("Unsupported architecture " + architecture);
        }
    }

    public int currentEndOfInstruction();

    public byte[] getPLTJumpCode();

    public byte[] getPLTStaticEntryCode(StubInformation stub);

    public byte[] getPLTVirtualEntryCode(StubInformation stub);

}
