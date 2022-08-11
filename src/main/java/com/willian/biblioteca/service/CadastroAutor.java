package com.willian.biblioteca.service;

import com.willian.biblioteca.model.Autor;
import com.willian.biblioteca.repository.AutorRepository;
import com.willian.biblioteca.resource.AutorResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CadastroAutor {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private AutorConversor autorConversor;

    public void cadastroAutor(AutorResource autorResource){
        Autor autor = autorConversor.conversor(autorResource);
        autorRepository.saveAndFlush(autor);
    }
}
