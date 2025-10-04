package github.dev.xero.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Configure Hibernate Utility with EntityManager Factory
 */
public class HibernateConfig {
    private static final EntityManagerFactory emf;

    static {
        HashMap<String, String> properties = new HashMap<>();

        String DB_URL = System.getenv("DB_URL");
        String DB_USER = System.getenv("DB_USER");
        String DB_PASS = System.getenv("DB_PASS");

        if (DB_URL == null || DB_USER == null || DB_PASS == null) {
            LoggerUtil.info("Database properties: DB_URL, DB_USER, DB_PASS not configured properly");
            System.exit(1);
        }

        properties.put("jakarta.persistence.jdbc.url", DB_URL);
        properties.put("jakarta.persistence.jdbc.user", DB_USER);
        properties.put("jakarta.persistence.jdbc.password", DB_PASS);

        emf = Persistence.createEntityManagerFactory("jpa", properties);
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
