package com.alura.cursos.challenge_literalura_app_libros.repository;

import com.alura.cursos.challenge_literalura_app_libros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
    public interface AutorRepository extends JpaRepository<Autor, Integer> {

        // Buscar autores que estén vivos en un año determinado
        List<Autor> findByFechaNacimientoLessThanEqualAndFechaMuerteGreaterThanEqual(int anio, int anio2);

    Optional<Autor> findByNombre(String nombre);
}


