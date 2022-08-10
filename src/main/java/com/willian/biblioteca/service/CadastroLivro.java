package com.willian.biblioteca.service;

import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CadastroLivro {

    @Autowired
    private LivroRepository livroRepository;

    public void cadastroLivro(Livro livro){
        livroRepository.saveAndFlush(livro);

    }
}
