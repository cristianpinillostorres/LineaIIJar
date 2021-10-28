package co.com.eej.trabajoejbjar.Repository;

import co.com.eej.trabajoejbjar.Entity.Artista;
import javax.ejb.Local;

@Local
public interface IArtistaRepo extends ICrud<Artista, Integer>{
    
}
