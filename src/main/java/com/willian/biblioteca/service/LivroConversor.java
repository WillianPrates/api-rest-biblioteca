package com.willian.biblioteca.service;

import com.willian.biblioteca.exception.LivroResourceException;
import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.resource.LivroResource;
import org.springframework.stereotype.Component;

@Component
public class LivroConversor {

    String idAutorString;
    String idEditoraString;

    public Livro conversor(LivroResource livroResource) throws LivroResourceException {

        idAutorString = livroResource.getIdAutor();
        idEditoraString = livroResource.getIdEditora();


        try {
            Livro livroSave = new Livro();

            livroSave.setIdAutor(Integer.parseInt(this.idAutorString));
            livroSave.setIdEditora(Integer.parseInt(this.idEditoraString));
            livroSave.setNome(livroResource.getNome());
            livroSave.setAno(livroResource.getAno());

            return livroSave;
        } catch (Exception e) {
            throw new LivroResourceException("Falha ao converter o resource para entidade, resource: " + livroResource);
        }
    }

    private int checkIdAutor(String idAutor) {
        return Integer.parseInt(idAutor);
    }

    private int checkIdEditora(String idEditora) {
        return Integer.parseInt(idEditora);
    }
}
