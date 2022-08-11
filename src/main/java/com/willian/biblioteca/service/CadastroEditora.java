package com.willian.biblioteca.service;

import com.willian.biblioteca.model.Editora;
import com.willian.biblioteca.repository.EditoraRepository;
import com.willian.biblioteca.resource.EditoraResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroEditora {

    @Autowired
    private EditoraRepository editoraRepository;

    @Autowired
    private EditoraConversor editoraConversor;


    public void cadastroEditora(EditoraResource editoraResource){
        Editora editora = editoraConversor.conversor(editoraResource);
        editoraRepository.saveAndFlush(editora);

    }
}
