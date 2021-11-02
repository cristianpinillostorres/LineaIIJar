package co.com.eej.trabajoejbjar.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "autor")

@NamedQueries({
    @NamedQuery(name = "Autor.ListarTodos", query = "SELECT a FROM Autor a")
})
public class Autor implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;   
    
    @Column(name = "identificacion", nullable = false, length = 15, unique = true)
    private String identificacion;      
    
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;    
    
    @Column(name = "apellido", nullable = false, length = 30)
    private String apellido;    
    
    @Column(name = "edad", nullable = false)
    private Integer edad;   
    
    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY, cascade= CascadeType.ALL, orphanRemoval = true)
    private List<Libro> libro;
    
    public Autor(){
    
    }

    public Autor(String identificacion, String nombre, String apellido, Integer edad, List<Libro> libro) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.libro = libro;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }
    
}