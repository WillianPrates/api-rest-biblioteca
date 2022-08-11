package com.willian.biblioteca.controller;

import com.willian.biblioteca.exception.EditoraNotFound;
import com.willian.biblioteca.model.Editora;
import com.willian.biblioteca.resource.EditoraResource;
import com.willian.biblioteca.service.BuscarEditoraPorIdService;
import com.willian.biblioteca.service.BuscarEditorasService;
import com.willian.biblioteca.service.CadastroEditora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estante")
public class EditoraController {



    @Autowired
    private BuscarEditorasService buscarEditorasService;

    @Autowired
    private CadastroEditora cadastroEditora;

    @Autowired
    private BuscarEditoraPorIdService buscarEditoraPorIdService;

    @GetMapping(path = "/editoras")
    public List<Editora> buscarEditoras(){
        return buscarEditorasService.buscarTodasEditoras();
    }

    @GetMapping(path = "/editoras/id/{id}")
    public Editora buscarEditoraPorId(@PathVariable (value = "id", required = true) int id) throws EditoraNotFound {
        return buscarEditoraPorIdService.buscarPorId(id);
    }

    @PostMapping(path = "/editoras/save")
    public void salvarLivro(@RequestBody EditoraResource editoraResource){

        cadastroEditora.cadastroEditora(editoraResource);
    }

    @DeleteMapping(path = "/livros/editoras/{id}")
    public void deleteEditora(@PathVariable (name ="id", required = true) int id) throws EditoraNotFound {

        buscarEditoraPorIdService.deletarPorId(id);
    }
}
