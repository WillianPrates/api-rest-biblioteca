package com.willian.biblioteca.service;

import com.willian.biblioteca.controller.LivroController;
import com.willian.biblioteca.exception.LivroNotFound;
import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class BuscarLivroPorIdServiceTest {

    @Autowired
    private LivroController livroController;

    @Autowired
    private LivroRepository livroRepository;

    @Test
    public void buscarPorId() throws LivroNotFound {

        Livro livro = livroController.buscarLivroPorId(11);

        assertEquals("poeira em alto mar", livro.getNome());
        assertEquals("1", String.valueOf(livro.getIdAutor()));
        assertEquals("4", String.valueOf(livro.getIdEditora()));
        assertEquals("2022", livro.getAno());
    }

    @Test
    public void deletarPortId() throws LivroNotFound {

        Optional<Livro> optionalLivro = livroRepository.findById(11);

        livroController.deleteLivro(11);

        assertFalse(optionalLivro.isPresent());

    }

}