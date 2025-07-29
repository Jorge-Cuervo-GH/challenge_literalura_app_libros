package com.alura.cursos.challenge_literalura_app_libros.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutor> autores,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Double numeroDeDescargas
) {
    public String idioma() {
        return idiomas != null && !idiomas.isEmpty() ? idiomas.get(0) : "Desconocido";
    }

    public Double numeroDescargas() {
        return numeroDeDescargas;
    }
}
