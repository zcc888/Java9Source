/*
 * Copyright (c) 2016, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.lir.jtt;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.common.PermanentBailoutException;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;
import org.graalvm.compiler.lir.gen.LIRGeneratorTool;

import jdk.vm.ci.code.BailoutException;
import jdk.vm.ci.meta.ResolvedJavaMethod;
import jdk.vm.ci.meta.Value;
import jdk.vm.ci.sparc.SPARC;

/**
 * Tests the {@link BailoutException} thrown, when trying to compile huge methods, which have branch
 * displacements which does not fit into 19 bit signed.
 */
public class SPARCBranchBailoutTest extends LIRTest {
    private static class BranchSpec extends LIRTestSpecification {
        private final int n;

        BranchSpec(int n) {
            super();
            this.n = n;
        }

        @Override
        public void generate(LIRGeneratorTool gen, Value a) {
            gen.append(new LargeOp(n));
            setResult(a);
        }
    }

    private static final BranchSpec spec = new BranchSpec(1 << 20);

    @LIRIntrinsic
    public static int branch(@SuppressWarnings("unused") BranchSpec s, int a) {
        return a;
    }

    public static int testBranch(int length) {
        int res = 1;
        if (length > 0) {
            res = branch(spec, 1);
        } else {
            res = branch(spec, 2);
        }
        return GraalDirectives.opaque(res);
    }

    @Test
    public void testBailoutOnBranchOverflow() throws Throwable {
        Assume.assumeTrue(getBackend().getTarget().arch instanceof SPARC);
        ResolvedJavaMethod m = getResolvedJavaMethod("testBranch");
        try {
            compile(m, null);
        } catch (GraalError e) {
            Assert.assertEquals(PermanentBailoutException.class, e.getCause().getClass());
        }
    }

    public static class LargeOp extends LIRInstruction {
        private static final LIRInstructionClass<LargeOp> TYPE = LIRInstructionClass.create(LargeOp.class);
        private final int n;

        public LargeOp(int n) {
            super(TYPE);
            this.n = n;
        }

        @Override
        public void emitCode(CompilationResultBuilder crb) {
            for (int i = 0; i < n; i++) {
                crb.asm.emitInt(0);
            }
        }
    }
}
