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

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class CadastroAutorTest {

    @Autowired
    @Mock
    private AutorRepository autorRepository;

    @Autowired
    @Mock
    private AutorController autorController;

    @Test
    void cadastroAutor() throws AutorNotFound, EditoraNotFound {

        Autor aTeste = new Autor("Elvis Presley");
        CadastroAutor cadastroAutor = new CadastroAutor();
        autorRepository.saveAll(Arrays.asList(aTeste));

        assertEquals("Elvis Presley", aTeste.getNomeAutor());
    }

}