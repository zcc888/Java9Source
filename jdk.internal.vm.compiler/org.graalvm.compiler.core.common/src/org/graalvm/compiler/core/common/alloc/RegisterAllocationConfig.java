/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.core.common.alloc;

import static org.graalvm.compiler.core.common.GraalOptions.RegisterPressure;

import java.util.HashMap;
import java.util.Map;

import jdk.vm.ci.code.Register;
import jdk.vm.ci.code.RegisterArray;
import jdk.vm.ci.code.RegisterConfig;
import jdk.vm.ci.meta.PlatformKind;

import org.graalvm.compiler.core.common.GraalOptions;

/**
 * Configuration for register allocation. This is different to {@link RegisterConfig} as it only
 * returns registers specified by {@link GraalOptions#RegisterPressure}.
 */
public class RegisterAllocationConfig {

    public static final class AllocatableRegisters {
        public final Register[] allocatableRegisters;
        public final int minRegisterNumber;
        public final int maxRegisterNumber;

        public AllocatableRegisters(RegisterArray allocatableRegisters, int minRegisterNumber, int maxRegisterNumber) {
            this.allocatableRegisters = allocatableRegisters.toArray();
            this.minRegisterNumber = minRegisterNumber;
            this.maxRegisterNumber = maxRegisterNumber;
            assert verify(allocatableRegisters, minRegisterNumber, maxRegisterNumber);
        }

        private static boolean verify(RegisterArray allocatableRegisters, int minRegisterNumber, int maxRegisterNumber) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (Register reg : allocatableRegisters) {
                int number = reg.number;
                if (number < min) {
                    min = number;
                }
                if (number > max) {
                    max = number;
                }
            }
            assert minRegisterNumber == min;
            assert maxRegisterNumber == max;
            return true;
        }
    }

    public static final String ALL_REGISTERS = "<all>";

    private static Register findRegister(String name, RegisterArray all) {
        for (Register reg : all) {
            if (reg.name.equals(name)) {
                return reg;
            }
        }
        throw new IllegalArgumentException("register " + name + " is not allocatable");
    }

    protected RegisterArray initAllocatable(RegisterArray registers) {
        if (RegisterPressure.getValue() != null && !RegisterPressure.getValue().equals(ALL_REGISTERS)) {
            String[] names = RegisterPressure.getValue().split(",");
            Register[] regs = new Register[names.length];
            for (int i = 0; i < names.length; i++) {
                regs[i] = findRegister(names[i], registers);
            }
            return new RegisterArray(regs);
        }

        return registers;
    }

    protected final RegisterConfig registerConfig;
    private final Map<PlatformKind.Key, AllocatableRegisters> categorized = new HashMap<>();
    private RegisterArray cachedRegisters;

    public RegisterAllocationConfig(RegisterConfig registerConfig) {
        assert registerConfig != null;
        this.registerConfig = registerConfig;
    }

    /**
     * Gets the set of registers that can be used by the register allocator for a value of a
     * particular kind.
     */
    public AllocatableRegisters getAllocatableRegisters(PlatformKind kind) {
        PlatformKind.Key key = kind.getKey();
        if (categorized.containsKey(key)) {
            AllocatableRegisters val = categorized.get(key);
            return val;
        }
        AllocatableRegisters ret = createAllocatableRegisters(registerConfig.filterAllocatableRegisters(kind, getAllocatableRegisters()));
        categorized.put(key, ret);
        return ret;
    }

    protected AllocatableRegisters createAllocatableRegisters(RegisterArray registers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Register reg : registers) {
            int number = reg.number;
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }
        assert min < max;
        return new AllocatableRegisters(registers, min, max);

    }

    /**
     * Gets the set of registers that can be used by the register allocator.
     */
    public RegisterArray getAllocatableRegisters() {
        if (cachedRegisters == null) {
            cachedRegisters = initAllocatable(registerConfig.getAllocatableRegisters());
        }
        assert cachedRegisters != null;
        return cachedRegisters;
    }

    public RegisterConfig getRegisterConfig() {
        return registerConfig;
    }

}
