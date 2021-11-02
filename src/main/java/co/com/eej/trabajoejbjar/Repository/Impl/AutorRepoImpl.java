package co.com.eej.trabajoejbjar.Repository.Impl;

import co.com.eej.trabajoejbjar.Entity.Autor;
import co.com.eej.trabajoejbjar.Repository.IAutor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class AutorRepoImpl implements IAutor{
    
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager em;    

    @Override
    public List<Autor> listarTodos() {
       TypedQuery<Autor> query = em.createNamedQuery("Autor.ListarTodos", Autor.class);
        return query.getResultList();
    }

    @Override
    public Autor listarPorId(Integer id) {
         return em.find(Autor.class, id);
    }

    @Override
    public void guardar(Autor obj) {
             this.em.persist(obj);
    }

    @Override
    public void editar(Autor obj) {
        this.em.merge(obj);
    }

    @Override
    public void eliminar(Autor obj) {
        this.em.remove(obj);
    }
    
}
