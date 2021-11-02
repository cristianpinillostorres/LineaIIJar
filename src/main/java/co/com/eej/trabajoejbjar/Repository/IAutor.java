package co.com.eej.trabajoejbjar.Repository;

import co.com.eej.trabajoejbjar.Entity.Autor;
import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface IAutor extends ICrud<Autor, Integer>{
    
}