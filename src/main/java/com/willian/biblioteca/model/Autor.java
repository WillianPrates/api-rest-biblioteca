package com.willian.biblioteca.model;

import javax.persistence.*;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    public String nome;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return id == autor.id;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
