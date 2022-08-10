package com.willian.biblioteca.controller;

import com.willian.biblioteca.model.Autor;
import com.willian.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estante")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping(path = "/autores")
    public List<Autor> buscarAutor(){return autorRepository.findAll();}

    @GetMapping(path = "/autores/id/{id}")
    public Optional <Autor> buscarAutorPorId(@PathVariable (value = "id", required = true) Long idAutor){
        return autorRepository.findById(idAutor);
    }

}
