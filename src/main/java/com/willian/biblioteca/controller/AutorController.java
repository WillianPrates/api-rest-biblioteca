package com.willian.biblioteca.controller;

import com.willian.biblioteca.exception.EditoraNotFound;
import com.willian.biblioteca.model.Autor;
import com.willian.biblioteca.repository.AutorRepository;
import com.willian.biblioteca.resource.AutorResource;
import com.willian.biblioteca.service.BuscaAutorPorIdService;
import com.willian.biblioteca.service.BuscarAutoresService;
import com.willian.biblioteca.service.CadastroAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estante")
public class AutorController {



    @Autowired
    private BuscarAutoresService buscarAutoresService;

    @Autowired
    private CadastroAutor cadastroAutor;

    @Autowired
    private BuscaAutorPorIdService buscaAutorPorIdService;

    @GetMapping(path = "/autores")
    public List<Autor> buscarAutor(){

        return buscarAutoresService.buscarTodosOsAutores();
    }

    @GetMapping(path = "/autores/id/{id}")
    public Autor buscarAutorPorId(@PathVariable (value = "id", required = true) int id) throws EditoraNotFound {
        return buscaAutorPorIdService.buscarPorId(id);
    }

    @PostMapping(path = "/autores/save")
    public void salvarAutoreso(@RequestBody AutorResource autorResource){

        cadastroAutor.cadastroAutor(autorResource);
    }

    @DeleteMapping(path = "/livros/autores/{id}")
    public void deleteAutores(@PathVariable (name ="id", required = true) int id) throws EditoraNotFound {

        buscaAutorPorIdService.deletarPorId(id);
    }

}
