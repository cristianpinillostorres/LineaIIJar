package co.com.eej.trabajoejbjar.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "v_autor")
@NamedQueries({
    @NamedQuery(name = "VistaAutor.ListarTodos", query = "SELECT a FROM v_autor a")
})
public class VistaAutor implements Serializable{
    
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
    
    @Column(name = "id_libro", nullable = false)
    private Integer idLibro;
    
    @Column(name = "nombre_libro", nullable = false)
    private String NombreLibro;
    
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    
    @Column(name = "no_paginas", nullable = false)
    private Integer noPaginas;

    public VistaAutor() {
    }

    public VistaAutor(Integer id, String identificacion, String nombre, String apellido, Integer edad, Integer idLibro, String NombreLibro, String descripcion, Integer noPaginas) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.idLibro = idLibro;
        this.NombreLibro = NombreLibro;
        this.descripcion = descripcion;
        this.noPaginas = noPaginas;
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

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombreLibro() {
        return NombreLibro;
    }

    public void setNombreLibro(String NombreLibro) {
        this.NombreLibro = NombreLibro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNoPaginas() {
        return noPaginas;
    }

    public void setNoPaginas(Integer noPaginas) {
        this.noPaginas = noPaginas;
    }
    
    
}