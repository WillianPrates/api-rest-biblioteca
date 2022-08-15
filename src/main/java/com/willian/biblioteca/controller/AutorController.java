package com.willian.biblioteca.controller;

import com.willian.biblioteca.exception.EditoraNotFound;
import com.willian.biblioteca.model.Autor;
import com.willian.biblioteca.resource.AutorResource;
import com.willian.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @Autowired
    private AutorService buscaAutorPorIdService;

    @GetMapping(path = "/autor")
    public List<Autor> buscarAutor(){

        return autorService.buscarTodosOsAutores();
    }

    @GetMapping(path = "/autor/{id}")
    public Autor buscarAutorPorId(@PathVariable (value = "id", required = true) int id) throws EditoraNotFound {
        return buscaAutorPorIdService.buscarPorId(id);
    }

    @PostMapping(path = "/autor")
    public void salvarAutores(@RequestBody AutorResource autorResource){

        autorService.cadastroAutor(autorResource);
    }

    @DeleteMapping(path = "/autor/{id}")
    public void deleteAutores(@PathVariable (name ="id", required = true) int id) throws EditoraNotFound {

        buscaAutorPorIdService.deletarPorId(id);
    }

}
