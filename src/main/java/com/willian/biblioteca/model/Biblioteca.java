package com.willian.biblioteca.model;

import javax.persistence.*;

@Entity
public class Biblioteca {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private Long idLivro;


    public Biblioteca(Long id, Long idLivro) {
        this.id = id;
        this.idLivro = idLivro;
    }

    public Biblioteca() {
    }

    public long getId() {
        return id;
    }

    public Long getidLivro() {
        return idLivro;
    }

    public void setidLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Biblioteca that = (Biblioteca) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
