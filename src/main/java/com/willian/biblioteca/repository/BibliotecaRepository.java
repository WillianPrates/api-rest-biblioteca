package com.willian.biblioteca.repository;

import com.willian.biblioteca.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
}
