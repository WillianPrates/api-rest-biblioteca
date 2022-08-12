package com.willian.biblioteca.service;

import com.willian.biblioteca.model.Autor;
import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.AutorRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class BuscarAutoresServiceTest {

    @Autowired
    @Mock
    private BuscarAutoresService buscarAutoresService;
    @Test
    void buscarTodosOsAutores() {
        boolean possui;
        List<Autor> autorList = buscarAutoresService.buscarTodosOsAutores();
        if (!autorList.isEmpty()){
            possui = true;
        } else {
            possui = false;
        }
        assertTrue(possui);
    }

}