package co.com.eej.trabajoejbjar.Repository;

import java.util.List;

public interface ICrud<T, V> {
    
    public List<T> listarTodos();
    
    public T listarPorId(V id);
    
    public void guardar(T obj);
    
    public void editar(T obj);
    
    public void eliminar(T obj);
    
}
