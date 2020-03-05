package dao;


import classes.Paciente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;


public class PacienteDAO {
private EntityManager em;

    public PacienteDAO() {
    }


    public Paciente pesquisarPorId(long id) {
        em = JPAUtil.getEntityManager();
        return (Paciente) em.find(Paciente.class, id);
    }

  public Paciente buscar(long id) {
        em = JPAUtil.getEntityManager();
        Paciente paciente = em.find(Paciente.class, id);
        em.close();
        return paciente;
    }
    public void remover(long id) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {

            em.remove(em.getReference(Paciente.class, id));
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("Não existe o id: " + id);
        } finally {
            em.close();
        }
    }


    public Paciente atualizar(Paciente paciente) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(paciente);
        em.getTransaction().commit();
        em.close();
    return null;
    }

    public void cadastrar(Paciente paciente) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(paciente);
        em.getTransaction().commit();
        em.close();
    }

    public List<Paciente> buscarTodos() {
        em = JPAUtil.getEntityManager();
        return em.createQuery("Select entity from Paciente entity").getResultList();
    }

}
