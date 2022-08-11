package com.willian.biblioteca.service;

import com.willian.biblioteca.exception.LivroResourceException;
import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.resource.LivroResource;
import org.springframework.stereotype.Component;

@Component
public class LivroConversor {

    public Livro conversor(LivroResource livroResource) throws LivroResourceException {

        try{
            Livro livro = new Livro();

            int idAutor = checkIdAutor(livroResource.getIdAutor());

            int idEditora = checkIdEditora(livroResource.getIdEditora());

            livro.setIdAutor(idAutor);
            livro.setIdEditora(idEditora);
            livro.setNome(livroResource.getNome());
            livro.setAno(livroResource.getAno());

            return livro;
        }catch (Exception e){
            throw new LivroResourceException("Falha ao converter o resource para entidade, resource: " + livroResource);
        }
    }

    private int checkIdAutor(String idAutor){
        return Integer.parseInt(idAutor);
    }

    private int checkIdEditora(String idEditora){
        return Integer.parseInt(idEditora);
    }
}
