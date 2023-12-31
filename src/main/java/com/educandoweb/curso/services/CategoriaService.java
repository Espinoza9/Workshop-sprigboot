package com.educandoweb.curso.services;

import com.educandoweb.curso.models.Categoria;
import com.educandoweb.curso.models.Pedido;
import com.educandoweb.curso.repositories.CategoriaRepository;
import com.educandoweb.curso.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll() {

        return repository.findAll();
    }

    public Categoria findById(Long id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.get();
    }
}
