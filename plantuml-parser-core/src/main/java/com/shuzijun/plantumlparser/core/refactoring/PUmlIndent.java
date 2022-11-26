package com.shuzijun.plantumlparser.core.refactoring;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode
@ToString
public class PUmlIndent {
    private static final String TAB = "\t";

    private final int depth;

    public static PUmlIndent valueOf(int depth) {
        return new PUmlIndent(Math.max(0, depth));
    }

    public PUmlIndent increment() {
        return new PUmlIndent(depth + 1);
    }

    public String getIndentAsString() {
        return TAB.repeat(depth);
    }
}
