package com.willian.biblioteca.controller;

import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
import com.willian.biblioteca.resource.LivroResource;
import com.willian.biblioteca.service.BuscarLivrosService;
import com.willian.biblioteca.service.CadastroLivro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estante")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private BuscarLivrosService bucarLivrosService;

    @Autowired
    private CadastroLivro cadastroLivro;

    @GetMapping(path = "/livros")
    public List<Livro> buscarLivro(){

        return bucarLivrosService.buscarTodosOsLivros();
    }

    @GetMapping(path = "/livros/id/{id}")
    public Optional <Livro> buscarLivroPorId(@PathVariable (value = "id", required  =true) Long id){
        return livroRepository.findById(id);
    }

    @PostMapping(path = "/livros/save")
    public void salvarLivro(@RequestBody LivroResource livro){

        cadastroLivro.cadastroLivro(livro);
        ;
    }

    @DeleteMapping(path = "/livros/delete/{id}")
    public void deleteLivro(@PathVariable (name ="id", required = true) Long id){
        livroRepository.deleteById(id);
    }

}
