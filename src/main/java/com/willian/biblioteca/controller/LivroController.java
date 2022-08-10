package com.willian.biblioteca.controller;

import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping(path = "api/livro-id/{}")
    public ResponseEntity<Optional<Livro>> buscarLivroPorId(@PathVariable (name="id", required = true) Long idLivro){

        return ResponseEntity.ok(livroRepository.findById(idLivro));
    }

}
