package com.willian.biblioteca.service;

import com.willian.biblioteca.model.Editora;
import com.willian.biblioteca.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CadastroEditora {

    @Autowired
    private EditoraRepository editoraRepository;

    public void cadastroEditora(Editora editora){
        editoraRepository.saveAndFlush(editora);

    }
}
