import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.AddressEntity;
import jpabook.jpashop.domain.Member;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Address address = new Address("city", "street", "1");

      Member member = new Member();
      member.setUsername("member1");
      member.setWorkAddress(address);

      member.getFavoriteFoods().add("치킨");
      member.getFavoriteFoods().add("피자");

      member.getAddressEntityList().add(new AddressEntity(address));

      em.persist(member);

      em.flush();
      em.clear();

      System.out.println("=====================");
      Member findMember = em.find(Member.class, member.getId());

      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}
