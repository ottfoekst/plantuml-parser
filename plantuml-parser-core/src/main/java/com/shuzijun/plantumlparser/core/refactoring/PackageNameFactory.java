package com.shuzijun.plantumlparser.core.refactoring;

import com.github.javaparser.ast.PackageDeclaration;
import com.shuzijun.plantumlparser.core.ParserConfig;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class PackageNameFactory {
    public static PackageName create(ParserConfig parserConfig, Optional<PackageDeclaration> packageDeclaration) {
        if (parserConfig.isShowPackage()) {
            return PackageName.valueOf(packageDeclaration);
        } else {
            return PackageName.EMPTY;
        }
    }
}
