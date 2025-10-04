package github.dev.xero;

import github.dev.xero.config.HibernateConfig;
import github.dev.xero.config.LoggerUtil;
import jakarta.persistence.EntityManager;
import github.dev.xero.model.Player;

public class Main {
    public static void main(String[] args) {
        EntityManager em = HibernateConfig.getEntityManager();
        em.getTransaction().begin();

        Player playerOne = new Player("algo_xero", "xero@email.com", "pass_hash_one");
        Player playerTwo = new Player("torvalds", "torvalds@email.com", "pass_hash_two");

        em.persist(playerOne);
        em.persist(playerTwo);

        LoggerUtil.info("Successfully persisted player one and two");

        em.getTransaction().commit();
        em.close();
    }
}
