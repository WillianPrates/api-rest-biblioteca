package com.willian.biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Editora implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public Long idEdiora;

    public String nomeEditora;

    public Editora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    @SuppressWarnings("unused")
    public Editora() {
    }

    public Long getIdEdiora() {
        return idEdiora;
    }

    public void setIdEdiora(Long idEdiora) {
        this.idEdiora = idEdiora;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Editora editora = (Editora) o;
        return Objects.equals(idEdiora, editora.idEdiora) && Objects.equals(nomeEditora, editora.nomeEditora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEdiora, nomeEditora);
    }

    @Override
    public String toString() {
        return "Editora{" +
                "idEdiora=" + idEdiora +
                ", nomeEditora='" + nomeEditora + '\'' +
                '}';
    }
}
