package com.willian.biblioteca.controller;

import com.willian.biblioteca.exception.LivroNotFound;
import com.willian.biblioteca.exception.LivroResourceException;
import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
import com.willian.biblioteca.resource.LivroResource;
import com.willian.biblioteca.service.BuscarLivroPorIdService;
import com.willian.biblioteca.service.BuscarLivrosService;
import com.willian.biblioteca.service.CadastroLivro;
import com.willian.biblioteca.service.LivroConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estante")
public class LivroController {


    @Autowired
    private BuscarLivrosService bucarLivrosService;

    @Autowired
    private CadastroLivro cadastroLivro;

    @Autowired
    private BuscarLivroPorIdService buscarLivroPorIdService;

    @Autowired
    private LivroConversor livroConversor;

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping(path = "/livros")
    public List<Livro> buscarLivro() {

        return bucarLivrosService.buscarTodosOsLivros();
    }

    @GetMapping(path = "/livros/id/{id}")
    public Livro buscarLivroPorId(@PathVariable(value = "id", required = true) int id) throws LivroNotFound {
        return buscarLivroPorIdService.buscarPorId(id);
    }

    @PostMapping(path = "/livros/save")
    public void salvarLivro(@RequestBody LivroResource livro) throws LivroResourceException {
        cadastroLivro.cadastroLivro(livro);

    }
    @DeleteMapping(path = "/livros/delete/{id}")
    public void deleteLivro(@PathVariable(name = "id", required = true) int id) throws LivroNotFound {

        buscarLivroPorIdService.deletarPorId(id);
    }

    @PutMapping(path = "/livros/reserva/{id}")
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

    @PutMapping(path = "/livros/devolve/{id}")
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
