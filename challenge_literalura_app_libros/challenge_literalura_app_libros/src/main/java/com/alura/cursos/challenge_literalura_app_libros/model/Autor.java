package com.alura.cursos.challenge_literalura_app_libros.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "fecha_nacimiento")
    private Integer fechaNacimiento;

    @Column(name = "fecha_muerte")
    private Integer fechaMuerte;

    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros = new ArrayList<>();
    public Autor() {}

    // Constructor con parámetros
    public Autor(String nombre, Integer fechaNacimiento, Integer fechaMuerte) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaMuerte = fechaMuerte;
    }

    // Getters y setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getFechaNacimiento() { return fechaNacimiento; }

    public void setFechaNacimiento(Integer fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public Integer getFechaMuerte() { return fechaMuerte; }

    public void setFechaMuerte(Integer fechaMuerte) { this.fechaMuerte = fechaMuerte; }

    public List<Libro> getLibros() { return libros; }

    public void setLibros(List<Libro> libros) { this.libros = libros; }
}
