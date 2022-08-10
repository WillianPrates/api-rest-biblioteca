package com.willian.biblioteca.service;

import com.willian.biblioteca.model.Autor;
import com.willian.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CadastroAutor {

    @Autowired
    private AutorRepository autorRepository;

    public void cadastroAutor(Autor autor){
        autorRepository.saveAndFlush(autor);
    }
}
