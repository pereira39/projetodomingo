package dao;


import classes.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;


public class UsuarioDAO {
private EntityManager em;

    public UsuarioDAO() {
    }


    public Usuario pesquisarPorId(long id) {
        em = JPAUtil.getEntityManager();
        return (Usuario) em.find(Usuario.class, id);
    }

  public Usuario buscar(long id) {
        em = JPAUtil.getEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return usuario;
    }
    public void remover(long id) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {

            em.remove(em.getReference(Usuario.class, id));
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("Não existe o id: " + id);
        } finally {
            em.close();
        }
    }


    public Usuario atualizar(Usuario usuario) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
    return null;
    }

    public void cadastrar(Usuario usuario) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public List<Usuario> buscarTodos() {
        em = JPAUtil.getEntityManager();
        return em.createQuery("Select entity from Usuario entity").getResultList();
    }

}
