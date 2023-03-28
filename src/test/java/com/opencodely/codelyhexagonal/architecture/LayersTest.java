package com.opencodely.codelyhexagonal.architecture;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = "com.opencodely.codelyhexagonal")
public class LayersTest {

    @ArchTest
    void testApplicationLayerDependencies(JavaClasses classes) {
        onionArchitecture()
            .domainModels("..domain..")
            .applicationServices("..application..")
            .adapter("..infraestructure..")
            .check(classes);
    }
}
