package com.willian.biblioteca.service;

import com.willian.biblioteca.controller.LivroController;
import com.willian.biblioteca.exception.LivroNotFound;
import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
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
class LivroServiceTest {

    @Autowired
    @Mock
    private LivroController livroController;

    @Autowired
    @Mock
    private LivroRepository livroRepository;

    @Autowired
    @Mock
    private LivroService livroService;

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

        livroController.deleteLivro(12);

        Optional<Livro> optionalLivro = livroRepository.findById(12);

        assertFalse(optionalLivro.isPresent());

    }

    @Test
    public void buscarTodosOsLivros() {
        List<Livro> livroList = livroService.buscarTodosOsLivros();
        boolean possui;
        if (!livroList.isEmpty()) {
            possui = true;
        } else {
            possui = false;
        }
        assertTrue(possui);
    }

    @Test
    void cadastroLivro() throws LivroNotFound {

        Livro lTeste = new Livro("a volta dos que nao foram 2", 2, 2, "2022", false);
        LivroService livroService = new LivroService();
        livroRepository.saveAll(Arrays.asList(lTeste));

        Livro livro = livroController.buscarLivroPorId(lTeste.getId());
        assertEquals("a volta dos que nao foram 2", livro.getNome());
        assertEquals(2, livro.getIdAutor());
        assertEquals(2, livro.getIdEditora());
        assertEquals("2022", livro.getAno());
    }

}