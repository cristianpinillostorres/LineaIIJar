package co.com.eej.trabajoejbjar.Service.Imp;

import co.com.eej.trabajoejbjar.Entity.Autor;
import co.com.eej.trabajoejbjar.Repository.IAutor;
import co.com.eej.trabajoejbjar.Service.IAutorService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AutorServiceImpl implements IAutorService {

    @EJB
    private IAutor repo;
    
    @Override
    public List<Autor> listar() {
        return repo.listarTodos();
    }

    @Override
    public Autor listarPorId(Integer id)  {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardar(Autor obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Autor obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
