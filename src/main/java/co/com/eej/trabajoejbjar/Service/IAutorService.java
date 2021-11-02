package co.com.eej.trabajoejbjar.Service;

import co.com.eej.trabajoejbjar.Entity.Autor;
import java.util.List;
import javax.ejb.Local;


@Local
public interface IAutorService {
    
    public List<Autor> listar();
    
    public Autor listarPorId(Integer id);
    
    public void guardar(Autor obj);
    
    public void editar(Autor obj);
    
    public void eliminar(Integer id);    
    
}
