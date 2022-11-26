package com.shuzijun.plantumlparser.core.refactoring;

import com.github.javaparser.ast.PackageDeclaration;
import lombok.*;

import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class PackageName {
    static final PackageName EMPTY = new PackageName("");

    private final String name;

    public String getNameAsString() {
        return name;
    }

    public static PackageName valueOf(Optional<PackageDeclaration> packageDeclaration) {
        if (packageDeclaration.isPresent()) {
            return new PackageName(packageDeclaration.get().getNameAsString().trim());
        } else {
            return EMPTY;
        }
    }
}
