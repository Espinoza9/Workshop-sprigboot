package com.educandoweb.curso.repositories;

import com.educandoweb.curso.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria , Long> {
}
