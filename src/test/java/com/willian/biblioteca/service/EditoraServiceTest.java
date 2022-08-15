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
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class EditoraServiceTest {

    @Autowired
    @Mock
    private EditoraRepository editoraRepository;

    @Autowired
    @Mock
    private EditoraController editoraController;

    @Autowired
    @Mock
    private EditoraService editoraService;

    private Editora editora;

    @Test
    void buscarPorId() throws EditoraNotFound {

        editora = editoraController.buscarEditoraPorId(5);

        assertEquals("Editora Padrao", editora.getNomeEditora());
    }

    @Test
    void deletarPorId() throws EditoraNotFound {

        editoraController.deleteEditora(4);

        Optional<Editora> editoraOptional = editoraRepository.findById(4);

        assertFalse(editoraOptional.isPresent());
    }

    @Test
    void buscarTodasEditoras() {
        boolean possui;
        List<Editora> editoraList = editoraService.buscarTodasEditoras();
        if (!editoraList.isEmpty()) {
            possui = true;
        } else {
            possui = false;
        }
        assertTrue(possui);
    }

    @Test
    void cadastroEditora() throws EditoraNotFound {

        Editora eTeste = new Editora("Super Marca");
        EditoraService editoraService = new EditoraService();
        editoraRepository.saveAll(Arrays.asList(eTeste));

        Editora editora = editoraController.buscarEditoraPorId(eTeste.getIdEditora());
        assertEquals("Super Marca", editora.getNomeEditora());
    }

}