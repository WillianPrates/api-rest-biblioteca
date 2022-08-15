package com.willian.biblioteca.controller;

import com.willian.biblioteca.exception.EditoraNotFound;
import com.willian.biblioteca.model.Editora;
import com.willian.biblioteca.resource.EditoraResource;
import com.willian.biblioteca.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class EditoraController {


    @Autowired
    private EditoraService editoraService;

    @GetMapping(path = "/editora")
    public List<Editora> buscarEditoras(){
        return editoraService.buscarTodasEditoras();
    }

    @GetMapping(path = "/editora/{idEditora}")
    public Editora buscarEditoraPorId(@PathVariable (value = "id", required = true) int idEditora) throws EditoraNotFound {
        return editoraService.buscarPorId(idEditora);
    }

    @PostMapping(path = "/editora")
    public void salvarEditora(@RequestBody EditoraResource editoraResource){

        editoraService.cadastroEditora(editoraResource);
    }

    @DeleteMapping(path = "/editora/{idEditora}")
    public void deleteEditora(@PathVariable (name ="idEditora", required = true) int idEditora) throws EditoraNotFound {

        editoraService.deletarPorId(idEditora);
    }
}
