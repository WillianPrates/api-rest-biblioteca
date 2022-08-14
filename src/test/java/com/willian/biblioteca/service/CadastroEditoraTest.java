package com.willian.biblioteca.service;

import com.willian.biblioteca.controller.EditoraController;
import com.willian.biblioteca.exception.EditoraNotFound;
import com.willian.biblioteca.model.Editora;
import com.willian.biblioteca.repository.EditoraRepository;
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
class CadastroEditoraTest {

    @Autowired
    @Mock
    private EditoraRepository editoraRepository;

    @Autowired
    @Mock
    private EditoraController editoraController;

    @Test
    void cadastroEditora() throws EditoraNotFound {

        Editora eTeste = new Editora("Super Marca");
        CadastroEditora cadastroEditora = new CadastroEditora();
        editoraRepository.saveAll(Arrays.asList(eTeste));

        Editora editora = editoraController.buscarEditoraPorId(eTeste.getIdEditora());
        assertEquals("Super Marca", editora.getNomeEditora());
    }


}