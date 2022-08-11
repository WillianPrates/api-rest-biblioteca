package com.willian.biblioteca.controller;

import com.willian.biblioteca.model.Editora;
import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.EditoraRepository;
import com.willian.biblioteca.resource.EditoraResource;
import com.willian.biblioteca.service.BuscarAutoresService;
import com.willian.biblioteca.service.BuscarEditorasService;
import com.willian.biblioteca.service.CadastroEditora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estante")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @Autowired
    private BuscarEditorasService buscarEditorasService;

    @Autowired
    private CadastroEditora cadastroEditora;

    @GetMapping(path = "/editoras")
    public List<Editora> buscarEditoras(){
        return buscarEditorasService.buscarTodasEditoras();
    }

    @GetMapping(path = "/editoras/id/{id}")
    public Optional <Editora> buscarEditoraPorId(@PathVariable (value = "id", required = true) Long idEdiora){
        return editoraRepository.findById(idEdiora);
    }

    @PostMapping(path = "/editoras/save")
    public void salvarLivro(@RequestBody EditoraResource editoraResource){

        cadastroEditora.cadastroEditora(editoraResource);
    }

    @DeleteMapping(path = "/livros/editoras/{id}")
    public void deleteEditora(@PathVariable (name ="id", required = true) Long id){
        editoraRepository.deleteById(id);
    }
}
