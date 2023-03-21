package com.opencodely.codelyhexagonal.ascent.infrastructure.persistance;

import com.opencodely.codelyhexagonal.climber.infrastructure.persistance.ClimberJpaEntity;
import com.opencodely.codelyhexagonal.route.infrastructure.persistance.RouteJpaEntity;
import com.opencodely.codelyhexagonal.shared.domain.Grade;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

@Entity
@Table(name = "ascent")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AscentJpaEntity {

  @Id
  private UUID id;
  @NotNull
  @ManyToOne(fetch = FetchType.LAZY)
  private ClimberJpaEntity climber;
  @NotNull
  @ManyToOne(fetch = FetchType.LAZY)
  private RouteJpaEntity route;
  @Enumerated(EnumType.STRING)
  private Grade proposedGrade;
  private LocalDate ascensionDate = LocalDate.now();

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    final AscentJpaEntity that = (AscentJpaEntity) o;
    return getId() != null && Objects.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
