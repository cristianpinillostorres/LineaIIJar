package co.com.eej.trabajoejbjar.Service;

import co.com.eej.trabajoejbjar.Entity.Estudiante;
import co.com.eej.trabajoejbjar.Exception.BadRequestEx;
import co.com.eej.trabajoejbjar.Exception.ConflictEx;
import co.com.eej.trabajoejbjar.Exception.NoContentEx;
import co.com.eej.trabajoejbjar.Exception.NotFoundEx;
import java.util.List;

public interface IEstudianteService {
    
    public List<Estudiante> listar();
    
    public Estudiante listarPorId(Integer id) throws NotFoundEx;
    
    public void guardar(Estudiante obj) throws ConflictEx,BadRequestEx;
    
    public void editar(Estudiante obj)throws NotFoundEx, ConflictEx, BadRequestEx ;
    
    public void eliminar(Integer id) throws NotFoundEx;
    
    public void eliminar2(Integer id) throws NotFoundEx;
  
}
