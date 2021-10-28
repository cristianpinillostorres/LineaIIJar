package co.com.eej.trabajoejbjar.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "artista")

@NamedQueries({
    @NamedQuery(name = "Artista.ListarTodos", query = "SELECT a FROM Artista a")      
})

public class Artista implements Serializable {

    @Id
    private Integer id;

    @NotNull(message = "El campo Nombre es obligatorio")
    @Size(min = 3, max = 30, message = "El campo Nombre debe tener entre 3 y 30 caracteres")
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @NotNull(message = "El campo Fecha de Nacimiento es obligatorio")
    @Size(min = 3, max = 30, message = "El campo Fecha de Nacimiento no tiene el formato adecuado")
    @Column(name = "fecha_nacimiento", nullable = false, length = 30)
    private String fechaNacimiento;

    @NotNull(message = "El campo Nacionalidad es obligatorio")
    @Size(min = 3, max = 30, message = "El campo nacionalidad debe tener entre 3 y 30 caracteres")
    @Column(name = "nacionalidad", nullable = false, length = 30)
    private String nacionalidad;

    @NotNull(message = "El campo Genero Musical es obligatorio")
    @Size(min = 3, max = 30, message = "El campo Genero Musical debe tener entre 3 y 30 caracteres")
    @Column(name = "genero_musical", nullable = false, length = 30)
    private String generoMusical;

    public Artista() {
    }

    public Artista(Integer id, String nombre, String fechaNacimiento, String nacionalidad, String generoMusical) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.generoMusical = generoMusical;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

}
