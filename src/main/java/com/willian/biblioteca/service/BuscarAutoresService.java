package com.willian.biblioteca.service;

import com.sun.istack.logging.Logger;
import com.willian.biblioteca.model.Autor;
import com.willian.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarAutoresService {

    private static final Logger LOG = Logger.getLogger(BuscarAutoresService.class);

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> buscarTodosOsAutores(){
        LOG.info("Serviço para buscar todos os autores sendo executada!");
        List<Autor> listAutor = autorRepository.findAll();
        return listAutor;
    }
}
