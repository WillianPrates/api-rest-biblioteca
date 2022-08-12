package com.willian.biblioteca.service;

import com.willian.biblioteca.controller.AutorController;
import com.willian.biblioteca.controller.EditoraController;
import com.willian.biblioteca.exception.EditoraNotFound;
import com.willian.biblioteca.model.Autor;
import com.willian.biblioteca.model.Editora;
import com.willian.biblioteca.repository.AutorRepository;
import com.willian.biblioteca.repository.EditoraRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class BuscaAutorPorIdServiceTest {


    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private AutorController autorController;

    private Autor autor;


    @Test
    void buscarPorId() throws EditoraNotFound {

        autor = autorController.buscarAutorPorId(7);

        assertEquals("Willian Prates", autor.getNomeAutor());

    }

    @Test
    void deletarPorId() throws EditoraNotFound {

        autorController.deleteAutores(7);

        Optional<Autor> autorOptional = autorRepository.findById(4);

        assertFalse(autorOptional.isPresent());
    }
}