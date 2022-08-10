package com.willian.biblioteca.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long idAutor;

    public String nomeAutor;

    public Autor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    @SuppressWarnings("unused")
    public Autor() {
    }

    public long getIdAutor() {
        return idAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return idAutor == autor.idAutor;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
