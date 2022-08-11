package com.willian.biblioteca.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EditoraResource {

    @JsonProperty("nome_editora")
    private String nomeEditora;

    public EditoraResource(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }
}
