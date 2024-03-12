package jpabook.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

  @Id @GeneratedValue
  @Column(name = "member_id")
  private Long id;

  private String username;

  private String city;

  private String street;

  private String zipcode;

//  @OneToMany(mappedBy = "member")
//  private List<Order> orders = new ArrayList<>();
}
