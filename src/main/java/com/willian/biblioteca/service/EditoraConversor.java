package com.willian.biblioteca.service;

import com.willian.biblioteca.model.Editora;
import com.willian.biblioteca.resource.EditoraResource;
import org.springframework.stereotype.Component;

@Component
public class EditoraConversor {

    public Editora conversor(EditoraResource editoraResource){

        Editora editora = new Editora();
        editora.setNomeEditora(editoraResource.getNomeEditora());
        return editora;
    }


}
