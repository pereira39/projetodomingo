package dao;


import classes.Consulta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;


public class ConsultaDAO {
private EntityManager em;

    public ConsultaDAO() {
    }


    public Consulta pesquisarPorId(long id) {
        em = JPAUtil.getEntityManager();
        return (Consulta) em.find(Consulta.class, id);
    }
    
    
     public Consulta buscar(long id) {
        em = JPAUtil.getEntityManager();
        Consulta consulta = em.find(Consulta.class, id);
        em.close();
        return consulta;
    }

    public void remover(long id) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {

            em.remove(em.getReference(Consulta.class, id));
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("Não existe o id: " + id);
        } finally {
            em.close();
        }

    }

    public Consulta atualizar(Consulta consulta) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(consulta);
        em.getTransaction().commit();
        em.close();
    return null;
    }

    public void salvar(Consulta consulta) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(consulta);
        em.getTransaction().commit();
        em.close();
    }

    public List<Consulta> buscarTodos() {
        em = JPAUtil.getEntityManager();
        return em.createQuery("Select entity from Consulta entity").getResultList();
    }

}
