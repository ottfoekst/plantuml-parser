package com.shuzijun.plantumlparser.core.refactoring;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import lombok.experimental.UtilityClass;

import java.util.Objects;

@UtilityClass
public class VisibilitySpecifyService {
    public static Visibility findVisibility(NodeList<Modifier> modifiers) {
        return modifiers.stream()
                .map(Visibility::valueOf)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(Visibility.DEFAULT);
    }
}
