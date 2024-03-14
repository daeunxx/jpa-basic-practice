package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Period {

  private LocalDateTime startDate;
  private LocalDateTime endDate;
}
