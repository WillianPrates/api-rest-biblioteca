package com.willian.biblioteca.service;

import com.willian.biblioteca.controller.AutorController;
import com.willian.biblioteca.exception.EditoraNotFound;
import com.willian.biblioteca.model.Autor;
import com.willian.biblioteca.repository.AutorRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
class BuscaAutorPorIdServiceTest {


    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    @Mock
    private AutorController autorController;

    private Autor autor;


    @Test
    void buscarPorId() throws EditoraNotFound {

        autor = autorController.buscarAutorPorId(7);

        assertEquals("Willian Prates", autor.getNomeAutor());

    }

    @Test
    void deletarPorId() throws EditoraNotFound {

        autorController.deleteAutores(9);

        Optional<Autor> autorOptional = autorRepository.findById(9);

        assertFalse(autorOptional.isPresent());
    }
}