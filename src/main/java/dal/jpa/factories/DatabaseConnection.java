package dal.jpa.factories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseConnection {

    public static final String JPA_DEMO_PERSISTENCE_UNIT = "JPA_Demo";

    private static EntityManagerFactory entityManagerFactory;

    private DatabaseConnection() {}

    public static EntityManagerFactory getInstance() {
        if(entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(JPA_DEMO_PERSISTENCE_UNIT);
        }
        return entityManagerFactory;
    }

    public void closeEmf() {
        if(entityManagerFactory.isOpen() || entityManagerFactory != null) {
            entityManagerFactory.close();
        }
        entityManagerFactory = null;
    }
}
