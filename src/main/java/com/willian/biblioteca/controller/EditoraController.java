package com.willian.biblioteca.controller;

import com.willian.biblioteca.model.Editora;
import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estante")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @GetMapping(path = "/editoras")
    public List<Editora> buscarEditoras(){return editoraRepository.findAll();}

    @GetMapping(path = "/editoras/id/{id}")
    public Optional <Editora> buscarEditoraPorId(@PathVariable (value = "id", required = true) Long idEdiora){
        return editoraRepository.findById(idEdiora);
    }

    @PostMapping(path = "/editoras/save")
    public void salvarLivro(@RequestBody Editora editora){
        editoraRepository.save(editora);
    }

    @DeleteMapping(path = "/livros/editoras/{id}")
    public void deleteEditora(@PathVariable (name ="id", required = true) Long id){
        editoraRepository.deleteById(id);
    }
}
