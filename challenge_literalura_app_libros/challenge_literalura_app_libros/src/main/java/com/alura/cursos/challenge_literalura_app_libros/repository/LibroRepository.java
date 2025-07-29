package com.alura.cursos.challenge_literalura_app_libros.repository;

import com.alura.cursos.challenge_literalura_app_libros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
    public interface LibroRepository extends JpaRepository<Libro, Integer> {

        // Buscar libros por idioma
        List<Libro> findByIdioma(String idioma);

    Optional<Libro> findByTitulo(String titulo);
}


