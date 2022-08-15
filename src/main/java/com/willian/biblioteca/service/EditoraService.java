package com.willian.biblioteca.service;

import com.willian.biblioteca.exception.EditoraNotFound;
import com.willian.biblioteca.model.Editora;
import com.willian.biblioteca.repository.EditoraRepository;
import com.willian.biblioteca.resource.EditoraResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    @Autowired
    private EditoraConversor editoraConversor;

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

    public List<Editora> buscarTodasEditoras(){
        List<Editora> listEditora = editoraRepository.findAll();
        return listEditora;
    }

    public void cadastroEditora(EditoraResource editoraResource){
        Editora editora = editoraConversor.conversor(editoraResource);
        editoraRepository.saveAndFlush(editora);

    }

}
