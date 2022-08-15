package com.willian.biblioteca.service;

import com.willian.biblioteca.exception.LivroNotFound;
import com.willian.biblioteca.exception.LivroResourceException;
import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
import com.willian.biblioteca.resource.LivroResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private LivroConversor conversorService;

    public Livro buscarPorId(int id) throws LivroNotFound {

        Livro livro;
        Optional<Livro> optionalLivro = getOptional(id);

        if (!optionalLivro.isPresent()){
            throw new LivroNotFound("Livro não encontrado!" + id);
        } else {
            livro = optionalLivro.get();

        }
        return livro;

    }

    public Optional<Livro> getOptional(int id) {
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        return optionalLivro;
    }

    public void deletarPorId(int id) throws LivroNotFound {

        Optional<Livro> optionalLivro = getOptional(id);

        if (!optionalLivro.isPresent()){
            throw new LivroNotFound("Livro não encontrado!" + id);
        }else{
            livroRepository.delete(optionalLivro.get());
        }
    }

    public void cadastroLivro(LivroResource livroResource){
        Livro livro;

        try {
            livro = conversorService.conversor(livroResource);
            livroRepository.saveAndFlush(livro);
        } catch (LivroResourceException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> buscarTodosOsLivros(){
        List<Livro> listLivros = livroRepository.findAll();
        return listLivros;
    }


}
