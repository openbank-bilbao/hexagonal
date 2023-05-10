package com.opencodely.codelyhexagonal.route.infrastructure.persistance;

import com.opencodely.codelyhexagonal.shared.domain.Grade;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@Table(name = "route")
@AllArgsConstructor
@NoArgsConstructor
public class RouteJpaEntity {
  @Id
  private String id;
  private String name;
  private String crag;
  @Enumerated(EnumType.STRING)
  private Grade baseGrade;
  @Enumerated(EnumType.STRING)
  private Grade consensusGrade;
  private int ascentNumber = 0;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
      return false;
    RouteJpaEntity that = (RouteJpaEntity) o;
    return getId() != null && Objects.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
