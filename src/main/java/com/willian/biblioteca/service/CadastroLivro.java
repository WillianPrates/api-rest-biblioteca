package com.willian.biblioteca.service;

import com.willian.biblioteca.exception.LivroResourceException;
import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
import com.willian.biblioteca.resource.LivroResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class CadastroLivro {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private LivroConversor conversorService;

    public void cadastroLivro(LivroResource livroResource){
        Livro livro;

        try {
            livro = conversorService.conversor(livroResource);
            livroRepository.saveAndFlush(livro);
        } catch (LivroResourceException e) {
            throw new RuntimeException(e);
        }


    }
}
