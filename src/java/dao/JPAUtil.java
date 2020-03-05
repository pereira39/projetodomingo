package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author silviacb
 */
public class JPAUtil {
    private static EntityManagerFactory emf;
    public static EntityManager getEntityManager() {
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("ProjetoDomingoPU");
        return emf.createEntityManager();
    }
    public void fechaEntityManager(){
        emf.close();
    }
}
