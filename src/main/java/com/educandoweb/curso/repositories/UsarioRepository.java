package com.educandoweb.curso.repositories;

import com.educandoweb.curso.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsarioRepository extends JpaRepository<Usuario , Long> {
}
