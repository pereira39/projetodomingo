package dao;


import classes.Medico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;


public class MedicoDAO {
private EntityManager em;

    public MedicoDAO() {
    }

  public Medico buscar(long id) {
        em = JPAUtil.getEntityManager();
        Medico medico = em.find(Medico.class, id);
        em.close();
        return medico;
    }
    public Medico pesquisarPorId(long id) {
        em = JPAUtil.getEntityManager();
        return (Medico) em.find(Medico.class, id);
    }

    public void remover(long id) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {

            em.remove(em.getReference(Medico.class, id));
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("Não existe o id: " + id);
        } finally {
            em.close();
        }

    }

    public Medico atualizar(Medico medico) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(medico);
        em.getTransaction().commit();
        em.close();
    return null;
    }
    
    /*
     public void atualizar(Medico medico) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(medico);
        em.getTransaction().commit();
        em.close();
    }
    *///como era antes

    public void salvar(Medico medico) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(medico);
        em.getTransaction().commit();
        em.close();
    }
    public void cadastrarMed(Medico medico) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(medico);
        em.getTransaction().commit();
        em.close();
    }

    public List<Medico> buscarTodos() {
        em = JPAUtil.getEntityManager();
        return em.createQuery("Select entity from Medico entity").getResultList();
    }

}
