package jpabook.jpashop.domain;

import static jakarta.persistence.FetchType.LAZY;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Delivery extends BaseEntity {

  @Id @GeneratedValue
  @Column(name = "delivery_id")
  private Long id;

  @Embedded
  private Address address;
  private DeliveryStatus status;

  @OneToOne(mappedBy = "delivery", fetch = LAZY)
  private Order order;
}
