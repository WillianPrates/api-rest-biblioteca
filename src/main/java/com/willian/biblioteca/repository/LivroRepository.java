package com.willian.biblioteca.repository;

import com.willian.biblioteca.model.Biblioteca;
import com.willian.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
