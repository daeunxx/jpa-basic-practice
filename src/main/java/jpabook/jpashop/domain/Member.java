package jpabook.jpashop.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
  @AttributeOverrides({@AttributeOverride(name = "city", column = @Column(name = "city2")),
      @AttributeOverride(name = "street", column = @Column(name = "street2")),
      @AttributeOverride(name = "zipcode", column = @Column(name = "zipcode2"))})
  private Address workAddress;

  @ElementCollection
  @CollectionTable(name = "favorite_food", joinColumns = @JoinColumn(name = "member_id"))
  @Column(name = "food_name")
  private Set<String> favoriteFoods = new HashSet<>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "member_id")
  private List<AddressEntity> addressEntityList = new ArrayList<>();

//  @ElementCollection
//  @CollectionTable(name = "address_history", joinColumns = @JoinColumn(name = "member_id"))
//  private List<Address> addressHistory = new ArrayList<>();

//  @OneToMany(mappedBy = "member")
//  private List<Order> orders = new ArrayList<>();
}
