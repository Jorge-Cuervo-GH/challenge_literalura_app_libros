package com.alura.cursos.challenge_literalura_app_libros.principal;

import com.alura.cursos.challenge_literalura_app_libros.service.LibroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal implements CommandLineRunner {

    private final LibroService libroService;

    public Principal(LibroService libroService) {
        this.libroService = libroService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            try {
                System.out.println("***************************************");
                System.out.println("\n=== MENÚ PRINCIPAL ===");
                System.out.println("1. Buscar libros por título");
                System.out.println("2. Listar libros registrados");
                System.out.println("3. Listar autores registrados");
                System.out.println("4. Listar autores vivos en un año");
                System.out.println("5. Listar libros por idioma");
                System.out.println("0. Salir");
                System.out.println("***************************************");
                System.out.print("Seleccione una opción: ");

                String entrada = scanner.nextLine();

                if (!entrada.matches("\\d+")) {
                    System.out.println("⚠️ Entrada inválida. Por favor escribe un número.");
                    continue;
                }

                opcion = Integer.parseInt(entrada);

                switch (opcion) {
                    case 1: {
                        System.out.print("Ingrese el título del libro: ");
                        String titulo = scanner.nextLine();
                        libroService.buscarLibroPorTitulo(titulo);
                        break;
                    }
                    case 2: {
                        System.out.println("\n=== 📚 LISTA DE LIBROS ALMACENADOS === ");
                        libroService.listarLibrosRegistrados();
                        break;
                    }
                    case 3: {
                        System.out.println("\n=== 👩‍💼 LISTA DE AUTORES REGISTRADOS === ");
                        libroService.listarAutoresRegistrados();
                        break;
                    }
                    case 4: {
                        System.out.print("Ingrese el año: ");
                        String entradaAnio = scanner.nextLine();
                        if (!entradaAnio.matches("\\d+")) {
                            System.out.println("⚠️ Entrada inválida. Por favor escribe un número.");
                            break;
                        }
                        int anio = Integer.parseInt(entradaAnio);
                        System.out.println("\n=== 📅 LISTA DE AUTORES VIVOS EN EL AÑO " + anio + " === ");
                        libroService.listarAutoresVivosEnAnio(anio);
                        break;
                    }
                    case 5: {
                        System.out.print("Ingrese el idioma (ej: 'en', 'es', 'fr'): ");
                        String idioma = scanner.nextLine();
                        System.out.println("\n=== 🌍 LISTA DE LIBROS ESCRITOS EN EL IDIOMA " + idioma + " === ");
                        libroService.listarLibrosPorIdioma(idioma);
                        break;
                    }
                    case 0: {
                        System.out.println("¡Hasta pronto!");
                        break;
                    }
                    default: {
                        System.out.println("⚠️ Opción inválida, intente de nuevo.");
                    }
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error inesperado: " + e.getMessage());

            }
        }
        scanner.close();
    }
}
