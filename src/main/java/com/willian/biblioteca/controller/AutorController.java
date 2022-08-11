package com.willian.biblioteca.controller;

import com.willian.biblioteca.model.Autor;
import com.willian.biblioteca.repository.AutorRepository;
import com.willian.biblioteca.resource.AutorResource;
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
    private AutorRepository autorRepository;

    @Autowired
    private BuscarAutoresService buscarAutoresService;

    @Autowired
    private CadastroAutor cadastroAutor;

    @GetMapping(path = "/autores")
    public List<Autor> buscarAutor(){

        return buscarAutoresService.buscarTodosOsAutores();
    }

    @GetMapping(path = "/autores/id/{id}")
    public Optional <Autor> buscarAutorPorId(@PathVariable (value = "id", required = true) Long idAutor){
        return autorRepository.findById(idAutor);
    }

    @PostMapping(path = "/autores/save")
    public void salvarAutoreso(@RequestBody AutorResource autorResource){

        cadastroAutor.cadastroAutor(autorResource);
    }

    @DeleteMapping(path = "/livros/autores/{id}")
    public void deleteAutores(@PathVariable (name ="id", required = true) Long id){
        autorRepository.deleteById(id);
    }

}
