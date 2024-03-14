package jpabook.jpashop.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "member_id")
  private Long id;
  private String username;

  // Period
  @Embedded
  private Period period;

  // Address
  @Embedded
  private Address homeAddress;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "city", column = @Column(name = "city2")),
      @AttributeOverride(name = "street", column = @Column(name = "street2")),
      @AttributeOverride(name = "zipcode", column = @Column(name = "zipcode2"))
  })
  private Address workAddress;

//  @OneToMany(mappedBy = "member")
//  private List<Order> orders = new ArrayList<>();
}
