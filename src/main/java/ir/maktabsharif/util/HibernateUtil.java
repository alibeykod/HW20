package ir.maktabsharif.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private static final String persistenceUnit = "postgres-pu";
    private static EntityManagerFactory emf;

    private HibernateUtil() {
    }

    public static EntityManagerFactory emf(){
        if (emf == null){
            emf = Persistence.createEntityManagerFactory(persistenceUnit);
        }
        return emf;
    }

}
