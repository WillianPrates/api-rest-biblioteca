package com.willian.biblioteca.controller;

import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/livros/save")
    public void salvarLivro(@RequestBody Livro livro){
        livroRepository.save(livro);
    }

    @DeleteMapping(path = "/livros/delete/{id}")
    public void deleteLivro(@PathVariable (name ="id", required = true) Long id){
        livroRepository.deleteById(id);
    }

}
