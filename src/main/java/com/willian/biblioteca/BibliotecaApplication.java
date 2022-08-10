package com.willian.biblioteca;

import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {

	@Autowired
	private LivroRepository livroRepository;
	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Livro l1 = new Livro("a volta dos que nao foram", 1, 2,"2022",true);
		Livro l2 = new Livro("poeira em alto mar", 13, 5,"2022",false);
		Livro l3 = new Livro("os pentes do careca", 11, 7,"2022",true);

		livroRepository.saveAll(Arrays.asList(l1,l2,l3));
	}
}
