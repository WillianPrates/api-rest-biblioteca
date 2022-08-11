package com.willian.biblioteca.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AutorResource {

    @JsonProperty("nome_autor")
    private String nomeAutor;

    public AutorResource(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }
}
