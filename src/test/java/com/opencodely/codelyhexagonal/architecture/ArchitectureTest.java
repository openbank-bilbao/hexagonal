package com.opencodely.codelyhexagonal.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.opencodely.codelyhexagonal")
public class ArchitectureTest {

  @ArchTest
  void testApplicationLayerDependencies(JavaClasses classes) {
    classes().that().resideInAPackage("..application..")
      .should().onlyDependOnClassesThat().resideOutsideOfPackage("..infrastructure..")
      .check(classes);
  }

  @ArchTest
  void testDomainLayerDependencies(JavaClasses classes) {
    classes().that().resideInAPackage("..domain..")
      .should().onlyDependOnClassesThat().resideOutsideOfPackages("..application..", "..infrastructure..")
      .check(classes);
  }
}
