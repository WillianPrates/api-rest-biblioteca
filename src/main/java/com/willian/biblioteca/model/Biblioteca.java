package com.willian.biblioteca.model;

import javax.persistence.*;

@Entity
public class Biblioteca {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private int idLivro;


    public Biblioteca(int id, int idLivro) {
        this.id = id;
        this.idLivro = idLivro;
    }

    public Biblioteca() {
    }

    public int getId() {
        return id;
    }

    public int getidLivro() {
        return idLivro;
    }

    public void setidLivro(int idLivro) {
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
