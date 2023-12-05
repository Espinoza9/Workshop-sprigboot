package com.educandoweb.curso.repositories;

import com.educandoweb.curso.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria , Long> {
}
