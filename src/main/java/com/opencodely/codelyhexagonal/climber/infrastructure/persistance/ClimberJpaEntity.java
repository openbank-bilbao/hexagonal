package com.opencodely.codelyhexagonal.climber.infrastructure.persistance;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "climber")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClimberJpaEntity {
  @Id
  private String id;
  @NotNull
  private String name;
  @NotNull
  private String email;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
      return false;
    ClimberJpaEntity that = (ClimberJpaEntity) o;
    return getId() != null && Objects.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
