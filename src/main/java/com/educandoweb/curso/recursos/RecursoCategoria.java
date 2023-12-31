package com.educandoweb.curso.recursos;

import com.educandoweb.curso.models.Categoria;

import com.educandoweb.curso.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "categorias")
public class RecursoCategoria {
    @Autowired
    private CategoriaService service;
    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }
    @GetMapping(value = "/{id}")
    public  ResponseEntity<Categoria>findById(@PathVariable Long id){
         Categoria obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
