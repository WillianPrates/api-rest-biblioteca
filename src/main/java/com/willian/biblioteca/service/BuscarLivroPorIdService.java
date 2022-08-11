package com.willian.biblioteca.service;

import com.willian.biblioteca.exception.LivroNotFound;
import com.willian.biblioteca.model.Livro;
import com.willian.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarLivroPorIdService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro buscarPorId(int id) throws LivroNotFound {
        Optional<Livro> optionalLivro = getOptional(id);
        Livro livro;
        if (!optionalLivro.isPresent()){
            throw new LivroNotFound("Livro não encontrado!" + id);
        } else {
            livro = optionalLivro.get();
        }
        return livro;

    }

    private Optional<Livro> getOptional(int id) {
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        return optionalLivro;
    }

    public void deletarPorId(int id) throws LivroNotFound {

        Optional<Livro> optionalLivro = getOptional(id);
        Livro livro;
        if (!optionalLivro.isPresent()){
            throw new LivroNotFound("Livro não encontrado!" + id);
        }else{
            livroRepository.delete(optionalLivro.get());
        }
    }


}
