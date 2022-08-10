package com.willian.biblioteca.repository;

import com.willian.biblioteca.model.Editora;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
}
