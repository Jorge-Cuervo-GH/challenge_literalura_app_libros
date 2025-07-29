package com.alura.cursos.challenge_literalura_app_libros.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String idioma;

    @Column(nullable = false)
    private Double numeroDeDescargas;

    @ManyToMany
    @JoinTable(
            name = "libros_autores",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores = new ArrayList<>();

    // Constructores
    public Libro() {}

    public Libro(String titulo, String idioma, Double numeroDeDescargas, List<Autor> autores) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.numeroDeDescargas = numeroDeDescargas;
        this.autores = autores;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
