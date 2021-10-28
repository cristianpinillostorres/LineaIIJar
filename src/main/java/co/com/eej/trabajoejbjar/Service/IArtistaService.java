package co.com.eej.trabajoejbjar.Service;

import co.com.eej.trabajoejbjar.Entity.Artista;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IArtistaService {
    
    public void guardarArtista(Artista Obj);

    public List<Artista> listarArtistas();

    public Artista obtenerArtista(Integer id);

    public void modificarArtista();

    public void eliminarArtista(Integer id);
    
}
