package com.willian.biblioteca.service;

import com.willian.biblioteca.model.Autor;
import com.willian.biblioteca.resource.AutorResource;
import org.springframework.stereotype.Component;

@Component
public class AutorConversor {

    public Autor conversor(AutorResource autorResource){

        Autor autor = new Autor();
        autor.setNomeAutor(autorResource.getNomeAutor());
        return autor;
    }


}