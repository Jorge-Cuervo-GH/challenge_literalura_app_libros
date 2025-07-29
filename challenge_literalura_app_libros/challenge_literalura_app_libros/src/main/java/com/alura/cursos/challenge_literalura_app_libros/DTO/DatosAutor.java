package com.alura.cursos.challenge_literalura_app_libros.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") String fechaNacimiento,
        @JsonAlias("death_year") String fechaMuerte
) {
}
