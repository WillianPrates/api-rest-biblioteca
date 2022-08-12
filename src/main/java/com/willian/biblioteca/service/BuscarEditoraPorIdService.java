package com.willian.biblioteca.service;

import com.willian.biblioteca.exception.EditoraNotFound;
import com.willian.biblioteca.model.Editora;
import com.willian.biblioteca.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarEditoraPorIdService {

    @Autowired
    private EditoraRepository editoraRepository;

    public Editora buscarPorId(int idEditora) throws EditoraNotFound {

        Editora editora;
        Optional<Editora> optionalEditora = getOptional(idEditora);


        if (!optionalEditora.isPresent()){
            throw new EditoraNotFound("Editora não encontrado!" + idEditora);
        } else {
            editora = optionalEditora.get();
        }
        return editora;

    }

    public Optional<Editora> getOptional(int idEditora) {
        Optional<Editora> optionalEditora = editoraRepository.findById(idEditora);
        return optionalEditora;
    }

    public void deletarPorId(int idEditora) throws EditoraNotFound {
        Optional<Editora> optionalEditora = getOptional(idEditora);


        if (!optionalEditora.isPresent()){
            throw new EditoraNotFound("Editora não encontrado!" + idEditora);
        } else {

            editoraRepository.delete(optionalEditora.get());;
        }

    }

}
