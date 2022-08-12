package com.willian.biblioteca.service;

import com.willian.biblioteca.controller.LivroController;
import com.willian.biblioteca.exception.LivroNotFound;
import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
import com.willian.biblioteca.resource.LivroResource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class CadastroLivroTest {

    @Autowired
    @Mock
    private LivroController livroController;

    @Autowired
    @Mock
    private LivroRepository livroRepository;

    @Test
    void cadastroLivro() throws LivroNotFound {

        Livro lTeste = new Livro("a volta dos que nao foram 2", 2, 2,"2022",false);
        CadastroLivro cadastroLivro = new CadastroLivro();
        livroRepository.saveAll(Arrays.asList(lTeste));

        Livro livro = livroController.buscarLivroPorId(lTeste.getId());
        assertEquals("a volta dos que nao foram 2", livro.getNome());
        assertEquals(2, livro.getIdAutor());
        assertEquals(2, livro.getIdEditora());
        assertEquals("2022", livro.getAno());


    }
}