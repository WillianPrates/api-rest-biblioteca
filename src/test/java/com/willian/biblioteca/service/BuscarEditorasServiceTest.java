package com.willian.biblioteca.service;

import com.willian.biblioteca.model.Autor;
import com.willian.biblioteca.model.Editora;
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
class BuscarEditorasServiceTest {

    @Autowired
    @Mock
    private BuscarEditorasService buscarEditorasService;

    @Test
    void buscarTodasEditoras() {
        boolean possui;
        List<Editora> editoraList = buscarEditorasService.buscarTodasEditoras();
        if (!editoraList.isEmpty()){
            possui = true;
        } else {
            possui = false;
        }
        assertTrue(possui);

    }
}