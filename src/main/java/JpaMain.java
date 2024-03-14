import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Period;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Address address = new Address("city", "street", "1");

      Member member1 = new Member();
      member1.setUsername("member1");
      member1.setWorkAddress(address);
      member1.setPeriod(new Period());
      em.persist(member1);

      Member member2 = new Member();
      member2.setUsername("member1");
      member2.setWorkAddress(address);
      member2.setPeriod(new Period());
      em.persist(member2);

//      member1.getWorkAddress().setCity("newCity");

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
