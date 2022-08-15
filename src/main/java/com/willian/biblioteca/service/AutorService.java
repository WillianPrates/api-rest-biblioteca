package com.willian.biblioteca.service;

import com.willian.biblioteca.exception.EditoraNotFound;
import com.willian.biblioteca.model.Autor;
import com.willian.biblioteca.repository.AutorRepository;
import com.willian.biblioteca.resource.AutorResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private AutorConversor autorConversor;

    public Autor buscarPorId(int id) throws EditoraNotFound {
        Optional<Autor> optionalAutor = getOptional(id);
        Autor autor;
        if (!optionalAutor.isPresent()){
            throw new EditoraNotFound("Editora não encontrado!" + id);
        } else {
            autor = optionalAutor.get();
        }
        return autor;

    }

    private Optional<Autor> getOptional(int id) {
        Optional <Autor>  optionalAutor = autorRepository.findById(id);
        return optionalAutor;
    }

    public void deletarPorId(int id) throws EditoraNotFound {
        Optional<Autor> optionalAutor = getOptional(id);
        Autor autor;
        if (!optionalAutor.isPresent()){
            throw new EditoraNotFound("Autor não encontrado!" + id);
        } else {
            autorRepository.delete(optionalAutor.get());
        }
    }

    public List<Autor> buscarTodosOsAutores(){
        List<Autor> listAutor = autorRepository.findAll();
        return listAutor;
    }

    public void cadastroAutor(AutorResource autorResource){
        Autor autor = autorConversor.conversor(autorResource);
        autorRepository.saveAndFlush(autor);
    }
}
