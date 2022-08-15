package com.willian.biblioteca.controller;

import com.willian.biblioteca.exception.LivroNotFound;
import com.willian.biblioteca.exception.LivroResourceException;
import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
import com.willian.biblioteca.resource.LivroResource;
import com.willian.biblioteca.service.LivroService;
import com.willian.biblioteca.service.LivroConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private LivroConversor livroConversor;

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping(path = "/livro")
    public List<Livro> buscarLivro() {

        return livroService.buscarTodosOsLivros();
    }

    @GetMapping(path = "/livro/{id}")
    public Livro buscarLivroPorId(@PathVariable(value = "id", required = true) int id) throws LivroNotFound {
        return livroService.buscarPorId(id);
    }

    @PostMapping(path = "/livro")
    public void salvarLivro(@RequestBody LivroResource livro) throws LivroResourceException {
        livroService.cadastroLivro(livro);

    }
    @DeleteMapping(path = "/livro/{id}")
    public void deleteLivro(@PathVariable(name = "id", required = true) int id) throws LivroNotFound {

        livroService.deletarPorId(id);
    }

    @PutMapping(path = "/livro/{id}")
    public void reservaLivro(@PathVariable("id") Integer id, @RequestBody LivroResource livro) throws Exception {
        var l = livroRepository.findById(id);

        if (l.isPresent()) {
            var livroSave = l.get();
            livroSave.setNome(livro.getNome());
            livroSave.setIdEditora(Integer.parseInt(livro.getIdEditora()));
            livroSave.setIdAutor(Integer.parseInt(livro.getIdEditora()));
            livroSave.setAno(livro.getAno());
            livroSave.setReservado(true);
            livroRepository.save(livroSave);
        } else {
            throw new Exception("Livro nao encontrado");
        }
    }

    @PutMapping(path = "/livro{id}")
    public void DevolveLivro(@PathVariable("id") Integer id, @RequestBody LivroResource livro) throws Exception {
        var l = livroRepository.findById(id);

        if (l.isPresent()) {
            var livroSave = l.get();
            livroSave.setNome(livro.getNome());
            livroSave.setIdEditora(Integer.parseInt(livro.getIdEditora()));
            livroSave.setIdAutor(Integer.parseInt(livro.getIdEditora()));
            livroSave.setAno(livro.getAno());
            livroSave.setReservado(false);
            livroRepository.save(livroSave);
        } else {
            throw new Exception("Livro nao encontrado");
        }
    }

}
