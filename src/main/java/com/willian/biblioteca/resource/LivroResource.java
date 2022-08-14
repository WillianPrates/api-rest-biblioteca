package com.willian.biblioteca.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LivroResource {

    @JsonProperty
    private String id;
    @JsonProperty()
    private String nome;

    @JsonProperty()
    private String idAutor;

    @JsonProperty()
    private String idEditora;

    @JsonProperty
    private String Ano;

    public LivroResource(String id, String nome, String idAutor, String idEditora, String ano) {
        this.id = id;
        this.nome = nome;
        this.idAutor = idAutor;
        this.idEditora = idEditora;
        Ano = ano;
    }

    public LivroResource(String nome, String idAutor, String idEditora, String ano) {
        this.nome = nome;
        this.idAutor = idAutor;
        this.idEditora = idEditora;
        Ano = ano;
    }

    public LivroResource(String nome, String idAutor, String idEditora) {
        this.nome = nome;
        this.idAutor = idAutor;
        this.idEditora = idEditora;
    }

    public LivroResource() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(String idEditora) {
        this.idEditora = idEditora;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String ano) {
        Ano = ano;
    }

    @Override
    public String toString() {
        return "LivroResource{" +
                "nome='" + nome + '\'' +
                ", idAutor='" + idAutor + '\'' +
                ", idEditora='" + idEditora + '\'' +
                ", Ano='" + Ano + '\'' +
                '}';
    }

}
