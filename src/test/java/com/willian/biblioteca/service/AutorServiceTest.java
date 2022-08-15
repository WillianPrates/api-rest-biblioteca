package com.willian.biblioteca.service;

import com.willian.biblioteca.controller.AutorController;
import com.willian.biblioteca.exception.AutorNotFound;
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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class AutorServiceTest {


    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    @Mock
    private AutorController autorController;

    @Autowired
    @Mock
    private AutorService autorService;

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

    @Test
    void buscarTodosOsAutores() {
        boolean possui;
        List<Autor> autorList = autorService.buscarTodosOsAutores();
        if (!autorList.isEmpty()){
            possui = true;
        } else {
            possui = false;
        }
        assertTrue(possui);
    }

    @Test
    void cadastroAutor() throws AutorNotFound, EditoraNotFound {

        Autor aTeste = new Autor("Elvis Presley");
        AutorService autorService = new AutorService();
        autorRepository.saveAll(Arrays.asList(aTeste));

        assertEquals("Elvis Presley", aTeste.getNomeAutor());
    }
}