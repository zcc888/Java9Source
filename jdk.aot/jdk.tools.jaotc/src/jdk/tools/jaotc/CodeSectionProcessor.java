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

import java.util.ArrayList;

import jdk.tools.jaotc.binformat.BinaryContainer;
import jdk.tools.jaotc.binformat.CodeContainer;
import jdk.tools.jaotc.binformat.Symbol;
import jdk.tools.jaotc.CompiledMethodInfo.StubInformation;
import org.graalvm.compiler.code.CompilationResult;
import org.graalvm.compiler.hotspot.HotSpotForeignCallLinkage;

import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.code.site.Call;
import jdk.vm.ci.code.site.Infopoint;
import jdk.vm.ci.code.site.InfopointReason;
import jdk.vm.ci.meta.ResolvedJavaMethod;

class CodeSectionProcessor {

    private final TargetDescription target;

    private final BinaryContainer binaryContainer;

    CodeSectionProcessor(DataBuilder dataBuilder) {
        this.target = dataBuilder.getBackend().getTarget();
        this.binaryContainer = dataBuilder.getBinaryContainer();
    }

    /**
     * Method that looks at code section of a compiled result {@code compClass} and records function
     * entry point symbols along with the text section contents. Note that the text section contents
     * are not yet ready to be written in the form of a binary text section since the contents may
     * need to be patched with references to other sections.
     *
     * @param compClass Graal compilation result.
     */
    void process(AOTCompiledClass compClass) {
        ArrayList<CompiledMethodInfo> compiledMethods = compClass.getCompiledMethods();

        for (CompiledMethodInfo methodInfo : compiledMethods) {
            CompilationResult compResult = methodInfo.getCompilationResult();

            byte[] targetCode = compResult.getTargetCode();
            int targetCodeSize = compResult.getTargetCodeSize();
            JavaMethodInfo compMethod = methodInfo.getMethodInfo();

            // Step through all foreign calls, for every call, clear destination.
            // Otherwise libelf may not patch them correctly.
            for (Infopoint infopoint : compResult.getInfopoints()) {
                if (infopoint.reason == InfopointReason.CALL) {
                    final Call callInfopoint = (Call) infopoint;
                    if (callInfopoint.target instanceof HotSpotForeignCallLinkage) {
                        // TODO 4 is x86 size of relative displacement.
                        // For SPARC need something different.
                        int destOffset = infopoint.pcOffset + callInfopoint.size - 4;
                        targetCode[destOffset + 0] = 0;
                        targetCode[destOffset + 1] = 0;
                        targetCode[destOffset + 2] = 0;
                        targetCode[destOffset + 3] = 0;
                    }
                }
            }

            String entry = compMethod.getSymbolName();
            assert entry != null : "missing name for compiled method";

            // Align and pad method entry
            CodeContainer codeSection = binaryContainer.getCodeContainer();
            int codeIdOffset = binaryContainer.alignUp(codeSection, binaryContainer.getCodeSegmentSize());
            // Store CodeId into code. It will be use by find_aot() using code.segments
            methodInfo.setCodeId();
            binaryContainer.appendIntToCode(methodInfo.getCodeId());
            int textBaseOffset = binaryContainer.alignUp(codeSection, binaryContainer.getCodeEntryAlignment());

            codeSection.createSymbol(textBaseOffset, Symbol.Kind.JAVA_FUNCTION, Symbol.Binding.LOCAL, targetCodeSize, entry);

            // Set the offset at which the text section of this method would be layed out
            methodInfo.setTextSectionOffset(textBaseOffset);

            // Write code bytes of the current method into byte stream
            binaryContainer.appendCodeBytes(targetCode, 0, targetCodeSize);
            int currentStubOffset = binaryContainer.alignUp(codeSection, 8);
            // Set the offset at which stubs of this method would be laid out
            methodInfo.setStubsOffset(currentStubOffset - textBaseOffset);
            // step through all calls, for every call, add a stub
            for (Infopoint infopoint : compResult.getInfopoints()) {
                if (infopoint.reason == InfopointReason.CALL) {
                    final Call callInfopoint = (Call) infopoint;
                    if (callInfopoint.target instanceof ResolvedJavaMethod) {
                        ResolvedJavaMethod call = (ResolvedJavaMethod) callInfopoint.target;
                        StubInformation stub = addCallStub(MiscUtils.isVirtualCall(methodInfo, callInfopoint));
                        // Get the targetSymbol. A symbol for this will be created later during plt
                        // creation
                        String targetSymbol = MiscUtils.uniqueMethodName(call) + ".at." + infopoint.pcOffset;
                        methodInfo.addStubCode(targetSymbol, stub);
                        currentStubOffset += stub.getSize();
                    }
                }
            }
            assert currentStubOffset == codeSection.getByteStreamSize() : "wrong offset";
            binaryContainer.addCodeSegments(codeIdOffset, currentStubOffset);
        }
    }

    private StubInformation addCallStub(boolean isVirtualCall) {
        final int startOffset = binaryContainer.getCodeContainer().getByteStreamSize();
        StubInformation stub = new StubInformation(startOffset, isVirtualCall);
        ELFMacroAssembler masm = ELFMacroAssembler.getELFMacroAssembler(target);
        byte[] code;
        if (isVirtualCall) {
            code = masm.getPLTVirtualEntryCode(stub);
        } else {
            code = masm.getPLTStaticEntryCode(stub);
        }
        binaryContainer.appendCodeBytes(code, 0, code.length);
        return stub;
    }

}
