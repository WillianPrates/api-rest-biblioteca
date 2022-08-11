package com.willian.biblioteca.service;

import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


class BuscarLivrosServiceTest {


    private LivroRepository livroRepository;

    @Test
    public boolean buscarTodosOsLivros() {
        List<Livro> livroList = livroRepository.findAll();
        if (!livroList.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}