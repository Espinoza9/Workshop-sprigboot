package com.educandoweb.curso.services;

import com.educandoweb.curso.models.Produto;
import com.educandoweb.curso.models.Usuario;
import com.educandoweb.curso.repositories.ProdutoRepository;
import com.educandoweb.curso.repositories.UsarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll() {

        return repository.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> obj = repository.findById(id);
        return obj.get();
    }
}
