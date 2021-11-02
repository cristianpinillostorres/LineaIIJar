package co.com.eej.trabajoejbjar.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
@Table(name = "libro")
public class Libro implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;   
    
    @Column(name = "nombre_libro", nullable = false, length = 30)
    private String nombre;     
    
    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;       
    
    @Column(name = "no_paginas", nullable = false)
    private Integer noPaginas;
   
    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    public Libro() {
    }

    public Libro(String nombre, String descripcion, Integer noPaginas, Autor autor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.noPaginas = noPaginas;
        this.autor = autor;
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

    @JsonIgnore
    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
  
}