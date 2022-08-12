package com.willian.biblioteca;

import com.willian.biblioteca.controller.EditoraController;
import com.willian.biblioteca.controller.LivroController;
import com.willian.biblioteca.model.Autor;
import com.willian.biblioteca.model.Editora;
import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.AutorRepository;
import com.willian.biblioteca.repository.EditoraRepository;
import com.willian.biblioteca.repository.LivroRepository;
import com.willian.biblioteca.resource.LivroResource;
import com.willian.biblioteca.service.BuscarLivroPorIdService;
import com.willian.biblioteca.service.CadastroLivro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private EditoraRepository editoraRepository;
	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private LivroController livroController;

	@Autowired
	private EditoraController editoraController;

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	BuscarLivroPorIdService buscarLivroPorIdService = new BuscarLivroPorIdService();

	@Override
	public void run(String... args) throws Exception {

		Livro l1 = new Livro("a volta dos que nao foram", 2, 2,"2022",true);
		Livro l2 = new Livro("poeira em alto mar", 1, 4,"2022",false);
		Livro l3 = new Livro("os pentes do careca", 4, 3,"2022",true);
		Livro l4 = new Livro("a trança do careca", 4, 3,"2022",true);
		Livro l5 = new Livro("didi", 3, 1,"2022",false);
		Livro l6 = new Livro("didi 2", 1, 2,"2022",false);

		Editora e1 = new Editora("Editora Natura");
		Editora e2 = new Editora("Editora Santana");
		Editora e3 = new Editora("Editora Domingos");
		Editora e4 = new Editora("Editora Falimiar");
		Editora e5 = new Editora("Editora Padrao");

		Autor a1 = new Autor("Mauricio Saraiva");
		Autor a2 = new Autor("Willian Prates");
		Autor a3 = new Autor("Sabrina Souza");
		Autor a4 = new Autor("Bruce Willis");


		editoraRepository.saveAll(Arrays.asList(e1,e2,e3,e4,e5));
		autorRepository.saveAll(Arrays.asList(a1,a2,a3,a4));
		livroRepository.saveAll(Arrays.asList(l1,l2,l3, l4, l5, l6));

	}
}