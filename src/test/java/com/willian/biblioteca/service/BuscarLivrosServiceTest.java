package com.willian.biblioteca.service;

import com.willian.biblioteca.model.Livro;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class BuscarLivrosServiceTest {


    @Autowired
    @Mock
    private BuscarLivrosService buscarLivrosService;

    @Test
    public void buscarTodosOsLivros() {
        List<Livro> livroList = buscarLivrosService.buscarTodosOsLivros();
        boolean possui;
        if (!livroList.isEmpty()) {
            possui = true;
        } else {
            possui = false;
        }
        assertTrue(possui);
    }
}