package co.com.eej.trabajoejbjar.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "estudiante")

@NamedQueries({
    @NamedQuery(name = "Estudiante.ListarTodos", query = "SELECT a FROM Estudiante a")
    
})

@NamedNativeQueries({
       @NamedNativeQuery(name = "Estudiante.ContarId", query = "SELECT count(id) FROM public.estudiante where id = ?"),
        
       @NamedNativeQuery(name = "Estudiante.EliminarPorId", query = "DELETE FROM public.estudiante where id = ?" )
})

public class Estudiante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El Nombre es obligatorio")
    @Size(min = 3, max = 30, message = "El Nombre debe tener entre 3 y 20 caracteres")
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @NotNull(message = "El apellido es obligatorio")
    @Size(min = 3, max = 30, message = "el apellido debe tener entre 3 y 20 caracteres")
    @Column(name = "apellido", nullable = false, length = 20)
    private String apellido;

    @NotNull(message = "Edad es obligatorio")
    @Min(value = 18, message = "Debe ser mayor de edad")
    @Column(name = "edad", nullable = false)
    private Integer edad;

    @NotNull(message = "Cedula es obligatoria")
    @Size(min = 10, max = 10, message = "Cedula debe tener 10 caracteres")
    @Column(name = "cedula", nullable = false, length = 10, unique = true)
    private String cedula;
    
    @NotNull(message = "El correo es obligatoria")
    @Size(min = 10, max = 20, message = "Cedula debe tener 10 caracteres")
    @Column(name = "correo", nullable = false, length = 20)
    private String correo;
   
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "La fecha es obligatoria")
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    public Estudiante() {
    }

    public Estudiante(Integer id, String nombre, String apellido, Integer edad, String cedula,String correo , Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo ;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    
}
