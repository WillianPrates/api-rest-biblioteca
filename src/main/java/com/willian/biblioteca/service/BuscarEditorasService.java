package com.willian.biblioteca.service;
import com.sun.istack.logging.Logger;
import com.willian.biblioteca.model.Editora;
import com.willian.biblioteca.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarEditorasService {

    private static final Logger LOG = Logger.getLogger(BuscarEditorasService.class);

    @Autowired
    private EditoraRepository editoraRepository;

    public List<Editora> buscarTodasEditoras(){
        LOG.info("Serviço para buscar todas as editoras sendo executada!");
        List<Editora> listEditora = editoraRepository.findAll();
        return listEditora;
    }
}
