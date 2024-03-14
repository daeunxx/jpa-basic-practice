package jpabook.jpashop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address_history")
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

  @Id @GeneratedValue
  private Long id;

  private Address address;

  public AddressEntity(Address address) {
    this.address = address;
  }
}
