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

    public Editora buscarPorId(int id) throws EditoraNotFound {
        Optional<Editora> optionalEditora = getOptional(id);
        Editora editora;
        if (!optionalEditora.isPresent()){
            throw new EditoraNotFound("Editora não encontrado!" + id);
        } else {
            editora = optionalEditora.get();
        }
        return editora;

    }

    private Optional<Editora> getOptional(int id) {
        Optional<Editora> optionalEditora = editoraRepository.findById(id);
        return optionalEditora;
    }

    public void deletarPorId(int id) throws EditoraNotFound {
        Optional<Editora> optionalEditora = getOptional(id);

        Editora editora;
        if (!optionalEditora.isPresent()){
            throw new EditoraNotFound("Editora não encontrado!" + id);
        } else {
            editora = optionalEditora.get();

            editoraRepository.delete(optionalEditora.get());;
        }

    }

}
