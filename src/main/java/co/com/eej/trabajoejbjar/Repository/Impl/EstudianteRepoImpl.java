package co.com.eej.trabajoejbjar.Repository.Impl;

import co.com.eej.trabajoejbjar.Entity.Estudiante;
import co.com.eej.trabajoejbjar.Repository.IEstudianteRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author ASUS
 */
@Stateless
public class EstudianteRepoImpl implements IEstudianteRepo{
    
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager em;

    @Override
    public List<Estudiante> listarTodos() {
        TypedQuery<Estudiante> query = em.createNamedQuery("Estudiante.ListarTodos", Estudiante.class);
        return query.getResultList();
    }

    @Override
    public Estudiante listarPorId(Integer id) {
         return em.find(Estudiante.class, id);
    }

    @Override
    public void guardar(Estudiante obj) {
         this.em.persist(obj);
    }

    @Override
    public void editar(Estudiante obj) {
        this.em.merge(obj);
    }

    @Override
    public void eliminar(Estudiante obj) {
        this.em.remove(obj);
    }

    @Override
    public void eliminar2(Integer id) {
        this.em.createNamedQuery("Estudiante.EliminarPorId").setParameter(1, id).executeUpdate();
    }

    @Override
    public byte contarId(Integer id) {
        
        Query query = em.createNamedQuery("Estudiante.ContarId").setParameter(1, id);
        return ((Number) query.getSingleResult()).byteValue();

    }
    
    
}