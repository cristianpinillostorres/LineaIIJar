package co.com.eej.trabajoejbjar.Service.Imp;

import co.com.eej.trabajoejbjar.Entity.Artista;
import co.com.eej.trabajoejbjar.Repository.IArtistaRepo;
import co.com.eej.trabajoejbjar.Service.IArtistaService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class artistaServiceImpl implements IArtistaService {
    
    @EJB
    private IArtistaRepo repo;

    @Override
    public void guardarArtista(Artista Obj) {
        //validacione --- logica
        this.repo.guardar(Obj);
    }

    @Override
    public List<Artista> listarArtistas() {
        
        return repo.listarTodos();        
    }

    @Override
    public Artista obtenerArtista(Integer id) {
        return repo.listarPorId(id);
       
    }

    @Override
    public void modificarArtista() {
    }

    @Override
    public void eliminarArtista(Integer id) {
    }
    
}
