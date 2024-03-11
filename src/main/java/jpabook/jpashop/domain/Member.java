package jpabook.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

  @Id @GeneratedValue
  @Column(name = "member_id")
  private Long id;

  private String username;

  @ManyToOne
  @JoinColumn(name = "team_id")
  private Team team;

  private String city;

  private String street;

  private String zipcode;

  public void changeTeam(Team team) {
    this.team = team;
    team.getMembers().add(this);
  }
}
