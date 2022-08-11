package com.willian.biblioteca.service;

import com.sun.istack.logging.Logger;
import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarLivrosService {

    private static final Logger LOG = Logger.getLogger(BuscarLivrosService.class);
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> buscarTodosOsLivros(){
        LOG.info("Serviço para buscar todos os livros sendo executada!");
        List<Livro> listLivros = livroRepository.findAll();
        return listLivros;
    }
}
