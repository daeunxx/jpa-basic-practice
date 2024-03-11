package jpabook.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Team {

  @Id @GeneratedValue
  @Column(name = "team_id")
  private Long id;

  private String name;

//  @OneToMany(mappedBy = "team")
//  private List<Member> members = new ArrayList<>();

}
