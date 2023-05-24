package com.opencodely.codelyhexagonal.ascent.infraestructure;

import com.opencodely.codelyhexagonal.ascent.domain.Ascent;
import com.opencodely.codelyhexagonal.ascent.domain.AscentSupplier;
import com.opencodely.codelyhexagonal.ascent.infrastructure.persistance.AscentJpaRepositoryAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;


@Testcontainers
@SpringBootTest
public class AscentPersistenceIT {

  @Container
  static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:9-alpine"));
  @Autowired
  private AscentJpaRepositoryAdapter ascentRepository;

  @DynamicPropertySource
  static void postgresqlProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", postgres::getJdbcUrl);
    registry.add("spring.datasource.password", postgres::getPassword);
    registry.add("spring.datasource.username", postgres::getUsername);
  }

  @Test
  @Sql(statements = {
    "INSERT INTO climber (id, name, email) VALUES ('0f14d0ab-9605-4a62-a9e4-5ed26688389b', 'Jon', 'jon@sputnik.com')",
    "INSERT INTO route (id, name, crag, base_grade, ascent_number) VALUES ('0f14d0ab-9605-4a62-a9e4-5ed26688389b', 'Pinches', 'Valde', 'GRADE_6C', 0)"
  })
  void should_save() {
    Ascent ascent = AscentSupplier.ascentBuilder()
      .climberId("0f14d0ab-9605-4a62-a9e4-5ed26688389b")
      .routeId("0f14d0ab-9605-4a62-a9e4-5ed26688389b")
      .build();
    ascentRepository.save(ascent);
  }
}
