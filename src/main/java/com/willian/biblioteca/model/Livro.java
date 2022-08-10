package com.willian.biblioteca.model;

import javax.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    private String nome;

    private Long idAutor;


    private Long idEditora;


    private String ano;


    private boolean reservado;

    public Livro(long id, String nome, Long idAutor, Long idEditora, String ano, boolean reservado) {
        this.id = id;
        this.nome = nome;
        this.idAutor = idAutor;
        this.idEditora = idEditora;
        this.ano = ano;
        this.reservado = reservado;
    }

    @SuppressWarnings("unused")
    public Livro() {
    }

    public long getId() {
        return id;
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

    public void setIdAutor(Long autor) {
        this.idAutor = idAutor;
    }

    public Long getIdEditora() {
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
