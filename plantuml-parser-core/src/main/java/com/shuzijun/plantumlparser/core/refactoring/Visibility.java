package com.shuzijun.plantumlparser.core.refactoring;

import com.github.javaparser.ast.Modifier;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Visibility {
    PUBLIC("public", '+'),
    DEFAULT("default", '~'),
    PROTECTED("protected", '#'),
    PRIVATE("private", '-');

    private final String name;
    private final char pUmlSymbol;

    public static Visibility valueOf(Modifier modifier) {
        if (modifier.getKeyword() == Modifier.Keyword.PUBLIC) {
            return PUBLIC;
        } else if (modifier.getKeyword() == Modifier.Keyword.DEFAULT) {
            return DEFAULT;
        } else if (modifier.getKeyword() == Modifier.Keyword.PROTECTED) {
            return PROTECTED;
        } else if (modifier.getKeyword() == Modifier.Keyword.PRIVATE) {
            return PRIVATE;
        } else {
            return null;
        }
    }
}
