package com.willian.biblioteca.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Livro implements Serializable{

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String nome;

    private int idAutor;


    private int idEditora;


    private String ano;


    private boolean reservado;

    public Livro(String nome, int idAutor, int idEditora, String ano, boolean reservado) {

        this.nome = nome;
        this.idAutor = idAutor;
        this.idEditora = idEditora;
        this.ano = ano;
        this.reservado = reservado;
    }

    @SuppressWarnings("unused")
    public Livro() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int autor) {
        this.idAutor = idAutor;
    }

    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(String editora) {
        this.idEditora = idEditora;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return id == livro.id;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", autor='" + idAutor + '\'' +
                ", editora='" + idEditora + '\'' +
                ", ano='" + ano + '\'' +
                ", reservado=" + reservado +
                '}';
    }
}
