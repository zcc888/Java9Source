// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: SPARCNodeMatchRules.java
package org.graalvm.compiler.core.sparc;

import java.util.*;
import org.graalvm.compiler.core.match.*;
import org.graalvm.compiler.core.gen.NodeMatchRules;
import org.graalvm.compiler.graph.Position;
import org.graalvm.compiler.serviceprovider.ServiceProvider;
import org.graalvm.compiler.nodes.memory.*;
import org.graalvm.compiler.nodes.calc.*;

@ServiceProvider(MatchStatementSet.class)
public class SPARCNodeMatchRules_MatchStatementSet implements MatchStatementSet {

    private static final String[] signExtend_arguments = new String[] {"root", "access"};
    private static final class MatchGenerator_signExtend implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_signExtend();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((SPARCNodeMatchRules) nodeMatchRules).signExtend((SignExtendNode) args[0], (Access) args[1]);
        }
        @Override
        public String getName() {
             return "signExtend";
        }
    }

    private static final String[] zeroExtend_arguments = new String[] {"root", "access"};
    private static final class MatchGenerator_zeroExtend implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_zeroExtend();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((SPARCNodeMatchRules) nodeMatchRules).zeroExtend((ZeroExtendNode) args[0], (Access) args[1]);
        }
        @Override
        public String getName() {
             return "zeroExtend";
        }
    }

    @Override
    public Class<? extends NodeMatchRules> forClass() {
        return SPARCNodeMatchRules.class;
    }

    @Override
    public List<MatchStatement> statements() {
        // Checkstyle: stop 
        Position[] SignExtendNode_positions = MatchRuleRegistry.findPositions(SignExtendNode.TYPE, new String[]{"value"});
        Position[] ZeroExtendNode_positions = MatchRuleRegistry.findPositions(ZeroExtendNode.TYPE, new String[]{"value"});

        List<MatchStatement> statements = Collections.unmodifiableList(Arrays.asList(
            new MatchStatement("signExtend", new MatchPattern(SignExtendNode.class, null, new MatchPattern(ReadNode.class, "access", true), SignExtendNode_positions, true), MatchGenerator_signExtend.instance, signExtend_arguments),
            new MatchStatement("signExtend", new MatchPattern(SignExtendNode.class, null, new MatchPattern(FloatingReadNode.class, "access", true), SignExtendNode_positions, true), MatchGenerator_signExtend.instance, signExtend_arguments),
            new MatchStatement("zeroExtend", new MatchPattern(ZeroExtendNode.class, null, new MatchPattern(ReadNode.class, "access", true), ZeroExtendNode_positions, true), MatchGenerator_zeroExtend.instance, zeroExtend_arguments),
            new MatchStatement("zeroExtend", new MatchPattern(ZeroExtendNode.class, null, new MatchPattern(FloatingReadNode.class, "access", true), ZeroExtendNode_positions, true), MatchGenerator_zeroExtend.instance, zeroExtend_arguments)
        ));
        // Checkstyle: resume
        return statements;
    }

}
