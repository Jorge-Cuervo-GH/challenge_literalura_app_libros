package com.alura.cursos.challenge_literalura_app_libros;

import com.alura.cursos.challenge_literalura_app_libros.principal.Principal;
import com.alura.cursos.challenge_literalura_app_libros.repository.AutorRepository;
import com.alura.cursos.challenge_literalura_app_libros.repository.LibroRepository;
import com.alura.cursos.challenge_literalura_app_libros.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeLiteraluraAppLibrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraluraAppLibrosApplication.class, args);
	}

	@Autowired
	private Principal principal;

	@Override
	public void run(String... args) throws Exception {
		//principal.muestraElMenu();
	}
}
