package co.com.eej.trabajoejbjar.Repository.Impl;

import co.com.eej.trabajoejbjar.Entity.Artista;
import co.com.eej.trabajoejbjar.Repository.IArtistaRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ArtistaRepoImpl implements IArtistaRepo {

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager em;

    @Override
    public List<Artista> listarTodos() {   
        TypedQuery<Artista> query = em.createNamedQuery("Artista.ListarTodos", Artista.class);
        return query.getResultList();
    }

    @Override
    public Artista listarPorId(Integer id) {
        return em.find(Artista.class, id);
    }

    @Override
    public void guardar(Artista obj) {
        this.em.persist(obj);
    }

    @Override
    public void editar(Artista obj) {

    }

    @Override
    public void eliminar(Artista id) {
        
    }

}
