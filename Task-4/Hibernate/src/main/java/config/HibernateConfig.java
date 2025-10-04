package config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;

/**
 * Configure Hibernate Utility with EntityManager Factory
 */
public class HibernateConfig {
    private static final EntityManagerFactory emf;

    static {
        HashMap<String, String> overrides = new HashMap<>();

        String DB_URL = System.getenv("DB_URL");
        String DB_USER = System.getenv("DB_USER");
        String DB_PASS = System.getenv("DB_PASS");

        if (DB_URL == null || DB_USER == null || DB_PASS == null) {
            LoggerUtil.info("Database properties: DB_URL, DB_USER, DB_PASS not configured properly");
            System.exit(1);
        }

        overrides.put("jakarta.persistence.jdbc.url", DB_URL);
        overrides.put("jakarta.persistence.jdbc.user", DB_USER);
        overrides.put("jakarta.persistence.jdbc.pass", DB_PASS);

        emf = Persistence.createEntityManagerFactory("jpa", overrides);
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
