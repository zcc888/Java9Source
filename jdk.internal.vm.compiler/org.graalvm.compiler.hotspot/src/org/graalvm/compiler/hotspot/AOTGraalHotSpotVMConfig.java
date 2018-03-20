/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot;

import jdk.vm.ci.hotspot.HotSpotVMConfigStore;

public class AOTGraalHotSpotVMConfig extends GraalHotSpotVMConfig {
    private final CompressEncoding aotOopEncoding;
    private final CompressEncoding aotKlassEncoding;

    public AOTGraalHotSpotVMConfig(HotSpotVMConfigStore store) {
        super(store);
        // In AOT, force the shift to be always equal to alignment therefore avoiding zero-shift.
        CompressEncoding vmOopEncoding = super.getOopEncoding();
        aotOopEncoding = new CompressEncoding(vmOopEncoding.base, vmOopEncoding.alignment, vmOopEncoding.alignment);
        CompressEncoding vmKlassEncoding = super.getKlassEncoding();
        aotKlassEncoding = new CompressEncoding(vmKlassEncoding.base, vmKlassEncoding.alignment, vmKlassEncoding.alignment);
        assert check();
    }

    @Override
    public CompressEncoding getOopEncoding() {
        return aotOopEncoding;
    }

    @Override
    public CompressEncoding getKlassEncoding() {
        return aotKlassEncoding;
    }
}
