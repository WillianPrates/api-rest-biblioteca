package com.willian.biblioteca.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class LivroResource {

    @JsonProperty("nome_livro")
    private String nome;

    @JsonProperty("id_autor")
    private Long idAutor;

    @JsonProperty("id_editora")
    private Long idEditora;

    public LivroResource(String nome, Long idAutor, Long idEditora) {
        this.nome = nome;
        this.idAutor = idAutor;
        this.idEditora = idEditora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public Long getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Long idEditora) {
        this.idEditora = idEditora;
    }
}
