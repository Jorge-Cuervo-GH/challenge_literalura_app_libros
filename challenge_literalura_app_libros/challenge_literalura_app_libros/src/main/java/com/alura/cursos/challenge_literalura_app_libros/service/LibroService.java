package com.alura.cursos.challenge_literalura_app_libros.service;

import com.alura.cursos.challenge_literalura_app_libros.DTO.Datos;
import com.alura.cursos.challenge_literalura_app_libros.DTO.DatosAutor;
import com.alura.cursos.challenge_literalura_app_libros.DTO.DatosLibro;
import com.alura.cursos.challenge_literalura_app_libros.model.Autor;
import com.alura.cursos.challenge_literalura_app_libros.model.Libro;
import com.alura.cursos.challenge_literalura_app_libros.repository.AutorRepository;
import com.alura.cursos.challenge_literalura_app_libros.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroService {

    private final ConsumoAPI consumoAPI;
    private final ConvierteDatos convierteDatos;
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public LibroService(ConsumoAPI consumoAPI, ConvierteDatos convierteDatos,
                        LibroRepository libroRepository, AutorRepository autorRepository) {
        this.consumoAPI = consumoAPI;
        this.convierteDatos = convierteDatos;
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void buscarLibroPorTitulo(String titulo) {
        String url = "https://gutendex.com/books/?search=" + titulo.replace(" ", "%20");

        try {
            String json = consumoAPI.obtenerDatos(url);
            Datos datos = convierteDatos.obtenerDatos(json, Datos.class);

            if (datos.resultados().isEmpty()) {
                System.out.println("⚠️ No se encontró ningún libro con ese título.");
                return;
            }

            DatosLibro libroDto = datos.resultados().get(0);
            if (libroRepository.findByTitulo(libroDto.titulo()).isPresent()) {
                System.out.println("\n⚠️ El libro \"" + libroDto.titulo() + "\" ya está registrado en la base de datos.");
                return;
            }
            List<Autor> listaAutores = new ArrayList<>();

            for (DatosAutor datosAutor : libroDto.autores()) {
                Autor autor = autorRepository.findByNombre(datosAutor.nombre())
                        .orElseGet(() -> {
                            Autor nuevoAutor = new Autor(
                                    datosAutor.nombre(),
                                    parseFecha(datosAutor.fechaNacimiento()),
                                    parseFecha(datosAutor.fechaMuerte())
                            );
                            return autorRepository.save(nuevoAutor);
                        });
                listaAutores.add(autor);
            }

            Libro libro = new Libro(
                    libroDto.titulo(),
                    libroDto.idiomas().get(0),
                    libroDto.numeroDeDescargas(),
                    listaAutores
            );

            libroRepository.save(libro);

            System.out.println("✅ Libro encontrado y guardado:");
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor(es): " + listaAutores.stream()
                    .map(Autor::getNombre)
                    .reduce((a, b) -> a + ", " + b).orElse("Desconocido"));
            System.out.println("Idioma: " + libro.getIdioma());
            System.out.println("Descargas: " + libro.getNumeroDeDescargas());

        } catch (Exception e) {
            System.out.println("❌ Error al buscar el libro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listarLibrosRegistrados() {
        libroRepository.findAll().forEach(libro ->
                System.out.println("📘 " + libro.getTitulo() + " (" + libro.getIdioma() + ")")
        );
    }

    public void listarAutoresRegistrados() {
        autorRepository.findAll().forEach(autor ->
                System.out.println("👤 " + autor.getNombre() +
                        " (Nacimiento: " + autor.getFechaNacimiento() +
                        ", Muerte: " + autor.getFechaMuerte() + ")")
        );
    }

    public void listarAutoresVivosEnAnio(int anio) {
        autorRepository.findAll().stream()
                .filter(autor -> autor.getFechaNacimiento() != null && autor.getFechaNacimiento() <= anio &&
                        (autor.getFechaMuerte() == null || autor.getFechaMuerte() > anio))
                .forEach(autor -> System.out.println("👤 " + autor.getNombre()));
    }

    public void listarLibrosPorIdioma(String idioma) {
        libroRepository.findAll().stream()
                .filter(libro -> libro.getIdioma().equalsIgnoreCase(idioma))
                .forEach(libro -> System.out.println("📘 " + libro.getTitulo()));
    }

    // 🔹 Conversión segura de String a Integer
    private Integer parseFecha(String fecha) {
        try {
            return (fecha != null && !fecha.isBlank()) ? Integer.parseInt(fecha) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
