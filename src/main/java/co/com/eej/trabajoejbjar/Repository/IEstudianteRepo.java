package co.com.eej.trabajoejbjar.Repository;

import co.com.eej.trabajoejbjar.Entity.Estudiante;
import javax.ejb.Local;

@Local
public interface IEstudianteRepo extends ICrud<Estudiante, Integer>{
    
    public void eliminar2(Integer obj); 
    
    public byte contarId(Integer obj); 
    
}
