package com.willian.biblioteca.controller;

import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estante")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping(path = "/livros")
    public List<Livro> buscarLivro(){
        return livroRepository.findAll();
    }

    @GetMapping(path = "/livros/id/{id}")
    public Optional <Livro> buscarLivroPorId(@PathVariable (value = "id", required  =true) Long id){
        return livroRepository.findById(id);
    }

}
